package expressions.two_arguments;

import expressions.Expression;
import expressions.no_argument.Constant;

import java.util.Map;

public class Multiplication extends TwoArgExpr {
    public Multiplication(Expression valueA, Expression valueB) {
        this.valueA = valueA;
        this.valueB = valueB;
    }

    @Override
    public String toString() {
        return "(" + this.valueA + " * " + this.valueB + ")";
    }

    @Override
    public double eval(Map<String, Double> env) {
        return this.valueA.eval(env) * this.valueB.eval(env);
    }

    @Override
    public Expression partialEval() {
        // If both are constants
        if (this.valueA instanceof Constant cA && this.valueB instanceof Constant cB) {
            return new Constant(cA.getValue() * cB.getValue());
        }
        // If A is a constant (as per above either A or B are not)
        if (this.valueA instanceof Constant c) {
            if (c.getValue() == 0.0) return new Constant(0);
            if (c.getValue() == 1.0) return valueB;
        }
        // If B is a constant (as per above either A or B are not)
        if (this.valueB instanceof Constant c) {
            if (c.getValue() == 0.0) return new Constant(0);
            if (c.getValue() == 1.0) return valueA;
        }
        // This is already the most simplified
        return super.partialEval();
    }
}
