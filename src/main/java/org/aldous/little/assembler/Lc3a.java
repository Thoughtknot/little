package org.aldous.little.assembler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Lc3a {

	private static final Option f = Option.builder().argName("f").longOpt("file-name").desc("Relative path to the source code (lc3 assembly) file.").hasArg().build();
	private static final Option o = Option.builder().argName("o").longOpt("output-file").desc("Relative path to the output (obj) file.").hasArg().build();
	private static final Options options = new Options().addOption(f).addOption(o);
	
	public static void main(String[] args) {
		CommandLineParser parser = new DefaultParser();
		try {
			CommandLine cl = parser.parse(options, args);
			String inputFileName = cl.getOptionValue("file-name");
			String outputFileName = cl.getOptionValue("output-file");
			
			if (inputFileName == null || outputFileName == null) {
				throw new ParseException("Required options not supplied.");
			}
			
			int[] mc = Lc3Assembler.assemble(Files.readString(Paths.get(inputFileName)));
			Lc3Assembler.writeToFile(mc, outputFileName);
		} 
		catch (ParseException e) {
			e.printStackTrace();
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("Lc3a", options);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
}
