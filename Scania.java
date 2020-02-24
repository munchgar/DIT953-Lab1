import java.awt.*;

/**
 * Basic class for a Scania truck, extends Car.
 * 
 * @author Jonathan Héden,
 * @author Nicklas Strandevall,
 * @author Kevin Rylander
 */
public class Scania extends Car {

    private int degree;

    final int MAX_TILT = 70;
    final int MIN_TILT = 0;

    /**
     * Constructor for a scania truck.
     */
    public Scania() {
        super(  2,  //nrDoors
                "Scania" //modelName
        );
        setColor(Color.GRAY);
        setEnginePower(325);
    }

    public int getDegree() {
        return degree;
    }

    /**
     * Tips the flatbed of a scania, only if the speed is 0.
     * 
     * @param deg
     */
    public void tip(int deg) {
        if (getCurrentSpeed() != 0 ) throw new IllegalStateException();
        if(deg < 0) throw new IllegalArgumentException();

        if (degree + deg > MAX_TILT)
            degree = MAX_TILT;
        else
            degree += deg;
    }

    /**
     * Sinks the flatbed of a scania, only if the speed is 0.
     * 
     * @param deg
     */
    public void sink(int deg) {
        if (getCurrentSpeed() != 0 ) throw new IllegalStateException();
        if(deg < 0) throw new IllegalArgumentException();

        if (degree - deg < MIN_TILT)
            degree = MIN_TILT;
        else
            degree -= deg;
    }

    /**
     * Overriden gas function that also says that if the degree of the flatbed is higher than 0
     * it will give an error, preventing the truck from driving with a flatbed that has tipped.
     * 
     * @param amount - takes this as argument. (value between 0 and 1 or error).
     */
    @Override
    public void gas(double amount){
        if (degree > 0) throw new IllegalStateException("The flatbed is still up");
        if (amount < 0 || amount > 1) throw new IllegalArgumentException();

        incrementSpeed(amount);
    }

    protected void incrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() + amount);
    }

    protected void decrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() - amount);
    }
}


