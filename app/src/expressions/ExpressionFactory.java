package expressions;

import expressions.no_argument.Constant;
import expressions.no_argument.Variable;
import expressions.one_argument.Negate;
import expressions.two_arguments.Addition;
import expressions.two_arguments.Multiplication;

public class ExpressionFactory {

	public static Expression var(String x) {
		return new Variable(x);
	}

	public static Expression con(Double x) {
		return new Constant(x);
	}

	public static Expression add(Expression x, Expression y) {
		return new Addition(x,y);
	}

	public static Expression mul(Expression x, Expression y) {
		return new Multiplication(x,y);
	}

	public static Expression neg(Expression x) {
		return new Negate(x);
	}
}
