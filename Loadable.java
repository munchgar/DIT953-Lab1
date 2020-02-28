public interface Loadable<T> {

    void load(T item);

    T unload();
}