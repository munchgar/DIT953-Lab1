import java.awt.*;

/**
 * Basic class for a Volvo240, extends Car.
 * 
 * @author Jonathan Héden,
 * @author Nicklas Strandevall,
 * @author Kevin Rylander
 */
public class Volvo240 extends Car{

    private final static double trimFactor = 1.25; // Value that is used when calculating speedFactor.

    /**
    * Constructor that gives the Volvo240 4 doors, the color black and enginepower 100.
    */
    public Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
    }

    /**
     * Sets the currentSpeed to 0.
     */
    public void stopEngine(){
	    currentSpeed = 0;
    }

    /**
     * Function that returns the speedFactor
     * 
     * @return gives us a speedfactor based on enginePower, trimfactor & a constant double.
     */
    private double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    /**
     * Gets overriden by Car.
     * 
     * @param amount
     */
    @Override
    protected void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    /**
     * Gets overriden by Car.
     * 
     * @param amount
     */
    @Override
    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }
}
