// Generated from Trig.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TrigParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TrigVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TrigParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(TrigParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link TrigParser#trig_func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrig_func(TrigParser.Trig_funcContext ctx);
}