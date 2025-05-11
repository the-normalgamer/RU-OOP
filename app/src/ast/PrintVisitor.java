package ast;

public class PrintVisitor implements FormulaVisitor<String> {

    @Override
    public String visit(Not form) {
        return "¬" + form.operand().toString();
    }

    @Override
    public String visit(Atom form) {
        return form.label();
    }

    @Override
    public String visit(Constant form) {
        return form.value().toString();
    }

    @Override
    public String visit(BinaryFormula form) {
        return form.operandA().toString() + form.type().toString() + form.operandB().toString();
        // We couldn't figure out how to make a recursive structure using visitors
    }
}
