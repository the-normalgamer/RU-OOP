package expressions.one_argument;

import expressions.Expression;

import java.util.Map;

public abstract class OneArgExpr implements Expression {
    @Override
    public double eval(Map<String, Double> env) {
        return 0;
    }

    @Override
    public Expression partialEval() {
        return null;
    }
}
