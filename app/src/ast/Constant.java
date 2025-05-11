package ast;

public record Constant(Boolean value) implements Formula {
    @Override
    public void accept(FormulaVisitor visitor) {
        visitor.visit(this);
    }
}

