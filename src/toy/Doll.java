/*
 * This file represents the toy, Doll. We define first its private state, implement its constructor, its
 * accessors(behaviors) and both play and toString methods from Doll's parent class, Toy.
 */
package toy;
/**
 * Doll extends the Toy abstract class and defines the private state and behaviors for all Doll objects.
 *
 * @author Miguel Reyes, mar6466@g.rit.edu
 */
public class Doll extends Toy{
    /**
     * Doll's state: Below are descriptions of state variables not being initialized from constructor.
     *
     * DEGRADATION_RATE - rate of degradation for Dolls
     * productCode - the unique 7 digit identifier of each Doll(starts at 3000000)
     */
    private static final int DEGRADATION_RATE = 17;
    private static int productCode = 3000000;
    private String hairColor;
    private String eyeColor;

    /**
     * Constructor for Doll objects
     *
     * @param name - name of Doll
     * @param msrp - original price of Doll
     * @param hairColor - hair color of Doll
     * @param eyeColor - eye color of Doll
     */
    protected Doll(String name, double msrp, String hairColor, String eyeColor){
        super(productCode, name, msrp, DEGRADATION_RATE);
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        productCode += 1;
    }

    /**
     * This is the constructor that is called inside the ActionFigures constructor as super() because an Action
     * Figure is a Doll with one exception/difference it has an attribute called kungFuGrip.
     * @param productCode - the unique 7 digit identifier of each ActionFigure
     * @param name - name of ActionFigure
     * @param msrp - original price of ActionFigure
     * @param hairColor - hair color of ActionFigure
     * @param eyeColor - eye color of ActionFigure
     * @param DEGRADATION_RATE - rate of degradation for ActionFigures
     */
    protected Doll(int productCode, String name, double msrp, String hairColor, String eyeColor, int DEGRADATION_RATE) {
        super(productCode, name, msrp, DEGRADATION_RATE);
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
    }

    /**
     * play will first call play from the parent class, and then it will print out the stout message.
     * This play method is called for both Doll and child class ActionFigure implementations.
     */
    @Override
    public void play() {
        super.play();
        System.out.println("After play, " + getName() + "'s condition is " + getCondition());
    }

    /**
     * toString calls toString from the parent class and then concatenates the following strings.
     * @return The string representation of Doll
     */
    @Override
    public String toString() {
        return super.toString() + ", hair color=" + this.hairColor + ", eye color=" + this.eyeColor + "]";
    }

}
