/*
 * This file represents the toy, Robot. We define first its private state, implement its constructor, its
 * accessors(behaviors) and both play and toString methods from Robot's parent class, BatteryOperatedToy.
 */
package toy;
/**
 * Robot extends the BatteryOperatedToy abstract class and defines the private state and behaviors for all Robot objects.
 *
 * @author Miguel Reyes, mar6466@g.rit.edu
 */
public class Robot extends BatteryOperatedToy{
    /**
     * Robot's state: Below are descriptions of state variables not being initialized from constructor.
     *
     * productCode - the unique 7 digit identifier of each Robot(starts at 7000000)
     * DEPLETION_RATE - rate of depletion for Robots
     * DEGRADATION_RATE - rate of degradation for Robots
     */
    private static int productCode = 7000000;
    private final static int DEPLETION_RATE = 25;
    private final static int DEGRADATION_RATE = 20;
    private String sound;

    /**
     *
     * @param name - the name of each  Robot
     * @param msrp - original price of  Robot
     * @param battery - Battery type of Robot
     * @param numberOfBatteries - how many batteries in Robot
     * @param sound - sound robot makes
     */
    protected Robot(String name, double msrp, BatteryType battery, int numberOfBatteries, String sound) {
        super(productCode, name, msrp, battery, numberOfBatteries, DEGRADATION_RATE, DEPLETION_RATE);
        this.sound = sound;
        productCode += 1;
    }
    /**
     * Below is a getter for sound
     */
    public String getSound() {
        return this.sound;
    }

    /**
     * play will first call play from the parent class, and then it will print out the stout messages.
     */
    @Override
    public void play() {
        super.play();
        System.out.println(getName() + " goes '" + this.sound + "'");
        System.out.println("After play, " + getName() + "'s condition is " + getCondition());
    }

    /**
     * toString calls toString from the parent class and then concatenates the following strings.
     * @return The string representation of Robot
     */
    @Override
    public String toString() {
        return super.toString() + ", sound=" + this.sound + "]";
    }
}
