package expressions.two_arguments;

import expressions.Expression;

public class Multiplication extends TwoArgExpr {
    public Multiplication(Expression valueA, Expression valueB) {
        this.valueA = valueA;
        this.valueB = valueB;
    }

    @Override
    public String toString() {
        return "( " + this.valueA + " + " + this.valueB + " )";
    }

    @Override
    public Expression partialEval() {
        return super.partialEval();
    }
}
