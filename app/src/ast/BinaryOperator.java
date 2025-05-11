package ast;

public record BinaryOperator(Formula operand) implements Formula {
    public void accept (FormulaVisitor v) {
        v.visit(this);
    }
}
