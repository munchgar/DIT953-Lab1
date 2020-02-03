import java.awt.*;

public class Car implements Movable{

    enum Direction{NORTH, EAST, SOUTH, WEST;}

    Direction dir = Direction.NORTH; //Current direction of car
    double X = 0; //X-coordinate for car
    double Y = 0; //Y-coordinates for car

    int nrDoors; // Number of doors on the car
    double enginePower; // Engine power of the car
    double currentSpeed; // The current speed of the car
    Color color; // Color of the car
    String modelName; // The car model name    
    
    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
	    color = clr;
    }

    public void startEngine(){
	    currentSpeed = 0.1;
    }

    public void stopEngine(){
	    currentSpeed = 0;
    }

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
    
    // TODO fix this method according to lab pm
    public void gas(double amount){
        if(amount < 0 || amount > 1) throw new IllegalArgumentException();

        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        if(amount < 0 || amount > 1) throw new IllegalArgumentException();

        decrementSpeed(amount);
    }

    //---------- Movable implementation ----------//

    public void move(){
        switch(dir) {
            case NORTH: Y += getCurrentSpeed(); break;
            case EAST: X += getCurrentSpeed(); break;
            case SOUTH: Y -= getCurrentSpeed(); break;
            case WEST: X -= getCurrentSpeed(); break;
        }
    }

    public void turnLeft(){
        switch(dir) {
            case NORTH: dir = Direction.WEST; break;
            case EAST: dir = Direction.NORTH; break;
            case SOUTH: dir = Direction.EAST; break;
            case WEST: dir = Direction.SOUTH; break;
        }
    }
    
    public void turnRight(){
        switch(dir) {
            case NORTH: dir = Direction.EAST; break;
            case EAST: dir = Direction.SOUTH; break;
            case SOUTH: dir = Direction.WEST; break;
            case WEST: dir = Direction.NORTH; break;
        }
    }

    //---------- Print methods ----------//

    public void printCoords() {
        System.out.println("(" + X + "," + Y +")"); // (X,Y)
    }
}