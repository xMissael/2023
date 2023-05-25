package Ejecucion_Hilos;

public class ContadorAdelante implements Runnable {
    private String nombre;
    public ContadorAdelante (String nombrex) {
        this.nombre = nombrex;
    }
    @Override
    public void run() {
        for (int i= 1; i<=1000; i++) {
            System.out.print("|t"+ nombre + " " + i + "\n");
        }
        System.out.println();
    }
}
