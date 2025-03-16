package expressions.one_argument;

import expressions.Expression;
import expressions.no_argument.Constant;

import java.util.Map;

public class Negate extends OneArgExpr {
    public Negate(Expression value) {
        this.value = value;
    }

    @Override
    public Expression partialEval() {
        // If the value is a (negatable) constant
        if (value instanceof Constant c) {
            return new Constant(-c.getValue());
        }
        // This is already the most simplified
        return this.value.partialEval();
    }

    @Override
    public double eval(Map<String, Double> env) {
        // The value itself has evaluation capabilities,
        // returning a value we can just negate.
        return -value.eval(env);
    }

    @Override
    public String toString() {
        return "-" + this.value.toString();
    }
}
