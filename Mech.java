import java.util.ArrayList;

public class Mech <T extends Car> {

    private final int maxLoad;
    private int load;
    private ArrayList<T> mechGarage;

    public Mech(int maxLoad) {
        this.maxLoad = maxLoad;
        mechGarage = new ArrayList<T>();
    }

    public void load(T car) {
        if(load + 1 > maxLoad) return;

        mechGarage.add(car);
        load++;
    }

    public T unoload() {
        T car = mechGarage.remove(mechGarage.size() - 1);
        load--;
        return car;
    }
}