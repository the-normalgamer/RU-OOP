package ast;

public interface FormulaVisitor {
    void visit ( Not form );
    void visit ( BinaryOperator form );
    // and so on
}
