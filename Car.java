import java.awt.*;

/**
 * The Car class is a simple class that implements a basic representation
 * of a car which include some typical car specs as well as position and
 * direction.
 * 
 * @author Jonathan Héden
 * @author Nicklas Strandevall
 * @author Kevin Rylander
 *
 */
public class Car implements Movable {
    
    /**
     * Cars class that specifies the functions of a car. We initiate any car to start in (0,0) with the direction NORTH.
     */
    enum Direction {NORTH, EAST, SOUTH, WEST;} // directional values to represent where a car is facing
    
    Direction dir = Direction.NORTH; // Current direction of car
    double x = 0; // X-coordinate for car
    double y = 0; // Y-coordinate for car

    int nrDoors; // Number of doors on the car
    double enginePower; // Engine power of the car
    double currentSpeed; // The current speed of the car
    Color color; // Color of the car
    String modelName; // The car model name


    /***
     * getter for current speed
     * @return gives back the speed of a car in the form of a double
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /***
     * getter for colour
     * @return gives back the color of a car
     */
    public Color getColor() {
        return color;
    }

    /***
     * setter for color of a car
     * @param clr takes in a color as an argument and sets it for the car.
     */

    public void setColor(Color clr) {
        color = clr;
    }

    /***
     * starting speed when engine is turned on.
     */

    public void startEngine() {
        currentSpeed = 0.1;
    }

    /***
     * getter for number of doors on car
     * @return gives the number of doors
     */

    public int getNrDoors() {
        return nrDoors;
    }

    /***
     * getter for engine power of car
     * @return gives the engine power
     */

    public double getEnginePower() {
        return enginePower;
    }

    /***
     *  Sets speed of car to 0
     */

    public void stopEngine() {
        currentSpeed = 0;
    }

    /***
     * Implementation of the car moving with a direction and speed with a switch statement.
     */

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
    }

    /***
     * Similar implementation but for turning current direction left.
     */

    public void turnLeft() {
        switch (dir) {
            case NORTH:
                dir = Direction.WEST;
                break;
            case EAST:
                dir = Direction.NORTH;
                break;
            case SOUTH:
                dir = Direction.EAST;
                break;
            case WEST:
                dir = Direction.SOUTH;
                break;
        }

    }

    /***
     * Similar implementation but for turning cars direction one step right.
     */
    public void turnRight() {
        switch (dir) {
            case NORTH:
                dir = Direction.EAST;
                break;
            case EAST:
                dir = Direction.SOUTH;
                break;
            case SOUTH:
                dir = Direction.WEST;
                break;
            case WEST:
                dir = Direction.NORTH;
                break;
        }

    }

    /***
     * Improved incrementspeed that adds speed based on amount
     * @param amount <-- relies on this argument
     */
    private void incrementSpeed(double amount) {
        double temp = currentSpeed + amount;
        if (temp > enginePower )
            currentSpeed = enginePower;

        else if (temp < 0)
            currentSpeed = 0;
        else {
            currentSpeed = temp;
        }

    }

    /***
     * Decreases speed by x amount
     * @param amount <-- relies on this argument.
     */

    private void decrementSpeed(double amount) {
        double temp = currentSpeed - amount;
        if (temp > enginePower )
            currentSpeed = enginePower;

        else if (temp < 0)
            currentSpeed = 0;
        else {
            currentSpeed = temp;
        }
    }

    /***
     * Specifies that incrementSpeed (amount) only can be a double in the range of 0 to 1.
     * @param amount <-- takes this as argument.
     */
        public void gas ( double amount){
            incrementSpeed(amount);
            if (amount < 0 || amount > 1) {
                throw new IllegalArgumentException();
            }
        }

    /***
     * Same but for decrementspeed.
     * @param amount <-- takes this as argument
     */
    public void brake ( double amount){
            decrementSpeed(amount);
            if (amount < 0 || amount > 1) {
                throw new IllegalArgumentException();
            }
        }

        // -- PRINT METHODS -- //

    /***
     * Testfunction we used, to print coordinates in the x and y plane.
     */
        void printCoords() {
            System.out.println("(" + x + "," + y + ")");
        }

    }

