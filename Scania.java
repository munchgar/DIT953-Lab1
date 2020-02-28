import java.awt.*;

/**
 * Basic class for a Scania truck, extends Car.
 * 
 * @author Jonathan Héden,
 * @author Nicklas Strandevall,
 * @author Kevin Rylander
 */
public class Scania extends Car {

    private int degree = 0;
    private boolean floatBedDown = true;

    public static final int MAX_TILT = 70;
    public static final int MIN_TILT = 0;

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

    public boolean floatBedDown() {
        return floatBedDown;
    }

    /**
     * Tips the flatbed of a scania, only if the speed is 0.
     * 
     * @param deg
     */
    public void tip(int deg) {
        if (getCurrentSpeed() != 0) throw new IllegalStateException();
        if(deg < 0 || deg > 70) throw new IllegalArgumentException();

        if (degree + deg > MAX_TILT)
            degree = MAX_TILT;
        else
            degree += deg;

        if(degree > MIN_TILT)
            floatBedDown = false;
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

        if(degree == MIN_TILT)
            floatBedDown = true;
    }

    protected void incrementSpeed(double amount){
        if(floatBedDown())
            setCurrentSpeed(Math.min(getCurrentSpeed() + amount, getEnginePower()));
    }

    protected void decrementSpeed(double amount){
        if(floatBedDown())
            setCurrentSpeed(Math.max(getCurrentSpeed() - amount, 0));
    }
}


