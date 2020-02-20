import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Basic class for a BigBoy truck, extends Car.
 * 
 * @author Jonathan Héden,
 * @author Nicklas Strandevall,
 * @author Kevin Rylander
 */
public class BigBoy extends Car {

    /**
     * enumeration for the states of the ramp, namely UP and DOWN.
     */
    enum RampMode {UP, DOWN}
    RampMode rmp;

    /**
     * container for the cars
     */
    ArrayList<Car> load = new ArrayList<Car>();
    int loadSize;

    /**
     * Constructor for BigBoy.
     */
    public BigBoy() {
        rmp = RampMode.UP;
        nrDoors = 2;
        color = Color.black;
        enginePower = 35;
        modelName = "BigBoy";
        loadSize = 0;
        stopEngine();
    }

    /**
     * Method that loads a truck with cars, with a various amount of conditions that need to be met.
     * @param car - takes any car that is not a BigBoy as parameter.
     */
    
    public void load(Car car) {
        if (!checkDistance(car, this)) throw new IllegalStateException("The vehicles are too far apart or too close");
        if(car instanceof BigBoy) throw new IllegalStateException("You can't load a BigBoy on another BigBoy");
        if (rmp != RampMode.DOWN) throw new IllegalStateException("The ramp must be down to load a car");
        if(getCurrentSpeed() != 0) throw new IllegalStateException("The BigBoy is moving");
        if(loadSize + car.size > 10) throw new IllegalStateException("There is not enough room on the BigBoy to load the car");
        
        load.add(car);
        loadSize += car.size;
        changeXy(car);
        }

    /**
     * Small helper function for changing the x and y value of a car to the x and y of a truck.
     * 
     * @param car - takes any car as a parameter.
     */
    public void changeXy(Car car) {
            car.x = this.x;
            car.y = this.y;
    }



    /**
     * Unloads the car that was last loaded onto the truck and puts it 2 units behind the
     * truck (in whatever direction it is going).
     */
    public void unload() {
        if (loadSize == 0) throw new IllegalStateException("There's nothing to unload");
        if (getCurrentSpeed() != 0) throw new IllegalStateException("The BigBoy is moving");
        if (rmp!= RampMode.DOWN) throw new IllegalStateException("Unable to unload cars as the ramp is not down");

        int indexCar = load.size() - 1;
        Car car = load.remove(indexCar);
        loadSize =- car.size;

        switch(this.dir) {
            case NORTH:
                car.y -= 2;
                break;
            case EAST:
                car.x -= 2;
                break;
            case SOUTH:
                car.y += 2;
                break;
            case WEST:
                car.x += 2;
                break;
        }
    }
    
    /**
     * Overriden move function that works the same way but also loops through the list of cars (load)
     * and changes the specific cars X and Y to the X and Y of the truck.
     */
    @Override
    public void move() {
        switch (dir) {
            case NORTH:
                y += getCurrentSpeed();
                break;
            case EAST:
                x += getCurrentSpeed();
                break;
            case SOUTH:
                y -= getCurrentSpeed();
                break;
            case WEST:
                x -= getCurrentSpeed();
                break;
        }
        for (int index = 0; index < load.size(); index++) {
            Car car = load.get(index);
            car.x = this.x;
            car.y = this.y;
        }
    }
}

