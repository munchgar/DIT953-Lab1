public class Test {

    public static <T> void sout(T item) {
        System.out.println(item);
    }
    
    public static void main(String[] args) {
        Saab95 brum = new Saab95();
        brum.printCoords();

        //brum.gas(1);
        brum.gas(1);
        brum.move();
        brum.printCoords();

        brum.turnRight();
        brum.move();
        brum.printCoords();
    }
}