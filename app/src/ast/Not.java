package ast;

public record Not(Formula operand) implements Formula {
    public void accept (FormulaVisitor v) {
        v.visit(this);
    }
}
