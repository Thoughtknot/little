package org.aldous.little;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.aldous.little.LittleCompiler.Instruction;

public class LittleUtil {

	public static boolean isInteger(String val) {
		try {
			Integer.parseInt(val);
			return true;
		}
		catch (NumberFormatException e) {
			return false;
		}
	}

	public static void writeToFile(List<Instruction> instructions, String path) throws IOException {
		FileOutputStream fos = new FileOutputStream(new File(path));
		for (Instruction i : instructions) {
			fos.write(i.toString().getBytes());
			fos.write((int) '\n');
		}
		fos.close();
	}
	
}
