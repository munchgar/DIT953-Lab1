import java.awt.*;

/**
 * Represents a car called Saab95 from superclass "cars"
 */
public class Saab95 extends Car{
    /**
     * Determines whether the turbo is on or off
     */
    public boolean turboOn;

    /**
     * Method that gives the Saab95 two doors, the color red and enginepower 125
     *
     */
    public Saab95(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
	    turboOn = false;
        modelName = "Saab95";
        stopEngine();
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
     * @return - Returns the speedfactor
     */
    private double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    /**
     * Gets overridden by method in superclass cars, Improved incrementspeed that adds speed based on amount
     * @param amount
     */
    private void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    /**
     * Gets overridden by superclass cars
     * @param amount
     */
    private void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }
    
    // TODO fix this method according to lab pm

}
