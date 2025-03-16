package expressions.one_argument;

import expressions.Expression;
import expressions.no_argument.Constant;
import expressions.no_argument.NoArgExpr;

import java.util.Map;

public abstract class OneArgExpr implements Expression {
    protected Expression value;

    @Override
    public double eval(Map<String, Double> env) {
        return 0;
    }

    @Override
    public Expression partialEval() {
        return this;
    }
}
