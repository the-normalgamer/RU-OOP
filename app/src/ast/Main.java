package ast;

public class Main {

	public static void main(String[] args) {
		Atom f2 = new Atom("P");
		Not f1 = new Not(f2);

		PrintVisitor v = new PrintVisitor();

		f1.accept(v);
	}
}
