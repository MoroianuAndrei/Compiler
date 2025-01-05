// Generated from d:/Compiler/Tema/Tema/BasicLanguage.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BasicLanguageParser}.
 */
public interface BasicLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BasicLanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(BasicLanguageParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicLanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(BasicLanguageParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicLanguageParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(BasicLanguageParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicLanguageParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(BasicLanguageParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicLanguageParser#globalDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterGlobalDeclaration(BasicLanguageParser.GlobalDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicLanguageParser#globalDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitGlobalDeclaration(BasicLanguageParser.GlobalDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicLanguageParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(BasicLanguageParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicLanguageParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(BasicLanguageParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicLanguageParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(BasicLanguageParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicLanguageParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(BasicLanguageParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicLanguageParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(BasicLanguageParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicLanguageParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(BasicLanguageParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicLanguageParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(BasicLanguageParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicLanguageParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(BasicLanguageParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(BasicLanguageParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(BasicLanguageParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicLanguageParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(BasicLanguageParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicLanguageParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(BasicLanguageParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicLanguageParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(BasicLanguageParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicLanguageParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(BasicLanguageParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicLanguageParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(BasicLanguageParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicLanguageParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(BasicLanguageParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicLanguageParser#forCondition}.
	 * @param ctx the parse tree
	 */
	void enterForCondition(BasicLanguageParser.ForConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicLanguageParser#forCondition}.
	 * @param ctx the parse tree
	 */
	void exitForCondition(BasicLanguageParser.ForConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicLanguageParser#forIncrement}.
	 * @param ctx the parse tree
	 */
	void enterForIncrement(BasicLanguageParser.ForIncrementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicLanguageParser#forIncrement}.
	 * @param ctx the parse tree
	 */
	void exitForIncrement(BasicLanguageParser.ForIncrementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicLanguageParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(BasicLanguageParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicLanguageParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(BasicLanguageParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicLanguageParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(BasicLanguageParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicLanguageParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(BasicLanguageParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicLanguageParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(BasicLanguageParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicLanguageParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(BasicLanguageParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(BasicLanguageParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(BasicLanguageParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicLanguageParser#incrementExpr}.
	 * @param ctx the parse tree
	 */
	void enterIncrementExpr(BasicLanguageParser.IncrementExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicLanguageParser#incrementExpr}.
	 * @param ctx the parse tree
	 */
	void exitIncrementExpr(BasicLanguageParser.IncrementExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicLanguageParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(BasicLanguageParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicLanguageParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(BasicLanguageParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicLanguageParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(BasicLanguageParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicLanguageParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(BasicLanguageParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicLanguageParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(BasicLanguageParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicLanguageParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(BasicLanguageParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicLanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(BasicLanguageParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicLanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(BasicLanguageParser.TypeContext ctx);
}