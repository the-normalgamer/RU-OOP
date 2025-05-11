package ast;

public record BinaryFormula<T extends Formula>(T operandA, T operandB, BinOp type) implements Formula {
    public void accept(FormulaVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return operandA.toString() + type.toString() + operandB.toString();
    }
}
