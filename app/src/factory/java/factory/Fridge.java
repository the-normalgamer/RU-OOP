package factory.java.factory;

public class Fridge implements Product, EnergyConsumer{
    private double price;
    private double voltage;
    private double current;
    private boolean hasFreezer;
    private int volumeInLiters;
    private String brand;

    /**
     * @param brand what brand the freezer is
     * @param volume the volume of the freezer in Liters
     * @param price the price of the freezer
     * @return a freezer with the given specifications and 240V and 2A.
     */
    static Fridge CreateFreezer(String brand, int volume, double price){
        Fridge freezer = new Fridge();
        freezer.brand = brand;
        freezer.volumeInLiters = volume;
        freezer.price = price;
        freezer.voltage = 240;
        freezer.current = 2;
        freezer.hasFreezer = true;
        return freezer;
    }

    /**
     * @param brand what brand the fridge is
     * @param volume the volume of the fridge in Liters
     * @param price the price of the fridge
     * @return a fridge with the given specifications and 240V and 2A.
     */
    static Fridge CreateFridge(String brand, int volume, double price){
        Fridge fridge = new Fridge();
        fridge.brand = brand;
        fridge.volumeInLiters = volume;
        fridge.price = price;
        fridge.voltage = 240;
        fridge.current = 2;
        fridge.hasFreezer = false;
        return fridge;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double newPrice) {
        price = newPrice;
    }

    @Override
    public double getVoltage() {
        return voltage;
    }

    @Override
    public double getCurrent() {
        return current;
    }
}
