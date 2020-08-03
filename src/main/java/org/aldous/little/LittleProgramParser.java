package org.aldous.little;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.aldous.little.LittleCompiler.CompilerContext;
import org.aldous.little.LittleCompiler.ConditionFlag;
import org.aldous.little.LittleCompiler.Instruction;
import org.aldous.little.LittleCompiler.Register;
import org.aldous.little.LittleParser.AdditionContext;
import org.aldous.little.LittleParser.AndContext;
import org.aldous.little.LittleParser.ArrayAssContext;
import org.aldous.little.LittleParser.ArrayRefContext;
import org.aldous.little.LittleParser.CharLiteralContext;
import org.aldous.little.LittleParser.CopyContext;
import org.aldous.little.LittleParser.EqualsContext;
import org.aldous.little.LittleParser.ExpressionContext;
import org.aldous.little.LittleParser.GetcContext;
import org.aldous.little.LittleParser.GreaterContext;
import org.aldous.little.LittleParser.IfContext;
import org.aldous.little.LittleParser.IntLiteralContext;
import org.aldous.little.LittleParser.LineContext;
import org.aldous.little.LittleParser.LoopContext;
import org.aldous.little.LittleParser.MultiplicationContext;
import org.aldous.little.LittleParser.NotContext;
import org.aldous.little.LittleParser.OrContext;
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
		else if (exp instanceof EqualsContext) {
			EqualsContext ctxt = (EqualsContext) exp;
			return new Equal(parseExpression(ctxt.left), parseExpression(ctxt.right));
		}
		else if (exp instanceof GreaterContext) {
			GreaterContext ctxt = (GreaterContext) exp;
			return new Greater(parseExpression(ctxt.left), parseExpression(ctxt.right));
		}
		else if (exp instanceof AndContext) {
			AndContext ctxt = (AndContext) exp;
			return new And(parseExpression(ctxt.left), parseExpression(ctxt.right));
		}
		else if (exp instanceof OrContext) {
			OrContext ctxt = (OrContext) exp;
			return new Or(parseExpression(ctxt.left), parseExpression(ctxt.right));
		}
		else if (exp instanceof GetcContext) {
			return new Getc();
		}
		else if (exp instanceof NotContext) {
			NotContext ctxt = (NotContext) exp;
			return new Not(parseExpression(ctxt.expression()));
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
		else if (stmt instanceof CopyContext) {
			CopyContext ctxt = (CopyContext) stmt;
			String name = ctxt.VARIABLE_ID().getText();
			return new Copy(name, parseExpression(ctxt.expression()));
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
		List<Instruction> load(CompilerContext compilerContext, Register register);
		LittleType getType(CompilerContext compilerContext);
		int getSize();
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
		public List<Instruction> load(CompilerContext compilerContext, Register register) {
			List<Instruction> instructions = new ArrayList<>();
			Register reg1 = compilerContext.getFirstUnblockedRegister();
			instructions.add(Instruction.LEA(reg1, name.toUpperCase()));
			Register reg2 = compilerContext.getFirstUnblockedRegister();
			instructions.addAll(index.load(compilerContext, reg2));
			instructions.add(Instruction.ADD(reg1, reg2, reg1));
			compilerContext.unblock(reg2);
			
			instructions.add(Instruction.LDR(register, reg1, 0));
			compilerContext.unblock(reg1);
			return instructions;
		}

		@Override
		public LittleType getType(CompilerContext compilerContext) {
			return LittleType.INT;
		}

		@Override
		public int getSize() {
			return 1;
		}
	}
	
	public static class VarRef implements Expression {
		public final String name;

		public VarRef(String val) {
			name = val;
		}

		@Override
		public List<Instruction> load(CompilerContext compilerContext, Register register) {
			if (getType(compilerContext) == LittleType.INT) {
				return List.of(Instruction.LD(register, name.toUpperCase()));
			}
			else {
				return List.of(Instruction.LEA(register, name.toUpperCase()));
			}
		}

		@Override
		public LittleType getType(CompilerContext compilerContext) {
			return compilerContext.getType(name);
		}

		@Override
		public int getSize() {
			return 1;
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
		public List<Instruction> load(CompilerContext compilerContext, Register register) {
			List<Instruction> ins = new ArrayList<>();
			Register reg1 = compilerContext.getFirstUnblockedRegister();
			Register reg2 = compilerContext.getFirstUnblockedRegister();
			List<Instruction> leftIns = left.load(compilerContext, reg1);
			List<Instruction> rightIns = right.load(compilerContext, reg2);
			
			ins.addAll(leftIns);
			ins.addAll(rightIns);

			Register regIndex = compilerContext.getFirstUnblockedRegister();
			String startLabel = compilerContext.getNextLoop();
			String endLabel = compilerContext.getNextLoop();
			ins.add(Instruction.ANDI(regIndex, regIndex, 0));
			ins.add(Instruction.ANDI(register, register, 0));

			Register regComparison = compilerContext.getFirstUnblockedRegister();
			
			// Comparison: take regIndex - reg2 to see if we've added reg1, reg2 times
			ins.add(Instruction.Label(startLabel));
			ins.add(Instruction.NOT(regComparison, reg2));
			ins.add(Instruction.ADDI(regComparison, regComparison, 1));
			ins.add(Instruction.ADD(regComparison, regComparison, regIndex));
			ins.add(Instruction.BR(endLabel, ConditionFlag.Z, ConditionFlag.P));
			
			// Body
			ins.add(Instruction.ADD(register, reg1, register));
			
			// increment index
			ins.add(Instruction.ADDI(regIndex, regIndex, 1));
			
			// got to loop start
			ins.add(Instruction.BR(startLabel));

			ins.add(Instruction.Label(endLabel));
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

		@Override
		public int getSize() {
			return 1;
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
		public List<Instruction> load(CompilerContext compilerContext, Register register) {
			List<Instruction> ins = new ArrayList<>();
			Register reg1 = compilerContext.getFirstUnblockedRegister();
			Register reg2 = compilerContext.getFirstUnblockedRegister();
			List<Instruction> leftIns = left.load(compilerContext, reg1);
			List<Instruction> rightIns = right.load(compilerContext, reg2);
			
			ins.addAll(leftIns);
			ins.addAll(rightIns);
			ins.add(Instruction.NOT(reg2, reg2));
			ins.add(Instruction.ADDI(reg2,  reg2, 1));
			ins.add(Instruction.ADD(register,  reg1, reg2));
			
			compilerContext.unblock(reg1);
			compilerContext.unblock(reg2);
			return ins;
		}

		@Override
		public LittleType getType(CompilerContext compilerContext) {
			return LittleType.INT;
		}
		
		@Override
		public int getSize() {
			return 1;
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
		public List<Instruction> load(CompilerContext compilerContext, Register register) {
			List<Instruction> ins = new ArrayList<>();
			Register reg1 = compilerContext.getFirstUnblockedRegister();
			Register reg2 = compilerContext.getFirstUnblockedRegister();
			List<Instruction> leftIns = left.load(compilerContext, reg1);
			List<Instruction> rightIns = right.load(compilerContext, reg2);
			
			ins.addAll(leftIns);
			ins.addAll(rightIns);
			ins.add(Instruction.ADD(register,  reg1, reg2));
			
			compilerContext.unblock(reg1);
			compilerContext.unblock(reg2);
			return ins;
		}

		@Override
		public LittleType getType(CompilerContext compilerContext) {
			return LittleType.INT;
		}

		@Override
		public int getSize() {
			return 1;
		}
	}

	public static class StrLiteral implements Expression {
		public final String value;

		public StrLiteral(String val) {
			value = val;
		}

		@Override
		public List<Instruction> load(CompilerContext compilerContext, Register register) {
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
				instructions.add(Instruction.Label(label));
				instructions.add(Instruction.STRINGZ(value));
			}
			instructions.add(Instruction.LEA(register, label));
			return instructions;
		}
		
		@Override
		public LittleType getType(CompilerContext compilerContext) {
			return LittleType.ARRAY;
		}

		@Override
		public int getSize() {
			return value.length() - 1;
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
		public List<Instruction> load(CompilerContext compilerContext, Register register) {
			List<Instruction> instructions = new ArrayList<>();
			if (!compilerContext.hasConstant(value)) {
				String label = compilerContext.setConstant(value);
				instructions.add(Instruction.Label(label));
				instructions.add(Instruction.FILL(value));
			}
			String label = compilerContext.getConstant(value);
			instructions.add(Instruction.LD(register, label));
			return instructions;
		}
		
		@Override
		public LittleType getType(CompilerContext compilerContext) {
			return LittleType.INT;
		}

		@Override
		public int getSize() {
			return 1;
		}
	}

	public static class Not implements Expression {
		private final Expression exp;

		public Not(Expression exp) {
			this.exp = exp;
		}

		@Override
		public List<Instruction> load(CompilerContext compilerContext, Register register) {
			List<Instruction> instructions = new ArrayList<>();
			Register reg0 = Register.R0;
			Register reg1 = compilerContext.getFirstUnblockedRegister();
			instructions.addAll(exp.load(compilerContext, reg1));
			instructions.add(Instruction.ANDI(reg0, reg0, 0));
			instructions.add(Instruction.ADDI(reg0, reg1, 0));
			
			String endLabel = compilerContext.getNextLoop();
			String finalLabel = compilerContext.getNextLoop();
			instructions.add(Instruction.BR(endLabel, ConditionFlag.P));
			instructions.add(Instruction.ADDI(register, register, 1));
			instructions.add(Instruction.BR(finalLabel));
			instructions.add(Instruction.Label(endLabel));
			instructions.add(Instruction.ANDI(register, register, 0));
			instructions.add(Instruction.Label(finalLabel));
			compilerContext.unblock(reg1);
			return instructions;
		}
		
		@Override
		public LittleType getType(CompilerContext compilerContext) {
			return exp.getType(compilerContext);
		}

		@Override
		public int getSize() {
			return exp.getSize();
		}
	}

	public static class Equal implements Expression {
		private final Expression left;
		private final Expression right;

		public Equal(Expression left, Expression right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public List<Instruction> load(CompilerContext compilerContext, Register register) {
			List<Instruction> instructions = new ArrayList<>();
			
			compilerContext.blockRegister(Register.R0);
			Register reg1 = compilerContext.getFirstUnblockedRegister();
			Register reg2 = compilerContext.getFirstUnblockedRegister();
			instructions.addAll(left.load(compilerContext, reg1));
			instructions.addAll(right.load(compilerContext, reg2));
			instructions.add(Instruction.ANDI(Register.R0, Register.R0, 0));
			instructions.add(Instruction.ANDI(register, register, 0));
			
			instructions.add(Instruction.NOT(reg2, reg2));
			instructions.add(Instruction.ADDI(reg2, reg2, 1));
			instructions.add(Instruction.ADD(Register.R0, reg2, reg1));
			
			String endLabel = compilerContext.getNextLoop();
			String finalLabel = compilerContext.getNextLoop();
			instructions.add(Instruction.BR(endLabel, ConditionFlag.N, ConditionFlag.P));
			instructions.add(Instruction.ADDI(register, register, 1));
			instructions.add(Instruction.BR(finalLabel));
			instructions.add(Instruction.Label(endLabel));
			instructions.add(Instruction.ADDI(register, register, 0));
			instructions.add(Instruction.Label(finalLabel));
			
			compilerContext.unblock(reg1);
			compilerContext.unblock(reg2);
			compilerContext.unblock(Register.R0);
			return instructions;
		}
		
		@Override
		public LittleType getType(CompilerContext compilerContext) {
			return LittleType.INT;
		}

		@Override
		public int getSize() {
			return 1;
		}
	}
	
	public static class Greater implements Expression {
		private final Expression left;
		private final Expression right;

		public Greater(Expression left, Expression right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public List<Instruction> load(CompilerContext compilerContext, Register register) {
			List<Instruction> instructions = new ArrayList<>();
			
			Register reg1 = compilerContext.getFirstUnblockedRegister();
			Register reg2 = compilerContext.getFirstUnblockedRegister();
			instructions.addAll(left.load(compilerContext, reg1));
			instructions.addAll(right.load(compilerContext, reg2));
			instructions.add(Instruction.ANDI(Register.R0, Register.R0, 0));
			instructions.add(Instruction.ANDI(register, register, 0));
			
			instructions.add(Instruction.NOT(reg2, reg2));
			instructions.add(Instruction.ADDI(reg2, reg2, 1));
			instructions.add(Instruction.ADD(Register.R0, reg2, reg1));
			
			String endLabel = compilerContext.getNextLoop();
			String finalLabel = compilerContext.getNextLoop();
			instructions.add(Instruction.BR(endLabel, ConditionFlag.N, ConditionFlag.Z));
			instructions.add(Instruction.ADDI(register, register, 1));
			instructions.add(Instruction.BR(finalLabel));
			instructions.add(Instruction.Label(endLabel));
			instructions.add(Instruction.ADDI(register, register, 0));
			instructions.add(Instruction.Label(finalLabel));
			
			compilerContext.unblock(reg1);
			compilerContext.unblock(reg2);
			compilerContext.unblock(Register.R0);
			return instructions;
		}
		
		@Override
		public LittleType getType(CompilerContext compilerContext) {
			return LittleType.INT;
		}

		@Override
		public int getSize() {
			return 1;
		}
	}
	
	public static class And implements Expression {
		private final Expression left;
		private final Expression right;

		public And(Expression left, Expression right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public List<Instruction> load(CompilerContext compilerContext, Register register) {
			List<Instruction> instructions = new ArrayList<>();
			
			compilerContext.blockRegister(Register.R0);
			Register reg1 = compilerContext.getFirstUnblockedRegister();
			Register reg2 = compilerContext.getFirstUnblockedRegister();
			String endLabel = compilerContext.getNextLoop();
			String finalLabel = compilerContext.getNextLoop();
			
			instructions.add(Instruction.ANDI(Register.R0, Register.R0, 0));
			instructions.addAll(left.load(compilerContext, reg1));
			instructions.add(Instruction.BR(endLabel, ConditionFlag.N, ConditionFlag.Z));
			instructions.addAll(right.load(compilerContext, reg2));
			instructions.add(Instruction.BR(endLabel, ConditionFlag.N, ConditionFlag.Z));
			
			instructions.add(Instruction.ADDI(register, register, 1));
			instructions.add(Instruction.BR(finalLabel));
			instructions.add(Instruction.Label(endLabel));
			instructions.add(Instruction.ADDI(register, register, 0));
			instructions.add(Instruction.Label(finalLabel));
			
			compilerContext.unblock(reg1);
			compilerContext.unblock(reg2);
			compilerContext.unblock(Register.R0);
			return instructions;
		}
		
		@Override
		public LittleType getType(CompilerContext compilerContext) {
			return LittleType.INT;
		}

		@Override
		public int getSize() {
			return 1;
		}
	}

	public static class Or implements Expression {
		private final Expression left;
		private final Expression right;

		public Or(Expression left, Expression right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public List<Instruction> load(CompilerContext compilerContext, Register register) {
			List<Instruction> instructions = new ArrayList<>();
			
			compilerContext.blockRegister(Register.R0);
			Register reg1 = compilerContext.getFirstUnblockedRegister();
			Register reg2 = compilerContext.getFirstUnblockedRegister();
			String startLabel = compilerContext.getNextLoop();
			String endLabel = compilerContext.getNextLoop();
			String finalLabel = compilerContext.getNextLoop();
			
			instructions.add(Instruction.ANDI(Register.R0, Register.R0, 0));
			instructions.addAll(left.load(compilerContext, reg1));
			instructions.add(Instruction.BR(startLabel, ConditionFlag.P));
			instructions.addAll(right.load(compilerContext, reg2));
			instructions.add(Instruction.BR(endLabel, ConditionFlag.N, ConditionFlag.Z));

			instructions.add(Instruction.Label(startLabel));
			instructions.add(Instruction.ADDI(register, register, 1));
			instructions.add(Instruction.BR(finalLabel));
			instructions.add(Instruction.Label(endLabel));
			instructions.add(Instruction.ADDI(register, register, 0));
			instructions.add(Instruction.Label(finalLabel));
			
			compilerContext.unblock(reg1);
			compilerContext.unblock(reg2);
			compilerContext.unblock(Register.R0);
			return instructions;
		}
		
		@Override
		public LittleType getType(CompilerContext compilerContext) {
			return LittleType.INT;
		}

		@Override
		public int getSize() {
			return 1;
		}
	}
	
	public static class Getc implements Expression {

		@Override
		public List<Instruction> load(CompilerContext compilerContext, Register register) {
			return List.of(
				Instruction.GETC(),
				Instruction.ANDI(register, register, 0),
				Instruction.ADD(register, Register.R0, register)); 
		}
		
		@Override
		public LittleType getType(CompilerContext compilerContext) {
			return LittleType.INT;
		}

		@Override
		public int getSize() {
			return 1;
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
			Register register = Register.R0;
			compilerContext.blockRegister(register);
			instructions.addAll(expression.load(compilerContext, register));
			compilerContext.unblock(register);
			if (expression.getType(compilerContext) == LittleType.ARRAY) {
				instructions.add(Instruction.PUTS());
			}
			else {
				instructions.add(Instruction.OUT());
			}
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
			Register reg1 = compilerContext.getFirstUnblockedRegister();
			instructions.add(Instruction.LEA(reg1, name.toUpperCase()));
			Register reg2 = compilerContext.getFirstUnblockedRegister();
			instructions.addAll(index.load(compilerContext, reg2));
			instructions.add(Instruction.ADD(reg1, reg2, reg1));
			compilerContext.unblock(reg2);
			
			Register register = compilerContext.getFirstUnblockedRegister();
			instructions.addAll(exp.load(compilerContext, register));
			instructions.add(Instruction.STR(register, reg1, 0));
			
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
			Register register = compilerContext.getFirstUnblockedRegister();
			
			instructions.addAll(exp.load(compilerContext, register));
			instructions.add(Instruction.ST(register, name.toUpperCase()));
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
			return List.of(Instruction.Label(name.toUpperCase()),
					Instruction.BLKW((size == 1 ? 1 : size + 1)));
		}

		public LittleType getType() {
			return size == 1 ? LittleType.INT : LittleType.ARRAY;
		}
	}
	
	public static class Copy implements Statement {
		private final String name;
		private final Expression exp;

		public Copy(String name, Expression exp) {
			this.name = name;
			this.exp = exp;
		}

		@Override
		public List<Instruction> emit(CompilerContext compilerContext) {
			int size = exp.getSize();
			List<Instruction> instructions = new ArrayList<>();
			String startLabel = compilerContext.getNextLoop();
			String endLabel = compilerContext.getNextLoop();
			Register reg0 = compilerContext.getFirstUnblockedRegister();
			Register reg1 = compilerContext.getFirstUnblockedRegister();
			Register reg2 = compilerContext.getFirstUnblockedRegister();
			Register reg3 = compilerContext.getFirstUnblockedRegister();
			Register reg4 = compilerContext.getFirstUnblockedRegister();
			Register reg5 = compilerContext.getFirstUnblockedRegister();

			instructions.add(Instruction.LEA(reg5, name.toUpperCase()));
			instructions.add(Instruction.ANDI(reg0, reg0, 0));
			instructions.add(Instruction.ANDI(reg1, reg1, 0));
			instructions.add(Instruction.ADDI(reg1, reg1, size));
			instructions.add(Instruction.NOT(reg1, reg1));
			instructions.add(Instruction.ADDI(reg1, reg1, 1));
			instructions.addAll(exp.load(compilerContext, reg3));
			instructions.add(Instruction.Label(startLabel));
			
			instructions.add(Instruction.ADD(reg2,  reg1, reg0));
			instructions.add(Instruction.BR(endLabel, ConditionFlag.P));
			
			// BODY - load the actual value currently pointed to - store it in the label + index
			instructions.add(Instruction.LDR(reg4, reg3, 0));
			instructions.add(Instruction.STR(reg4, reg5, 0));
			
			//incr pointer
			instructions.add(Instruction.ADDI(reg3, reg3, 1));
			instructions.add(Instruction.ADDI(reg5, reg5, 1));
			
			//incr index
			instructions.add(Instruction.ADDI(reg0, reg0, 1));
			
			//end
			instructions.add(Instruction.BR(startLabel));
			instructions.add(Instruction.Label(endLabel));
			
			compilerContext.unblock(reg0);
			compilerContext.unblock(reg1);
			compilerContext.unblock(reg2);
			compilerContext.unblock(reg3);
			compilerContext.unblock(reg4);
			compilerContext.unblock(reg5);
			return instructions;
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
			
			instructions.add(Instruction.Label(startLabel));
			Register register = compilerContext.getFirstUnblockedRegister();
			compilerContext.unblock(register);
			instructions.addAll(expression.load(compilerContext, register));
			instructions.add(Instruction.BR(endLabel, ConditionFlag.Z));
			
			// BODY
			for (Statement s : statements) {
				instructions.addAll(s.emit(compilerContext));
			}
			// 
			
			instructions.add(Instruction.BR(startLabel));
			instructions.add(Instruction.Label(endLabel));
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
			Register register = compilerContext.getFirstUnblockedRegister();
			instructions.addAll(expression.load(compilerContext, register));
			compilerContext.unblock(register);
			instructions.add(Instruction.BR(endLabel, ConditionFlag.N, ConditionFlag.Z));
			
			// BODY
			for (Statement s : statements) {
				instructions.addAll(s.emit(compilerContext));
			}
			
			instructions.add(Instruction.Label(endLabel));
			return instructions;
		}

		public LittleType getType() {
			return LittleType.ARRAY;
		}
	}
}
