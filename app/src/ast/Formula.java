package ast;


public interface Formula {
    public void accept (FormulaVisitor visitor);
}
