package factory.java.factory;

public interface EnergyConsumer {
    /**
     * @return The current voltage
     */
    double getVoltage();

    /**
     * @return The current voltage
     */
    double getCurrent();

    /**
     * @return The yearly power consumption in Kilowatt-hour
     */
    default double getKiloWattHour(){
        return getVoltage()*getCurrent()*24*365/1000;
    }
}