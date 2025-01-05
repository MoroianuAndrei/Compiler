// Generated from d:/Compiler/Tema/Tema/BasicLanguage.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class BasicLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT=1, FLOAT=2, DOUBLE=3, STRING=4, VOID=5, IF=6, ELSE=7, FOR=8, WHILE=9, 
		RETURN=10, ID=11, NUMBER=12, STRING_LITERAL=13, PLUS=14, MINUS=15, STAR=16, 
		SLASH=17, MOD=18, LT=19, GT=20, LE=21, GE=22, EQ=23, NE=24, AND=25, OR=26, 
		NOT=27, ASSIGN=28, PLUS_ASSIGN=29, MINUS_ASSIGN=30, STAR_ASSIGN=31, SLASH_ASSIGN=32, 
		MOD_ASSIGN=33, INCREMENT=34, DECREMENT=35, LPAREN=36, RPAREN=37, LBRACE=38, 
		RBRACE=39, COMMA=40, SEMICOLON=41, COMMENT=42, BLOCK_COMMENT=43, WS=44;
	public static final int
		RULE_program = 0, RULE_functionDecl = 1, RULE_globalDeclaration = 2, RULE_parameters = 3, 
		RULE_parameter = 4, RULE_declaration = 5, RULE_block = 6, RULE_statement = 7, 
		RULE_expressionStatement = 8, RULE_forStatement = 9, RULE_forInit = 10, 
		RULE_forCondition = 11, RULE_forIncrement = 12, RULE_ifStatement = 13, 
		RULE_whileStatement = 14, RULE_returnStatement = 15, RULE_expr = 16, RULE_incrementExpr = 17, 
		RULE_functionCall = 18, RULE_arguments = 19, RULE_literal = 20, RULE_type = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "functionDecl", "globalDeclaration", "parameters", "parameter", 
			"declaration", "block", "statement", "expressionStatement", "forStatement", 
			"forInit", "forCondition", "forIncrement", "ifStatement", "whileStatement", 
			"returnStatement", "expr", "incrementExpr", "functionCall", "arguments", 
			"literal", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'float'", "'double'", "'string'", "'void'", "'if'", "'else'", 
			"'for'", "'while'", "'return'", null, null, null, "'+'", "'-'", "'*'", 
			"'/'", "'%'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'&&'", "'||'", 
			"'!'", "'='", "'+='", "'-='", "'*='", "'/='", "'%='", "'++'", "'--'", 
			"'('", "')'", "'{'", "'}'", "','", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "FLOAT", "DOUBLE", "STRING", "VOID", "IF", "ELSE", "FOR", 
			"WHILE", "RETURN", "ID", "NUMBER", "STRING_LITERAL", "PLUS", "MINUS", 
			"STAR", "SLASH", "MOD", "LT", "GT", "LE", "GE", "EQ", "NE", "AND", "OR", 
			"NOT", "ASSIGN", "PLUS_ASSIGN", "MINUS_ASSIGN", "STAR_ASSIGN", "SLASH_ASSIGN", 
			"MOD_ASSIGN", "INCREMENT", "DECREMENT", "LPAREN", "RPAREN", "LBRACE", 
			"RBRACE", "COMMA", "SEMICOLON", "COMMENT", "BLOCK_COMMENT", "WS"
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
	public String getGrammarFileName() { return "BasicLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    // Symbol table to track global variables
	    private HashSet<string> globalVars = new HashSet<string>();

	    // Helper method to check for duplicates
	    private void CheckDuplicate(string varName, int line) {
	        if (globalVars.Contains(varName)) {
	            Console.WriteLine($"Error: Duplicate global variable '{varName}' at line {line}");
	        } else {
	            globalVars.Add(varName);
	        }
	    }

	public BasicLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(BasicLanguageParser.EOF, 0); }
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
		}
		public List<GlobalDeclarationContext> globalDeclaration() {
			return getRuleContexts(GlobalDeclarationContext.class);
		}
		public GlobalDeclarationContext globalDeclaration(int i) {
			return getRuleContext(GlobalDeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 62L) != 0)) {
				{
				setState(46);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(44);
					functionDecl();
					}
					break;
				case 2:
					{
					setState(45);
					globalDeclaration();
					}
					break;
				}
				}
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(51);
			match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(BasicLanguageParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(BasicLanguageParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(BasicLanguageParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(BasicLanguageParser.SEMICOLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitFunctionDecl(this);
		}
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			type();
			setState(54);
			match(ID);
			setState(55);
			match(LPAREN);
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 62L) != 0)) {
				{
				setState(56);
				parameters();
				}
			}

			setState(59);
			match(RPAREN);
			setState(62);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEMICOLON:
				{
				setState(60);
				match(SEMICOLON);
				}
				break;
			case LBRACE:
				{
				setState(61);
				block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
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

	@SuppressWarnings("CheckReturnValue")
	public static class GlobalDeclarationContext extends ParserRuleContext {
		public Token ID;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(BasicLanguageParser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(BasicLanguageParser.SEMICOLON, 0); }
		public TerminalNode ASSIGN() { return getToken(BasicLanguageParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public GlobalDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterGlobalDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitGlobalDeclaration(this);
		}
	}

	public final GlobalDeclarationContext globalDeclaration() throws RecognitionException {
		GlobalDeclarationContext _localctx = new GlobalDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_globalDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			type();
			setState(65);
			((GlobalDeclarationContext)_localctx).ID = match(ID);
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(66);
				match(ASSIGN);
				setState(67);
				expr(0);
				}
			}

			setState(70);
			match(SEMICOLON);

			        CheckDuplicate((((GlobalDeclarationContext)_localctx).ID!=null?((GlobalDeclarationContext)_localctx).ID.getText():null), (((GlobalDeclarationContext)_localctx).ID!=null?((GlobalDeclarationContext)_localctx).ID.getLine():0));
			    
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParametersContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(BasicLanguageParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BasicLanguageParser.COMMA, i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitParameters(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			parameter();
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(74);
				match(COMMA);
				setState(75);
				parameter();
				}
				}
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(BasicLanguageParser.ID, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitParameter(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			type();
			setState(82);
			match(ID);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(BasicLanguageParser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(BasicLanguageParser.SEMICOLON, 0); }
		public TerminalNode ASSIGN() { return getToken(BasicLanguageParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			type();
			setState(85);
			match(ID);
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(86);
				match(ASSIGN);
				setState(87);
				expr(0);
				}
			}

			setState(90);
			match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(BasicLanguageParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(BasicLanguageParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(LBRACE);
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 395271225214L) != 0)) {
				{
				{
				setState(93);
				statement();
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(99);
			match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statement);
		try {
			setState(108);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				ifStatement();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				forStatement();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(103);
				whileStatement();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 4);
				{
				setState(104);
				returnStatement();
				}
				break;
			case INT:
			case FLOAT:
			case DOUBLE:
			case STRING:
			case VOID:
				enterOuterAlt(_localctx, 5);
				{
				setState(105);
				declaration();
				}
				break;
			case ID:
			case NUMBER:
			case STRING_LITERAL:
			case NOT:
			case INCREMENT:
			case DECREMENT:
			case LPAREN:
				enterOuterAlt(_localctx, 6);
				{
				setState(106);
				expressionStatement();
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 7);
				{
				setState(107);
				block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionStatementContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(BasicLanguageParser.SEMICOLON, 0); }
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitExpressionStatement(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			expr(0);
			setState(111);
			match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(BasicLanguageParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(BasicLanguageParser.LPAREN, 0); }
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public ForConditionContext forCondition() {
			return getRuleContext(ForConditionContext.class,0);
		}
		public ForIncrementContext forIncrement() {
			return getRuleContext(ForIncrementContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BasicLanguageParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitForStatement(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_forStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(FOR);
			setState(114);
			match(LPAREN);
			setState(115);
			forInit();
			setState(116);
			forCondition();
			setState(117);
			forIncrement();
			setState(118);
			match(RPAREN);
			setState(119);
			statement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForInitContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(BasicLanguageParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(BasicLanguageParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(BasicLanguageParser.SEMICOLON, 0); }
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterForInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitForInit(this);
		}
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_forInit);
		int _la;
		try {
			setState(131);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
			case DOUBLE:
			case STRING:
			case VOID:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				type();
				setState(122);
				match(ID);
				setState(123);
				match(ASSIGN);
				setState(124);
				expr(0);
				setState(125);
				match(SEMICOLON);
				}
				break;
			case ID:
			case NUMBER:
			case STRING_LITERAL:
			case NOT:
			case INCREMENT:
			case DECREMENT:
			case LPAREN:
			case SEMICOLON:
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 120393316352L) != 0)) {
					{
					setState(127);
					expr(0);
					}
				}

				setState(130);
				match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForConditionContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(BasicLanguageParser.SEMICOLON, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ForConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterForCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitForCondition(this);
		}
	}

	public final ForConditionContext forCondition() throws RecognitionException {
		ForConditionContext _localctx = new ForConditionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_forCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 120393316352L) != 0)) {
				{
				setState(133);
				expr(0);
				}
			}

			setState(136);
			match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForIncrementContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ForIncrementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forIncrement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterForIncrement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitForIncrement(this);
		}
	}

	public final ForIncrementContext forIncrement() throws RecognitionException {
		ForIncrementContext _localctx = new ForIncrementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_forIncrement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 120393316352L) != 0)) {
				{
				setState(138);
				expr(0);
				}
			}

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

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(BasicLanguageParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(BasicLanguageParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BasicLanguageParser.RPAREN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(BasicLanguageParser.ELSE, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitIfStatement(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(IF);
			setState(142);
			match(LPAREN);
			setState(143);
			expr(0);
			setState(144);
			match(RPAREN);
			setState(145);
			statement();
			setState(148);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(146);
				match(ELSE);
				setState(147);
				statement();
				}
				break;
			}
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

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(BasicLanguageParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(BasicLanguageParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BasicLanguageParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitWhileStatement(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(WHILE);
			setState(151);
			match(LPAREN);
			setState(152);
			expr(0);
			setState(153);
			match(RPAREN);
			setState(154);
			statement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(BasicLanguageParser.RETURN, 0); }
		public TerminalNode SEMICOLON() { return getToken(BasicLanguageParser.SEMICOLON, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitReturnStatement(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(RETURN);
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 120393316352L) != 0)) {
				{
				setState(157);
				expr(0);
				}
			}

			setState(160);
			match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode ID() { return getToken(BasicLanguageParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(BasicLanguageParser.LPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(BasicLanguageParser.RPAREN, 0); }
		public TerminalNode NOT() { return getToken(BasicLanguageParser.NOT, 0); }
		public TerminalNode ASSIGN() { return getToken(BasicLanguageParser.ASSIGN, 0); }
		public TerminalNode PLUS_ASSIGN() { return getToken(BasicLanguageParser.PLUS_ASSIGN, 0); }
		public TerminalNode MINUS_ASSIGN() { return getToken(BasicLanguageParser.MINUS_ASSIGN, 0); }
		public TerminalNode STAR_ASSIGN() { return getToken(BasicLanguageParser.STAR_ASSIGN, 0); }
		public TerminalNode SLASH_ASSIGN() { return getToken(BasicLanguageParser.SLASH_ASSIGN, 0); }
		public TerminalNode MOD_ASSIGN() { return getToken(BasicLanguageParser.MOD_ASSIGN, 0); }
		public IncrementExprContext incrementExpr() {
			return getRuleContext(IncrementExprContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public TerminalNode STAR() { return getToken(BasicLanguageParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(BasicLanguageParser.SLASH, 0); }
		public TerminalNode MOD() { return getToken(BasicLanguageParser.MOD, 0); }
		public TerminalNode PLUS() { return getToken(BasicLanguageParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(BasicLanguageParser.MINUS, 0); }
		public TerminalNode LT() { return getToken(BasicLanguageParser.LT, 0); }
		public TerminalNode GT() { return getToken(BasicLanguageParser.GT, 0); }
		public TerminalNode LE() { return getToken(BasicLanguageParser.LE, 0); }
		public TerminalNode GE() { return getToken(BasicLanguageParser.GE, 0); }
		public TerminalNode EQ() { return getToken(BasicLanguageParser.EQ, 0); }
		public TerminalNode NE() { return getToken(BasicLanguageParser.NE, 0); }
		public TerminalNode AND() { return getToken(BasicLanguageParser.AND, 0); }
		public TerminalNode OR() { return getToken(BasicLanguageParser.OR, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(163);
				literal();
				}
				break;
			case 2:
				{
				setState(164);
				match(ID);
				}
				break;
			case 3:
				{
				setState(165);
				match(LPAREN);
				setState(166);
				expr(0);
				setState(167);
				match(RPAREN);
				}
				break;
			case 4:
				{
				setState(169);
				match(NOT);
				setState(170);
				expr(4);
				}
				break;
			case 5:
				{
				setState(171);
				match(ID);
				setState(172);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 16911433728L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(173);
				expr(3);
				}
				break;
			case 6:
				{
				setState(174);
				incrementExpr();
				}
				break;
			case 7:
				{
				setState(175);
				functionCall();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(198);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(196);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(178);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(179);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 458752L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(180);
						expr(11);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(181);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(182);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(183);
						expr(10);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(184);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(185);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7864320L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(186);
						expr(9);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(187);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(188);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NE) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(189);
						expr(8);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(190);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(191);
						match(AND);
						setState(192);
						expr(7);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(193);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(194);
						match(OR);
						setState(195);
						expr(6);
						}
						break;
					}
					} 
				}
				setState(200);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IncrementExprContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(BasicLanguageParser.ID, 0); }
		public TerminalNode INCREMENT() { return getToken(BasicLanguageParser.INCREMENT, 0); }
		public TerminalNode DECREMENT() { return getToken(BasicLanguageParser.DECREMENT, 0); }
		public IncrementExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_incrementExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterIncrementExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitIncrementExpr(this);
		}
	}

	public final IncrementExprContext incrementExpr() throws RecognitionException {
		IncrementExprContext _localctx = new IncrementExprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_incrementExpr);
		try {
			setState(209);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(201);
				match(ID);
				setState(202);
				match(INCREMENT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(203);
				match(ID);
				setState(204);
				match(DECREMENT);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(205);
				match(INCREMENT);
				setState(206);
				match(ID);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(207);
				match(DECREMENT);
				setState(208);
				match(ID);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(BasicLanguageParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(BasicLanguageParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(BasicLanguageParser.RPAREN, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitFunctionCall(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(ID);
			setState(212);
			match(LPAREN);
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 120393316352L) != 0)) {
				{
				setState(213);
				arguments();
				}
			}

			setState(216);
			match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(BasicLanguageParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BasicLanguageParser.COMMA, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitArguments(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			expr(0);
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(219);
				match(COMMA);
				setState(220);
				expr(0);
				}
				}
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(BasicLanguageParser.NUMBER, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(BasicLanguageParser.STRING_LITERAL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			_la = _input.LA(1);
			if ( !(_la==NUMBER || _la==STRING_LITERAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(BasicLanguageParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(BasicLanguageParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(BasicLanguageParser.DOUBLE, 0); }
		public TerminalNode STRING() { return getToken(BasicLanguageParser.STRING, 0); }
		public TerminalNode VOID() { return getToken(BasicLanguageParser.VOID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 62L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 16:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 6);
		case 5:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001,\u00e7\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0001\u0000\u0001\u0000\u0005\u0000/\b\u0000\n\u0000\f\u00002\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001:\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"?\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"E\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0005\u0003M\b\u0003\n\u0003\f\u0003P\t\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005Y\b\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0005\u0006_\b\u0006\n\u0006\f\u0006b\t\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0003\u0007m\b\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0081\b\n\u0001\n\u0003\n\u0084"+
		"\b\n\u0001\u000b\u0003\u000b\u0087\b\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0003\f\u008c\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0003\r\u0095\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0003\u000f\u009f\b\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00b1\b\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005"+
		"\u0010\u00c5\b\u0010\n\u0010\f\u0010\u00c8\t\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0003\u0011\u00d2\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012"+
		"\u00d7\b\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0005\u0013\u00de\b\u0013\n\u0013\f\u0013\u00e1\t\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0000\u0001 \u0016\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*\u0000\u0007\u0001\u0000\u001c!\u0001\u0000\u0010\u0012\u0001\u0000"+
		"\u000e\u000f\u0001\u0000\u0013\u0016\u0001\u0000\u0017\u0018\u0001\u0000"+
		"\f\r\u0001\u0000\u0001\u0005\u00f5\u00000\u0001\u0000\u0000\u0000\u0002"+
		"5\u0001\u0000\u0000\u0000\u0004@\u0001\u0000\u0000\u0000\u0006I\u0001"+
		"\u0000\u0000\u0000\bQ\u0001\u0000\u0000\u0000\nT\u0001\u0000\u0000\u0000"+
		"\f\\\u0001\u0000\u0000\u0000\u000el\u0001\u0000\u0000\u0000\u0010n\u0001"+
		"\u0000\u0000\u0000\u0012q\u0001\u0000\u0000\u0000\u0014\u0083\u0001\u0000"+
		"\u0000\u0000\u0016\u0086\u0001\u0000\u0000\u0000\u0018\u008b\u0001\u0000"+
		"\u0000\u0000\u001a\u008d\u0001\u0000\u0000\u0000\u001c\u0096\u0001\u0000"+
		"\u0000\u0000\u001e\u009c\u0001\u0000\u0000\u0000 \u00b0\u0001\u0000\u0000"+
		"\u0000\"\u00d1\u0001\u0000\u0000\u0000$\u00d3\u0001\u0000\u0000\u0000"+
		"&\u00da\u0001\u0000\u0000\u0000(\u00e2\u0001\u0000\u0000\u0000*\u00e4"+
		"\u0001\u0000\u0000\u0000,/\u0003\u0002\u0001\u0000-/\u0003\u0004\u0002"+
		"\u0000.,\u0001\u0000\u0000\u0000.-\u0001\u0000\u0000\u0000/2\u0001\u0000"+
		"\u0000\u00000.\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u000013\u0001"+
		"\u0000\u0000\u000020\u0001\u0000\u0000\u000034\u0005\u0000\u0000\u0001"+
		"4\u0001\u0001\u0000\u0000\u000056\u0003*\u0015\u000067\u0005\u000b\u0000"+
		"\u000079\u0005$\u0000\u00008:\u0003\u0006\u0003\u000098\u0001\u0000\u0000"+
		"\u00009:\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;>\u0005%\u0000"+
		"\u0000<?\u0005)\u0000\u0000=?\u0003\f\u0006\u0000><\u0001\u0000\u0000"+
		"\u0000>=\u0001\u0000\u0000\u0000?\u0003\u0001\u0000\u0000\u0000@A\u0003"+
		"*\u0015\u0000AD\u0005\u000b\u0000\u0000BC\u0005\u001c\u0000\u0000CE\u0003"+
		" \u0010\u0000DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EF\u0001"+
		"\u0000\u0000\u0000FG\u0005)\u0000\u0000GH\u0006\u0002\uffff\uffff\u0000"+
		"H\u0005\u0001\u0000\u0000\u0000IN\u0003\b\u0004\u0000JK\u0005(\u0000\u0000"+
		"KM\u0003\b\u0004\u0000LJ\u0001\u0000\u0000\u0000MP\u0001\u0000\u0000\u0000"+
		"NL\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000O\u0007\u0001\u0000"+
		"\u0000\u0000PN\u0001\u0000\u0000\u0000QR\u0003*\u0015\u0000RS\u0005\u000b"+
		"\u0000\u0000S\t\u0001\u0000\u0000\u0000TU\u0003*\u0015\u0000UX\u0005\u000b"+
		"\u0000\u0000VW\u0005\u001c\u0000\u0000WY\u0003 \u0010\u0000XV\u0001\u0000"+
		"\u0000\u0000XY\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z[\u0005"+
		")\u0000\u0000[\u000b\u0001\u0000\u0000\u0000\\`\u0005&\u0000\u0000]_\u0003"+
		"\u000e\u0007\u0000^]\u0001\u0000\u0000\u0000_b\u0001\u0000\u0000\u0000"+
		"`^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000ac\u0001\u0000\u0000"+
		"\u0000b`\u0001\u0000\u0000\u0000cd\u0005\'\u0000\u0000d\r\u0001\u0000"+
		"\u0000\u0000em\u0003\u001a\r\u0000fm\u0003\u0012\t\u0000gm\u0003\u001c"+
		"\u000e\u0000hm\u0003\u001e\u000f\u0000im\u0003\n\u0005\u0000jm\u0003\u0010"+
		"\b\u0000km\u0003\f\u0006\u0000le\u0001\u0000\u0000\u0000lf\u0001\u0000"+
		"\u0000\u0000lg\u0001\u0000\u0000\u0000lh\u0001\u0000\u0000\u0000li\u0001"+
		"\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000lk\u0001\u0000\u0000\u0000"+
		"m\u000f\u0001\u0000\u0000\u0000no\u0003 \u0010\u0000op\u0005)\u0000\u0000"+
		"p\u0011\u0001\u0000\u0000\u0000qr\u0005\b\u0000\u0000rs\u0005$\u0000\u0000"+
		"st\u0003\u0014\n\u0000tu\u0003\u0016\u000b\u0000uv\u0003\u0018\f\u0000"+
		"vw\u0005%\u0000\u0000wx\u0003\u000e\u0007\u0000x\u0013\u0001\u0000\u0000"+
		"\u0000yz\u0003*\u0015\u0000z{\u0005\u000b\u0000\u0000{|\u0005\u001c\u0000"+
		"\u0000|}\u0003 \u0010\u0000}~\u0005)\u0000\u0000~\u0084\u0001\u0000\u0000"+
		"\u0000\u007f\u0081\u0003 \u0010\u0000\u0080\u007f\u0001\u0000\u0000\u0000"+
		"\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000"+
		"\u0082\u0084\u0005)\u0000\u0000\u0083y\u0001\u0000\u0000\u0000\u0083\u0080"+
		"\u0001\u0000\u0000\u0000\u0084\u0015\u0001\u0000\u0000\u0000\u0085\u0087"+
		"\u0003 \u0010\u0000\u0086\u0085\u0001\u0000\u0000\u0000\u0086\u0087\u0001"+
		"\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u0089\u0005"+
		")\u0000\u0000\u0089\u0017\u0001\u0000\u0000\u0000\u008a\u008c\u0003 \u0010"+
		"\u0000\u008b\u008a\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000"+
		"\u0000\u008c\u0019\u0001\u0000\u0000\u0000\u008d\u008e\u0005\u0006\u0000"+
		"\u0000\u008e\u008f\u0005$\u0000\u0000\u008f\u0090\u0003 \u0010\u0000\u0090"+
		"\u0091\u0005%\u0000\u0000\u0091\u0094\u0003\u000e\u0007\u0000\u0092\u0093"+
		"\u0005\u0007\u0000\u0000\u0093\u0095\u0003\u000e\u0007\u0000\u0094\u0092"+
		"\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u001b"+
		"\u0001\u0000\u0000\u0000\u0096\u0097\u0005\t\u0000\u0000\u0097\u0098\u0005"+
		"$\u0000\u0000\u0098\u0099\u0003 \u0010\u0000\u0099\u009a\u0005%\u0000"+
		"\u0000\u009a\u009b\u0003\u000e\u0007\u0000\u009b\u001d\u0001\u0000\u0000"+
		"\u0000\u009c\u009e\u0005\n\u0000\u0000\u009d\u009f\u0003 \u0010\u0000"+
		"\u009e\u009d\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000"+
		"\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005)\u0000\u0000\u00a1"+
		"\u001f\u0001\u0000\u0000\u0000\u00a2\u00a3\u0006\u0010\uffff\uffff\u0000"+
		"\u00a3\u00b1\u0003(\u0014\u0000\u00a4\u00b1\u0005\u000b\u0000\u0000\u00a5"+
		"\u00a6\u0005$\u0000\u0000\u00a6\u00a7\u0003 \u0010\u0000\u00a7\u00a8\u0005"+
		"%\u0000\u0000\u00a8\u00b1\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005\u001b"+
		"\u0000\u0000\u00aa\u00b1\u0003 \u0010\u0004\u00ab\u00ac\u0005\u000b\u0000"+
		"\u0000\u00ac\u00ad\u0007\u0000\u0000\u0000\u00ad\u00b1\u0003 \u0010\u0003"+
		"\u00ae\u00b1\u0003\"\u0011\u0000\u00af\u00b1\u0003$\u0012\u0000\u00b0"+
		"\u00a2\u0001\u0000\u0000\u0000\u00b0\u00a4\u0001\u0000\u0000\u0000\u00b0"+
		"\u00a5\u0001\u0000\u0000\u0000\u00b0\u00a9\u0001\u0000\u0000\u0000\u00b0"+
		"\u00ab\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b0"+
		"\u00af\u0001\u0000\u0000\u0000\u00b1\u00c6\u0001\u0000\u0000\u0000\u00b2"+
		"\u00b3\n\n\u0000\u0000\u00b3\u00b4\u0007\u0001\u0000\u0000\u00b4\u00c5"+
		"\u0003 \u0010\u000b\u00b5\u00b6\n\t\u0000\u0000\u00b6\u00b7\u0007\u0002"+
		"\u0000\u0000\u00b7\u00c5\u0003 \u0010\n\u00b8\u00b9\n\b\u0000\u0000\u00b9"+
		"\u00ba\u0007\u0003\u0000\u0000\u00ba\u00c5\u0003 \u0010\t\u00bb\u00bc"+
		"\n\u0007\u0000\u0000\u00bc\u00bd\u0007\u0004\u0000\u0000\u00bd\u00c5\u0003"+
		" \u0010\b\u00be\u00bf\n\u0006\u0000\u0000\u00bf\u00c0\u0005\u0019\u0000"+
		"\u0000\u00c0\u00c5\u0003 \u0010\u0007\u00c1\u00c2\n\u0005\u0000\u0000"+
		"\u00c2\u00c3\u0005\u001a\u0000\u0000\u00c3\u00c5\u0003 \u0010\u0006\u00c4"+
		"\u00b2\u0001\u0000\u0000\u0000\u00c4\u00b5\u0001\u0000\u0000\u0000\u00c4"+
		"\u00b8\u0001\u0000\u0000\u0000\u00c4\u00bb\u0001\u0000\u0000\u0000\u00c4"+
		"\u00be\u0001\u0000\u0000\u0000\u00c4\u00c1\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c8\u0001\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000\u00c6"+
		"\u00c7\u0001\u0000\u0000\u0000\u00c7!\u0001\u0000\u0000\u0000\u00c8\u00c6"+
		"\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005\u000b\u0000\u0000\u00ca\u00d2"+
		"\u0005\"\u0000\u0000\u00cb\u00cc\u0005\u000b\u0000\u0000\u00cc\u00d2\u0005"+
		"#\u0000\u0000\u00cd\u00ce\u0005\"\u0000\u0000\u00ce\u00d2\u0005\u000b"+
		"\u0000\u0000\u00cf\u00d0\u0005#\u0000\u0000\u00d0\u00d2\u0005\u000b\u0000"+
		"\u0000\u00d1\u00c9\u0001\u0000\u0000\u0000\u00d1\u00cb\u0001\u0000\u0000"+
		"\u0000\u00d1\u00cd\u0001\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000"+
		"\u0000\u00d2#\u0001\u0000\u0000\u0000\u00d3\u00d4\u0005\u000b\u0000\u0000"+
		"\u00d4\u00d6\u0005$\u0000\u0000\u00d5\u00d7\u0003&\u0013\u0000\u00d6\u00d5"+
		"\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000\u00d7\u00d8"+
		"\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005%\u0000\u0000\u00d9%\u0001\u0000"+
		"\u0000\u0000\u00da\u00df\u0003 \u0010\u0000\u00db\u00dc\u0005(\u0000\u0000"+
		"\u00dc\u00de\u0003 \u0010\u0000\u00dd\u00db\u0001\u0000\u0000\u0000\u00de"+
		"\u00e1\u0001\u0000\u0000\u0000\u00df\u00dd\u0001\u0000\u0000\u0000\u00df"+
		"\u00e0\u0001\u0000\u0000\u0000\u00e0\'\u0001\u0000\u0000\u0000\u00e1\u00df"+
		"\u0001\u0000\u0000\u0000\u00e2\u00e3\u0007\u0005\u0000\u0000\u00e3)\u0001"+
		"\u0000\u0000\u0000\u00e4\u00e5\u0007\u0006\u0000\u0000\u00e5+\u0001\u0000"+
		"\u0000\u0000\u0015.09>DNX`l\u0080\u0083\u0086\u008b\u0094\u009e\u00b0"+
		"\u00c4\u00c6\u00d1\u00d6\u00df";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}