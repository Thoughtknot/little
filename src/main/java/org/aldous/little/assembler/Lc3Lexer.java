// Generated from Lc3.g4 by ANTLR 4.7.1

package org.aldous.little.assembler;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Lc3Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, NEWLINE=4, WS=5, INT_LIT=6, INT_DEC_LIT=7, INT_HEX_LIT=8, 
		STR_LIT=9, ORIG=10, END=11, FILL=12, BLKW=13, STRINGZ=14, BR=15, LDI=16, 
		LD=17, LDR=18, LEA=19, STI=20, STR=21, ST=22, JMP=23, JSR=24, JSRR=25, 
		RET=26, ADD=27, AND=28, NOT=29, HALT=30, IN=31, OUT=32, GETC=33, PUTS=34, 
		REGISTER=35, COMMA=36, LABEL=37;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "NEWLINE", "WS", "INT_LIT", "INT_DEC_LIT", "INT_HEX_LIT", 
		"STR_LIT", "ORIG", "END", "FILL", "BLKW", "STRINGZ", "BR", "LDI", "LD", 
		"LDR", "LEA", "STI", "STR", "ST", "JMP", "JSR", "JSRR", "RET", "ADD", 
		"AND", "NOT", "HALT", "IN", "OUT", "GETC", "PUTS", "REGISTER", "COMMA", 
		"LABEL"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'n'", "'z'", "'p'", "'\n'", null, null, null, null, null, "'.ORIG'", 
		"'.END'", "'.FILL'", "'.BLKW'", "'.STRINGZ'", "'BR'", "'LDI'", "'LD'", 
		"'LDR'", "'LEA'", "'STI'", "'STR'", "'ST'", "'JMP'", "'JSR'", "'JSRR'", 
		"'RET'", "'ADD'", "'AND'", "'NOT'", "'HALT'", "'IN'", "'OUT'", "'GETC'", 
		"'PUTS'", null, "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "NEWLINE", "WS", "INT_LIT", "INT_DEC_LIT", "INT_HEX_LIT", 
		"STR_LIT", "ORIG", "END", "FILL", "BLKW", "STRINGZ", "BR", "LDI", "LD", 
		"LDR", "LEA", "STI", "STR", "ST", "JMP", "JSR", "JSRR", "RET", "ADD", 
		"AND", "NOT", "HALT", "IN", "OUT", "GETC", "PUTS", "REGISTER", "COMMA", 
		"LABEL"
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


	public Lc3Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Lc3.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\'\u00f6\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\6\6W\n\6\r\6\16\6X\3\6\3\6\3\7\6\7^\n\7\r\7\16\7_\3\b\3\b\5\bd\n\b"+
		"\3\b\6\bg\n\b\r\b\16\bh\3\t\3\t\5\tm\n\t\3\t\6\tp\n\t\r\t\16\tq\3\n\3"+
		"\n\7\nv\n\n\f\n\16\ny\13\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3"+
		"\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3"+
		"\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3"+
		"\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3"+
		"\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3"+
		"\37\3\37\3 \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3"+
		"$\3$\3%\3%\3&\6&\u00f3\n&\r&\16&\u00f4\2\2\'\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'\3\2\b\5"+
		"\2\13\13\17\17\"\"\3\2\62;\4\2\62;CH\4\2\f\f\17\17\3\2\629\4\2C\\aa\2"+
		"\u00fd\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2"+
		"G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\3M\3\2\2\2\5O\3\2\2\2\7Q\3\2\2\2\tS\3"+
		"\2\2\2\13V\3\2\2\2\r]\3\2\2\2\17a\3\2\2\2\21j\3\2\2\2\23s\3\2\2\2\25|"+
		"\3\2\2\2\27\u0082\3\2\2\2\31\u0087\3\2\2\2\33\u008d\3\2\2\2\35\u0093\3"+
		"\2\2\2\37\u009c\3\2\2\2!\u009f\3\2\2\2#\u00a3\3\2\2\2%\u00a6\3\2\2\2\'"+
		"\u00aa\3\2\2\2)\u00ae\3\2\2\2+\u00b2\3\2\2\2-\u00b6\3\2\2\2/\u00b9\3\2"+
		"\2\2\61\u00bd\3\2\2\2\63\u00c1\3\2\2\2\65\u00c6\3\2\2\2\67\u00ca\3\2\2"+
		"\29\u00ce\3\2\2\2;\u00d2\3\2\2\2=\u00d6\3\2\2\2?\u00db\3\2\2\2A\u00de"+
		"\3\2\2\2C\u00e2\3\2\2\2E\u00e7\3\2\2\2G\u00ec\3\2\2\2I\u00ef\3\2\2\2K"+
		"\u00f2\3\2\2\2MN\7p\2\2N\4\3\2\2\2OP\7|\2\2P\6\3\2\2\2QR\7r\2\2R\b\3\2"+
		"\2\2ST\7\f\2\2T\n\3\2\2\2UW\t\2\2\2VU\3\2\2\2WX\3\2\2\2XV\3\2\2\2XY\3"+
		"\2\2\2YZ\3\2\2\2Z[\b\6\2\2[\f\3\2\2\2\\^\t\3\2\2]\\\3\2\2\2^_\3\2\2\2"+
		"_]\3\2\2\2_`\3\2\2\2`\16\3\2\2\2ac\7%\2\2bd\7/\2\2cb\3\2\2\2cd\3\2\2\2"+
		"df\3\2\2\2eg\t\3\2\2fe\3\2\2\2gh\3\2\2\2hf\3\2\2\2hi\3\2\2\2i\20\3\2\2"+
		"\2jl\7z\2\2km\7/\2\2lk\3\2\2\2lm\3\2\2\2mo\3\2\2\2np\t\4\2\2on\3\2\2\2"+
		"pq\3\2\2\2qo\3\2\2\2qr\3\2\2\2r\22\3\2\2\2sw\7$\2\2tv\n\5\2\2ut\3\2\2"+
		"\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2xz\3\2\2\2yw\3\2\2\2z{\7$\2\2{\24\3\2"+
		"\2\2|}\7\60\2\2}~\7Q\2\2~\177\7T\2\2\177\u0080\7K\2\2\u0080\u0081\7I\2"+
		"\2\u0081\26\3\2\2\2\u0082\u0083\7\60\2\2\u0083\u0084\7G\2\2\u0084\u0085"+
		"\7P\2\2\u0085\u0086\7F\2\2\u0086\30\3\2\2\2\u0087\u0088\7\60\2\2\u0088"+
		"\u0089\7H\2\2\u0089\u008a\7K\2\2\u008a\u008b\7N\2\2\u008b\u008c\7N\2\2"+
		"\u008c\32\3\2\2\2\u008d\u008e\7\60\2\2\u008e\u008f\7D\2\2\u008f\u0090"+
		"\7N\2\2\u0090\u0091\7M\2\2\u0091\u0092\7Y\2\2\u0092\34\3\2\2\2\u0093\u0094"+
		"\7\60\2\2\u0094\u0095\7U\2\2\u0095\u0096\7V\2\2\u0096\u0097\7T\2\2\u0097"+
		"\u0098\7K\2\2\u0098\u0099\7P\2\2\u0099\u009a\7I\2\2\u009a\u009b\7\\\2"+
		"\2\u009b\36\3\2\2\2\u009c\u009d\7D\2\2\u009d\u009e\7T\2\2\u009e \3\2\2"+
		"\2\u009f\u00a0\7N\2\2\u00a0\u00a1\7F\2\2\u00a1\u00a2\7K\2\2\u00a2\"\3"+
		"\2\2\2\u00a3\u00a4\7N\2\2\u00a4\u00a5\7F\2\2\u00a5$\3\2\2\2\u00a6\u00a7"+
		"\7N\2\2\u00a7\u00a8\7F\2\2\u00a8\u00a9\7T\2\2\u00a9&\3\2\2\2\u00aa\u00ab"+
		"\7N\2\2\u00ab\u00ac\7G\2\2\u00ac\u00ad\7C\2\2\u00ad(\3\2\2\2\u00ae\u00af"+
		"\7U\2\2\u00af\u00b0\7V\2\2\u00b0\u00b1\7K\2\2\u00b1*\3\2\2\2\u00b2\u00b3"+
		"\7U\2\2\u00b3\u00b4\7V\2\2\u00b4\u00b5\7T\2\2\u00b5,\3\2\2\2\u00b6\u00b7"+
		"\7U\2\2\u00b7\u00b8\7V\2\2\u00b8.\3\2\2\2\u00b9\u00ba\7L\2\2\u00ba\u00bb"+
		"\7O\2\2\u00bb\u00bc\7R\2\2\u00bc\60\3\2\2\2\u00bd\u00be\7L\2\2\u00be\u00bf"+
		"\7U\2\2\u00bf\u00c0\7T\2\2\u00c0\62\3\2\2\2\u00c1\u00c2\7L\2\2\u00c2\u00c3"+
		"\7U\2\2\u00c3\u00c4\7T\2\2\u00c4\u00c5\7T\2\2\u00c5\64\3\2\2\2\u00c6\u00c7"+
		"\7T\2\2\u00c7\u00c8\7G\2\2\u00c8\u00c9\7V\2\2\u00c9\66\3\2\2\2\u00ca\u00cb"+
		"\7C\2\2\u00cb\u00cc\7F\2\2\u00cc\u00cd\7F\2\2\u00cd8\3\2\2\2\u00ce\u00cf"+
		"\7C\2\2\u00cf\u00d0\7P\2\2\u00d0\u00d1\7F\2\2\u00d1:\3\2\2\2\u00d2\u00d3"+
		"\7P\2\2\u00d3\u00d4\7Q\2\2\u00d4\u00d5\7V\2\2\u00d5<\3\2\2\2\u00d6\u00d7"+
		"\7J\2\2\u00d7\u00d8\7C\2\2\u00d8\u00d9\7N\2\2\u00d9\u00da\7V\2\2\u00da"+
		">\3\2\2\2\u00db\u00dc\7K\2\2\u00dc\u00dd\7P\2\2\u00dd@\3\2\2\2\u00de\u00df"+
		"\7Q\2\2\u00df\u00e0\7W\2\2\u00e0\u00e1\7V\2\2\u00e1B\3\2\2\2\u00e2\u00e3"+
		"\7I\2\2\u00e3\u00e4\7G\2\2\u00e4\u00e5\7V\2\2\u00e5\u00e6\7E\2\2\u00e6"+
		"D\3\2\2\2\u00e7\u00e8\7R\2\2\u00e8\u00e9\7W\2\2\u00e9\u00ea\7V\2\2\u00ea"+
		"\u00eb\7U\2\2\u00ebF\3\2\2\2\u00ec\u00ed\7T\2\2\u00ed\u00ee\t\6\2\2\u00ee"+
		"H\3\2\2\2\u00ef\u00f0\7.\2\2\u00f0J\3\2\2\2\u00f1\u00f3\t\7\2\2\u00f2"+
		"\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2"+
		"\2\2\u00f5L\3\2\2\2\13\2X_chlqw\u00f4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}