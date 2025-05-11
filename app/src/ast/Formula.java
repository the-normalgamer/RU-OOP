package ast;


public interface Formula {
    void accept (FormulaVisitor visitor);
}
