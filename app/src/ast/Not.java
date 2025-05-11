package ast;

public record Not(Formula operand) implements Formula {

    @Override
    public void accept(FormulaVisitor visitor) {
        visitor.visit(this);
    }
}
