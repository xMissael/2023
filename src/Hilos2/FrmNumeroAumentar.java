package Hilos2;
import javax.swing.*;
import java.awt.*;
public class FrmNumeroAumentar extends JFrame implements Runnable {
    private JTextField txtNumero;

    public FrmNumeroAumentar() {
        super("Número en aumento");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setLocationRelativeTo(null);
        txtNumero = new JTextField(20);
        add(txtNumero);

        Thread cargarDatos = new Thread(this);
        cargarDatos.start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
            txtNumero.setText("Mensaje " + i);


        }
    }

    public static void main(String[] args) {
        FrmNumeroAumentar window = new FrmNumeroAumentar();
        window.setVisible(true);
    }
}

