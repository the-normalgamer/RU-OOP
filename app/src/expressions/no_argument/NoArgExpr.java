package expressions.no_argument;

import expressions.Expression;

import java.util.Map;

public abstract class NoArgExpr implements Expression {
    @Override
    public double eval(Map<String, Double> env) {
        return 0;
    }

    @Override
    public Expression partialEval() {
        return this;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

}
