package ast;

public interface FormulaVisitor {
    void visit (Not form);
    void visit (Atom form);
    void visit (Constant form);
    void visit (BinaryFormula form);
}
