package ast;

import java.util.function.BinaryOperator;

public enum BinOp implements BinaryOperator<Boolean> {
    AND("∧", 2),
    OR ("∨", 3),
    IMP("⇒", 4);

    private final String symbol;
    private final int precedence;

    BinOp(String symbol, int precedence) {
        this.symbol = symbol;
        this.precedence = precedence;
    }

    @Override
    public Boolean apply(Boolean aBoolean, Boolean aBoolean2) {
        return switch (this) {
            case OR  ->  aBoolean || aBoolean2;
            case AND ->  aBoolean && aBoolean2;
            case IMP -> !aBoolean || aBoolean2;
        };
    }

    @Override
    public String toString() {
        return this.symbol;
    }

    public int getPrecedence() {
        return precedence;
    }
}
