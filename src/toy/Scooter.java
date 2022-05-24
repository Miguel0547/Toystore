/*
 * This file represents the toy, Scooter. We define first its private state, implement its constructor, its
 * accessors(behaviors) and both play and toString methods from Scooters parent class, Toy.
 */
package toy;
/**
 * Scooter extends the Toy abstract class and defines the private state and behaviors for all Scooter objects.
 *
 * @author Miguel Reyes, mar6466@g.rit.edu
 */
public class Scooter extends Toy{
    /**
     * Scooter's state: Below are descriptions of state variables not being initialized from constructor.
     *
     * DEGRADATION_RATE - rate of degradation for Scooters
     * productCode - the unique 7 digit identifier of each Scooter(starts at 9000000)
     * odometer - keeps track of the total miles that the scooter has been used.
     */
    private final static int DEGRADATION_RATE = 5;
    private static int productCode = 9000000;
    private String color;
    private int wheels;
    private int odometer = 0;

    /**
     *
     * @param name - name of Scooter
     * @param msrp - original price of Scooter
     * @param color - color of Scooter
     * @param wheels - amount of wheels Scooter has
     */
    protected Scooter(String name, double msrp, String color, int wheels){
        super(productCode, name, msrp, DEGRADATION_RATE);
        this.color = color;
        this.wheels = wheels;
        productCode += 1;
    }

    /**
     * Below are getters for the following instance variables - color, wheels, and odometer
     */

    public String getColor() {

        return this.color;
    }

    public int getWheels() {
        return this.wheels;
    }


    public int getOdometer() {

        return this.odometer;
    }

    /**
     * play will first call play from the parent class, and then it will print out the stout message. Finally,
     * it increments the odometer by 2 miles.
     */
    @Override
    public void play() {
        super.play();
        System.out.println("After play, " + getName() + "'s condition is " + getCondition());
        this.odometer += 2;
    }

    /**
     * toString calls toString from the parent class and then concatenates the following strings.
     * @return The string representation of Scooter
     */
    @Override
    public String toString() {
        return super.toString() + ", color=" + this.color + ", wheels=" + this.wheels + ", odometer=" + this.odometer
                + "]";
    }
}
