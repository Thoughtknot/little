// Generated from Little.g4 by ANTLR 4.7.1

package org.aldous.little;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LittleLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, INT_LIT=2, CHAR_LIT=3, STR_LIT=4, LOOP=5, TRUE=6, FALSE=7, PRINT=8, 
		GETC=9, DEF=10, COPY=11, IF=12, ELIF=13, ELSE=14, PLUS=15, MINUS=16, ASTERISK=17, 
		SLASH=18, LPAREN=19, RPAREN=20, LSPAREN=21, RSPAREN=22, LCPAREN=23, RCPAREN=24, 
		COMMA=25, SEMIC=26, COLON=27, EQ=28, LARROW=29, RARROW=30, DOLLAR=31, 
		VARIABLE_ID=32;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"WS", "INT_LIT", "CHAR_LIT", "STR_LIT", "LOOP", "TRUE", "FALSE", "PRINT", 
		"GETC", "DEF", "COPY", "IF", "ELIF", "ELSE", "PLUS", "MINUS", "ASTERISK", 
		"SLASH", "LPAREN", "RPAREN", "LSPAREN", "RSPAREN", "LCPAREN", "RCPAREN", 
		"COMMA", "SEMIC", "COLON", "EQ", "LARROW", "RARROW", "DOLLAR", "VARIABLE_ID"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, "'loop'", "'true'", "'false'", "'print'", 
		"'getc'", "'def'", "'copy'", "'if'", "'elif'", "'else'", "'+'", "'-'", 
		"'*'", "'/'", "'('", "')'", "'['", "']'", "'{'", "'}'", "','", "';'", 
		"':'", "'='", "'<-'", "'->'", "'$'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "INT_LIT", "CHAR_LIT", "STR_LIT", "LOOP", "TRUE", "FALSE", 
		"PRINT", "GETC", "DEF", "COPY", "IF", "ELIF", "ELSE", "PLUS", "MINUS", 
		"ASTERISK", "SLASH", "LPAREN", "RPAREN", "LSPAREN", "RSPAREN", "LCPAREN", 
		"RCPAREN", "COMMA", "SEMIC", "COLON", "EQ", "LARROW", "RARROW", "DOLLAR", 
		"VARIABLE_ID"
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


	public LittleLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Little.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\"\u00bb\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\6\2E\n\2\r\2\16\2F\3\2\3\2\3\3\5\3L\n\3\3\3\6\3O\n\3\r\3\16\3"+
		"P\3\4\3\4\3\4\3\4\3\5\3\5\7\5Y\n\5\f\5\16\5\\\13\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r"+
		"\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3"+
		"\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3"+
		"\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3"+
		"\36\3\37\3\37\3\37\3 \3 \3!\3!\7!\u00b7\n!\f!\16!\u00ba\13!\2\2\"\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"\3\2\b\5\2\13\f\17\17\"\"\3\2\62;\3\2\2\1\4\2\f\f\17\17\3\2c|\5\2\62"+
		";C\\c|\2\u00bf\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\3D\3\2\2\2\5K\3"+
		"\2\2\2\7R\3\2\2\2\tV\3\2\2\2\13_\3\2\2\2\rd\3\2\2\2\17i\3\2\2\2\21o\3"+
		"\2\2\2\23u\3\2\2\2\25z\3\2\2\2\27~\3\2\2\2\31\u0083\3\2\2\2\33\u0086\3"+
		"\2\2\2\35\u008b\3\2\2\2\37\u0090\3\2\2\2!\u0092\3\2\2\2#\u0094\3\2\2\2"+
		"%\u0096\3\2\2\2\'\u0098\3\2\2\2)\u009a\3\2\2\2+\u009c\3\2\2\2-\u009e\3"+
		"\2\2\2/\u00a0\3\2\2\2\61\u00a2\3\2\2\2\63\u00a4\3\2\2\2\65\u00a6\3\2\2"+
		"\2\67\u00a8\3\2\2\29\u00aa\3\2\2\2;\u00ac\3\2\2\2=\u00af\3\2\2\2?\u00b2"+
		"\3\2\2\2A\u00b4\3\2\2\2CE\t\2\2\2DC\3\2\2\2EF\3\2\2\2FD\3\2\2\2FG\3\2"+
		"\2\2GH\3\2\2\2HI\b\2\2\2I\4\3\2\2\2JL\7/\2\2KJ\3\2\2\2KL\3\2\2\2LN\3\2"+
		"\2\2MO\t\3\2\2NM\3\2\2\2OP\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\6\3\2\2\2RS\7"+
		")\2\2ST\t\4\2\2TU\7)\2\2U\b\3\2\2\2VZ\7$\2\2WY\n\5\2\2XW\3\2\2\2Y\\\3"+
		"\2\2\2ZX\3\2\2\2Z[\3\2\2\2[]\3\2\2\2\\Z\3\2\2\2]^\7$\2\2^\n\3\2\2\2_`"+
		"\7n\2\2`a\7q\2\2ab\7q\2\2bc\7r\2\2c\f\3\2\2\2de\7v\2\2ef\7t\2\2fg\7w\2"+
		"\2gh\7g\2\2h\16\3\2\2\2ij\7h\2\2jk\7c\2\2kl\7n\2\2lm\7u\2\2mn\7g\2\2n"+
		"\20\3\2\2\2op\7r\2\2pq\7t\2\2qr\7k\2\2rs\7p\2\2st\7v\2\2t\22\3\2\2\2u"+
		"v\7i\2\2vw\7g\2\2wx\7v\2\2xy\7e\2\2y\24\3\2\2\2z{\7f\2\2{|\7g\2\2|}\7"+
		"h\2\2}\26\3\2\2\2~\177\7e\2\2\177\u0080\7q\2\2\u0080\u0081\7r\2\2\u0081"+
		"\u0082\7{\2\2\u0082\30\3\2\2\2\u0083\u0084\7k\2\2\u0084\u0085\7h\2\2\u0085"+
		"\32\3\2\2\2\u0086\u0087\7g\2\2\u0087\u0088\7n\2\2\u0088\u0089\7k\2\2\u0089"+
		"\u008a\7h\2\2\u008a\34\3\2\2\2\u008b\u008c\7g\2\2\u008c\u008d\7n\2\2\u008d"+
		"\u008e\7u\2\2\u008e\u008f\7g\2\2\u008f\36\3\2\2\2\u0090\u0091\7-\2\2\u0091"+
		" \3\2\2\2\u0092\u0093\7/\2\2\u0093\"\3\2\2\2\u0094\u0095\7,\2\2\u0095"+
		"$\3\2\2\2\u0096\u0097\7\61\2\2\u0097&\3\2\2\2\u0098\u0099\7*\2\2\u0099"+
		"(\3\2\2\2\u009a\u009b\7+\2\2\u009b*\3\2\2\2\u009c\u009d\7]\2\2\u009d,"+
		"\3\2\2\2\u009e\u009f\7_\2\2\u009f.\3\2\2\2\u00a0\u00a1\7}\2\2\u00a1\60"+
		"\3\2\2\2\u00a2\u00a3\7\177\2\2\u00a3\62\3\2\2\2\u00a4\u00a5\7.\2\2\u00a5"+
		"\64\3\2\2\2\u00a6\u00a7\7=\2\2\u00a7\66\3\2\2\2\u00a8\u00a9\7<\2\2\u00a9"+
		"8\3\2\2\2\u00aa\u00ab\7?\2\2\u00ab:\3\2\2\2\u00ac\u00ad\7>\2\2\u00ad\u00ae"+
		"\7/\2\2\u00ae<\3\2\2\2\u00af\u00b0\7/\2\2\u00b0\u00b1\7@\2\2\u00b1>\3"+
		"\2\2\2\u00b2\u00b3\7&\2\2\u00b3@\3\2\2\2\u00b4\u00b8\t\6\2\2\u00b5\u00b7"+
		"\t\7\2\2\u00b6\u00b5\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8"+
		"\u00b9\3\2\2\2\u00b9B\3\2\2\2\u00ba\u00b8\3\2\2\2\b\2FKPZ\u00b8\3\b\2"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}