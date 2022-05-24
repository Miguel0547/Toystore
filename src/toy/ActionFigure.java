/*
 * This file represents the toy, ActionFigure. We define first its private state, implement its constructor, its
 * accessors(behaviors) and toString method from ActionFigure's parent class, Doll.
 */
package toy;
/**
 * ActionFigure extends the Doll class and defines the private state and behaviors for all ActionFigure objects.
 *
 * @author Miguel Reyes, mar6466@g.rit.edu
 */
public class ActionFigure extends Doll{
    /**
     * ActionFigure's state: Below are descriptions of state variables not being initialized from constructor.
     *
     * DEGRADATION_RATE - rate of degradation for ActionFigure
     * productCode - the unique 7 digit identifier of each ActionFigure(starts at 5000000)
     */
    private final static int DEGRADATION_RATE = 10;
    private static int productCode = 5000000;
    private Boolean kungFuGrip;

    /**
     *
     * @param name - name of ActionFigure
     * @param msrp - original price of ActionFigure
     * @param hairColor - hair color of ActionFigure
     * @param eyeColor - eye color of ActionFigure
     * @param kungFuGrip - whether the ActionFigure has kungFuGrip or not
     */
    protected ActionFigure(String name, double msrp, String hairColor, String eyeColor, Boolean kungFuGrip){
        super(productCode, name, msrp, hairColor, eyeColor, DEGRADATION_RATE);
        this.kungFuGrip = kungFuGrip;
        productCode += 1;
    }

    /**
     * toString calls toString from the parent class and then concatenates the following strings.
     * @return The string representation of ActionFigure
     */
    @Override
    public String toString() {
        return super.toString().replace(']', ',') + " kung-fu grip=" + this.kungFuGrip + "]";
    }
}
