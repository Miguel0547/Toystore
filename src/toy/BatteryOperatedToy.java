/*
 * This file represents all types of BatteryOperatedToy. It is the parent class of RCCar and Robot. We define first the
 * common private state for all the BatteryOperatedToy's, implement the constructor, the accessors(behaviors), toString
 * and play from parent class, Toy.
 */
package toy;
/**
 * BatteryOperatedToy extends the Toy class and defines the common private state and behaviors for all the
 * BatteryOperatedToy's.
 *
 * @author Miguel Reyes, mar6466@g.rit.edu
 */
public abstract class BatteryOperatedToy extends Toy{
    /**
     * BatteryOperatedToy's state: Below are descriptions of state variables not being initialized from constructor.
     *
     * FULLY_CHARGED - Initial state of all BatterOperatedToys is that they are all "fully charged" = 100% batteryLevel
     * DEPLETED - when the Battery is 0%
     * batteryLevel - how much of the BatterOperatedToy's battery has been used.
     */
    private final static int FULLY_CHARGED = 100;
    private final static int DEPLETED = 0;
    private int batteryLevel = FULLY_CHARGED;
    private int numberOfBatteries;
    private BatteryType battery;
    private int depletionRate;

    /**
     *
     * @param productCode - the unique 7 digit identifier of each BatteryOperatedToy
     * @param name - the name of each  BatteryOperatedToy
     * @param msrp - original price of  BatteryOperatedToy
     * @param battery - Battery type of BatteryOperatedToy
     * @param numberOfBatteries - how many batteries in BatteryOperatedToy
     * @param degradationRate - BatteryOperatedToy rate of degradation(impacts degradationLevel)
     * @param depletionRate - BatteryOperatedToy rate of depletion(impacts batteryLevel)
     */
    public BatteryOperatedToy(int productCode, String name, double msrp, BatteryType battery, int numberOfBatteries, int degradationRate, int depletionRate){
        super(productCode, name, msrp,degradationRate);
        this.battery = battery;
        this.numberOfBatteries = numberOfBatteries;
        this.depletionRate = depletionRate;
    }
    /**
     * Below is a setter batteryLevel
     */
    public void setBatteryLevel(int batteryLevel){
        this.batteryLevel = batteryLevel;
    }

    /**
     * play will first call play from parent class and check/update degradation level and condition.
     * Then for BatteryOperatedToy's we will decrement batteryLevel by the toy's depletion rate.
     * If batteries reach below zero then we set the battery level to DEPLETED. If play is implemented and battery is
     * DEPLETED we reset the batteryLevel to FULLY_CHARGED minus the depletionRate because we need to consider the play
     * called at that moment. Otherwise, if batteryLevel never reaches a negative level than we set the battery levels
     * to FULLY_CHARGED. This is all done as long as the toy does not reach MAX_DEGRADATION because then its
     * "thrown out".
     */
    @Override
    public void play() {
        super.play();
        if(this.batteryLevel > DEPLETED){
            setBatteryLevel(this.batteryLevel - this.depletionRate);
            if (this.batteryLevel < DEPLETED){
                setBatteryLevel(DEPLETED);
            }
        }
        else {
            if(this.batteryLevel == DEPLETED){
                setBatteryLevel(FULLY_CHARGED - this.depletionRate);
                System.out.println("The batteries are dead! Let's replace them...");
            }
            else{
                System.out.println("The batteries are dead! Let's replace them...");
                setBatteryLevel(FULLY_CHARGED);
            }
        }

    }
    /**
     * toString calls toString from the parent class and then concatenates the following strings.
     * @return The string representation of BatteryOperatedToy's
     */
    @Override
    public String toString() {
        return super.toString() + ", battery type=" + this.battery + ", number of batteries=" + this.numberOfBatteries
                + ", battery level=" + this.batteryLevel + "%";
    }
}
