import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BigBoyTest extends BigBoy{
    BigBoy bigboy = new BigBoy();
    Volvo240 volvo = new Volvo240();

    @Test
    void load() {
        volvo.gas(0.5);
        Assertions.assertThrows(IllegalStateException.class, () -> {
                    bigboy.load(volvo);
                }
        );
    }

    @Test
    void changeXy() {

    }


    @Test
    public void move() {
        assertEquals(bigboy.x, volvo.x);
    }

    @Test
    void testUnload() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
                    unload();
                }
        );
    }
}