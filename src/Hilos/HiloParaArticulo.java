package Hilos;

public class HiloParaArticulo {
    public static void main(String[] args) {
        System.out.println("Lista de Articulo Minorista");
        Thread empleados = new Thread(new HiloParaArticuloMinorista());
        empleados.start();
    }
}
