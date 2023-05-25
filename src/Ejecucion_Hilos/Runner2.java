package Ejecucion_Hilos;

class Runner2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; ++i)
            System.out.println("\t\tRunner2: " + i);
    }
}

