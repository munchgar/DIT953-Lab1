import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        CarModel model = new CarModel();

        model.addCar(new Volvo240());
        model.addCar(new Saab95());
        model.addCar(new Scania());
        model.addCar(new Saab95());
        model.addCar(new Volvo240());

        CarView view = new CarView("CarSim 2.0", model);
        CarController controller = new CarController(model);

        model.startModel();

        // CarModel model1 = new CarModel();

        // model1.addCar(new Volvo240());
        // model1.addCar(new Saab95());
        // model1.addCar(new Scania());
        // model1.addCar(new Saab95());
        // model1.addCar(new Volvo240());
        // model1.addCar(new Saab95());
        // model1.addCar(new Scania());
        // model1.addCar(new Scania());

        // CarView view1 = new CarView("CarSim 2.0", model1);

        // model1.startModel();
    }
}
