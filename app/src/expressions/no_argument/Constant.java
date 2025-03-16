package expressions.no_argument;

import java.util.Map;

public class Constant extends NoArgExpr {
    protected double value;

    public Constant(double value) {
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }

    @Override
    public double eval(Map<String, Double> env) {
        return this.value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
