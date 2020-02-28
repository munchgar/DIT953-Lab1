import java.awt.*;

/**
 * Cars class that specifies the functions of a car.
 * 
 * @author Jonathan Héden,
 * @author Nicklas Strandevall,
 * @author Kevin Rylander
 */
abstract public class Car implements Movable {

    private Direction dir = Direction.NORTH; // Current direction of car
    private Position pos = new Position(0, 0);
    
    private final int nrDoors; // Number of doors on the car
    private final String modelName; // Car model name
    private Color color; // Color of the car

    private double enginePower; // Engine power of the car
    private double currentSpeed; // Current speed of the car

    public Car(int nrDoors, String modelName) {
        this.nrDoors = nrDoors;
        this.modelName = modelName;
    }

    /*---------- Position & Direction ----------*/

    /**
     * Getter for direction
     * 
     * @return - gives the direction
     */
    public Direction getDir() {
        return dir;
    }

    public double getX() {
        return pos.x;
    }

    protected void setX(double x) {
        pos.x = x;
    }

    public double getY() {
        return pos.y;
    }

    protected void setY(double y) {
        pos.y = y;
    }

    /**
     * Getter for number of doors on car.
     * 
     * @return gives the number of doors
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * Getter for colour.
     * 
     * @return gives back the color of a car
     */
    public Color getColor() {
        return color;
    }

    /**
     * Setter for color of a car.
     * 
     * @param clr - takes in a color as an argument and sets it for the car.
     */
    public void setColor(Color clr) {
        color = clr;
    }

    public String getModel() {
        return modelName;
    }

    /**
     * Getter for engine power of car.
     * 
     * @return gives the engine power
     */
    public double getEnginePower() {
        return enginePower;
    }

    protected void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    /**
     * starting speed when engine is turned on.
     */
    public void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * Sets speed of car to 0.
     */

    public void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * Getter for current speed.
     * 
     * @return gives back the speed of a car in the form of a double
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    protected void setCurrentSpeed(double speed) {
        currentSpeed = speed;
    }

    /**
     * Improved incrementspeed that adds speed based on amount.
     * 
     * @param amount - relies on this argument
     */
    abstract protected void incrementSpeed(double amount);

    /**
     * Decreases speed of the car.
     * 
     * @param amount - The amount being decreased.
     */
    abstract protected void decrementSpeed(double amount);

    /**
     * Specifies that incrementSpeed (amount) only can be a double in the range of 0 to 1.
     * 
     * @param amount - takes this as argument.
     */
    public void gas(double amount){
        if(amount < 0 || amount > 1)
            throw new IllegalArgumentException();
        incrementSpeed(amount);
    }

    /**
     * Same but for decrementspeed.
     * 
     * @param amount - takes this as argument
     */
    public void brake(double amount){
        if(amount < 0 || amount > 1)
            throw new IllegalArgumentException();
        decrementSpeed(amount);
    }

    /**
     * Implementation of move() that alters the position of the car based
     * on its direction and speed.
     */
    public void move() {
        switch(dir) {
            case NORTH:
                pos.y += getCurrentSpeed();
                break;
            case EAST:
                pos.x += getCurrentSpeed();
                break;
            case SOUTH:
                pos.y -= getCurrentSpeed();
                break;
            case WEST:
                pos.x -= getCurrentSpeed();
                break;
        }
    }

    /**
     * Turns the car left by changing its direction.
     */
    public void turnLeft() {
        switch(dir) {
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

    /**
     * Turns the car right by changing its direction.
     */
    public void turnRight() {
        switch(dir) {
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

    public void turnAround() {
        turnRight();
        turnRight();
    }

    /**
     * Checks if two cars are an appropriate distance from each other.
     * 
     * @param car1
     * @param car2
     * @return - True if the difference in x or y is greater than 0 and
     * less then or equal to 3. False otherwise.
     */
    public boolean checkDistance(Car car) {
        if(pos.x == car.pos.x && pos.y == car.pos.y) {
            return false;
        } else if (Math.abs(pos.x - car.pos.x) > 3 || Math.abs(pos.y - car.pos.y) > 3) {
            return false;
        }
        return true;
    }

    /***
     * Testfunction for printing the coordinates of a car.
     */
    void printCoords() {
        System.out.println("(" + pos.x + ";" + pos.y + ")");
    }
}

