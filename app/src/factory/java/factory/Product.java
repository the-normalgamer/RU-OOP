package factory.java.factory;

public interface Product {
    /**
     * @return The price of the product
     */
    double getPrice();

    /**
     * @param newPrice the price the product should be set to.
     */
    void setPrice(double newPrice);

    /**
     * @param factor the amount to multiply the current price by<br>
     *               1 = 100%<br>
     *               1.3 = +30%<br>
     *               0.7 = -30%
     */
    default void multiplyPrice(double factor){
        setPrice(getPrice()*factor);
    }
    //void visit(ProductVisitor visitor);
}
