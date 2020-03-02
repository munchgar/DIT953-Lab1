import java.util.Random;

public class CarFactory {
    
    public Car createVolvo240() {
        return new Volvo240();
    }
    
    public Car createSaab95() {
        return new Saab95();
    }

    public Car createScania() {
        return new Scania();
    }

    public Car createRandomCar() {
        Random r = new Random();
        int random = r.nextInt((3 - 1) + 1) + 1;

        Car car;
        switch(random) {
            case 1: car = new Volvo240(); break;
            case 2: car = new Saab95(); break;
            case 3: car = new Scania(); break;
            default:
                    car = new BigBoy();
        }
        return car;
    }
}