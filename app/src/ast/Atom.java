package ast;

public record Atom(String label) implements Formula {
    @Override
    public <R, A> R accept(FormulaVisitor<R, A> visitor, A a) {
        return null;
    }
}
