package expressions;

import java.util.HashMap;
import java.util.Map;

import static expressions.ExpressionFactory.*;

public class Main {
	public static final Expression PI = con(3.14159);
	public static Map<String, Double> replacements = new HashMap<>();

	public static void main(String[] args) {
		Expression simple_addition = add(PI, var("x"));

		Expression more_complex_expression = add( mul( con(2.0), con(3.0) ), var("x"));

		replacements.put("x", 300.0);

		simple_addition.eval(replacements);
	}
}
