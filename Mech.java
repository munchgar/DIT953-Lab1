import java.util.ArrayList;

/***
 * The class of a garage that stores cars based on the specific car type
 * @param <T>
 */
public class Mech <T extends Car> {

    private final int maxLoad;
    private int load;
    private ArrayList<T> mechGarage;

    /***
     * Gives the garage a car limit and a list of the cars that are stored
     * @param maxLoad
     */
    public Mech(int maxLoad) {
        this.maxLoad = maxLoad;
        mechGarage = new ArrayList<T>();
    }

    /***
     * Stores a car in the garage
     * @param car of the specific type cartype
     */
    public void load(T car) {
        if(load + 1 > maxLoad) return;

        mechGarage.add(car);
        load++;
    }

    /***
     * Removes a car from the garage
     * @return returns the car that was removed
     */
    public T unoload() {
        T car = mechGarage.remove(mechGarage.size() - 1);
        load--;
        return car;
    }
}
