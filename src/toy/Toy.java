/*
 * This file is the parent class of all of our toy objects. We define first
 * the common private state for all the toys, implement the constructor and the accessors(behaviors).
 */

package toy;

/**
 * Toy implements the IToy interface and defines the common private state and behaviors for all the toys(sub-classes)
 *
 * @author Miguel Reyes, mar6466@g.rit.edu
 */

public abstract class Toy implements IToy {
    /**
     * Toy's state: Below are descriptions of state variables not being initialized from constructor.
     *
     * MAX_DEGRADATION - final because it never changes its value of 100, static because it applies to the entire class
     * cond - the condition of the toy. Starts at MINT condition, changes once toy is played with.
     * degradationLevel - how much the toy has been used. Every toy has a unique rate that directly impacts condition.
     *
     */
    private final static int MAX_DEGRADATION = 100;
    private String name;
    private int productCode;
    private double msrp;
    private Condition cond = Condition.MINT;
    private int degradationLevel = 0;
    private int degradationRate;

    /**
     * Toys constructor initializes state variables productCode, name, msrp, degradationRate
     * @param productCode - the unique 7 digit identifier of each Toy
     * @param name - the name of each Toy
     * @param msrp - original price of Toy
     * @param degradationRate - Toys rate of degradation(impacts degradationLevel)
     */
    protected Toy(int productCode, String name, double msrp, int degradationRate) {
        this.productCode = productCode;
        this.name = name;
        this.msrp = msrp;
        this.degradationRate = degradationRate;
    }

    /**
     * Below are getters for the following instance variables - name, productCode, msrp, degradationLevel, cond
     * Below are setters for the following instance variables - degradationLevel and cond
     */

    @Override
    public int getProductCode() {
        return this.productCode;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getMSRP() {
        return this.msrp;
    }
    /**
     * getter for resale value of the toy. The formula of the resale value is the toys msrp * toys condition multiplier
     * @return resale value of toy
     */
    @Override
    public double getResaleValue() {
        return this.msrp * this.cond.getMultiplier();
    }

    @Override
    public Condition getCondition() {
        return this.cond;
    }

    @Override
    public int getDegradationLevel() {
        return this.degradationLevel;
    }

    public void setDegradationLevel(int degradationLevel) {
        this.degradationLevel = degradationLevel;
    }

    public void setCond(Condition cond) {
        this.cond = cond;
    }

    /**
     * The play function for all toys will increase the degradation levels by each toy's unique
     * degradation rate(updating the value). It will then update the condition of the toy based on the degradation levels.
     */
    @Override
    public void play() {
        setDegradationLevel(this.degradationLevel + this.degradationRate);
        setCond(Condition.get(this.degradationLevel));
        if (getDegradationLevel() > MAX_DEGRADATION) {
            setDegradationLevel(MAX_DEGRADATION);
            setCond(Condition.get(this.degradationLevel));
        }
    }

    /**
     *
     * @return The string representation of each toy will have the following.
     */
    @Override
    public String toString() {
        String correctFormatMSRP = String.format("MSRP=%.2f", this.msrp);
        String correctFormatResaleValue = String.format("resale value=%.2f", getResaleValue());
        return this.name + " [product code=" + this.productCode + ", " + correctFormatMSRP + ", degradation level=" +
                this.degradationLevel + "%, condition=" + this.cond + ", " + correctFormatResaleValue;
    }
}
