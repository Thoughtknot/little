// Generated from src/main/antlr/Little.g4 by ANTLR 4.7.1

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
		WS=1, INT_LIT=2, DEC_LIT=3, BOOL_LIT=4, STR_LIT=5, FN=6, TRUE=7, FALSE=8, 
		PRINT=9, PLUS=10, MINUS=11, ASTERISK=12, SLASH=13, LPAREN=14, RPAREN=15, 
		LSPAREN=16, RSPAREN=17, LCPAREN=18, RCPAREN=19, COMMA=20, SEMIC=21, COLON=22, 
		EQ=23, LARROW=24, RARROW=25, DOLLAR=26, VARIABLE_ID=27, TYPE_ID=28, NEWLINE=29;
	public static final int
		RULE_file = 0, RULE_line = 1, RULE_statement = 2, RULE_variableDeclaration = 3, 
		RULE_expression = 4;
	public static final String[] ruleNames = {
		"file", "line", "statement", "variableDeclaration", "expression"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, "'fn'", "'true'", "'false'", "'print'", 
		"'+'", "'-'", "'*'", "'/'", "'('", "')'", "'['", "']'", "'{'", "'}'", 
		"','", "';'", "':'", "'='", "'<-'", "'->'", "'$'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "INT_LIT", "DEC_LIT", "BOOL_LIT", "STR_LIT", "FN", "TRUE", 
		"FALSE", "PRINT", "PLUS", "MINUS", "ASTERISK", "SLASH", "LPAREN", "RPAREN", 
		"LSPAREN", "RSPAREN", "LCPAREN", "RCPAREN", "COMMA", "SEMIC", "COLON", 
		"EQ", "LARROW", "RARROW", "DOLLAR", "VARIABLE_ID", "TYPE_ID", "NEWLINE"
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
			} while ( _la==PRINT || _la==VARIABLE_ID );
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
		public TerminalNode NEWLINE() { return getToken(LittleParser.NEWLINE, 0); }
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
			match(NEWLINE);
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
	public static class VarDecContext extends StatementContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
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

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(21);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VARIABLE_ID:
				_localctx = new VarDecContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(18);
				variableDeclaration();
				}
				break;
			case PRINT:
				_localctx = new PrintContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(19);
				match(PRINT);
				setState(20);
				expression();
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

	public static class VariableDeclarationContext extends ParserRuleContext {
		public TerminalNode VARIABLE_ID() { return getToken(LittleParser.VARIABLE_ID, 0); }
		public TerminalNode LARROW() { return getToken(LittleParser.LARROW, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).exitVariableDeclaration(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			match(VARIABLE_ID);
			setState(24);
			match(LARROW);
			setState(25);
			expression();
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
	public static class DecLiteralContext extends ExpressionContext {
		public TerminalNode DEC_LIT() { return getToken(LittleParser.DEC_LIT, 0); }
		public DecLiteralContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).enterDecLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).exitDecLiteral(this);
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
	public static class ParenExpressionContext extends ExpressionContext {
		public TerminalNode LPAREN() { return getToken(LittleParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LittleParser.RPAREN, 0); }
		public ParenExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).enterParenExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).exitParenExpression(this);
		}
	}
	public static class BoolLiteralContext extends ExpressionContext {
		public TerminalNode BOOL_LIT() { return getToken(LittleParser.BOOL_LIT, 0); }
		public BoolLiteralContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).enterBoolLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleListener ) ((LittleListener)listener).exitBoolLiteral(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expression);
		try {
			setState(36);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VARIABLE_ID:
				_localctx = new VariableReferenceContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(27);
				match(VARIABLE_ID);
				}
				break;
			case INT_LIT:
				_localctx = new IntLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(28);
				match(INT_LIT);
				}
				break;
			case DEC_LIT:
				_localctx = new DecLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(29);
				match(DEC_LIT);
				}
				break;
			case BOOL_LIT:
				_localctx = new BoolLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(30);
				match(BOOL_LIT);
				}
				break;
			case STR_LIT:
				_localctx = new StringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(31);
				match(STR_LIT);
				}
				break;
			case LPAREN:
				_localctx = new ParenExpressionContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(32);
				match(LPAREN);
				setState(33);
				expression();
				setState(34);
				match(RPAREN);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\37)\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\6\2\16\n\2\r\2\16\2\17\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\5\4\30\n\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\5\6\'\n\6\3\6\2\2\7\2\4\6\b\n\2\2\2*\2\r\3\2\2\2\4\21\3\2\2\2\6\27"+
		"\3\2\2\2\b\31\3\2\2\2\n&\3\2\2\2\f\16\5\4\3\2\r\f\3\2\2\2\16\17\3\2\2"+
		"\2\17\r\3\2\2\2\17\20\3\2\2\2\20\3\3\2\2\2\21\22\5\6\4\2\22\23\7\37\2"+
		"\2\23\5\3\2\2\2\24\30\5\b\5\2\25\26\7\13\2\2\26\30\5\n\6\2\27\24\3\2\2"+
		"\2\27\25\3\2\2\2\30\7\3\2\2\2\31\32\7\35\2\2\32\33\7\32\2\2\33\34\5\n"+
		"\6\2\34\t\3\2\2\2\35\'\7\35\2\2\36\'\7\4\2\2\37\'\7\5\2\2 \'\7\6\2\2!"+
		"\'\7\7\2\2\"#\7\20\2\2#$\5\n\6\2$%\7\21\2\2%\'\3\2\2\2&\35\3\2\2\2&\36"+
		"\3\2\2\2&\37\3\2\2\2& \3\2\2\2&!\3\2\2\2&\"\3\2\2\2\'\13\3\2\2\2\5\17"+
		"\27&";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}