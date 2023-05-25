package Dolar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MostrarDolar {

    public static void main(String[] args) {
        // Crear una instancia de JFrame
        JFrame frame = new JFrame("Billete de un dólar");

        // Crear una instancia de ImageIcon con la ruta de la imagen
        ImageIcon iconoDolar = new ImageIcon("r.jpg");

        // Crear una instancia de JLabel y establecer el icono
        JLabel etiquetaDolar = new JLabel(iconoDolar);

        // Agregar la etiqueta al JFrame
        frame.add(etiquetaDolar);

        // Configurar el tamaño del JFrame
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
