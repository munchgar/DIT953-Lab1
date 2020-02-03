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
     * the direction of the car as represented by the points of
     * the compass (north, east, south and west).
     */
    enum Direction{NORTH, EAST, SOUTH, WEST;}

    Direction dir = Direction.NORTH; //Current direction of car
    double X = 0; //X-coordinate for car
    double Y = 0; //Y-coordinates for car

    final int nrDoors; // Number of doors on the car
    double enginePower; // Engine power of the car
    double currentSpeed; // The current speed of the car
    Color color; // Color of the car
    String modelName; // The car model name
    
    /**
     * The constructor initiates all field to default values and sets
     * direction to North and realtice position to coord: (0,0).
     * 
     * @param nrDoors - the number of doors of the car.
     * @throws IllegalArgumentException if the number of doors is less
     * then 1.
     */
    public Car(int nrDoors) {
        if(nrDoors < 1) throw new IllegalArgumentException();
        this.nrDoors = nrDoors;
    }
    
    /**
     * @return - the number of doors.
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * @return - the current engine power
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * @return - the current speed.
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * @return - the color.
     */
    public Color getColor(){
        return color;
    }

    /**
     * @param clr - the color to be set.
     */
    public void setColor(Color clr){
	    color = clr;
    }

    /**
     * sets current speed to 0.1.
     */
    public void startEngine(){
	    currentSpeed = 0.1;
    }

    /**
     * sets current speed to 0.
     */
    public void stopEngine(){
	    currentSpeed = 0;
    }

    /**
     * @param amount - the amount of increase to the speed of the car.
     */
    private void incrementSpeed(double amount){
        double temp = currentSpeed + amount;
        if(temp > enginePower) {
            currentSpeed = enginePower;
        } else if (temp < 0) {
            currentSpeed = 0;
        } else {
            currentSpeed = temp;
        }
    }

    /**
     * @param amount - the amount of decrease to the speed of the car.
     */
    private void decrementSpeed(double amount){
        double temp = currentSpeed - amount;
        if(temp > enginePower) {
            currentSpeed = enginePower;
        } else if (temp < 0) {
            currentSpeed = 0;
        } else {
            currentSpeed = temp;
        }
    }
    
    /**
     * @param amount - the amount of increase to the speed of the car.
     * @throws  IllegalArgumentException if amount is lesser then 0 or 
     *          greater then 1.
     */
    // TODO fix this method according to lab pm
    public void gas(double amount){
        if(amount < 0 || amount > 1) throw new IllegalArgumentException();

        incrementSpeed(amount);
    }

    /**
     * @param amount - the amount of derease to the speed of the car.
     * @throws  IllegalArgumentException if amount is lesser then 0 or 
     *          greater then 1.
     */
    // TODO fix this method according to lab pm
    public void brake(double amount){
        if(amount < 0 || amount > 1) throw new IllegalArgumentException();

        decrementSpeed(amount);
    }

    //---------- Movable implementation ----------//

    /**
     * Changes the car's position in accordence with its current direction
     * and speed.
     */
    public void move(){
        switch(dir) {
            case NORTH: Y += getCurrentSpeed(); break;
            case EAST: X += getCurrentSpeed(); break;
            case SOUTH: Y -= getCurrentSpeed(); break;
            case WEST: X -= getCurrentSpeed(); break;
        }
    }
    /**
     * Shifts the direction of the car 90 degrees to the left (counter clockwise).
     */
    public void turnLeft(){
        switch(dir) {
            case NORTH: dir = Direction.WEST; break;
            case EAST: dir = Direction.NORTH; break;
            case SOUTH: dir = Direction.EAST; break;
            case WEST: dir = Direction.SOUTH; break;
        }
    }
    /**
     * Shifts the direction of the car 90 degrees to the right (clockwise).
     */
    public void turnRight(){
        switch(dir) {
            case NORTH: dir = Direction.EAST; break;
            case EAST: dir = Direction.SOUTH; break;
            case SOUTH: dir = Direction.WEST; break;
            case WEST: dir = Direction.NORTH; break;
        }
    }

    //---------- Print methods ----------//
    /**
     * A simple print method.
     */
    public void printCoords() {
        System.out.println("(" + X + "," + Y +")"); // (X,Y)
    }
}
