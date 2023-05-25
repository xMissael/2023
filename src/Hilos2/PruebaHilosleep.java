package Hilos2;

public class PruebaHilosleep {
    public static void main(String[] args) {
        Thread h1 = new Thread(new Runner());
        h1.start();
    }
}
