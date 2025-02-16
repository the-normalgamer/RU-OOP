package factory.java.factory;

import java.util.ArrayList;

/**
 * @methods: <ul>
 * <li>int getVerticalResolution();
 * <li>int getHorizontalResolution()
 * <li>int getRefreshRate();
 * <li>int getBitsPerPixel();
 * <li>String getBrand();
 * <li>String getModel();
 * <li>String getDisplayTechnology();
 * <li>int getConnectorCount(String type);
 * </ul>
 * <!-- it was really annoying to scroll down when to see what variables to add when implementing this interface so this helps -->
 */
public interface Display {
    int getHorizontalResolution();
    int getVerticalResolution();
    int getRefreshRate();
    int getBitsPerPixel();
    String getBrand();
    String getModel();
    String getDisplayTechnology();

    /**
     * @param type what type of connector to count
     * @return the amount of connectors of the given type
     */
    int getConnectorCount(String type);
}
