package factory.java.factory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Tv implements Product, EnergyConsumer, Display{
    private int horizontalResolution;
    private int verticalResolution;
    private int refreshRate;
    private int bitsPerPixel;
    private String brand;
    private String model;
    private String displayTechnology;
    private ArrayList<String> connectors;
    private double voltage;
    private double current;
    private double prize;

    @Override
    public int getHorizontalResolution() {
        return horizontalResolution;
    }

    @Override
    public int getVerticalResolution() {
        return verticalResolution;
    }

    @Override
    public int getRefreshRate() {
        return refreshRate;
    }

    @Override
    public int getBitsPerPixel() {
        return bitsPerPixel;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getDisplayTechnology() {
        return displayTechnology;
    }

    @Override
    public int getConnectorCount(String type) {
        private Iterator<String> iterator = connectors.iterator()
        int count = 0;
        while (iterator.hasNext()){
            if (Objects.equals(iterator.next(), type)) {
                count++;
            };
        }
        return count;
    }

    @Override
    public double getVoltage() {
        return voltage;
    }

    @Override
    public double getCurrent() {
        return current;
    }

    @Override
    public double getPrice() {
        return prize;
    }

    @Override
    public void setPrice(double newPrice) {
        prize = newPrice;
    }


}
