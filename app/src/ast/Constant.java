package ast;

public record Constant(Formula operand) implements Formula {
    public void accept (FormulaVisitor v) {
        v.visit(this);
    }
}
