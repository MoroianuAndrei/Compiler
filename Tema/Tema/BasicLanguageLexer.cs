//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     ANTLR Version: 4.13.1
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

// Generated from d:/Compiler/Tema/Tema/BasicLanguage.g4 by ANTLR 4.13.1

// Unreachable code detected
#pragma warning disable 0162
// The variable '...' is assigned but its value is never used
#pragma warning disable 0219
// Missing XML comment for publicly visible type or member '...'
#pragma warning disable 1591
// Ambiguous reference in cref attribute
#pragma warning disable 419

using System;
using System.IO;
using System.Text;
using Antlr4.Runtime;
using Antlr4.Runtime.Atn;
using Antlr4.Runtime.Misc;
using DFA = Antlr4.Runtime.Dfa.DFA;

[System.CodeDom.Compiler.GeneratedCode("ANTLR", "4.13.1")]
[System.CLSCompliant(false)]
public partial class BasicLanguageLexer : Lexer {
	protected static DFA[] decisionToDFA;
	protected static PredictionContextCache sharedContextCache = new PredictionContextCache();
	public const int
		INT=1, FLOAT=2, DOUBLE=3, STRING=4, VOID=5, IF=6, ELSE=7, FOR=8, WHILE=9, 
		RETURN=10, ID=11, NUMBER=12, STRING_LITERAL=13, PLUS=14, MINUS=15, STAR=16, 
		SLASH=17, MOD=18, LT=19, GT=20, LE=21, GE=22, EQ=23, NE=24, AND=25, OR=26, 
		NOT=27, ASSIGN=28, PLUS_ASSIGN=29, MINUS_ASSIGN=30, STAR_ASSIGN=31, SLASH_ASSIGN=32, 
		MOD_ASSIGN=33, INCREMENT=34, DECREMENT=35, LPAREN=36, RPAREN=37, LBRACE=38, 
		RBRACE=39, COMMA=40, SEMICOLON=41, COMMENT=42, BLOCK_COMMENT=43, WS=44;
	public static string[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static string[] modeNames = {
		"DEFAULT_MODE"
	};

	public static readonly string[] ruleNames = {
		"INT", "FLOAT", "DOUBLE", "STRING", "VOID", "IF", "ELSE", "FOR", "WHILE", 
		"RETURN", "ID", "NUMBER", "STRING_LITERAL", "PLUS", "MINUS", "STAR", "SLASH", 
		"MOD", "LT", "GT", "LE", "GE", "EQ", "NE", "AND", "OR", "NOT", "ASSIGN", 
		"PLUS_ASSIGN", "MINUS_ASSIGN", "STAR_ASSIGN", "SLASH_ASSIGN", "MOD_ASSIGN", 
		"INCREMENT", "DECREMENT", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "COMMA", 
		"SEMICOLON", "COMMENT", "BLOCK_COMMENT", "WS"
	};


	public BasicLanguageLexer(ICharStream input)
	: this(input, Console.Out, Console.Error) { }

	public BasicLanguageLexer(ICharStream input, TextWriter output, TextWriter errorOutput)
	: base(input, output, errorOutput)
	{
		Interpreter = new LexerATNSimulator(this, _ATN, decisionToDFA, sharedContextCache);
	}

	private static readonly string[] _LiteralNames = {
		null, "'int'", "'float'", "'double'", "'string'", "'void'", "'if'", "'else'", 
		"'for'", "'while'", "'return'", null, null, null, "'+'", "'-'", "'*'", 
		"'/'", "'%'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'&&'", "'||'", 
		"'!'", "'='", "'+='", "'-='", "'*='", "'/='", "'%='", "'++'", "'--'", 
		"'('", "')'", "'{'", "'}'", "','", "';'"
	};
	private static readonly string[] _SymbolicNames = {
		null, "INT", "FLOAT", "DOUBLE", "STRING", "VOID", "IF", "ELSE", "FOR", 
		"WHILE", "RETURN", "ID", "NUMBER", "STRING_LITERAL", "PLUS", "MINUS", 
		"STAR", "SLASH", "MOD", "LT", "GT", "LE", "GE", "EQ", "NE", "AND", "OR", 
		"NOT", "ASSIGN", "PLUS_ASSIGN", "MINUS_ASSIGN", "STAR_ASSIGN", "SLASH_ASSIGN", 
		"MOD_ASSIGN", "INCREMENT", "DECREMENT", "LPAREN", "RPAREN", "LBRACE", 
		"RBRACE", "COMMA", "SEMICOLON", "COMMENT", "BLOCK_COMMENT", "WS"
	};
	public static readonly IVocabulary DefaultVocabulary = new Vocabulary(_LiteralNames, _SymbolicNames);

	[NotNull]
	public override IVocabulary Vocabulary
	{
		get
		{
			return DefaultVocabulary;
		}
	}

	public override string GrammarFileName { get { return "BasicLanguage.g4"; } }

	public override string[] RuleNames { get { return ruleNames; } }

	public override string[] ChannelNames { get { return channelNames; } }

	public override string[] ModeNames { get { return modeNames; } }

	public override int[] SerializedAtn { get { return _serializedATN; } }

	static BasicLanguageLexer() {
		decisionToDFA = new DFA[_ATN.NumberOfDecisions];
		for (int i = 0; i < _ATN.NumberOfDecisions; i++) {
			decisionToDFA[i] = new DFA(_ATN.GetDecisionState(i), i);
		}
	}
	private static int[] _serializedATN = {
		4,0,44,273,6,-1,2,0,7,0,2,1,7,1,2,2,7,2,2,3,7,3,2,4,7,4,2,5,7,5,2,6,7,
		6,2,7,7,7,2,8,7,8,2,9,7,9,2,10,7,10,2,11,7,11,2,12,7,12,2,13,7,13,2,14,
		7,14,2,15,7,15,2,16,7,16,2,17,7,17,2,18,7,18,2,19,7,19,2,20,7,20,2,21,
		7,21,2,22,7,22,2,23,7,23,2,24,7,24,2,25,7,25,2,26,7,26,2,27,7,27,2,28,
		7,28,2,29,7,29,2,30,7,30,2,31,7,31,2,32,7,32,2,33,7,33,2,34,7,34,2,35,
		7,35,2,36,7,36,2,37,7,37,2,38,7,38,2,39,7,39,2,40,7,40,2,41,7,41,2,42,
		7,42,2,43,7,43,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,2,1,2,1,2,
		1,2,1,2,1,2,1,3,1,3,1,3,1,3,1,3,1,3,1,3,1,4,1,4,1,4,1,4,1,4,1,5,1,5,1,
		5,1,6,1,6,1,6,1,6,1,6,1,7,1,7,1,7,1,7,1,8,1,8,1,8,1,8,1,8,1,8,1,9,1,9,
		1,9,1,9,1,9,1,9,1,9,1,10,1,10,5,10,146,8,10,10,10,12,10,149,9,10,1,11,
		4,11,152,8,11,11,11,12,11,153,1,11,1,11,4,11,158,8,11,11,11,12,11,159,
		3,11,162,8,11,1,12,1,12,5,12,166,8,12,10,12,12,12,169,9,12,1,12,1,12,1,
		13,1,13,1,14,1,14,1,15,1,15,1,16,1,16,1,17,1,17,1,18,1,18,1,19,1,19,1,
		20,1,20,1,20,1,21,1,21,1,21,1,22,1,22,1,22,1,23,1,23,1,23,1,24,1,24,1,
		24,1,25,1,25,1,25,1,26,1,26,1,27,1,27,1,28,1,28,1,28,1,29,1,29,1,29,1,
		30,1,30,1,30,1,31,1,31,1,31,1,32,1,32,1,32,1,33,1,33,1,33,1,34,1,34,1,
		34,1,35,1,35,1,36,1,36,1,37,1,37,1,38,1,38,1,39,1,39,1,40,1,40,1,41,1,
		41,1,41,1,41,5,41,246,8,41,10,41,12,41,249,9,41,1,41,1,41,1,42,1,42,1,
		42,1,42,5,42,257,8,42,10,42,12,42,260,9,42,1,42,1,42,1,42,1,42,1,42,1,
		43,4,43,268,8,43,11,43,12,43,269,1,43,1,43,2,167,258,0,44,1,1,3,2,5,3,
		7,4,9,5,11,6,13,7,15,8,17,9,19,10,21,11,23,12,25,13,27,14,29,15,31,16,
		33,17,35,18,37,19,39,20,41,21,43,22,45,23,47,24,49,25,51,26,53,27,55,28,
		57,29,59,30,61,31,63,32,65,33,67,34,69,35,71,36,73,37,75,38,77,39,79,40,
		81,41,83,42,85,43,87,44,1,0,5,3,0,65,90,95,95,97,122,4,0,48,57,65,90,95,
		95,97,122,1,0,48,57,2,0,10,10,13,13,3,0,9,10,13,13,32,32,280,0,1,1,0,0,
		0,0,3,1,0,0,0,0,5,1,0,0,0,0,7,1,0,0,0,0,9,1,0,0,0,0,11,1,0,0,0,0,13,1,
		0,0,0,0,15,1,0,0,0,0,17,1,0,0,0,0,19,1,0,0,0,0,21,1,0,0,0,0,23,1,0,0,0,
		0,25,1,0,0,0,0,27,1,0,0,0,0,29,1,0,0,0,0,31,1,0,0,0,0,33,1,0,0,0,0,35,
		1,0,0,0,0,37,1,0,0,0,0,39,1,0,0,0,0,41,1,0,0,0,0,43,1,0,0,0,0,45,1,0,0,
		0,0,47,1,0,0,0,0,49,1,0,0,0,0,51,1,0,0,0,0,53,1,0,0,0,0,55,1,0,0,0,0,57,
		1,0,0,0,0,59,1,0,0,0,0,61,1,0,0,0,0,63,1,0,0,0,0,65,1,0,0,0,0,67,1,0,0,
		0,0,69,1,0,0,0,0,71,1,0,0,0,0,73,1,0,0,0,0,75,1,0,0,0,0,77,1,0,0,0,0,79,
		1,0,0,0,0,81,1,0,0,0,0,83,1,0,0,0,0,85,1,0,0,0,0,87,1,0,0,0,1,89,1,0,0,
		0,3,93,1,0,0,0,5,99,1,0,0,0,7,106,1,0,0,0,9,113,1,0,0,0,11,118,1,0,0,0,
		13,121,1,0,0,0,15,126,1,0,0,0,17,130,1,0,0,0,19,136,1,0,0,0,21,143,1,0,
		0,0,23,151,1,0,0,0,25,163,1,0,0,0,27,172,1,0,0,0,29,174,1,0,0,0,31,176,
		1,0,0,0,33,178,1,0,0,0,35,180,1,0,0,0,37,182,1,0,0,0,39,184,1,0,0,0,41,
		186,1,0,0,0,43,189,1,0,0,0,45,192,1,0,0,0,47,195,1,0,0,0,49,198,1,0,0,
		0,51,201,1,0,0,0,53,204,1,0,0,0,55,206,1,0,0,0,57,208,1,0,0,0,59,211,1,
		0,0,0,61,214,1,0,0,0,63,217,1,0,0,0,65,220,1,0,0,0,67,223,1,0,0,0,69,226,
		1,0,0,0,71,229,1,0,0,0,73,231,1,0,0,0,75,233,1,0,0,0,77,235,1,0,0,0,79,
		237,1,0,0,0,81,239,1,0,0,0,83,241,1,0,0,0,85,252,1,0,0,0,87,267,1,0,0,
		0,89,90,5,105,0,0,90,91,5,110,0,0,91,92,5,116,0,0,92,2,1,0,0,0,93,94,5,
		102,0,0,94,95,5,108,0,0,95,96,5,111,0,0,96,97,5,97,0,0,97,98,5,116,0,0,
		98,4,1,0,0,0,99,100,5,100,0,0,100,101,5,111,0,0,101,102,5,117,0,0,102,
		103,5,98,0,0,103,104,5,108,0,0,104,105,5,101,0,0,105,6,1,0,0,0,106,107,
		5,115,0,0,107,108,5,116,0,0,108,109,5,114,0,0,109,110,5,105,0,0,110,111,
		5,110,0,0,111,112,5,103,0,0,112,8,1,0,0,0,113,114,5,118,0,0,114,115,5,
		111,0,0,115,116,5,105,0,0,116,117,5,100,0,0,117,10,1,0,0,0,118,119,5,105,
		0,0,119,120,5,102,0,0,120,12,1,0,0,0,121,122,5,101,0,0,122,123,5,108,0,
		0,123,124,5,115,0,0,124,125,5,101,0,0,125,14,1,0,0,0,126,127,5,102,0,0,
		127,128,5,111,0,0,128,129,5,114,0,0,129,16,1,0,0,0,130,131,5,119,0,0,131,
		132,5,104,0,0,132,133,5,105,0,0,133,134,5,108,0,0,134,135,5,101,0,0,135,
		18,1,0,0,0,136,137,5,114,0,0,137,138,5,101,0,0,138,139,5,116,0,0,139,140,
		5,117,0,0,140,141,5,114,0,0,141,142,5,110,0,0,142,20,1,0,0,0,143,147,7,
		0,0,0,144,146,7,1,0,0,145,144,1,0,0,0,146,149,1,0,0,0,147,145,1,0,0,0,
		147,148,1,0,0,0,148,22,1,0,0,0,149,147,1,0,0,0,150,152,7,2,0,0,151,150,
		1,0,0,0,152,153,1,0,0,0,153,151,1,0,0,0,153,154,1,0,0,0,154,161,1,0,0,
		0,155,157,5,46,0,0,156,158,7,2,0,0,157,156,1,0,0,0,158,159,1,0,0,0,159,
		157,1,0,0,0,159,160,1,0,0,0,160,162,1,0,0,0,161,155,1,0,0,0,161,162,1,
		0,0,0,162,24,1,0,0,0,163,167,5,34,0,0,164,166,9,0,0,0,165,164,1,0,0,0,
		166,169,1,0,0,0,167,168,1,0,0,0,167,165,1,0,0,0,168,170,1,0,0,0,169,167,
		1,0,0,0,170,171,5,34,0,0,171,26,1,0,0,0,172,173,5,43,0,0,173,28,1,0,0,
		0,174,175,5,45,0,0,175,30,1,0,0,0,176,177,5,42,0,0,177,32,1,0,0,0,178,
		179,5,47,0,0,179,34,1,0,0,0,180,181,5,37,0,0,181,36,1,0,0,0,182,183,5,
		60,0,0,183,38,1,0,0,0,184,185,5,62,0,0,185,40,1,0,0,0,186,187,5,60,0,0,
		187,188,5,61,0,0,188,42,1,0,0,0,189,190,5,62,0,0,190,191,5,61,0,0,191,
		44,1,0,0,0,192,193,5,61,0,0,193,194,5,61,0,0,194,46,1,0,0,0,195,196,5,
		33,0,0,196,197,5,61,0,0,197,48,1,0,0,0,198,199,5,38,0,0,199,200,5,38,0,
		0,200,50,1,0,0,0,201,202,5,124,0,0,202,203,5,124,0,0,203,52,1,0,0,0,204,
		205,5,33,0,0,205,54,1,0,0,0,206,207,5,61,0,0,207,56,1,0,0,0,208,209,5,
		43,0,0,209,210,5,61,0,0,210,58,1,0,0,0,211,212,5,45,0,0,212,213,5,61,0,
		0,213,60,1,0,0,0,214,215,5,42,0,0,215,216,5,61,0,0,216,62,1,0,0,0,217,
		218,5,47,0,0,218,219,5,61,0,0,219,64,1,0,0,0,220,221,5,37,0,0,221,222,
		5,61,0,0,222,66,1,0,0,0,223,224,5,43,0,0,224,225,5,43,0,0,225,68,1,0,0,
		0,226,227,5,45,0,0,227,228,5,45,0,0,228,70,1,0,0,0,229,230,5,40,0,0,230,
		72,1,0,0,0,231,232,5,41,0,0,232,74,1,0,0,0,233,234,5,123,0,0,234,76,1,
		0,0,0,235,236,5,125,0,0,236,78,1,0,0,0,237,238,5,44,0,0,238,80,1,0,0,0,
		239,240,5,59,0,0,240,82,1,0,0,0,241,242,5,47,0,0,242,243,5,47,0,0,243,
		247,1,0,0,0,244,246,8,3,0,0,245,244,1,0,0,0,246,249,1,0,0,0,247,245,1,
		0,0,0,247,248,1,0,0,0,248,250,1,0,0,0,249,247,1,0,0,0,250,251,6,41,0,0,
		251,84,1,0,0,0,252,253,5,47,0,0,253,254,5,42,0,0,254,258,1,0,0,0,255,257,
		9,0,0,0,256,255,1,0,0,0,257,260,1,0,0,0,258,259,1,0,0,0,258,256,1,0,0,
		0,259,261,1,0,0,0,260,258,1,0,0,0,261,262,5,42,0,0,262,263,5,47,0,0,263,
		264,1,0,0,0,264,265,6,42,0,0,265,86,1,0,0,0,266,268,7,4,0,0,267,266,1,
		0,0,0,268,269,1,0,0,0,269,267,1,0,0,0,269,270,1,0,0,0,270,271,1,0,0,0,
		271,272,6,43,0,0,272,88,1,0,0,0,9,0,147,153,159,161,167,247,258,269,1,
		6,0,0
	};

	public static readonly ATN _ATN =
		new ATNDeserializer().Deserialize(_serializedATN);


}
