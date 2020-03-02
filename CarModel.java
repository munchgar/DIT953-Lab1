import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;

public class CarModel {

    private static final int MAX_CARS = 10;

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // A list of cars, modify if needed
    public ArrayList<Car> cars;

    ArrayList<PositionObserver> observers;

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                car.move();

                // if(car instanceof Volvo240) {
                //     System.out.print("Volvo240 position: ");
                //     car.printCoords();
                // } else if(car instanceof Saab95) {
                //     System.out.print("Saab95 position: ");
                //     car.printCoords();
                // } else if(car instanceof Scania) {
                //     System.out.print("Scania position: ");
                //     car.printCoords();
                // }
            }
            notifyPositionObservers();
        }
    }

    public CarModel() {
        //timer = new Timer(delay, new TimerListener());
        cars = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public void addCar(Car car) {
        if(cars.size() < MAX_CARS) {
            car.setX(cars.size() * 100);
            cars.add(car);
        } else
            System.out.println("There isn't room for another car");
    }

    public void removeCar(Car car) {
        if(cars.size() > 0) {
            cars.remove(cars.size() - 1);
        } else
            System.out.println("There are no cars");
    }

    public void startModel() {
        timer.start();
    }

    /* -------------------- Observers -------------------- */

    public void subscribe(PositionObserver observer) {
        observers.add(observer);
    }

    public void notifyPositionObservers() {
        for(PositionObserver observer : observers) {
            observer.updatePosition(cars);
        }
    }

    /* -------------------- Handlers -------------------- */

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    // Calls the brake method for each car once
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }

    // Calls the setTurboOn method for each Saab95 once
    void setTurboOn() {
        for (Car car : cars) {
            if(car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    // Calls the setTurboOff method for each Saab95 once
    void setTurboOff() {
        for (Car car : cars) {
            if(car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    // Calls the tip method for each Scania once
    void tip() {
        for (Car car : cars) {
            if(car instanceof Scania && car.getCurrentSpeed() == 0) {
                ((Scania) car).tip(70);
                System.out.println("Tip");
            }
        }
    }

    // Calls the sink method for each Scania once
    void sink() {
        for (Car car : cars) {
            if(car instanceof Scania && car.getCurrentSpeed() == 0) {
                ((Scania) car).sink(70);
                System.out.println("Sink");
            }
        }
    }

    void startAll() {
        for (Car car : cars) {
            car.startEngine();
        }
    }

    void stopAll() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }
}