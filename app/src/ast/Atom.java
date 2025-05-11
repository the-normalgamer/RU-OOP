package ast;

public record Atom(String label) implements Formula {
    public void accept (FormulaVisitor v) {
        v.visit(this);
    }
}
