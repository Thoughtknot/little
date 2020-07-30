// Generated from Little.g4 by ANTLR 4.7.1

package org.aldous.little;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LittleParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, INT_LIT=2, CHAR_LIT=3, STR_LIT=4, LOOP=5, TRUE=6, FALSE=7, PRINT=8, 
		DEF=9, IF=10, ELIF=11, ELSE=12, PLUS=13, MINUS=14, ASTERISK=15, SLASH=16, 
		LPAREN=17, RPAREN=18, LSPAREN=19, RSPAREN=20, LCPAREN=21, RCPAREN=22, 
		COMMA=23, SEMIC=24, COLON=25, EQ=26, LARROW=27, RARROW=28, DOLLAR=29, 
		VARIABLE_ID=30;
	public static final int
		RULE_file = 0, RULE_line = 1, RULE_elseStmt = 2, RULE_statement = 3, RULE_expression = 4;
	public static final String[] ruleNames = {
		"file", "line", "elseStmt", "statement", "expression"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, "'loop'", "'true'", "'false'", "'print'", 
		"'def'", "'if'", "'elif'", "'else'", "'+'", "'-'", "'*'", "'/'", "'('", 
		"')'", "'['", "']'", "'{'", "'}'", "','", "';'", "':'", "'='", "'<-'", 
		"'->'", "'$'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "INT_LIT", "CHAR_LIT", "STR_LIT", "LOOP", "TRUE", "FALSE", 
		"PRINT", "DEF", "IF", "ELIF", "ELSE", "PLUS", "MINUS", "ASTERISK", "SLASH", 
		"LPAREN", "RPAREN", "LSPAREN", "RSPAREN", "LCPAREN", "RCPAREN", "COMMA", 
		"SEMIC", "COLON", "EQ", "LARROW", "RARROW", "DOLLAR", "VARIABLE_ID"
	};
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
	public String getGrammarFileName() { return "Little.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LittleParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FileContext extends ParserRuleContext {
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).exitFile(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(11); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(10);
				line();
				}
				}
				setState(13); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOOP) | (1L << PRINT) | (1L << DEF) | (1L << IF) | (1L << VARIABLE_ID))) != 0) );
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

	public static class LineContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode SEMIC() { return getToken(LittleParser.SEMIC, 0); }
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).exitLine(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			statement();
			setState(16);
			match(SEMIC);
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

	public static class ElseStmtContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(LittleParser.ELSE, 0); }
		public TerminalNode LCPAREN() { return getToken(LittleParser.LCPAREN, 0); }
		public TerminalNode RCPAREN() { return getToken(LittleParser.RCPAREN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> SEMIC() { return getTokens(LittleParser.SEMIC); }
		public TerminalNode SEMIC(int i) {
			return getToken(LittleParser.SEMIC, i);
		}
		public ElseStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).enterElseStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).exitElseStmt(this);
		}
	}

	public final ElseStmtContext elseStmt() throws RecognitionException {
		ElseStmtContext _localctx = new ElseStmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_elseStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			match(ELSE);
			setState(19);
			match(LCPAREN);
			setState(23); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(20);
				statement();
				setState(21);
				match(SEMIC);
				}
				}
				setState(25); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOOP) | (1L << PRINT) | (1L << DEF) | (1L << IF) | (1L << VARIABLE_ID))) != 0) );
			setState(27);
			match(RCPAREN);
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
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrintContext extends StatementContext {
		public TerminalNode PRINT() { return getToken(LittleParser.PRINT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).exitPrint(this);
		}
	}
	public static class LoopContext extends StatementContext {
		public TerminalNode LOOP() { return getToken(LittleParser.LOOP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LCPAREN() { return getToken(LittleParser.LCPAREN, 0); }
		public TerminalNode RCPAREN() { return getToken(LittleParser.RCPAREN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> SEMIC() { return getTokens(LittleParser.SEMIC); }
		public TerminalNode SEMIC(int i) {
			return getToken(LittleParser.SEMIC, i);
		}
		public LoopContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).enterLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).exitLoop(this);
		}
	}
	public static class ArrayAssContext extends StatementContext {
		public ExpressionContext index;
		public ExpressionContext value;
		public TerminalNode VARIABLE_ID() { return getToken(LittleParser.VARIABLE_ID, 0); }
		public TerminalNode LSPAREN() { return getToken(LittleParser.LSPAREN, 0); }
		public TerminalNode RSPAREN() { return getToken(LittleParser.RSPAREN, 0); }
		public TerminalNode LARROW() { return getToken(LittleParser.LARROW, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArrayAssContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).enterArrayAss(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).exitArrayAss(this);
		}
	}
	public static class VarDecContext extends StatementContext {
		public Token size;
		public TerminalNode DEF() { return getToken(LittleParser.DEF, 0); }
		public TerminalNode VARIABLE_ID() { return getToken(LittleParser.VARIABLE_ID, 0); }
		public TerminalNode LSPAREN() { return getToken(LittleParser.LSPAREN, 0); }
		public TerminalNode RSPAREN() { return getToken(LittleParser.RSPAREN, 0); }
		public TerminalNode INT_LIT() { return getToken(LittleParser.INT_LIT, 0); }
		public VarDecContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).enterVarDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).exitVarDec(this);
		}
	}
	public static class VarAssContext extends StatementContext {
		public TerminalNode VARIABLE_ID() { return getToken(LittleParser.VARIABLE_ID, 0); }
		public TerminalNode LARROW() { return getToken(LittleParser.LARROW, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarAssContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).enterVarAss(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).exitVarAss(this);
		}
	}
	public static class IfContext extends StatementContext {
		public ExpressionContext ifc;
		public TerminalNode IF() { return getToken(LittleParser.IF, 0); }
		public TerminalNode LCPAREN() { return getToken(LittleParser.LCPAREN, 0); }
		public TerminalNode RCPAREN() { return getToken(LittleParser.RCPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> SEMIC() { return getTokens(LittleParser.SEMIC); }
		public TerminalNode SEMIC(int i) {
			return getToken(LittleParser.SEMIC, i);
		}
		public ElseStmtContext elseStmt() {
			return getRuleContext(ElseStmtContext.class,0);
		}
		public IfContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).exitIf(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		int _la;
		try {
			setState(74);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new VarDecContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				match(DEF);
				setState(30);
				match(VARIABLE_ID);
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LSPAREN) {
					{
					setState(31);
					match(LSPAREN);
					setState(32);
					((VarDecContext)_localctx).size = match(INT_LIT);
					setState(33);
					match(RSPAREN);
					}
				}

				}
				break;
			case 2:
				_localctx = new VarAssContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(36);
				match(VARIABLE_ID);
				setState(37);
				match(LARROW);
				setState(38);
				expression(0);
				}
				break;
			case 3:
				_localctx = new ArrayAssContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(39);
				match(VARIABLE_ID);
				setState(40);
				match(LSPAREN);
				setState(41);
				((ArrayAssContext)_localctx).index = expression(0);
				setState(42);
				match(RSPAREN);
				setState(43);
				match(LARROW);
				setState(44);
				((ArrayAssContext)_localctx).value = expression(0);
				}
				break;
			case 4:
				_localctx = new LoopContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(46);
				match(LOOP);
				setState(47);
				expression(0);
				setState(48);
				match(LCPAREN);
				setState(52); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(49);
					statement();
					setState(50);
					match(SEMIC);
					}
					}
					setState(54); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOOP) | (1L << PRINT) | (1L << DEF) | (1L << IF) | (1L << VARIABLE_ID))) != 0) );
				setState(56);
				match(RCPAREN);
				}
				break;
			case 5:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(58);
				match(IF);
				setState(59);
				((IfContext)_localctx).ifc = expression(0);
				setState(60);
				match(LCPAREN);
				setState(64); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(61);
					statement();
					setState(62);
					match(SEMIC);
					}
					}
					setState(66); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOOP) | (1L << PRINT) | (1L << DEF) | (1L << IF) | (1L << VARIABLE_ID))) != 0) );
				setState(68);
				match(RCPAREN);
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(69);
					elseStmt();
					}
				}

				}
				break;
			case 6:
				_localctx = new PrintContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(72);
				match(PRINT);
				setState(73);
				expression(0);
				}
				break;
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DivisionContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public TerminalNode SLASH() { return getToken(LittleParser.SLASH, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DivisionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).enterDivision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).exitDivision(this);
		}
	}
	public static class ParenContext extends ExpressionContext {
		public TerminalNode LPAREN() { return getToken(LittleParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LittleParser.RPAREN, 0); }
		public ParenContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).enterParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).exitParen(this);
		}
	}
	public static class StringLiteralContext extends ExpressionContext {
		public TerminalNode STR_LIT() { return getToken(LittleParser.STR_LIT, 0); }
		public StringLiteralContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).exitStringLiteral(this);
		}
	}
	public static class VariableReferenceContext extends ExpressionContext {
		public TerminalNode VARIABLE_ID() { return getToken(LittleParser.VARIABLE_ID, 0); }
		public VariableReferenceContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).enterVariableReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).exitVariableReference(this);
		}
	}
	public static class IntLiteralContext extends ExpressionContext {
		public TerminalNode INT_LIT() { return getToken(LittleParser.INT_LIT, 0); }
		public IntLiteralContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).enterIntLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).exitIntLiteral(this);
		}
	}
	public static class SubtractionContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public TerminalNode MINUS() { return getToken(LittleParser.MINUS, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public SubtractionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).enterSubtraction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).exitSubtraction(this);
		}
	}
	public static class CharLiteralContext extends ExpressionContext {
		public TerminalNode CHAR_LIT() { return getToken(LittleParser.CHAR_LIT, 0); }
		public CharLiteralContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).enterCharLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).exitCharLiteral(this);
		}
	}
	public static class ArrayRefContext extends ExpressionContext {
		public TerminalNode VARIABLE_ID() { return getToken(LittleParser.VARIABLE_ID, 0); }
		public TerminalNode LSPAREN() { return getToken(LittleParser.LSPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RSPAREN() { return getToken(LittleParser.RSPAREN, 0); }
		public ArrayRefContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).enterArrayRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).exitArrayRef(this);
		}
	}
	public static class MultiplicationContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public TerminalNode ASTERISK() { return getToken(LittleParser.ASTERISK, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MultiplicationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).enterMultiplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).exitMultiplication(this);
		}
	}
	public static class AdditionContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public TerminalNode PLUS() { return getToken(LittleParser.PLUS, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AdditionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).enterAddition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).exitAddition(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				_localctx = new VariableReferenceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(77);
				match(VARIABLE_ID);
				}
				break;
			case 2:
				{
				_localctx = new IntLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(78);
				match(INT_LIT);
				}
				break;
			case 3:
				{
				_localctx = new CharLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(79);
				match(CHAR_LIT);
				}
				break;
			case 4:
				{
				_localctx = new StringLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(80);
				match(STR_LIT);
				}
				break;
			case 5:
				{
				_localctx = new ParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(81);
				match(LPAREN);
				setState(82);
				expression(0);
				setState(83);
				match(RPAREN);
				}
				break;
			case 6:
				{
				_localctx = new ArrayRefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(85);
				match(VARIABLE_ID);
				setState(86);
				match(LSPAREN);
				setState(87);
				expression(0);
				setState(88);
				match(RSPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(106);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(104);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicationContext(new ExpressionContext(_parentctx, _parentState));
						((MultiplicationContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(92);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(93);
						match(ASTERISK);
						setState(94);
						((MultiplicationContext)_localctx).right = expression(10);
						}
						break;
					case 2:
						{
						_localctx = new DivisionContext(new ExpressionContext(_parentctx, _parentState));
						((DivisionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(95);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(96);
						match(SLASH);
						setState(97);
						((DivisionContext)_localctx).right = expression(9);
						}
						break;
					case 3:
						{
						_localctx = new SubtractionContext(new ExpressionContext(_parentctx, _parentState));
						((SubtractionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(98);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(99);
						match(MINUS);
						setState(100);
						((SubtractionContext)_localctx).right = expression(8);
						}
						break;
					case 4:
						{
						_localctx = new AdditionContext(new ExpressionContext(_parentctx, _parentState));
						((AdditionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(101);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(102);
						match(PLUS);
						setState(103);
						((AdditionContext)_localctx).right = expression(7);
						}
						break;
					}
					} 
				}
				setState(108);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3 p\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\3\2\6\2\16\n\2\r\2\16\2\17\3\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\3\4\6\4\32\n\4\r\4\16\4\33\3\4\3\4\3\5\3\5\3\5\3\5\3\5\5\5"+
		"%\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\6\5\67\n\5\r\5\16\58\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\6\5C\n\5\r\5\16"+
		"\5D\3\5\3\5\5\5I\n\5\3\5\3\5\5\5M\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\5\6]\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\7\6k\n\6\f\6\16\6n\13\6\3\6\2\3\n\7\2\4\6\b\n\2\2\2~\2\r"+
		"\3\2\2\2\4\21\3\2\2\2\6\24\3\2\2\2\bL\3\2\2\2\n\\\3\2\2\2\f\16\5\4\3\2"+
		"\r\f\3\2\2\2\16\17\3\2\2\2\17\r\3\2\2\2\17\20\3\2\2\2\20\3\3\2\2\2\21"+
		"\22\5\b\5\2\22\23\7\32\2\2\23\5\3\2\2\2\24\25\7\16\2\2\25\31\7\27\2\2"+
		"\26\27\5\b\5\2\27\30\7\32\2\2\30\32\3\2\2\2\31\26\3\2\2\2\32\33\3\2\2"+
		"\2\33\31\3\2\2\2\33\34\3\2\2\2\34\35\3\2\2\2\35\36\7\30\2\2\36\7\3\2\2"+
		"\2\37 \7\13\2\2 $\7 \2\2!\"\7\25\2\2\"#\7\4\2\2#%\7\26\2\2$!\3\2\2\2$"+
		"%\3\2\2\2%M\3\2\2\2&\'\7 \2\2\'(\7\35\2\2(M\5\n\6\2)*\7 \2\2*+\7\25\2"+
		"\2+,\5\n\6\2,-\7\26\2\2-.\7\35\2\2./\5\n\6\2/M\3\2\2\2\60\61\7\7\2\2\61"+
		"\62\5\n\6\2\62\66\7\27\2\2\63\64\5\b\5\2\64\65\7\32\2\2\65\67\3\2\2\2"+
		"\66\63\3\2\2\2\678\3\2\2\28\66\3\2\2\289\3\2\2\29:\3\2\2\2:;\7\30\2\2"+
		";M\3\2\2\2<=\7\f\2\2=>\5\n\6\2>B\7\27\2\2?@\5\b\5\2@A\7\32\2\2AC\3\2\2"+
		"\2B?\3\2\2\2CD\3\2\2\2DB\3\2\2\2DE\3\2\2\2EF\3\2\2\2FH\7\30\2\2GI\5\6"+
		"\4\2HG\3\2\2\2HI\3\2\2\2IM\3\2\2\2JK\7\n\2\2KM\5\n\6\2L\37\3\2\2\2L&\3"+
		"\2\2\2L)\3\2\2\2L\60\3\2\2\2L<\3\2\2\2LJ\3\2\2\2M\t\3\2\2\2NO\b\6\1\2"+
		"O]\7 \2\2P]\7\4\2\2Q]\7\5\2\2R]\7\6\2\2ST\7\23\2\2TU\5\n\6\2UV\7\24\2"+
		"\2V]\3\2\2\2WX\7 \2\2XY\7\25\2\2YZ\5\n\6\2Z[\7\26\2\2[]\3\2\2\2\\N\3\2"+
		"\2\2\\P\3\2\2\2\\Q\3\2\2\2\\R\3\2\2\2\\S\3\2\2\2\\W\3\2\2\2]l\3\2\2\2"+
		"^_\f\13\2\2_`\7\21\2\2`k\5\n\6\fab\f\n\2\2bc\7\22\2\2ck\5\n\6\13de\f\t"+
		"\2\2ef\7\20\2\2fk\5\n\6\ngh\f\b\2\2hi\7\17\2\2ik\5\n\6\tj^\3\2\2\2ja\3"+
		"\2\2\2jd\3\2\2\2jg\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2m\13\3\2\2\2n"+
		"l\3\2\2\2\f\17\33$8DHL\\jl";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}