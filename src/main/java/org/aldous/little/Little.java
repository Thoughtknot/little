package org.aldous.little;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.aldous.little.LittleCompiler.Instruction;
import org.aldous.little.LittleProgramParser.Program;
import org.aldous.little.assembler.Lc3Assembler;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Little {

	private static final Option f = Option.builder().argName("f").longOpt("file-name").desc("Relative path to the source code (ltl) file.").hasArg().build();
	private static final Option o = Option.builder().argName("o").longOpt("output-file").desc("Relative path to the output (obj) file.").hasArg().build();
	private static final Option a = Option.builder().argName("a").longOpt("assembly").desc("If set, produces an output file for the LC3 assembly language translation.").hasArg(false).optionalArg(true).build();
	private static final Options options = new Options().addOption(f).addOption(o).addOption(a);
	
	public static void main(String[] args) {
		CommandLineParser parser = new DefaultParser();
		try {
			CommandLine cl = parser.parse(options, args);
			String inputFileName = cl.getOptionValue("file-name");
			String outputFileName = cl.getOptionValue("output-file");
			
			if (inputFileName == null || outputFileName == null) {
				throw new ParseException("Required options not supplied.");
			}
			
			Program program = LittleProgramParser.parse(Files.readString(Paths.get(inputFileName)));
			List<Instruction> instructions = LittleCompiler.compile(program);
			int[] mc = Lc3Assembler.assemble(instructions);
			Lc3Assembler.writeToFile(mc, outputFileName);
			if (cl.hasOption("assembly")) {
				String assemblyFileName = outputFileName + ".lc3";
				LittleUtil.writeToFile(instructions, assemblyFileName);
			}
		} 
		catch (ParseException e) {
			e.printStackTrace();
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("Little", options);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
}
