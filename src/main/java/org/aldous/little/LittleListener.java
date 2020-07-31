// Generated from Little.g4 by ANTLR 4.7.1

package org.aldous.little;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LittleParser}.
 */
public interface LittleListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LittleParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(LittleParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(LittleParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(LittleParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(LittleParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleParser#elseStmt}.
	 * @param ctx the parse tree
	 */
	void enterElseStmt(LittleParser.ElseStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleParser#elseStmt}.
	 * @param ctx the parse tree
	 */
	void exitElseStmt(LittleParser.ElseStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varDec}
	 * labeled alternative in {@link LittleParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterVarDec(LittleParser.VarDecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDec}
	 * labeled alternative in {@link LittleParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitVarDec(LittleParser.VarDecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varAss}
	 * labeled alternative in {@link LittleParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterVarAss(LittleParser.VarAssContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varAss}
	 * labeled alternative in {@link LittleParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitVarAss(LittleParser.VarAssContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayAss}
	 * labeled alternative in {@link LittleParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterArrayAss(LittleParser.ArrayAssContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayAss}
	 * labeled alternative in {@link LittleParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitArrayAss(LittleParser.ArrayAssContext ctx);
	/**
	 * Enter a parse tree produced by the {@code loop}
	 * labeled alternative in {@link LittleParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterLoop(LittleParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code loop}
	 * labeled alternative in {@link LittleParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitLoop(LittleParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code if}
	 * labeled alternative in {@link LittleParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIf(LittleParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code if}
	 * labeled alternative in {@link LittleParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIf(LittleParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code print}
	 * labeled alternative in {@link LittleParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterPrint(LittleParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code print}
	 * labeled alternative in {@link LittleParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitPrint(LittleParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code copy}
	 * labeled alternative in {@link LittleParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterCopy(LittleParser.CopyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code copy}
	 * labeled alternative in {@link LittleParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitCopy(LittleParser.CopyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code division}
	 * labeled alternative in {@link LittleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDivision(LittleParser.DivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code division}
	 * labeled alternative in {@link LittleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDivision(LittleParser.DivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code paren}
	 * labeled alternative in {@link LittleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParen(LittleParser.ParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code paren}
	 * labeled alternative in {@link LittleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParen(LittleParser.ParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link LittleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(LittleParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link LittleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(LittleParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableReference}
	 * labeled alternative in {@link LittleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVariableReference(LittleParser.VariableReferenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableReference}
	 * labeled alternative in {@link LittleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVariableReference(LittleParser.VariableReferenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intLiteral}
	 * labeled alternative in {@link LittleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIntLiteral(LittleParser.IntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intLiteral}
	 * labeled alternative in {@link LittleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIntLiteral(LittleParser.IntLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subtraction}
	 * labeled alternative in {@link LittleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSubtraction(LittleParser.SubtractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subtraction}
	 * labeled alternative in {@link LittleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSubtraction(LittleParser.SubtractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code charLiteral}
	 * labeled alternative in {@link LittleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCharLiteral(LittleParser.CharLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code charLiteral}
	 * labeled alternative in {@link LittleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCharLiteral(LittleParser.CharLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayRef}
	 * labeled alternative in {@link LittleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayRef(LittleParser.ArrayRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayRef}
	 * labeled alternative in {@link LittleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayRef(LittleParser.ArrayRefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplication}
	 * labeled alternative in {@link LittleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplication(LittleParser.MultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplication}
	 * labeled alternative in {@link LittleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplication(LittleParser.MultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code getc}
	 * labeled alternative in {@link LittleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGetc(LittleParser.GetcContext ctx);
	/**
	 * Exit a parse tree produced by the {@code getc}
	 * labeled alternative in {@link LittleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGetc(LittleParser.GetcContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addition}
	 * labeled alternative in {@link LittleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddition(LittleParser.AdditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addition}
	 * labeled alternative in {@link LittleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddition(LittleParser.AdditionContext ctx);
}