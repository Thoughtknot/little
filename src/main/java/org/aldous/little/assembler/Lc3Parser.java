// Generated from Lc3.g4 by ANTLR 4.7.2

package org.aldous.little.assembler;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Lc3Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, NEWLINE=4, WS=5, INT_LIT=6, INT_DEC_LIT=7, INT_HEX_LIT=8, 
		STR_LIT=9, ORIG=10, END=11, FILL=12, BLKW=13, STRINGZ=14, BR=15, LDI=16, 
		LD=17, LDR=18, LEA=19, STI=20, STR=21, ST=22, JMP=23, JSR=24, JSRR=25, 
		RET=26, ADD=27, AND=28, NOT=29, HALT=30, IN=31, OUT=32, GETC=33, PUTS=34, 
		REGISTER=35, COMMA=36, LABEL=37;
	public static final int
		RULE_file = 0, RULE_statement = 1, RULE_innerStatement = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "statement", "innerStatement"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'n'", "'z'", "'p'", "'\n'", null, null, null, null, null, "'.ORIG'", 
			"'.END'", "'.FILL'", "'.BLKW'", "'.STRINGZ'", "'BR'", "'LDI'", "'LD'", 
			"'LDR'", "'LEA'", "'STI'", "'STR'", "'ST'", "'JMP'", "'JSR'", "'JSRR'", 
			"'RET'", "'ADD'", "'AND'", "'NOT'", "'HALT'", "'IN'", "'OUT'", "'GETC'", 
			"'PUTS'", null, "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "NEWLINE", "WS", "INT_LIT", "INT_DEC_LIT", "INT_HEX_LIT", 
			"STR_LIT", "ORIG", "END", "FILL", "BLKW", "STRINGZ", "BR", "LDI", "LD", 
			"LDR", "LEA", "STI", "STR", "ST", "JMP", "JSR", "JSRR", "RET", "ADD", 
			"AND", "NOT", "HALT", "IN", "OUT", "GETC", "PUTS", "REGISTER", "COMMA", 
			"LABEL"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Lc3.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Lc3Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FileContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(Lc3Parser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(Lc3Parser.NEWLINE, i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).exitFile(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(9); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(6);
				statement();
				setState(7);
				match(NEWLINE);
				}
				}
				setState(11); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEWLINE) | (1L << ORIG) | (1L << END) | (1L << FILL) | (1L << BLKW) | (1L << STRINGZ) | (1L << BR) | (1L << LDI) | (1L << LD) | (1L << LDR) | (1L << LEA) | (1L << STI) | (1L << STR) | (1L << ST) | (1L << JMP) | (1L << JSR) | (1L << JSRR) | (1L << RET) | (1L << ADD) | (1L << AND) | (1L << NOT) | (1L << HALT) | (1L << OUT) | (1L << GETC) | (1L << PUTS) | (1L << LABEL))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public Token label;
		public InnerStatementContext innerStatement() {
			return getRuleContext(InnerStatementContext.class,0);
		}
		public TerminalNode LABEL() { return getToken(Lc3Parser.LABEL, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LABEL) {
				{
				setState(13);
				((StatementContext)_localctx).label = match(LABEL);
				}
			}

			setState(16);
			innerStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InnerStatementContext extends ParserRuleContext {
		public InnerStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_innerStatement; }
	 
		public InnerStatementContext() { }
		public void copyFrom(InnerStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class JsrContext extends InnerStatementContext {
		public TerminalNode JSR() { return getToken(Lc3Parser.JSR, 0); }
		public TerminalNode LABEL() { return getToken(Lc3Parser.LABEL, 0); }
		public JsrContext(InnerStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).enterJsr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).exitJsr(this);
		}
	}
	public static class LeaContext extends InnerStatementContext {
		public Token dr;
		public TerminalNode LEA() { return getToken(Lc3Parser.LEA, 0); }
		public TerminalNode COMMA() { return getToken(Lc3Parser.COMMA, 0); }
		public TerminalNode LABEL() { return getToken(Lc3Parser.LABEL, 0); }
		public TerminalNode REGISTER() { return getToken(Lc3Parser.REGISTER, 0); }
		public LeaContext(InnerStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).enterLea(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).exitLea(this);
		}
	}
	public static class JmpContext extends InnerStatementContext {
		public Token baser;
		public TerminalNode JMP() { return getToken(Lc3Parser.JMP, 0); }
		public TerminalNode REGISTER() { return getToken(Lc3Parser.REGISTER, 0); }
		public JmpContext(InnerStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).enterJmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).exitJmp(this);
		}
	}
	public static class OutContext extends InnerStatementContext {
		public TerminalNode OUT() { return getToken(Lc3Parser.OUT, 0); }
		public OutContext(InnerStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).enterOut(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).exitOut(this);
		}
	}
	public static class BrContext extends InnerStatementContext {
		public Token n;
		public Token z;
		public Token p;
		public TerminalNode BR() { return getToken(Lc3Parser.BR, 0); }
		public TerminalNode LABEL() { return getToken(Lc3Parser.LABEL, 0); }
		public BrContext(InnerStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).enterBr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).exitBr(this);
		}
	}
	public static class NotContext extends InnerStatementContext {
		public Token dr;
		public Token value;
		public TerminalNode NOT() { return getToken(Lc3Parser.NOT, 0); }
		public TerminalNode COMMA() { return getToken(Lc3Parser.COMMA, 0); }
		public List<TerminalNode> REGISTER() { return getTokens(Lc3Parser.REGISTER); }
		public TerminalNode REGISTER(int i) {
			return getToken(Lc3Parser.REGISTER, i);
		}
		public NotContext(InnerStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).exitNot(this);
		}
	}
	public static class AndContext extends InnerStatementContext {
		public Token dr;
		public Token left;
		public Token right;
		public TerminalNode AND() { return getToken(Lc3Parser.AND, 0); }
		public List<TerminalNode> COMMA() { return getTokens(Lc3Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Lc3Parser.COMMA, i);
		}
		public List<TerminalNode> REGISTER() { return getTokens(Lc3Parser.REGISTER); }
		public TerminalNode REGISTER(int i) {
			return getToken(Lc3Parser.REGISTER, i);
		}
		public TerminalNode INT_DEC_LIT() { return getToken(Lc3Parser.INT_DEC_LIT, 0); }
		public AndContext(InnerStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).exitAnd(this);
		}
	}
	public static class BlkwContext extends InnerStatementContext {
		public Token val;
		public TerminalNode BLKW() { return getToken(Lc3Parser.BLKW, 0); }
		public TerminalNode INT_DEC_LIT() { return getToken(Lc3Parser.INT_DEC_LIT, 0); }
		public TerminalNode INT_HEX_LIT() { return getToken(Lc3Parser.INT_HEX_LIT, 0); }
		public BlkwContext(InnerStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).enterBlkw(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).exitBlkw(this);
		}
	}
	public static class EndContext extends InnerStatementContext {
		public TerminalNode END() { return getToken(Lc3Parser.END, 0); }
		public EndContext(InnerStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).enterEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).exitEnd(this);
		}
	}
	public static class StringzContext extends InnerStatementContext {
		public TerminalNode STRINGZ() { return getToken(Lc3Parser.STRINGZ, 0); }
		public TerminalNode STR_LIT() { return getToken(Lc3Parser.STR_LIT, 0); }
		public StringzContext(InnerStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).enterStringz(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).exitStringz(this);
		}
	}
	public static class AddContext extends InnerStatementContext {
		public Token dr;
		public Token left;
		public Token right;
		public TerminalNode ADD() { return getToken(Lc3Parser.ADD, 0); }
		public List<TerminalNode> COMMA() { return getTokens(Lc3Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Lc3Parser.COMMA, i);
		}
		public List<TerminalNode> REGISTER() { return getTokens(Lc3Parser.REGISTER); }
		public TerminalNode REGISTER(int i) {
			return getToken(Lc3Parser.REGISTER, i);
		}
		public TerminalNode INT_DEC_LIT() { return getToken(Lc3Parser.INT_DEC_LIT, 0); }
		public AddContext(InnerStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).enterAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).exitAdd(this);
		}
	}
	public static class RetContext extends InnerStatementContext {
		public TerminalNode RET() { return getToken(Lc3Parser.RET, 0); }
		public RetContext(InnerStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).enterRet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).exitRet(this);
		}
	}
	public static class StContext extends InnerStatementContext {
		public Token sr;
		public TerminalNode ST() { return getToken(Lc3Parser.ST, 0); }
		public TerminalNode COMMA() { return getToken(Lc3Parser.COMMA, 0); }
		public TerminalNode LABEL() { return getToken(Lc3Parser.LABEL, 0); }
		public TerminalNode REGISTER() { return getToken(Lc3Parser.REGISTER, 0); }
		public StContext(InnerStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).enterSt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).exitSt(this);
		}
	}
	public static class StiContext extends InnerStatementContext {
		public Token sr;
		public TerminalNode STI() { return getToken(Lc3Parser.STI, 0); }
		public TerminalNode COMMA() { return getToken(Lc3Parser.COMMA, 0); }
		public TerminalNode LABEL() { return getToken(Lc3Parser.LABEL, 0); }
		public TerminalNode REGISTER() { return getToken(Lc3Parser.REGISTER, 0); }
		public StiContext(InnerStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).enterSti(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).exitSti(this);
		}
	}
	public static class LabelContext extends InnerStatementContext {
		public LabelContext(InnerStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).enterLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).exitLabel(this);
		}
	}
	public static class FillContext extends InnerStatementContext {
		public Token val;
		public TerminalNode FILL() { return getToken(Lc3Parser.FILL, 0); }
		public TerminalNode INT_DEC_LIT() { return getToken(Lc3Parser.INT_DEC_LIT, 0); }
		public TerminalNode INT_HEX_LIT() { return getToken(Lc3Parser.INT_HEX_LIT, 0); }
		public FillContext(InnerStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).enterFill(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).exitFill(this);
		}
	}
	public static class LdiContext extends InnerStatementContext {
		public Token dr;
		public TerminalNode LDI() { return getToken(Lc3Parser.LDI, 0); }
		public TerminalNode COMMA() { return getToken(Lc3Parser.COMMA, 0); }
		public TerminalNode LABEL() { return getToken(Lc3Parser.LABEL, 0); }
		public TerminalNode REGISTER() { return getToken(Lc3Parser.REGISTER, 0); }
		public LdiContext(InnerStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).enterLdi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).exitLdi(this);
		}
	}
	public static class StrContext extends InnerStatementContext {
		public Token sr;
		public Token br;
		public Token offset;
		public TerminalNode STR() { return getToken(Lc3Parser.STR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(Lc3Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Lc3Parser.COMMA, i);
		}
		public List<TerminalNode> REGISTER() { return getTokens(Lc3Parser.REGISTER); }
		public TerminalNode REGISTER(int i) {
			return getToken(Lc3Parser.REGISTER, i);
		}
		public TerminalNode INT_DEC_LIT() { return getToken(Lc3Parser.INT_DEC_LIT, 0); }
		public StrContext(InnerStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).enterStr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).exitStr(this);
		}
	}
	public static class PutsContext extends InnerStatementContext {
		public TerminalNode PUTS() { return getToken(Lc3Parser.PUTS, 0); }
		public PutsContext(InnerStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).enterPuts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).exitPuts(this);
		}
	}
	public static class HaltContext extends InnerStatementContext {
		public TerminalNode HALT() { return getToken(Lc3Parser.HALT, 0); }
		public HaltContext(InnerStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).enterHalt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).exitHalt(this);
		}
	}
	public static class OrigContext extends InnerStatementContext {
		public TerminalNode ORIG() { return getToken(Lc3Parser.ORIG, 0); }
		public TerminalNode INT_HEX_LIT() { return getToken(Lc3Parser.INT_HEX_LIT, 0); }
		public OrigContext(InnerStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).enterOrig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).exitOrig(this);
		}
	}
	public static class JsrrContext extends InnerStatementContext {
		public TerminalNode JSRR() { return getToken(Lc3Parser.JSRR, 0); }
		public TerminalNode REGISTER() { return getToken(Lc3Parser.REGISTER, 0); }
		public JsrrContext(InnerStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).enterJsrr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).exitJsrr(this);
		}
	}
	public static class LdContext extends InnerStatementContext {
		public Token dr;
		public TerminalNode LD() { return getToken(Lc3Parser.LD, 0); }
		public TerminalNode COMMA() { return getToken(Lc3Parser.COMMA, 0); }
		public TerminalNode LABEL() { return getToken(Lc3Parser.LABEL, 0); }
		public TerminalNode REGISTER() { return getToken(Lc3Parser.REGISTER, 0); }
		public LdContext(InnerStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).enterLd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).exitLd(this);
		}
	}
	public static class LdrContext extends InnerStatementContext {
		public Token dr;
		public Token baser;
		public Token offset;
		public TerminalNode LDR() { return getToken(Lc3Parser.LDR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(Lc3Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Lc3Parser.COMMA, i);
		}
		public List<TerminalNode> REGISTER() { return getTokens(Lc3Parser.REGISTER); }
		public TerminalNode REGISTER(int i) {
			return getToken(Lc3Parser.REGISTER, i);
		}
		public TerminalNode INT_DEC_LIT() { return getToken(Lc3Parser.INT_DEC_LIT, 0); }
		public LdrContext(InnerStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).enterLdr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).exitLdr(this);
		}
	}
	public static class GetcContext extends InnerStatementContext {
		public TerminalNode GETC() { return getToken(Lc3Parser.GETC, 0); }
		public GetcContext(InnerStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).enterGetc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Lc3Listener ) ((Lc3Listener)listener).exitGetc(this);
		}
	}

	public final InnerStatementContext innerStatement() throws RecognitionException {
		InnerStatementContext _localctx = new InnerStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_innerStatement);
		int _la;
		try {
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ORIG:
				_localctx = new OrigContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(18);
				match(ORIG);
				setState(19);
				match(INT_HEX_LIT);
				}
				break;
			case ADD:
				_localctx = new AddContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(20);
				match(ADD);
				setState(21);
				((AddContext)_localctx).dr = match(REGISTER);
				setState(22);
				match(COMMA);
				setState(23);
				((AddContext)_localctx).left = match(REGISTER);
				setState(24);
				match(COMMA);
				setState(25);
				((AddContext)_localctx).right = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INT_DEC_LIT || _la==REGISTER) ) {
					((AddContext)_localctx).right = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case AND:
				_localctx = new AndContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(26);
				match(AND);
				setState(27);
				((AndContext)_localctx).dr = match(REGISTER);
				setState(28);
				match(COMMA);
				setState(29);
				((AndContext)_localctx).left = match(REGISTER);
				setState(30);
				match(COMMA);
				setState(31);
				((AndContext)_localctx).right = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INT_DEC_LIT || _la==REGISTER) ) {
					((AndContext)_localctx).right = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case NOT:
				_localctx = new NotContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(32);
				match(NOT);
				setState(33);
				((NotContext)_localctx).dr = match(REGISTER);
				setState(34);
				match(COMMA);
				setState(35);
				((NotContext)_localctx).value = match(REGISTER);
				}
				break;
			case JMP:
				_localctx = new JmpContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(36);
				match(JMP);
				setState(37);
				((JmpContext)_localctx).baser = match(REGISTER);
				}
				break;
			case BR:
				_localctx = new BrContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(38);
				match(BR);
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(39);
					((BrContext)_localctx).n = match(T__0);
					}
				}

				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(42);
					((BrContext)_localctx).z = match(T__1);
					}
				}

				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(45);
					((BrContext)_localctx).p = match(T__2);
					}
				}

				setState(48);
				match(LABEL);
				}
				break;
			case RET:
				_localctx = new RetContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(49);
				match(RET);
				}
				break;
			case JSR:
				_localctx = new JsrContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(50);
				match(JSR);
				setState(51);
				match(LABEL);
				}
				break;
			case NEWLINE:
				_localctx = new LabelContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				}
				break;
			case JSRR:
				_localctx = new JsrrContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(53);
				match(JSRR);
				setState(54);
				match(REGISTER);
				}
				break;
			case LD:
				_localctx = new LdContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(55);
				match(LD);
				setState(56);
				((LdContext)_localctx).dr = match(REGISTER);
				setState(57);
				match(COMMA);
				setState(58);
				match(LABEL);
				}
				break;
			case LDI:
				_localctx = new LdiContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(59);
				match(LDI);
				setState(60);
				((LdiContext)_localctx).dr = match(REGISTER);
				setState(61);
				match(COMMA);
				setState(62);
				match(LABEL);
				}
				break;
			case LDR:
				_localctx = new LdrContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(63);
				match(LDR);
				setState(64);
				((LdrContext)_localctx).dr = match(REGISTER);
				setState(65);
				match(COMMA);
				setState(66);
				((LdrContext)_localctx).baser = match(REGISTER);
				setState(67);
				match(COMMA);
				setState(68);
				((LdrContext)_localctx).offset = match(INT_DEC_LIT);
				}
				break;
			case LEA:
				_localctx = new LeaContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(69);
				match(LEA);
				setState(70);
				((LeaContext)_localctx).dr = match(REGISTER);
				setState(71);
				match(COMMA);
				setState(72);
				match(LABEL);
				}
				break;
			case ST:
				_localctx = new StContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(73);
				match(ST);
				setState(74);
				((StContext)_localctx).sr = match(REGISTER);
				setState(75);
				match(COMMA);
				setState(76);
				match(LABEL);
				}
				break;
			case STI:
				_localctx = new StiContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(77);
				match(STI);
				setState(78);
				((StiContext)_localctx).sr = match(REGISTER);
				setState(79);
				match(COMMA);
				setState(80);
				match(LABEL);
				}
				break;
			case STR:
				_localctx = new StrContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(81);
				match(STR);
				setState(82);
				((StrContext)_localctx).sr = match(REGISTER);
				setState(83);
				match(COMMA);
				setState(84);
				((StrContext)_localctx).br = match(REGISTER);
				setState(85);
				match(COMMA);
				setState(86);
				((StrContext)_localctx).offset = match(INT_DEC_LIT);
				}
				break;
			case FILL:
				_localctx = new FillContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(87);
				match(FILL);
				setState(88);
				((FillContext)_localctx).val = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INT_DEC_LIT || _la==INT_HEX_LIT) ) {
					((FillContext)_localctx).val = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case STRINGZ:
				_localctx = new StringzContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(89);
				match(STRINGZ);
				setState(90);
				match(STR_LIT);
				}
				break;
			case BLKW:
				_localctx = new BlkwContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(91);
				match(BLKW);
				setState(92);
				((BlkwContext)_localctx).val = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INT_DEC_LIT || _la==INT_HEX_LIT) ) {
					((BlkwContext)_localctx).val = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case PUTS:
				_localctx = new PutsContext(_localctx);
				enterOuterAlt(_localctx, 21);
				{
				setState(93);
				match(PUTS);
				}
				break;
			case GETC:
				_localctx = new GetcContext(_localctx);
				enterOuterAlt(_localctx, 22);
				{
				setState(94);
				match(GETC);
				}
				break;
			case OUT:
				_localctx = new OutContext(_localctx);
				enterOuterAlt(_localctx, 23);
				{
				setState(95);
				match(OUT);
				}
				break;
			case HALT:
				_localctx = new HaltContext(_localctx);
				enterOuterAlt(_localctx, 24);
				{
				setState(96);
				match(HALT);
				}
				break;
			case END:
				_localctx = new EndContext(_localctx);
				enterOuterAlt(_localctx, 25);
				{
				setState(97);
				match(END);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\'g\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\3\2\3\2\3\2\6\2\f\n\2\r\2\16\2\r\3\3\5\3\21\n\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\5\4+\n\4\3\4\5\4.\n\4\3\4\5\4\61\n\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4e\n\4\3\4\2\2\5\2\4\6\2"+
		"\4\4\2\t\t%%\3\2\t\n\2\u0080\2\13\3\2\2\2\4\20\3\2\2\2\6d\3\2\2\2\b\t"+
		"\5\4\3\2\t\n\7\6\2\2\n\f\3\2\2\2\13\b\3\2\2\2\f\r\3\2\2\2\r\13\3\2\2\2"+
		"\r\16\3\2\2\2\16\3\3\2\2\2\17\21\7\'\2\2\20\17\3\2\2\2\20\21\3\2\2\2\21"+
		"\22\3\2\2\2\22\23\5\6\4\2\23\5\3\2\2\2\24\25\7\f\2\2\25e\7\n\2\2\26\27"+
		"\7\35\2\2\27\30\7%\2\2\30\31\7&\2\2\31\32\7%\2\2\32\33\7&\2\2\33e\t\2"+
		"\2\2\34\35\7\36\2\2\35\36\7%\2\2\36\37\7&\2\2\37 \7%\2\2 !\7&\2\2!e\t"+
		"\2\2\2\"#\7\37\2\2#$\7%\2\2$%\7&\2\2%e\7%\2\2&\'\7\31\2\2\'e\7%\2\2(*"+
		"\7\21\2\2)+\7\3\2\2*)\3\2\2\2*+\3\2\2\2+-\3\2\2\2,.\7\4\2\2-,\3\2\2\2"+
		"-.\3\2\2\2.\60\3\2\2\2/\61\7\5\2\2\60/\3\2\2\2\60\61\3\2\2\2\61\62\3\2"+
		"\2\2\62e\7\'\2\2\63e\7\34\2\2\64\65\7\32\2\2\65e\7\'\2\2\66e\3\2\2\2\67"+
		"8\7\33\2\28e\7%\2\29:\7\23\2\2:;\7%\2\2;<\7&\2\2<e\7\'\2\2=>\7\22\2\2"+
		">?\7%\2\2?@\7&\2\2@e\7\'\2\2AB\7\24\2\2BC\7%\2\2CD\7&\2\2DE\7%\2\2EF\7"+
		"&\2\2Fe\7\t\2\2GH\7\25\2\2HI\7%\2\2IJ\7&\2\2Je\7\'\2\2KL\7\30\2\2LM\7"+
		"%\2\2MN\7&\2\2Ne\7\'\2\2OP\7\26\2\2PQ\7%\2\2QR\7&\2\2Re\7\'\2\2ST\7\27"+
		"\2\2TU\7%\2\2UV\7&\2\2VW\7%\2\2WX\7&\2\2Xe\7\t\2\2YZ\7\16\2\2Ze\t\3\2"+
		"\2[\\\7\20\2\2\\e\7\13\2\2]^\7\17\2\2^e\t\3\2\2_e\7$\2\2`e\7#\2\2ae\7"+
		"\"\2\2be\7 \2\2ce\7\r\2\2d\24\3\2\2\2d\26\3\2\2\2d\34\3\2\2\2d\"\3\2\2"+
		"\2d&\3\2\2\2d(\3\2\2\2d\63\3\2\2\2d\64\3\2\2\2d\66\3\2\2\2d\67\3\2\2\2"+
		"d9\3\2\2\2d=\3\2\2\2dA\3\2\2\2dG\3\2\2\2dK\3\2\2\2dO\3\2\2\2dS\3\2\2\2"+
		"dY\3\2\2\2d[\3\2\2\2d]\3\2\2\2d_\3\2\2\2d`\3\2\2\2da\3\2\2\2db\3\2\2\2"+
		"dc\3\2\2\2e\7\3\2\2\2\b\r\20*-\60d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}