import java.awt.*;
import java.util.ArrayList;

public class BigBoy extends Cars {

    enum RampMode {UP, DOWN}
    RampMode rmp;

    ArrayList<Cars> BigBoyLoad = new ArrayList<Cars>();

    public BigBoy() {
        rmp = RampMode.UP;
        nrDoors = 2;
        color = Color.black;
        enginePower = 35;
        modelName = "BigBoy";
        stopEngine();
    }

    public ArrayList<Cars> load(ArrayList<Cars> bigboyload, Cars car) {

        return null;
    }


}

