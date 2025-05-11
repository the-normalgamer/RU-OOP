package ast;

public record BinaryFormula(Formula operand) implements Formula {
    public void accept (FormulaVisitor v) {
        v.visit(this);
    }
}
