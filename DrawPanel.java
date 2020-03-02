import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel implements PositionObserver {

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage, saabImage, scaniaImage;

    ArrayList<Car> cars;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    @Override
    public void updatePosition(ArrayList<Car> cars) {
        this.cars = cars;
        repaint();
    }

    private void checkWallCollision(int x, int y, Car car) {
        if(y < 0 || y > 500) {
            car.turnAround();
        } else if(x < 0 || x > 1015) {
            car.turnAround();
        }
    }

    private BufferedImage carToImage(Car car) {
        if(car instanceof Volvo240)
            return volvoImage;
        else if(car instanceof Saab95)
            return saabImage;
        else
            return scaniaImage;
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        BufferedImage tempImage;
        int x, y;

        for(Car car : cars) {
            tempImage = carToImage(car);

            x = (int) Math.round(car.getX());
            y = (int) Math.round(car.getY());

            checkWallCollision(x, y, car);

            g.drawImage(tempImage, x, y, null);
        }
    }
}
