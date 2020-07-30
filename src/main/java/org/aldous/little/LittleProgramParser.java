package org.aldous.little;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.aldous.little.LittleCompiler.CompilerContext;
import org.aldous.little.LittleCompiler.Instruction;
import org.aldous.little.LittleParser.AdditionContext;
import org.aldous.little.LittleParser.ArrayAssContext;
import org.aldous.little.LittleParser.ArrayRefContext;
import org.aldous.little.LittleParser.CharLiteralContext;
import org.aldous.little.LittleParser.ExpressionContext;
import org.aldous.little.LittleParser.IfContext;
import org.aldous.little.LittleParser.IntLiteralContext;
import org.aldous.little.LittleParser.LineContext;
import org.aldous.little.LittleParser.LoopContext;
import org.aldous.little.LittleParser.MultiplicationContext;
import org.aldous.little.LittleParser.ParenContext;
import org.aldous.little.LittleParser.PrintContext;
import org.aldous.little.LittleParser.StatementContext;
import org.aldous.little.LittleParser.StringLiteralContext;
import org.aldous.little.LittleParser.SubtractionContext;
import org.aldous.little.LittleParser.VarAssContext;
import org.aldous.little.LittleParser.VarDecContext;
import org.aldous.little.LittleParser.VariableReferenceContext;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class LittleProgramParser {
	public enum LittleType {
		INT, ARRAY;
	}

	public static Program parse(String program) throws IOException {
		LittleLexer ll = new LittleLexer(new ANTLRInputStream(new ByteArrayInputStream(program.getBytes())));
		LittleParser lp = new LittleParser(new CommonTokenStream(ll));
		List<LineContext> lines = lp.file().line();
		List<Statement> parsedStmts = lines.stream()
				.map(LineContext::statement)
				.map(LittleProgramParser::parseStatement)
				.collect(Collectors.toList());
		return new Program(parsedStmts);
	}

	public static Expression parseExpression(ExpressionContext exp) {
		if (exp instanceof IntLiteralContext) {
			IntLiteralContext ctxt = (IntLiteralContext) exp;
			return new IntLiteral(ctxt.INT_LIT().getText());
		}
		if (exp instanceof CharLiteralContext) {
			CharLiteralContext ctxt = (CharLiteralContext) exp;
			char val = ctxt.CHAR_LIT().getText().charAt(1);
			return new IntLiteral((int) val);
		}
		if (exp instanceof StringLiteralContext) {
			StringLiteralContext ctxt = (StringLiteralContext) exp;
			return new StrLiteral(ctxt.STR_LIT().getText());
		}
		if (exp instanceof ParenContext) {
			ParenContext ctxt = (ParenContext) exp;
			return parseExpression(ctxt.expression());
		}
		else if (exp instanceof VariableReferenceContext) {
			VariableReferenceContext ctxt = (VariableReferenceContext) exp;
			return new VarRef(ctxt.VARIABLE_ID().getText());
		}
		else if (exp instanceof ArrayRefContext) {
			ArrayRefContext ctxt = (ArrayRefContext) exp;
			return new ArrayRef(ctxt.VARIABLE_ID().getText(), parseExpression(ctxt.expression()));
		}
		else if (exp instanceof AdditionContext) {
			AdditionContext ctxt = (AdditionContext) exp;
			return new Addition(parseExpression(ctxt.left), parseExpression(ctxt.right));
		}
		else if (exp instanceof SubtractionContext) {
			SubtractionContext ctxt = (SubtractionContext) exp;
			return new Subtraction(parseExpression(ctxt.left), parseExpression(ctxt.right));
		}
		else if (exp instanceof MultiplicationContext) {
			MultiplicationContext ctxt = (MultiplicationContext) exp;
			return new Multiply(parseExpression(ctxt.left), parseExpression(ctxt.right));
		}
		return null;
	}

	public static Statement parseStatement(StatementContext stmt) {
		if (stmt instanceof VarDecContext) {
			VarDecContext vardecCtxt = (VarDecContext) stmt;
			String name = vardecCtxt.VARIABLE_ID().getText();
			int size = vardecCtxt.size == null ? 1 : Integer.parseInt(vardecCtxt.size.getText());
			VarDec vardec = new VarDec(name, size);
			return vardec;
		}
		else if (stmt instanceof VarAssContext) {
			VarAssContext varAss = (VarAssContext) stmt;
			String name = varAss.VARIABLE_ID().getText();
			VarAss vardec = new VarAss(name, parseExpression(varAss.expression()));
			return vardec;
		}
		else if (stmt instanceof ArrayAssContext) {
			ArrayAssContext ctxt = (ArrayAssContext) stmt;
			String name = ctxt.VARIABLE_ID().getText();
			return new ArrayAssignment(name, parseExpression(ctxt.index), parseExpression(ctxt.value));
		}
		else if (stmt instanceof PrintContext) {
			PrintContext print = (PrintContext) stmt;
			return new PrintStmt(parseExpression(print.expression()));
		}
		else if (stmt instanceof LoopContext) {
			LoopContext ctxt = (LoopContext) stmt;
			List<Statement> statements = ctxt
				.statement()
				.stream()
				.map(LittleProgramParser::parseStatement)
				.collect(Collectors.toList());
			return new Loop(parseExpression(ctxt.expression()), statements);
		}
		else if (stmt instanceof IfContext) {
			IfContext ctxt = (IfContext) stmt;
			List<Statement> statements = ctxt
				.statement()
				.stream()
				.map(LittleProgramParser::parseStatement)
				.collect(Collectors.toList());
			return new If(parseExpression(ctxt.expression()), statements);
		}
		return null;
	}

	public static class Program {
		private final List<Statement> statements;

		public Program(List<Statement> statements) {
			this.statements = statements;
		}

		public List<Statement> getStatements() {
			return statements;
		}
	}

	public static interface Expression {
		List<Instruction> load(CompilerContext compilerContext, int register);
		LittleType getType(CompilerContext compilerContext);
	}

	public static interface Statement {
		List<Instruction> emit(CompilerContext compilerContext);
	}
	
	public static class ArrayRef implements Expression {
		public final String name;
		private final Expression index;

		public ArrayRef(String val, Expression exp) {
			name = val;
			index = exp;
		}

		@Override
		public List<Instruction> load(CompilerContext compilerContext, int register) {
			List<Instruction> instructions = new ArrayList<>();
			int reg1 = compilerContext.getFirstUnblockedRegister();
			instructions.add(new Instruction("LEA R" + reg1 + ", " + name.toUpperCase()));
			int reg2 = compilerContext.getFirstUnblockedRegister();
			instructions.addAll(index.load(compilerContext, reg2));
			instructions.add(new Instruction("ADD R" + reg1 + ", R" + reg2 + ", R" + reg1));
			compilerContext.unblock(reg2);
			
			// load the value into register, name[index].
			Instruction ins = new Instruction("LDR R" + register + ", R" + reg1 + ", #0"); 
			instructions.add(ins);
			
			compilerContext.unblock(reg1);
			return instructions;
		}

		@Override
		public LittleType getType(CompilerContext compilerContext) {
			return LittleType.INT;
		}
	}
	
	public static class VarRef implements Expression {
		public final String name;

		public VarRef(String val) {
			name = val;
		}

		@Override
		public List<Instruction> load(CompilerContext compilerContext, int register) {
			if (getType(compilerContext) == LittleType.INT) {
				return List.of(new Instruction("LD R" + register + ", " + name.toUpperCase()));
			}
			else {
				return List.of(new Instruction("LEA R" + register + ", " + name.toUpperCase()));
			}
		}

		@Override
		public LittleType getType(CompilerContext compilerContext) {
			return compilerContext.getType(name);
		}
	}

	public static class Multiply implements Expression {
		private Expression left;
		private Expression right;

		public Multiply(Expression left, Expression right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public List<Instruction> load(CompilerContext compilerContext, int register) {
			List<Instruction> ins = new ArrayList<>();
			int reg1 = compilerContext.getFirstUnblockedRegister();
			int reg2 = compilerContext.getFirstUnblockedRegister();
			List<Instruction> leftIns = left.load(compilerContext, reg1);
			List<Instruction> rightIns = right.load(compilerContext, reg2);
			
			ins.addAll(leftIns);
			ins.addAll(rightIns);

			int regIndex = compilerContext.getFirstUnblockedRegister();
			String startLabel = compilerContext.getNextLoop();
			String endLabel = compilerContext.getNextLoop();
			ins.add(new Instruction("AND R" + regIndex + ", R" + regIndex + ", #0")); // set index to 0
			ins.add(new Instruction("AND R" + register + ", R" + register + ", #0")); // set dr to 0

			int regComparison = compilerContext.getFirstUnblockedRegister();
			
			// Comparison: take regIndex - reg2 to see if we've added reg1, reg2 times
			ins.add(new Instruction(startLabel + " NOT R" + regComparison + ", R" + reg2));
			ins.add(new Instruction("ADD R" + regComparison + ", R" + regComparison + ", #1"));
			ins.add(new Instruction("ADD R" + regComparison + ", R" + regComparison + ", R" + regIndex));
			ins.add(new Instruction("BRzp " + endLabel));
			
			// Body
			ins.add(new Instruction("ADD R" + register + ", R" + reg1 + ", R" + register)); 
			
			// increment index
			ins.add(new Instruction("ADD R" + regIndex + ", R" + regIndex + ", #1")); 
			
			// got to loop start
			ins.add(new Instruction("BR " + startLabel));

			ins.add(new Instruction(endLabel));
			compilerContext.unblock(reg1);
			compilerContext.unblock(reg2);
			compilerContext.unblock(regIndex);
			compilerContext.unblock(regComparison);
			return ins;
		}

		@Override
		public LittleType getType(CompilerContext compilerContext) {
			return LittleType.INT;
		}
	}
	
	public static class Subtraction implements Expression {
		private Expression left;
		private Expression right;

		public Subtraction(Expression left, Expression right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public List<Instruction> load(CompilerContext compilerContext, int register) {
			List<Instruction> ins = new ArrayList<>();
			int reg1 = compilerContext.getFirstUnblockedRegister();
			int reg2 = compilerContext.getFirstUnblockedRegister();
			List<Instruction> leftIns = left.load(compilerContext, reg1);
			List<Instruction> rightIns = right.load(compilerContext, reg2);
			
			ins.addAll(leftIns);
			ins.addAll(rightIns);
			ins.add(new Instruction("NOT R" + reg2 + ", R" + reg2));
			ins.add(new Instruction("ADD R" + reg2 + ", R" + reg2 + ", #1"));
			ins.add(new Instruction("ADD R" + register + ", R" + reg1 + ", R" + reg2));
			
			compilerContext.unblock(reg1);
			compilerContext.unblock(reg2);
			return ins;
		}

		@Override
		public LittleType getType(CompilerContext compilerContext) {
			return LittleType.INT;
		}
	}
	
	public static class Addition implements Expression {
		private Expression left;
		private Expression right;

		public Addition(Expression left, Expression right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public List<Instruction> load(CompilerContext compilerContext, int register) {
			List<Instruction> ins = new ArrayList<>();
			int reg1 = compilerContext.getFirstUnblockedRegister();
			int reg2 = compilerContext.getFirstUnblockedRegister();
			List<Instruction> leftIns = left.load(compilerContext, reg1);
			List<Instruction> rightIns = right.load(compilerContext, reg2);
			
			ins.addAll(leftIns);
			ins.addAll(rightIns);
			ins.add(new Instruction("ADD R" + register + ", R" + reg1 + ", R" + reg2));
			
			compilerContext.unblock(reg1);
			compilerContext.unblock(reg2);
			return ins;
		}

		@Override
		public LittleType getType(CompilerContext compilerContext) {
			return LittleType.INT;
		}
	}

	public static class StrLiteral implements Expression {
		public final String value;

		public StrLiteral(String val) {
			value = val;
		}

		@Override
		public List<Instruction> load(CompilerContext compilerContext, int register) {
			List<Instruction> instructions = new ArrayList<>();
			StringBuilder labelSb = new StringBuilder();
			for (int i = 0; i < value.length(); i++) {
				if (Character.isAlphabetic(value.charAt(i)) || value.charAt(i) == '_') {
					labelSb.append(value.charAt(i));
				}
				else {
					labelSb.append('_');
				}
			}
			String label = labelSb.toString().toUpperCase() ;
			if (!compilerContext.hasConstant(label)) {
				compilerContext.setConstant(label);
				Instruction a = new Instruction(label + " .STRINGZ " + value);
				instructions.add(a);
			}
			Instruction b = new Instruction("LEA R" + register + ", " + label);
			instructions.add(b);
			return instructions;
		}
		
		@Override
		public LittleType getType(CompilerContext compilerContext) {
			return LittleType.ARRAY;
		}
	}
	
	public static class IntLiteral implements Expression {
		public final int value;

		public IntLiteral(String val) {
			this(Integer.parseInt(val));
		}

		public IntLiteral(int val) {
			value = val;
		}

		@Override
		public List<Instruction> load(CompilerContext compilerContext, int register) {
			List<Instruction> instructions = new ArrayList<>();
			if (!compilerContext.hasConstant(value)) {
				String label = compilerContext.setConstant(value);
				Instruction a = new Instruction(label + " .FILL #" + value);
				instructions.add(a);
			}
			String label = compilerContext.getConstant(value);
			Instruction b = new Instruction("LD R" + register + ", " + label);
			instructions.add(b);
			return instructions;
		}
		
		@Override
		public LittleType getType(CompilerContext compilerContext) {
			return LittleType.INT;
		}
	}

	public static class PrintStmt implements Statement {
		private Expression expression;

		public PrintStmt(Expression parseExpression) {
			this.expression = parseExpression;
		}

		@Override
		public List<Instruction> emit(CompilerContext compilerContext) {
			List<Instruction> instructions = new ArrayList<>();
			int register = compilerContext.getFirstUnblockedRegister();
			instructions.addAll(expression.load(compilerContext, register));
			if (expression.getType(compilerContext) == LittleType.ARRAY) {
				instructions.add(new Instruction("PUTS"));
			}
			else {
				instructions.add(new Instruction("OUT"));
			}
			compilerContext.unblock(register);
			return instructions;
		}
	}
	
	public static class ArrayAssignment implements Statement {
		public final String name;
		private final Expression exp;
		private final Expression index;

		public ArrayAssignment(String string, Expression index, Expression exp) {
			this.name = string;
			this.index = index;
			this.exp = exp;
		}

		@Override
		public List<Instruction> emit(CompilerContext compilerContext) {
			List<Instruction> instructions = new ArrayList<>();
			int reg1 = compilerContext.getFirstUnblockedRegister();
			instructions.add(new Instruction("LEA R" + reg1 + ", " + name.toUpperCase()));
			int reg2 = compilerContext.getFirstUnblockedRegister();
			instructions.addAll(index.load(compilerContext, reg2));
			instructions.add(new Instruction("ADD R" + reg1 + ", R" + reg2 + ", R" + reg1));
			compilerContext.unblock(reg2);
			
			int register = compilerContext.getFirstUnblockedRegister();
			instructions.addAll(exp.load(compilerContext, register));
			Instruction ins = new Instruction("STR R" + register + ", R" + reg1 + ", #0");
			instructions.add(ins);
			
			compilerContext.unblock(reg1);
			compilerContext.unblock(register);
			return instructions;
		}
	}
	
	public static class VarAss implements Statement {
		public final String name;
		private final Expression exp;

		public VarAss(String string, Expression exp) {
			this.name = string;
			this.exp = exp;
		}

		@Override
		public List<Instruction> emit(CompilerContext compilerContext) {
			List<Instruction> instructions = new ArrayList<>();
			int register = compilerContext.getFirstUnblockedRegister();
			
			instructions.addAll(exp.load(compilerContext, register));
			Instruction ins = new Instruction("ST R" + register + ", " + name.toUpperCase());
			instructions.add(ins);
			compilerContext.unblock(register);
			return instructions;
		}
	}
	
	public static class VarDec implements Statement {
		public final String name;
		public final int size;

		public VarDec(String string, int size) {
			this.name = string;
			this.size = size;
		}

		@Override
		public List<Instruction> emit(CompilerContext compilerContext) {
			return List.of(new Instruction(name.toUpperCase() + " .BLKW " + (size + 1)));
		}

		public LittleType getType() {
			return size == 1 ? LittleType.INT : LittleType.ARRAY;
		}
	}
	
	public static class Loop implements Statement {
		private final Expression expression;
		private final List<Statement> statements;

		public Loop(Expression expression, List<Statement> statements) {
			this.expression = expression;
			this.statements = statements;
		}

		@Override
		public List<Instruction> emit(CompilerContext compilerContext) {
			List<Instruction> instructions = new ArrayList<>();
			String startLabel = compilerContext.getNextLoop();
			String endLabel = compilerContext.getNextLoop();
			Instruction labelStart = new Instruction(startLabel);
			instructions.add(labelStart);
			int register = compilerContext.getFirstUnblockedRegister();
			compilerContext.unblock(register);
			instructions.addAll(expression.load(compilerContext, register));
			Instruction branch = new Instruction("BRp " + endLabel);
			instructions.add(branch);
			
			// BODY
			for (Statement s : statements) {
				instructions.addAll(s.emit(compilerContext));
			}
			// 
			
			Instruction jumpToStart = new Instruction("BR " + startLabel);
			instructions.add(jumpToStart);
			Instruction labelEnd = new Instruction(endLabel);
			instructions.add(labelEnd);
			return instructions;
		}

		public LittleType getType() {
			return LittleType.ARRAY;
		}
	}
	
	public static class If implements Statement {
		private final Expression expression;
		private final List<Statement> statements;

		public If(Expression expression, List<Statement> statements) {
			this.expression = expression;
			this.statements = statements;
		}

		@Override
		public List<Instruction> emit(CompilerContext compilerContext) {
			List<Instruction> instructions = new ArrayList<>();
			String endLabel = compilerContext.getNextLoop();
			int register = compilerContext.getFirstUnblockedRegister();
			compilerContext.unblock(register);
			instructions.addAll(expression.load(compilerContext, register));
			Instruction branch = new Instruction("BRnz " + endLabel);
			instructions.add(branch);
			
			// BODY
			for (Statement s : statements) {
				instructions.addAll(s.emit(compilerContext));
			}
			
			Instruction labelEnd = new Instruction(endLabel);
			instructions.add(labelEnd);
			return instructions;
		}

		public LittleType getType() {
			return LittleType.ARRAY;
		}
	}
}
