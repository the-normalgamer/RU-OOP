package expressions.two_arguments;

import expressions.Expression;
import expressions.no_argument.Constant;

import java.util.Map;

public class Addition extends TwoArgExpr {
    public Addition(Expression valueA, Expression valueB) {
        this.valueA = valueA;
        this.valueB = valueB;
    }

    @Override
    public String toString() {
        return "(" + this.valueA + "+" + this.valueB + ")";
    }

    @Override
    public double eval(Map<String, Double> env) {
        return this.valueA.eval(env) + this.valueB.eval(env);
    }

    @Override
    public Expression partialEval() {
        Expression simplifiedA = this.valueA.partialEval();
        Expression simplifiedB = this.valueB.partialEval();

        // If both are constants
        if (simplifiedA instanceof Constant cA && simplifiedB instanceof Constant cB) {
            return new Constant(cA.getValue() + cB.getValue());
        }
        // If A is 0, return B
        if (simplifiedA instanceof Constant c && c.getValue() == 0.0) {
            return simplifiedB;
        }
        // If B is 0, return A
        if (simplifiedB instanceof Constant c && c.getValue() == 0.0) {
            return simplifiedA;
        }
        // This is already the most simplified
        return new Addition(simplifiedA, simplifiedB);
    }
}
