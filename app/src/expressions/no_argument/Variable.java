package expressions.no_argument;

import java.util.Map;

public class Variable extends NoArgExpr {
    protected String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public double eval(Map<String, Double> env) {
        if (env.containsKey(this.name))
            return env.get(this.name);

        throw new IllegalStateException("Attempted to evaluate unknown variable");
    }

    @Override
    public String toString() {
        return this.name;
    }
}
