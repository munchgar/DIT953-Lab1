public class Test {

    public static <T> void sout(T item) {
        System.out.println(item);
    }
    
    public static void main(String[] args) {
        Scania scan = new Scania();

        scan.tip(50);
        sout(scan.getDegree());
        scan.gas(1);
        scan.move();
        scan.printCoords();
    }
}