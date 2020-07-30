package org.aldous.little.assembler;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.aldous.little.assembler.Lc3Parser.AddContext;
import org.aldous.little.assembler.Lc3Parser.AndContext;
import org.aldous.little.assembler.Lc3Parser.BlkwContext;
import org.aldous.little.assembler.Lc3Parser.BrContext;
import org.aldous.little.assembler.Lc3Parser.EndContext;
import org.aldous.little.assembler.Lc3Parser.FillContext;
import org.aldous.little.assembler.Lc3Parser.GetcContext;
import org.aldous.little.assembler.Lc3Parser.HaltContext;
import org.aldous.little.assembler.Lc3Parser.InnerStatementContext;
import org.aldous.little.assembler.Lc3Parser.JmpContext;
import org.aldous.little.assembler.Lc3Parser.JsrContext;
import org.aldous.little.assembler.Lc3Parser.JsrrContext;
import org.aldous.little.assembler.Lc3Parser.LabelContext;
import org.aldous.little.assembler.Lc3Parser.LdContext;
import org.aldous.little.assembler.Lc3Parser.LdiContext;
import org.aldous.little.assembler.Lc3Parser.LdrContext;
import org.aldous.little.assembler.Lc3Parser.LeaContext;
import org.aldous.little.assembler.Lc3Parser.NotContext;
import org.aldous.little.assembler.Lc3Parser.OrigContext;
import org.aldous.little.assembler.Lc3Parser.OutContext;
import org.aldous.little.assembler.Lc3Parser.PutsContext;
import org.aldous.little.assembler.Lc3Parser.RetContext;
import org.aldous.little.assembler.Lc3Parser.StContext;
import org.aldous.little.assembler.Lc3Parser.StatementContext;
import org.aldous.little.assembler.Lc3Parser.StiContext;
import org.aldous.little.assembler.Lc3Parser.StrContext;
import org.aldous.little.assembler.Lc3Parser.StringzContext;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

public class Lc3Assembler {

	public void writeToFile(int[] assembled, String path) throws IOException {
		FileOutputStream fos = new FileOutputStream(new File(path));
		int lc = assembled[0];
		for (int i = 0; i < assembled.length; i++) {
			int current = assembled[i];
			int a = (current >> 8) & 0xFF;
			int b = current & 0xFF;
			System.out.println(String.format("lc: %04X, %04X", lc & 0xFFFF, current & 0xFFFF));
			fos.write(a);
			fos.write(b);
			lc++;
		}
		fos.close();
	}
	
	@SuppressWarnings("deprecation")
	public int[] assemble(String program) throws IOException {
		Lc3Lexer lc3l = new Lc3Lexer(new ANTLRInputStream(new ByteArrayInputStream(program.getBytes())));
		Lc3Parser lc3p = new Lc3Parser(new CommonTokenStream(lc3l));
		List<Statement> statements = lc3p
			.file()
			.statement()
			.stream()
			.map(this::parse)
			.collect(Collectors.toList());
		
		Map<String, Integer> symbolTable = buildSymbolTable(statements);
		int[] emitted = emit(statements, symbolTable);
		return emitted;
	}

	private int[] emit(List<Statement> statements, Map<String, Integer> symbolTable) {
		List<Integer> bytes = new ArrayList<>();
		for (Statement statement: statements) {
			bytes.addAll(statement.emit(symbolTable));
		}
		return bytes.stream().mapToInt(Integer::intValue).toArray();
	}

	private Map<String, Integer> buildSymbolTable(List<Statement> statements) {
		Map<String, Integer> symbolTable = new HashMap<>();
		int lc = -1;
		for (Statement statement : statements) {
			if (statement.isOrigin())
				lc = getInt(((OrigContext) statement.ctxt).INT_HEX_LIT().getText());
			statement.address = lc;
			if (statement.label != null) {
				symbolTable.put(statement.label.getText(), lc);
			}
			lc += statement.getOffset();
		}
		return symbolTable;
	}

	public Statement parse(StatementContext ctxt) {
		return new Statement(ctxt);
	}
	
	public static class Statement {
		public final InnerStatementContext ctxt;
		public final Token label;
		public int address;

		public Statement(StatementContext ctxt) {
			this.label = ctxt.label;
			this.ctxt = ctxt.innerStatement();
		}

		public Collection<Integer> emit(Map<String, Integer> symbolTable) {
			if (ctxt instanceof AddContext) {
				AddContext addContext = (AddContext) ctxt;
				int opcode = 0b0001;
				int dr = getRegister(addContext.dr.getText());
				int reg = getRegister(addContext.left.getText());
				int imm;
				int val;
				if (isRegister(addContext.right.getText())) {
					imm = 0;
					val = getRegister(addContext.right.getText());
				}
				else {
					imm = 1;
					val = getInt(addContext.right.getText());
				}
				int ret = opcode << 12 | (dr & 0b111) << 9 | (reg & 0b111) << 6 | (imm & 0b1) << 5
					| (val & 0b11111);
				return List.of(ret);
			}
			else if (ctxt instanceof AndContext) {
				AndContext addContext = (AndContext) ctxt;
				int opcode = 0b0101;
				int dr = getRegister(addContext.dr.getText());
				int reg = getRegister(addContext.left.getText());
				int imm;
				int val;
				if (isRegister(addContext.right.getText())) {
					imm = 0;
					val = getRegister(addContext.right.getText());
				}
				else {
					imm = 1;
					val = getInt(addContext.right.getText());
				}
				int ret = opcode << 12 | (dr & 0b111) << 9 | (reg & 0b111) << 6 | (imm & 0b1) << 5
					| (val & 0b11111);
				return List.of(ret);
			}
			else if (ctxt instanceof NotContext) {
				NotContext notContext = (NotContext) ctxt;
				int opcode = 0b1001;
				int dr = getRegister(notContext.dr.getText());
				int sr = getRegister(notContext.value.getText());
				int imm = 0b111111;
				int ret = opcode << 12 | (dr & 0b111) << 9 | (sr & 0b111) << 6 | imm;
				return List.of(ret);
			}
			else if (ctxt instanceof BrContext) {
				BrContext br = (BrContext) ctxt;
				int opcode = 0b0000;
				int n = br.n != null ? 0b1 : 0b0;
				int p = br.p != null ? 0b1 : 0b0;
				int z = br.z != null ? 0b1 : 0b0;
				if (n == 0b0 && p == 0b0 && z == 0b0) {
					n = 0b1;
					p = 0b1;
					z = 0b1;
				}
				int label = getAddress(symbolTable, br.LABEL().getText());
				int ret = opcode << 12 | n << 11 | z << 10 | p << 9 | (label & 0b111111111);
				return List.of(ret);
			}
			else if (ctxt instanceof BlkwContext) {
				BlkwContext blkw = (BlkwContext) ctxt;
				List<Integer> ints = new ArrayList<>();
				for (int i = 0; i < getInt(blkw.INT_LIT().getText()); i++) {
					ints.add(0);
				}
				return ints;
			}
			else if (ctxt instanceof OrigContext) {
				OrigContext orig = (OrigContext) ctxt;
				int value = getInt(orig.INT_HEX_LIT().getText());
				return List.of(value);
			}
			else if (ctxt instanceof FillContext) {
				FillContext fill = (FillContext) ctxt;
				int value = getInt(fill.val.getText());
				return List.of(value);
			}
			else if (ctxt instanceof EndContext) {
				return List.of();
			}
			else if (ctxt instanceof LabelContext) {
				return List.of();
			}
			else if (ctxt instanceof GetcContext) {
				int opcode = 0b1111;
				int trapvec = 0x20;
				int ret = opcode << 12 | trapvec;
				return List.of(ret);
			}
			else if (ctxt instanceof HaltContext) {
				int opcode = 0b1111;
				int trapvec = 0x25;
				int ret = opcode << 12 | trapvec;
				return List.of(ret);
			}
			else if (ctxt instanceof OutContext) {
				int opcode = 0b1111;
				int trapvec = 0x21;
				int ret = opcode << 12 | trapvec;
				return List.of(ret);
			}
			else if (ctxt instanceof PutsContext) {
				int opcode = 0b1111;
				int trapvec = 0x22;
				int ret = opcode << 12 | trapvec;
				return List.of(ret);
			}
			else if (ctxt instanceof JmpContext) {
				JmpContext jmp = (JmpContext) ctxt;
				int opcode = 0b1100;
				int baser = getRegister(jmp.baser.getText());
				int ret = opcode << 12 | (baser & 0b111) << 6;
				return List.of(ret);
			}
			else if (ctxt instanceof RetContext) {
				int opcode = 0b1100;
				int baser = 0b111;
				int ret = opcode << 12 | baser << 6;
				return List.of(ret);
			}
			else if (ctxt instanceof StContext) {
				StContext st = (StContext) ctxt;
				int opcode = 0b0011;
				int sr = getRegister(st.sr.getText());
				int label = getAddress(symbolTable, st.LABEL().getText());
				int ret = opcode << 12 | sr << 9 | (label & 0b111111111);
				return List.of(ret);
			}
			else if (ctxt instanceof StiContext) {
				StiContext st = (StiContext) ctxt;
				int opcode = 0b1011;
				int sr = getRegister(st.sr.getText());
				int label = getAddress(symbolTable, st.LABEL().getText()); // should be effective address... Right?
				int ret = opcode << 12 | sr << 9 | (label & 0b111111111);
				return List.of(ret);
			}
			else if (ctxt instanceof StrContext) {
				StrContext st = (StrContext) ctxt;
				int opcode = 0b0111;
				int sr = getRegister(st.sr.getText());
				int baser = getRegister(st.br.getText());
				int label = getInt(st.offset.getText());
				int ret = opcode << 12 | sr << 9 | baser << 6 | (label & 0b111111);
				return List.of(ret);
			}
			else if (ctxt instanceof JsrContext) {
				JsrContext jsr = (JsrContext) ctxt;
				int opcode = 0b0100;
				int bit11 = 0b1;
				int label = getAddress(symbolTable, jsr.LABEL().getText());
				int ret = opcode << 12 | bit11 << 11 | (label & 0b11111111111);
				return List.of(ret);
			}
			else if (ctxt instanceof JsrrContext) {
				JsrrContext jsrr = (JsrrContext) ctxt;
				int opcode = 0b0100;
				int bit11 = 0b0;
				int val = getRegister(jsrr.REGISTER().getText()); 
				int ret = opcode << 12 | bit11 << 11 | (val & 0b111) << 6;
				return List.of(ret);
			}
			else if (ctxt instanceof LdContext) {
				LdContext ldContext = (LdContext) ctxt;
				int opcode = 0b0010;
				int dr = getRegister(ldContext.dr.getText());
				int label = getAddress(symbolTable, ldContext.LABEL().getText());
				int ret = opcode << 12 | (dr & 0b111) << 9 | (label & 0b111111111);
				return List.of(ret);
			}
			else if (ctxt instanceof LdrContext) {
				LdrContext ldContext = (LdrContext) ctxt;
				int opcode = 0b0110;
				int dr = getRegister(ldContext.dr.getText());
				int baser = getRegister(ldContext.baser.getText());
				int offset = getInt(ldContext.offset.getText());
				int ret = opcode << 12 | (dr & 0b111) << 9 | (baser & 0b111) << 6 | (offset & 0b111111);
				return List.of(ret);
			}
			else if (ctxt instanceof LdiContext) {
				LdiContext ldiContext = (LdiContext) ctxt;
				int opcode = 0b1010;
				int dr = getRegister(ldiContext.dr.getText());
				int label = getAddress(symbolTable, ldiContext.LABEL().getText());
				int ret = opcode << 12 | (dr & 0b111) << 9 | (label & 0b111111111);
				return List.of(ret);
			}
			else if (ctxt instanceof LeaContext) {
				LeaContext ldiContext = (LeaContext) ctxt;
				int opcode = 0b1110;
				int dr = getRegister(ldiContext.dr.getText());
				int label = getAddress(symbolTable, ldiContext.LABEL().getText());
				int ret = opcode << 12 | (dr & 0b111) << 9 | (label & 0b111111111);
				return List.of(ret);
			}
			else if (ctxt instanceof StringzContext) {
				StringzContext stringzContext = (StringzContext) ctxt;
				List<Integer> chars = new ArrayList<>();
				String stringLiteral = stringzContext.STR_LIT().getText().replaceAll("<n>", "\n");
				for (int i = 1; i < stringLiteral.length() - 1; i++) {
					chars.add((int) stringLiteral.charAt(i));
				}
				chars.add(0);
				return chars;
			}
			return null;
		}

		private int getAddress(Map<String, Integer> symbolTable, String label) {
			if (!symbolTable.containsKey(label)) {
				System.out.println(label + " not found");
			}
			return symbolTable.get(label) - address - 1;
		}

		public int getOffset() {
			if (ctxt instanceof BlkwContext) {
				BlkwContext val = (BlkwContext) ctxt;
				return getInt(val.INT_LIT().getText());
			}
			else if (ctxt instanceof StringzContext) {
				StringzContext val = (StringzContext) ctxt;
				String text = val.STR_LIT().getText().replaceAll("<n>", "\n");
				return text.length() - 1;
			}
			else if (ctxt instanceof LabelContext) {
				return 0;
			}
			else {
				return 1;
			}
		}

		public boolean isOrigin() {
			return ctxt instanceof OrigContext;
		}
	}

	private static int getInt(String text) {
		if (text.charAt(0) == 'x') {
			return Integer.parseInt(text.substring(1), 16);
		}
		else if (text.charAt(0) == '#') {
			return Integer.parseInt(text.substring(1), 10);
		}
		else {
			return Integer.parseInt(text, 10);
		}
	}

	private static int getRegister(String text) {
		if (text.startsWith("R"))
			return Integer.parseInt(text.substring(1));
		else
			throw new RuntimeException();
	}

	private static boolean isRegister(String text) {
		return text.startsWith("R");
	}
}
