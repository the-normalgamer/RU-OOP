package expressions.one_argument;

import expressions.Expression;
import expressions.no_argument.Constant;
import expressions.no_argument.NoArgExpr;

import java.util.Map;

public class Negate extends OneArgExpr {
    public Negate(Expression value) {
        this.value = value;
    }

    @Override
    public Expression partialEval() {
        if (value instanceof Constant c) {
            return new Constant(-c.getValue());
        }
        return super.partialEval();
    }
    //    @Override
//    public double eval(Map<String, Double> env) {
//        return -this.value;
//    }

//    @Override
//    public String toString() {
//        return "neg(" + this.value + ")";
//    }
}
