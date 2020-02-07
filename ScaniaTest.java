import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import java.awt.*;

class ScaniaTest extends Cars {

    Scania scania = new Scania();


    @Test
    void tip() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                   scania.tip(-2);
                }
        );
    }

    @Test
    void sink() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    scania.sink(2);
                }
        );

    }

    @Test
    void gas() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    scania.gas(-2);
                }
        );
    }
}