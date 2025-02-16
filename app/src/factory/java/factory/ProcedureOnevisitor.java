package factory.java.factory;

import java.util.Objects;

public class ProcedureOnevisitor implements ProductVisitor{
    /**
     * reduces wooden chair costs by 15% and increases metal chair costs by 12%
     */
    @Override
    public void visit(Chair chair) {
        if (Objects.equals(chair.getMaterial(), "wooden")){chair.multiplyPrice(0.85);}
        if (Objects.equals(chair.getMaterial(), "metal")){chair.multiplyPrice(1.12);}
    }

    /**
     * @param fridge
     */
    @Override
    public void visit(Fridge fridge) {
        if(fridge.getBrand() == "Samsung"){fridge.multiplyPrice(0.95);}
    }

    /**
     * @param Tv
     */
    @Override
    public void visit(Tv Tv) {
        if (Tv.getConnectorCount("DP")>2){Tv.multiplyPrice(0.7);}
    }
}
