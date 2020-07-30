package org.aldous.little.assembler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class Lc3AssemblerTest {
	Lc3Assembler lc3a = new Lc3Assembler();

	@Test
	public void testHelloWorld() throws IOException {
		String val = ".ORIG x3000\n"
			+ "LEA R0, HI\n"
			+ "PUTS\n"
			+ "HALT\n"
			+ "HI .STRINGZ \"Hello World!<n>\"\n"
			+ ".END\n";
		int[] value = lc3a.assemble(val);
		lc3a.writeToFile(value, "test.obj");
	}
	
	@Test
	public void testLoop() throws IOException {
		String val = ".ORIG x3000\n" + 
				"LD R1, LOOPMAX\n" +
				"LD R2, NEGONE\n" +
				"LEA R0, LOOPMSG\n" + 
				
				"LOOPSTART PUTS\n" + 
				"ADD R1, R2, R1\n" + 
				
				"BRp LOOPSTART\n" + 
				
				"LOOPEND LEA R0, DONEMSG\n" + 
				"PUTS\n" + 
				
				"HALT\n" + 
				"LOOPMAX .FILL x000A\n" + 
				"NEGONE .FILL #-1\n" + 
				"LOOPMSG .STRINGZ \"Looping...<n>\"\n" + 
				"DONEMSG .STRINGZ \"All Done!\"\n" + 
				".END\n";
		int[] value = lc3a.assemble(val);
		lc3a.writeToFile(value, "loop.obj");
	}
	
	@Test
	public void testAdd() throws IOException {
		int[] val = lc3a.assemble("ADD R1, R2, R1\n");
		System.out.println(String.format("%04X", val[0]));
	}
}
