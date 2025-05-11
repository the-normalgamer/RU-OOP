package ast;

public class EvaluateVisitor implements FormulaVisitor<Boolean> {
    @Override
    public Boolean visit(Not form) {
        return null;
    }

    @Override
    public Boolean visit(Atom form) {
        return null;
    }

    @Override
    public Boolean visit(Constant form) {
        return form.value();
    }

    @Override
    public Boolean visit(BinaryFormula form) {
        return null;
    }
}
