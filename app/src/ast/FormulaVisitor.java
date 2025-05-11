package ast;

public interface FormulaVisitor<Result> {
    Result visit(Not form);

    Result visit(Atom form);

    Result visit(Constant form);

    Result visit(BinaryFormula form);
}
