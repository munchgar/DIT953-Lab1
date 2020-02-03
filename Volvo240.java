import java.awt.*;

public class Volvo240 extends Car{
    
    /***
     *  Basic class for cars Volvo240, Extends cars superclass
     */

    private final static double trimFactor = 1.25; // Simple double that is used in speedFactor
    /***
    * Specifies the creation of a Volvo240.
    */
    public Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
    }

    /***
     * Sets the currentSpeed to 0.
     */
    public void stopEngine(){
	    currentSpeed = 0;
    }

    /***
     * Function that returns the speedFactor
     * @return gives us a speedfactor based on enginePower, trimfactor & a constant double.
     */
    private double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    /***
     * Gets overriden by Car.
     * @param amount
     */
    private void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    /***
     * Gets overriden by Car.
     * @param amount
     */
    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }


}
