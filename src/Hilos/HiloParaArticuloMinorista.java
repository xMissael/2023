package Hilos;

public class HiloParaArticuloMinorista implements Runnable {
    @Override
    public void run() {
        // Crear las 3 instancias de empleado
        ArticuloMinorista articuloMinorista1 = new ArticuloMinorista("Chaqueta", 12, 59.95);
        ArticuloMinorista articuloMinorista2 = new ArticuloMinorista("Jeans de diseñador", 40, 34.95);
        ArticuloMinorista articuloMinorista3 = new ArticuloMinorista("Camisa", 20, 24.95);
        // Imprimir los datos
        System.out.println(articuloMinorista1.toString());
        System.out.println(articuloMinorista2.toString());
        System.out.println(articuloMinorista3.toString());
    }
}

