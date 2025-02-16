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
    public double getKiloWattHour(){
        return getVoltage()*getCurrent()*24*365/10000;
    }

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
        Iterator<String> iterator = connectors.iterator();
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

    public ArrayList<String> getConnectors(){
        return connectors;
    }


    private Tv(TvBuilder builder){
        this.horizontalResolution = builder.horizontalResolution;
        this.verticalResolution = builder.verticalResolution;
        this.refreshRate = builder.refreshRate;
        this.bitsPerPixel = builder.bitsPerPixel;
        this.brand = builder.brand;
        this.model = builder.model;
        this.displayTechnology = builder.displayTechnology;
        this.connectors = builder.connectors;
        this.voltage = builder.voltage;
        this.current = builder.current;
        this.prize = builder.prize;

    }

    public static class TvBuilder{

        // required parameters
        private int horizontalResolution;
        private int verticalResolution;
        // optional parameters
        private int refreshRate = 60;
        private int bitsPerPixel = 24;
        private String brand;
        private String model;
        private String displayTechnology;
        private ArrayList<String> connectors = new ArrayList<String>();
        private double voltage = 240;
        private double current = 0.1;
        private double prize;

        public TvBuilder(int horizontalResolution, int verticalResolution){
            this.horizontalResolution = horizontalResolution;
            this.verticalResolution = verticalResolution;
        }

        public TvBuilder setRefreshRate(int refreshRate){
            this.refreshRate = refreshRate;
            return this;
        }


        public TvBuilder setBitsPerPixel(int bitsPerPixel){
            this.bitsPerPixel = bitsPerPixel;
            return this;
        }
        public TvBuilder setBrand(String brand){
            this.brand = brand;
            return this;
        }
        public TvBuilder setModel(String model){
            this.model = model;
            return this;
        }
        public TvBuilder setDisplayTechnology(String displayTechnology){
            this.displayTechnology = displayTechnology;
            return this;
        }
        public TvBuilder addConnector(String connector){
            this.connectors.add(connector);
            return this;
        }

        public TvBuilder setVoltage(double voltage){
            this.voltage = voltage;
            return this;
        }

        public TvBuilder setCurrent(double current){
            this.current = current;
            return this;
        }

        public TvBuilder setPrize(double prize){
            this.prize = prize;
            return this;
        }


        public Tv build(){
            return new Tv(this);
        }
    }

    /**
     * makes a visitor visit this product
     * @param visitor a given visitor
     */
    @Override
    public void accept(ProductVisitor visitor) {
        visitor.visit(this);
    }
}
