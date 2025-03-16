package expressions.one_argument;

import expressions.Expression;
import expressions.no_argument.NoArgExpr;

import java.util.Map;

public class Negate extends OneArgExpr {
    public Negate(Expression value) {
        this.value = value;
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
