package org.aldous.little;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.aldous.little.LittleCompiler.Instruction;
import org.aldous.little.LittleProgramParser.Program;
import org.aldous.little.assembler.Lc3Assembler;
import org.junit.Test;

public class LittleCompilerTest {

	@Test
	public void compilerAddition() throws IOException {
		String val = "def hello;\n"
				+ "def apa[1];\n"
				+ "def kaka;\n"
				+ "hello <- 50;\n"
				+ "apa <- 2;\n"
				+ "kaka <- apa + hello;\n"
				+ "print kaka;\n";

		writeProgram(val, "comp1.obj");
	}

	@Test
	public void empty() throws IOException {
		String val = "";

		writeProgram(val, "comp0.obj");
	}

	@Test
	public void compilerString() throws IOException {
		String val = "def hello[12];\n"
				+ "copy \"Hello world!\" -> hello;\n"
				+ "print hello;\n";

		writeProgram(val, "comp2.obj");
	}

	@Test
	public void compilerArithmetic() throws IOException {
		String val = "def hello;\n"
				+ "def apa[1];\n"
				+ "def kaka;\n"
				+ "hello <- 50;\n"
				+ "apa <- 2;\n"
				+ "kaka <- apa + hello;\n"
				+ "print kaka;\n"
				+ "def rain[14];\n"
				+ "rain <- \"<n>Hello world!<n>\";\n"
				+ "print rain;\n";

		writeProgram(val, "comp3.obj");
	}

	@Test
	public void loop() throws IOException {
		String val = "def hello;\n"
				+ "def kaka;\n"
				+ "hello <- -5;\n"
				+ "kaka <- 74;\n"
				+ "loop hello {\n"
					+ "hello <- hello + 1;\n"
					+ "kaka <- kaka + 4;\n"
					+ "print kaka;\n"
					+ "print 10;\n"
				+ "};\n"
				+ "print hello;\n";
		writeProgram(val, "comp4.obj");
	}

	@Test
	public void compilerSubtraction() throws IOException {
		String val = "def hello;\n"
				+ "def apa;\n"
				+ "def kaka;\n"
				+ "hello <- 50;\n"
				+ "apa <- 2;\n"
				+ "kaka <- hello - apa;\n"
				+ "print kaka;\n"
				+ "print 10;\n";

		writeProgram(val, "comp5.obj");
	}

	@Test
	public void compilerMultiplication() throws IOException {
		String val = "def hello;\n"
				+ "def apa;\n"
				+ "def kaka;\n"
				+ "hello <- 12;\n"
				+ "apa <- 8;\n"
				+ "kaka <- hello * apa;\n"
				+ "print kaka;\n"
				+ "print 10;\n";

		writeProgram(val, "comp6.obj");
	}

	@Test
	public void compilerChar() throws IOException {
		String val = "def a;\n"
			+ "def b;\n"
			+ "a <- '\n';\n"
			+ "b <- 'A';\n"
			+ "print b;\n"
			+ "print a;\n";
		writeProgram(val, "comp7.obj");
	}

	@Test
	public void compilerArrayRef() throws IOException {
		String val = "def arbeit[3];\n"
			+ "arbeit[0] <- 'H';\n"
			+ "arbeit[1] <- 'i';\n"
			+ "arbeit[2] <- '\n';\n"
			+ "print arbeit;\n";
		writeProgram(val, "comp8.obj");
	}

	@Test
	public void compilerVarArrayRef() throws IOException {
		String val = "def arbeit[2];\n"
			+ "arbeit[0] <- 15;\n"
			+ "def kraut[2];\n"
			+ "kraut[1] <- 7;\n"
			+ "def r;\n"
			+ "r <- arbeit[0] + kraut[1];\n"
			+ "print (r + 48);\n";
		writeProgram(val, "comp9.obj");
	}

	@Test
	public void compilerConditional() throws IOException {
		String val = "def a;\n"
			+ "a <- 7;\n"
			+ "def b;\n"
			+ "b <- 12;\n"
			+ "if a { print 'A'; };\n"
			+ "if (b - 12) { print 'B'; };\n"
			+ "print '\n';";
		writeProgram(val, "comp10.obj");
	}

	@Test
	public void printString() throws IOException {
		String val = "print \"Hello, world!\";\n";
		writeProgram(val, "comp11.obj");
	}
	
	@Test
	public void getChar() throws IOException {
		String val = "def a;\n"
			+ "a <- getc();\n"
			+ "print a;\n"
			+ "print '\n';\n";
		writeProgram(val, "comp12.obj");
	}

	@Test
	public void copyString() throws IOException {
		String val = "def a[6];\n"
			+ "copy \"Hello\" -> a;\n"
			+ "print a;\n";
		writeProgram(val, "comp13.obj");
	}
	
	@Test
	public void equalTest() throws IOException {
		String val = "def a[6];\n"
			+ "copy \"Hello\" -> a;\n"
			+ "if a[0] == 'H' { print 'A'; };\n"
			+ "if !(a[0] == 'H') { print 'B'; };\n";
		writeProgram(val, "comp14.obj");
	}

	@Test
	public void conditionalsTest() throws IOException {
		String val = "def a[6];\n"
			+ "copy \"Hello\" -> a;\n"
			+ "if a[1] > 'b' { print a[0]; };\n"
			+ "if a[1] > 'b' && 'o' == a[4] { print a[2]; };\n"
			+ "if !(5 > 6) { print 'B'; };\n";
		writeProgram(val, "comp15.obj");
	}
	
	@Test
	public void wholeProgram() throws IOException {
		String str = Files.readString(Paths.get("src/test/resources/program.ltl"));
		writeProgram(str, "program.obj");
	}
	
	private void writeProgram(String val, String path) throws IOException {
		System.out.println(val);
		final Program prog = LittleProgramParser.parse(val);
		final List<Instruction> instructions = LittleCompiler.compile(prog);
		instructions.forEach(System.out::println);

		final StringBuilder sb = new StringBuilder();
		for (final Instruction i : instructions) {
			sb.append(i.toString()).append('\n');
		}
		final Lc3Assembler lc3a = new Lc3Assembler();
		final int[] lc3code = lc3a.assemble(sb.toString());
		lc3a.writeToFile(lc3code, path);
	}
}
