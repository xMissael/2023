package Ejecucion_Hilos;

class Runner1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; ++i)
            System.out.println("Runner 1: " + i);
    }
}

