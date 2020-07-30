package org.aldous.little;

import java.util.ArrayList;
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

	public static class Instruction {
		String source;
		String value;
		public Instruction(String value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return value;
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
			}
		}
		return compilerContext;
	}
	
	public static class CompilerContext {
		public final Set<String> labelForConstants = new HashSet<>();
		public final Map<String, LittleType> varToType = new HashMap<>();
		public final boolean[] registersBlocked = new boolean[8];
		private int loopCount = 0;
		
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

		public void unblock(int i) {
			registersBlocked[i] = false;
		}
		
		public int getFirstUnblockedRegister() {
			for (int i = 0; i < registersBlocked.length; i++) {
				if (!registersBlocked[i]) {
					registersBlocked[i] = true;
					return i;
				}
			}
			System.out.println("No registers available!");
			return -1;
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
