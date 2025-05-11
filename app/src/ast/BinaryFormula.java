package ast;

public record BinaryFormula(Formula operandA, Formula operandB) implements Formula {
    public void accept (FormulaVisitor visitor) {
        visitor.visit(this);
    }
}
