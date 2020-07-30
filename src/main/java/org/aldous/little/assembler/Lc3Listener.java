// Generated from Lc3.g4 by ANTLR 4.7.1

package org.aldous.little.assembler;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Lc3Parser}.
 */
public interface Lc3Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Lc3Parser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(Lc3Parser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link Lc3Parser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(Lc3Parser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link Lc3Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(Lc3Parser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Lc3Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(Lc3Parser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orig}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void enterOrig(Lc3Parser.OrigContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orig}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void exitOrig(Lc3Parser.OrigContext ctx);
	/**
	 * Enter a parse tree produced by the {@code add}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void enterAdd(Lc3Parser.AddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code add}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void exitAdd(Lc3Parser.AddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code and}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void enterAnd(Lc3Parser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code and}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void exitAnd(Lc3Parser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code not}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void enterNot(Lc3Parser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code not}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void exitNot(Lc3Parser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jmp}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void enterJmp(Lc3Parser.JmpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jmp}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void exitJmp(Lc3Parser.JmpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code br}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void enterBr(Lc3Parser.BrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code br}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void exitBr(Lc3Parser.BrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ret}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void enterRet(Lc3Parser.RetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ret}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void exitRet(Lc3Parser.RetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jsr}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void enterJsr(Lc3Parser.JsrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jsr}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void exitJsr(Lc3Parser.JsrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code label}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void enterLabel(Lc3Parser.LabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code label}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void exitLabel(Lc3Parser.LabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jsrr}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void enterJsrr(Lc3Parser.JsrrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jsrr}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void exitJsrr(Lc3Parser.JsrrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ld}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void enterLd(Lc3Parser.LdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ld}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void exitLd(Lc3Parser.LdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ldi}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void enterLdi(Lc3Parser.LdiContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ldi}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void exitLdi(Lc3Parser.LdiContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ldr}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void enterLdr(Lc3Parser.LdrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ldr}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void exitLdr(Lc3Parser.LdrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lea}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void enterLea(Lc3Parser.LeaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lea}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void exitLea(Lc3Parser.LeaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code st}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void enterSt(Lc3Parser.StContext ctx);
	/**
	 * Exit a parse tree produced by the {@code st}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void exitSt(Lc3Parser.StContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sti}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void enterSti(Lc3Parser.StiContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sti}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void exitSti(Lc3Parser.StiContext ctx);
	/**
	 * Enter a parse tree produced by the {@code str}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void enterStr(Lc3Parser.StrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code str}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void exitStr(Lc3Parser.StrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fill}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void enterFill(Lc3Parser.FillContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fill}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void exitFill(Lc3Parser.FillContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringz}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void enterStringz(Lc3Parser.StringzContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringz}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void exitStringz(Lc3Parser.StringzContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blkw}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlkw(Lc3Parser.BlkwContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blkw}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlkw(Lc3Parser.BlkwContext ctx);
	/**
	 * Enter a parse tree produced by the {@code puts}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void enterPuts(Lc3Parser.PutsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code puts}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void exitPuts(Lc3Parser.PutsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code getc}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void enterGetc(Lc3Parser.GetcContext ctx);
	/**
	 * Exit a parse tree produced by the {@code getc}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void exitGetc(Lc3Parser.GetcContext ctx);
	/**
	 * Enter a parse tree produced by the {@code out}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void enterOut(Lc3Parser.OutContext ctx);
	/**
	 * Exit a parse tree produced by the {@code out}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void exitOut(Lc3Parser.OutContext ctx);
	/**
	 * Enter a parse tree produced by the {@code halt}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void enterHalt(Lc3Parser.HaltContext ctx);
	/**
	 * Exit a parse tree produced by the {@code halt}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void exitHalt(Lc3Parser.HaltContext ctx);
	/**
	 * Enter a parse tree produced by the {@code end}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void enterEnd(Lc3Parser.EndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code end}
	 * labeled alternative in {@link Lc3Parser#innerStatement}.
	 * @param ctx the parse tree
	 */
	void exitEnd(Lc3Parser.EndContext ctx);
}