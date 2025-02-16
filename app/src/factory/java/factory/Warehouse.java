package factory.java.factory;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Warehouse {
    private String name;
    private List<Product> products;

    public Warehouse(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    public static Warehouse createMyWarehouse() {
        List<Product> products = new ArrayList<>();

        products.add(new Chair("wooden",50.00));
        products.add(new Chair("metal", 100.00));
        products.add(new Tv.TvBuilder(1920,1080)
                .setPrize(300)
                .setBitsPerPixel(24)
                .setRefreshRate(60)
                .setBrand("LG")
                .setModel("L27LCD+")
                .setDisplayTechnology("LCD")
                .addConnector("HDMI")
                .addConnector("HDMI")
                .addConnector("DP")
                .setVoltage(240)
                .setCurrent(0.1)
                .build());
        products.add(new Tv.TvBuilder(1920,1080)
                .setPrize(300)
                .setBitsPerPixel(24)
                .setRefreshRate(60)
                .setBrand("LG")
                .setModel("L27LCD+")
                .setDisplayTechnology("LCD")
                .addConnector("HDMI")
                .addConnector("HDMI")
                .addConnector("DP")
                .addConnector("DP")
                .setVoltage(240)
                .setCurrent(0.1)
                .build());
        products.add(new Tv.TvBuilder(1920,1080)
                .setPrize(500)
                .setBitsPerPixel(24)
                .setRefreshRate(90)
                .setBrand("Sony")
                .setModel("S33IPS++")
                .setDisplayTechnology("IPS")
                .addConnector("HDMI")
                .addConnector("HDMI")
                .addConnector("DP")
                .setVoltage(240)
                .setCurrent(0.1)
                .build());
        products.add(Fridge.CreateFreezer("Bosch",60,400));
        products.add(Fridge.CreateFridge("Samsung",60,600));
        return new Warehouse("My warehouse", products);
    }

    public void procedure1() {
        for (Product product : products) {
            if (product instanceof Tv) {
                if (Objects.equals(((Tv) product).getDisplayTechnology(), "LCD")) {
                    product.multiplyPrice(0.90);
                }
            } else if (product instanceof Fridge) {
                if (((Fridge) product).hasFreezer()) {
                    product.multiplyPrice(1.20);
                }
            }
        }
    }

    public void procedure2() {
        ProcedureOnevisitor visitor = new ProcedureOnevisitor();
        for (Product product : products) {
            product.accept(visitor);

        }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        String output = "Warehouse '"+this.name+"'\nProducts:";
        Iterator<Product> iterator = products.iterator();
        int count = 0;
        while (iterator.hasNext()){
            Product product = iterator.next();
            count++;
            output = output.concat("\n"
                    +count
                    +":\t\t$"
                    +df.format(product.getPrice())
                    +"\t");
            switch (product) {
                case Chair chair -> output = output.concat(chair.material)
                        .concat(" chair");
                case Fridge fridge -> {
                    output = output.concat(""
                            + fridge.getBrand()
                            + " "
                            + fridge.getVolumeInLiters()
                            + "L fridge ");
                    if (fridge.hasFreezer()) {
                        output = output.concat("with freezer");
                    } else output = output.concat("without freezer");
                }
                case Tv tv -> output = output.concat(""
                        + tv.getBrand()
                        + " "
                        + tv.getModel()
                        + ", "
                        + tv.getHorizontalResolution()
                        + "x"
                        + tv.getVerticalResolution()
                        + "x"
                        + tv.getBitsPerPixel()
                        + "@"
                        + tv.getRefreshRate()
                        + "hz "
                        + tv.getDisplayTechnology()
                        + " display "
                        + tv.getConnectors());
                default -> {
                }
            }
            if (EnergyConsumer.class.isAssignableFrom(product.getClass())) {
                output = output.concat(" "
                        + ((EnergyConsumer) product).getVoltage()
                        + "V "
                        + ((EnergyConsumer) product).getCurrent()
                        + "A (") + ((EnergyConsumer) product).getKiloWattHour() + ")";
            }

        }

        return output;
    }
}
