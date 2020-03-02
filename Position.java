public class Position {

    private double x = 0; // X-coordinate for car
    private double y = 0; // Y-coordinate for car

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }
    
    public void setY(double y) {
        this.y = y;
    }
}
