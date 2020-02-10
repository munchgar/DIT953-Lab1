import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MechTest <T extends Cars> {
ArrayList<Volvo240> volvoGarage;
Volvo240 volvo1 = new Volvo240();
int load = 0;

    @Test
    public void load() {
        volvoGarage.add(volvo1);
        assertTrue(load == 1);

    }

    @Test
    public void unoload() {
        Volvo240 volvo1 = volvoGarage.remove(volvoGarage.size() - 1);
        assertTrue(load == 0);

    }
}
