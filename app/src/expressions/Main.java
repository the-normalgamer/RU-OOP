package expressions;

import expressions.no_argument.Constant;
import expressions.no_argument.Variable;
import expressions.two_arguments.Addition;

import java.util.HashMap;
import java.util.Map;

import static expressions.ExpressionFactory.add;

public class Main {
	public static final Constant PI = new Constant (3.14159);

	public static void main(String[] args) {
		Variable x = new Variable("x");

		Expression simple_addition = add(PI, x);

		Map<String, Double> replacements = new HashMap<>();
		replacements.put("x", 300.0);

		simple_addition.eval(replacements);
	}
}
