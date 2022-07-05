package edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.model;

/**
 * Interface with required functionality for battery
 */
public interface IBattery {
    /**
     * setter for battery capacity
     * @param batteryCapacity
     */
    void setBatteryCapacity(int batteryCapacity);

    /**
     * getter for battery capacity
     * @return
     */
    int getBatteryCapacity();

    /**
     * setter for battery power
     * @param batteryPower
     */
    void setBatteryPower(int batteryPower);

    /**
     * getter for battery power
     * @return
     */
    int getBatteryPower();
}
