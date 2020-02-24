import java.awt.*;
import java.util.ArrayList;

/**
 * Basic class for a BigBoy truck, extends Car.
 * 
 * @author Jonathan Héden,
 * @author Nicklas Strandevall,
 * @author Kevin Rylander
 */
public class BigBoy extends Car implements Loadable<Car> {

    /**
     * enumeration for the states of the ramp, namely UP and DOWN.
     */
    enum RampMode {UP, DOWN}
    private RampMode rmp;

    /**
     * container for the cars
     */
    private ArrayList<Car> load = new ArrayList<Car>();
    private int loadCapacity;

    /**
     * Constructor for BigBoy.
     */
    public BigBoy() {
        super(  2, //nrDoors
                "BigBoy" //modelName
        );
        rmp = RampMode.UP;
        loadCapacity = 10;
        setColor(Color.ORANGE);
        setEnginePower(550);
        stopEngine();
    }

    /**
     * Method that loads a truck with cars, with a various amount of conditions that need to be met.
     * @param car - takes any car that is not a BigBoy as parameter.
     */
    
    public void load(Car car) {
        if (!checkDistance(car)) throw new IllegalStateException("The vehicles are too far apart or too close");
        if(car instanceof BigBoy) throw new IllegalStateException("You can't load a BigBoy on another BigBoy");
        if (rmp != RampMode.DOWN) throw new IllegalStateException("The ramp must be down to load a car");
        if(getCurrentSpeed() != 0) throw new IllegalStateException("The BigBoy is moving");
        if(load.size() >= loadCapacity) throw new IllegalArgumentException("The BigBoy is full");
        
        load.add(car);
        adjustPos(car);
        }

    /**
     * Small helper function for changing the x and y value of a car to the x and y of a truck.
     * 
     * @param car - takes any car as a parameter.
     */
    public void adjustPos(Car car) {
            car.setX(getX());
            car.setY(getY());
    }

    /**
     * Unloads the car that was last loaded onto the truck and puts it 2 units behind the
     * truck (in whatever direction it is going).
     */
    public Car unload() {
        if (load.size() == 0) throw new IllegalStateException("There's nothing to unload");
        if (getCurrentSpeed() != 0) throw new IllegalStateException("The BigBoy is moving");
        if (rmp != RampMode.DOWN) throw new IllegalStateException("Unable to unload cars as the ramp is not down");

        int indexCar = load.size() - 1;
        Car car = load.remove(indexCar);
        Direction dir = car.getDir();

        switch(dir) {
            case NORTH:
                car.setY(car.getY() - 2);
                break;
            case EAST:
                car.setX(car.getX() - 2);
                break;
            case SOUTH:
                car.setY(car.getY() + 2);
                break;
            case WEST:
                car.setX(car.getX() + 2);
                break;
        }
        return car;
    }
    
    /**
     * Overriden move function that works the same way but also loops through the list of cars (load)
     * and changes the specific cars X and Y to the X and Y of the truck.
     */
    @Override
    public void move() {
        Direction dir = getDir();
        switch (dir) {
            case NORTH:
                setY(getY() + getCurrentSpeed());
                break;
            case EAST:
                setX(getX() + getCurrentSpeed());
                break;
            case SOUTH:
                setY(getY() - getCurrentSpeed());
                break;
            case WEST:
                setX(getX() - getCurrentSpeed());
                break;
        }
        for (int index = 0; index < load.size(); index++) {
            Car car = load.get(index);
            adjustPos(car);
        }
    }

    protected void incrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() + amount);
    }

    protected void decrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() - amount);
    }
}

