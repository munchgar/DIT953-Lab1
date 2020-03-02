import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        CarModel model = new CarModel();
        CarFactory factory = new CarFactory();

        model.addCar(factory.createVolvo240());
        model.addCar(factory.createSaab95());
        model.addCar(factory.createScania());

        CarController controller = new CarController(model);
        CarView view = new CarView("CarSim 2.0");
        model.subscribe(view.getDrawPanel());

        model.startModel();
    }
}
