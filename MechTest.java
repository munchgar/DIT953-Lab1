import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class MechTest <T extends Car> {
ArrayList<Volvo240> volvoGarage = new ArrayList<Volvo240>();
Volvo240 volvo1 = new Volvo240();
int load = 0;

    @Test
    public void load() {
        volvoGarage.add(volvo1);
        assertTrue(volvoGarage.contains(volvo1));

    }

    @Test
    public void unoload() {
        volvoGarage.remove(volvo1);
        assertFalse(volvoGarage.contains(volvo1));
    }
}
