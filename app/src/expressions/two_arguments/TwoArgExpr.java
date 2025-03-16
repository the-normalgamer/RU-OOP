package expressions.two_arguments;

import expressions.Expression;
import expressions.no_argument.Constant;
import expressions.no_argument.NoArgExpr;

import java.util.Map;

public abstract class TwoArgExpr implements Expression {
    protected Expression valueA;
    protected Expression valueB;

    @Override
    public double eval(Map<String, Double> env) {
        return 0;
    }

    @Override
    public Expression partialEval() {
        return this;
    }
}
