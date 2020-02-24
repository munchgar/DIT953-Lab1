import java.util.ArrayList;

/**
 * The class of a garage that stores cars based on the specific car type
 * @param <T>
 * 
 * @author Jonathan Héden,
 * @author Nicklas Strandevall,
 * @author Kevin Rylander
 */
public class Mech <T extends Car> implements Loadable<T> {

    private final int maxLoad;
    private ArrayList<T> mechGarage;

    /**
     * Gives the garage a car limit and a list of the cars that are stored
     * @param maxLoad
     */
    public Mech(int maxLoad) {
        this.maxLoad = maxLoad;
        mechGarage = new ArrayList<T>();
    }

    /**
     * Stores a car in the garage
     * @param car of the specific type cartype
     */
    public void load(T car) {
        if(mechGarage.size() >= maxLoad) throw new IllegalArgumentException("Garage is full");

        mechGarage.add(car);
    }

    /**
     * Removes a car from the garage
     * @return returns the car that was removed
     */
    public T unload() {
        if(mechGarage.size() <= 0) throw new IllegalArgumentException("Garage is empty");

        T car = mechGarage.remove(mechGarage.size() - 1);
        return car;
    }
}
