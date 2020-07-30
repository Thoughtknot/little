// Generated from src/main/antlr/Little.g4 by ANTLR 4.7.1

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
	 * Enter a parse tree produced by {@link LittleParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(LittleParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(LittleParser.VariableDeclarationContext ctx);
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
	 * Enter a parse tree produced by the {@code decLiteral}
	 * labeled alternative in {@link LittleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDecLiteral(LittleParser.DecLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decLiteral}
	 * labeled alternative in {@link LittleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDecLiteral(LittleParser.DecLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolLiteral}
	 * labeled alternative in {@link LittleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolLiteral(LittleParser.BoolLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolLiteral}
	 * labeled alternative in {@link LittleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolLiteral(LittleParser.BoolLiteralContext ctx);
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
	 * Enter a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link LittleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpression(LittleParser.ParenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link LittleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpression(LittleParser.ParenExpressionContext ctx);
}