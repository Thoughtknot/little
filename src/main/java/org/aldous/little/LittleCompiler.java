package org.aldous.little;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.aldous.little.LittleProgramParser.LittleType;
import org.aldous.little.LittleProgramParser.Program;
import org.aldous.little.LittleProgramParser.Statement;
import org.aldous.little.LittleProgramParser.VarDec;

public class LittleCompiler {

	public enum ConditionFlag {
		N, Z, P;
	}
	
	public enum Register {
		R0, R1, R2, R3, R4, R5, R6, R7;
	}
	
	public static class Instruction {
		String source;
		String value;
		private Instruction(String value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return value;
		}

		public static Instruction BR(String label, ConditionFlag ... flags) {
			String flagString = "";
			List<ConditionFlag> flagList = Arrays.asList(flags);
			if (flagList.contains(ConditionFlag.N)) {
				flagString += "n";
			}
			if (flagList.contains(ConditionFlag.Z)) {
				flagString += "z";
			}
			if (flagList.contains(ConditionFlag.P)) {
				flagString += "p";
			}
			return new Instruction(String.format("BR%s %s", flagString, label));
		}
		
		public static Instruction ADD(Register dr, Register reg1, Register reg2) {
			return new Instruction(String.format("ADD %s, %s, %s", dr.toString(), reg1.toString(), reg2.toString()));
		}
		
		public static Instruction ADDI(Register dr, Register reg1, int imm) {
			return new Instruction(String.format("ADD %s, %s, #%d", dr.toString(), reg1.toString(), imm));
		}
		
		public static Instruction ANDI(Register dr, Register sr, int imm) {
			return new Instruction(String.format("AND %s, %s, #%d", dr.toString(), sr.toString(), imm));
		}

		public static Instruction LEA(Register dr, String label) {
			return new Instruction(String.format("LEA %s, %s", dr, label));
		}
		
		public static Instruction LD(Register dr, String label) {
			return new Instruction(String.format("LD %s, %s", dr, label));
		}
		
		public static Instruction LDR(Register dr, Register baser, int offset) {
			return new Instruction(String.format("LDR %s, %s, #%d", dr, baser.toString(), offset));
		}

		public static Instruction ST(Register register, String label) {
			return new Instruction(String.format("ST %s, %s", register, label));
		}
		public static Instruction STR(Register dr, Register baser, int offset) {
			return new Instruction(String.format("STR %s, %s, #%d", dr, baser.toString(), offset));
		}
		
		public static Instruction NOT(Register dr, Register sr) {
			return new Instruction(String.format("NOT %s, %s", dr, sr));
		}

		public static Instruction Label(String label) {
			return new Instruction(label);
		}

		public static Instruction STRINGZ(String str) {
			return new Instruction(String.format(".STRINGZ %s", str));
		}

		public static Instruction FILL(int value) {
			return new Instruction(String.format(".FILL #%d", value));
		}

		public static Instruction BLKW(int value) {
			return new Instruction(String.format(".BLKW #%d", value));
		}
		
		public static Instruction GETC() {
			return new Instruction("GETC");
		}

		public static Instruction PUTS() {
			return new Instruction("PUTS");
		}

		public static Instruction OUT() {
			return new Instruction("OUT");
		}




	}
	
	public static List<Instruction> compile(Program program) {
		List<Instruction> list = new ArrayList<>();
		CompilerContext compilerContext = initCtxt(program);
		Instruction origin = new Instruction(".ORIG x3000");
		list.add(origin);
		for (Statement stmt : program.getStatements()) {
			list.addAll(stmt.emit(compilerContext));
		}
		Instruction halt = new Instruction("HALT");
		Instruction end = new Instruction(".END");
		list.add(halt);
		list.add(end);
		return list;
	}

	private static CompilerContext initCtxt(Program program) {
		CompilerContext compilerContext = new CompilerContext();
		for (Statement stmt : program.getStatements()) {
			if (stmt instanceof VarDec) {
				VarDec varDec = (VarDec) stmt;
				compilerContext.addType(varDec.name, varDec.getType());
				compilerContext.addSize(varDec.name, varDec.size);
			}
		}
		return compilerContext;
	}
	
	public static class CompilerContext {
		public final Set<String> labelForConstants = new HashSet<>();
		public final Map<String, LittleType> varToType = new HashMap<>();
		public final Map<String, Integer> varToSize = new HashMap<>();
		public final Map<Register, Boolean> registersBlocked = new HashMap<>();
		private int loopCount = 0;
		
		public CompilerContext() {
			for (Register r : Register.values()) {
				registersBlocked.put(r, false);
			}
		}
		
		public boolean hasConstant(String value) {
			return labelForConstants.contains(value);
		}

		public boolean hasConstant(int value) {
			String label = toAlphabetic(value);
			return labelForConstants.contains(label);
		}

		public String setConstant(String value) {
			labelForConstants.add(value);
			return value;
		}
		
		public String setConstant(int value) {
			String label = toAlphabetic(value);
			labelForConstants.add(label);
			return label;
		}
		
		public String getConstant(int value) {
			return toAlphabetic(value);
		}
		
		public static String toAlphabetic(int i) {
		    if (i < 0) {
		        return "_" + toAlphabetic(-i-1);
		    }
		
		    int quot = i / 26;
		    int rem = i % 26;
		    char letter = (char) ((int)'A' + rem);
		    if (quot == 0 ) {
		        return "__" + letter;
		    } else {
		        return "__" + toAlphabetic(quot-1) + letter;
		    }
		}

		public void unblock(Register i) {
			registersBlocked.put(i, false);
		}

		public void blockRegister(Register i) {
			if (registersBlocked.get(i)) {
				System.out.println(i.toString() + " not available!");
				throw new RuntimeException();
			}
			registersBlocked.put(i, true);
		}
		
		public Register getFirstUnblockedRegister() {
			for (Register r : Register.values()) {
				if (r == Register.R0)
					continue;
				if (!registersBlocked.get(r)) {
					blockRegister(r);
					return r;
				}
			}
			if (!registersBlocked.get(Register.R0)) {
				blockRegister(Register.R0);
				return Register.R0;
			}
			System.out.println("No registers available!");
			throw new RuntimeException();
		}

		public void addSize(String name, int size) {
			varToSize.put(name, size);
		}
		
		public int getSize(String name) {
			return varToSize.get(name);
		}
		
		public void addType(String name, LittleType type) {
			varToType.put(name, type);
		}
		
		public LittleType getType(String name) {
			return varToType.get(name);
		}

		public String getNextLoop() {
			return "LOOP" + toAlphabetic(loopCount++);
		}
	}
}
