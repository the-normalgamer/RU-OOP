package factory.java.factory;


public class Chair implements Product {
    private double price;
    String material = "wooden";


    public Chair(String material, double price){
        this.material = material;
        this.price = price;
    }

    @Override
    public void setPrice(double price){
        this.price = price;
    }

    /**
     * makes a visitor visit this product
     * @param visitor a given visitor
     */
    @Override
    public void accept(ProductVisitor visitor) {
        visitor.visit(this);
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

}
