package ast;

public class PrintVisitor implements FormulaVisitor<String> {

    @Override
    public String visit(Not form) {
        return "¬" + form;
    }

    @Override
    public String visit(Atom form) {

    }

    @Override
    public String visit(Constant form) {

    }

    @Override
    public String visit(BinaryFormula form) {

    }
}
