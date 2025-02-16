package factory.java.factory;

public interface ProductVisitor {
    void visit(Chair chair);
    void visit(Fridge fridge);
    void visit(Tv Tv);
}
