package org.aldous.little;

import java.io.IOException;

import org.aldous.little.LittleProgramParser.Program;
import org.junit.Test;

public class LittleParserTest {

	@Test
	public void parser() throws IOException {
		String val = "int hello;\n"
			+ "int apa[1];\n"
			+ "apa <- 2;\n"
			+ "kaka <- apa + hello;\n"
			+ "print kaka;\n";
		Program prog = LittleProgramParser.parse(val);
		prog.getStatements();
	}
}
