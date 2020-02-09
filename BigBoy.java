import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/***
 * Class for a truck.
 */

public class BigBoy extends Cars {

    /***
     * enumeration for the states of the ramp, namely UP or DOWN.
     */
    enum RampMode {UP, DOWN}
    RampMode rmp;
    /***
     * container for the cars
     */
    ArrayList<Cars> load = new ArrayList<Cars>();
    int loadSize;
    BigBoy bigboy = new BigBoy();
    /***
     * Constructor for BigBoy (a truck).
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

    /***
     * Method that loads a truck with cars, with a various amount of conditions that need to be met.
     * @param car <-- takes any car that is not a BigBoy as parameter.
     */
    public void load(Cars car) {
        if (!checkDistance(car, this)) throw new IllegalStateException("The vehicles are too far apart or too close");
        if(car instanceof BigBoy) throw new IllegalStateException("You can't load a BigBoy on another BigBoy");
        if (rmp != RampMode.DOWN) throw new IllegalStateException("The ramp must be down to load a car");
        if(getCurrentSpeed() != 0) throw new IllegalStateException("The BigBoy is moving");
        if(loadSize + car.size > 10) throw new IllegalStateException("There is not enough room on the BigBoy to load the car");
        load.add(car);
        loadSize += car.size;
        changeXy(car);
        }


    public void changeXy(Cars car) {
            car.x = this.x;
            car.y = this.y;
    }

    /***
     * Unloads the car that was last loaded onto the truck
     */
    public void unload() {
        if (getCurrentSpeed() != 0) throw new IllegalStateException("The BigBoy is moving");
        if (rmp!= RampMode.DOWN) throw new IllegalStateException("Unable to unload cars as the ramp is not down");
        int indexCar = load.size() - 1;
        Cars car = load.remove(indexCar);
        load.remove(indexCar);
        car.x = car.x + 2;
        car.y = car.y + 2;
    }
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
        for (int index = 0; index < load.size()+1; index++) {
            Cars car = load.get(index);
            car.x = this.x;
            car.y = this.y;
        }
    }



}

