import java.awt.*;

/**
 * Basic class for a Saab95, extends Car.
 * 
 * @author Jonathan Héden,
 * @author Nicklas Strandevall,
 * @author Kevin Rylander
 */
public class Saab95 extends Car {
    
    private boolean turboOn;

    /**
     * Constructor that gives the Saab95 2 doors, the color red and enginepower 125.
     */
    public Saab95(){
        super(  2, //nrDoors
                "Saab95" //modelName
        );
        setColor(Color.RED);
        setEnginePower(125);
	    turboOn = false;
        stopEngine();
    }

    public boolean getTurbo() {
        return turboOn;
    }

    /**
     * Turns the turbo on
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * Turns the turbo off
     */
    public void setTurboOff(){
	    turboOn = false;
    }

    /**
     * Method that determines the speedfactor based on the enginepower and turbo
     * 
     * @return - Returns the speedfactor
     */
    private double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    /**
     * Gets overridden by method in superclass car. Improved incrementspeed that adds speed based on amount
     * @param amount
     */
    protected void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    /**
     * Gets overridden by superclass car. Decreases speed by x amount
     * @param amount
     */
    protected void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
    }
}
