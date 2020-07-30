package org.aldous.little;

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

}
