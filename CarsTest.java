import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.awt.*;

import static org.junit.Assert.*;

public class CarsTest {
    Cars saab = new Saab95();
    Cars volvo = new Volvo240();

    @Test
    public void getCurrentSpeed() {
        assertTrue(volvo.getCurrentSpeed() == 0);

    }

    @Test
    public void getColor() {
        assertEquals(Color.red, saab.getColor());
    }

    @Test
    public void setColor() {
        assertEquals(Color.black, volvo.getColor());
    }

    /***
     * Will return false because it is not initiated.
     */
    @Test
    public void startEngine() {
        assertTrue(saab.getCurrentSpeed() == 0.1);
    }

    @Test
    public void getNrDoors() {
        assertTrue(volvo.getNrDoors() == 4);
    }

    @Test
    public void getEnginePower() {
        assertTrue(saab.getEnginePower() == 125);
    }

    @Test
    public void stopEngine() {
        assertTrue(saab.getCurrentSpeed() == 0);
    }

    @Test
    public void move() {
        volvo.move();
        saab.move();
        assertTrue(volvo.getCurrentSpeed() == 0);
        assertTrue(saab.getCurrentSpeed() == 0);
    }


    @Test
    public void turnLeft() {
        volvo.turnLeft();
        assertTrue(volvo.getDir() == Cars.Direction.WEST);
    }

    @Test
    public void turnRight() {
        volvo.turnRight();
        assertTrue(volvo.getDir() == Cars.Direction.EAST);
    }

    @Test
    public void gas() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    volvo.gas(2);
                }
        );

    }

    @Test
    public void brake() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    saab.gas(-2);
                }
        );
    }

    @Test
    public void getDir()  {
        assertTrue(volvo.getDir() == Cars.Direction.NORTH);
    }

}

