package factory.java.factory;


public class Chair implements Product {
    private double price;
    String material = "wood";

    @Override
    public void setPrice(double price){
        this.price = price;
    }

    @Override
    public double getPrice(){
        return price;
    }

    /**
     * @return The material of the chair
     */
    public String getMaterial(){
        return material;
    }
    /*
    @Override
    public void visit(ProductVisitor visitor) {

    }*/
}
