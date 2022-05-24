/*
 * This file represents the toy, RCCar. We define first its private state, implement its constructor, its
 * accessors(behaviors) and both play and toString methods from RCCar's parent class, BatteryOperatedToy.
 */
package toy;
/**
 * RCCar extends the BatteryOperatedToy abstract class and defines the private state and behaviors for all RCCar objects.
 *
 * @author Miguel Reyes, mar6466@g.rit.edu
 */
public class RCCar extends BatteryOperatedToy{
    /**
     * RCCar's state: Below are descriptions of state variables not being initialized from constructor.
     *
     * productCode - the unique 7 digit identifier of each RCCar(starts at 6000000)
     * DEPLETION_RATE - rate of depletion for RCCar
     * DEGRADATION_RATE - rate of degradation for RCCar
     */
    private static int productCode = 6000000;
    private final static int DEPLETION_RATE = 30;
    private final static int DEGRADATION_RATE = 15;
    private int speed;

    /**
     *
     * @param name - the name of each  RCCar
     * @param msrp - original price of  RCCar
     * @param battery - Battery type of RCCar
     * @param numberOfBatteries - how many batteries in RCCar
     * @param speed - speed(mph) RCCar goes
     */
    protected RCCar(String name, double msrp, BatteryType battery, int numberOfBatteries, int speed) {
        super(productCode, name, msrp, battery, numberOfBatteries, DEGRADATION_RATE, DEPLETION_RATE);
        this.speed = speed;
        productCode += 1;
    }
    /**
     * Below is a getter for speed
     */
    public int getSpeed() {
        return this.speed;
    }
    /**
     * play will first call play from the parent class, and then it will print out the stout messages.
     */
    @Override
    public void play() {
        super.play();
        System.out.println(getName() + " races in circles at " + this.speed + " mph!");
        System.out.println("After play, " + getName() + "'s condition is " + getCondition());
    }
    /**
     * toString calls toString from the parent class and then concatenates the following strings.
     * @return The string representation of RCCar
     */
    @Override
    public String toString() {
        return super.toString() + ", speed=" + this.speed + "]";
    }
}
