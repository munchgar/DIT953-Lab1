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
        super(  4, //nrDoors
                "Volvo240" //modelName
        );
        setColor(Color.BLACK);
        setEnginePower(100);
        stopEngine();
    }

    /**
     * Function that returns the speedFactor
     * 
     * @return gives us a speedfactor based on enginePower, trimfactor & a constant double.
     */
    private double speedFactor(){
        return getEnginePower()*0.01*trimFactor;
    }

    /**
     * Gets overriden by Car.
     * 
     * @param amount
     */
    protected void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor()*amount, getEnginePower()));
    }

    /**
     * Gets overriden by Car.
     * 
     * @param amount
     */
    protected void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor()*amount,0));
    }
}
