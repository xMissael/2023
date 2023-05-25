package USOHILOS;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Imagen {

    public static void main(String[] args) {
        // Crear un JFrame
        JFrame frame = new JFrame("Mostrar Imagen");

        // Cerrar la aplicación cuando se cierre la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Cargar la imagen
        String rutaImagen = "f.jpeg";
        ImageIcon icono = new ImageIcon(rutaImagen);

        // Crear un JLabel para mostrar la imagen
        JLabel etiquetaImagen = new JLabel(icono);

        // Agregar la etiqueta a la ventana
        frame.getContentPane().add(etiquetaImagen);

        // Ajustar el tamaño de la ventana al tamaño de la imagen
        frame.pack();

        // Centrar la ventana en la pantalla
        frame.setLocationRelativeTo(null);

        // Mostrar la ventana
        frame.setVisible(true);

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Pregunta exerciseThread = new Pregunta();
        exerciseThread.startExercise("-----------------------------------------\nRead the conversation. Who is doing these things? Complete the sentences.\n");
        exerciseThread.waitForAnswer("1. Anne is Paul's ____ ", "wife");
        exerciseThread.evaluateAnswer("Wife");


        exerciseThread.waitForAnswer("2. Jason and Emily are their ____  ", "children");
        exerciseThread.evaluateAnswer("children");


        exerciseThread.waitForAnswer("3. Paul is Anne's ____  ", "husband");
        exerciseThread.evaluateAnswer("husband");


        exerciseThread.waitForAnswer("4. Jason is Anne´s ____  ", "son");
        exerciseThread.evaluateAnswer("son");


        exerciseThread.waitForAnswer("5. Emily is Paul´s ____  ", "daughter");
        exerciseThread.evaluateAnswer("daughter");


        exerciseThread.waitForAnswer("6. Jason is Emily´s ____  ", "brother");
        exerciseThread.evaluateAnswer("brother");


        exerciseThread.waitForAnswer("7. Emily is Jason´s ____ ", "sister");
        exerciseThread.evaluateAnswer("sister");


        exerciseThread.waitForAnswer("8. Paul and Anne are Jason´s ____  ", "parents");
        exerciseThread.evaluateAnswer("parents");
    }

    private static void displayMessage(String message) {
        Timer timer = new Timer(2, null);
        timer.addActionListener(new ActionListener() {
            int index = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (index < message.length()) {
                    System.out.print(message.charAt(index));
                    index++;
                } else {
                    ((Timer) e.getSource()).stop();
                    System.out.println();
                }
            }
        });

        timer.start();
    }

    private static class Pregunta {
        private void startExercise(String exercise) {
            System.out.println(exercise);
            sleep();
        }

        private void waitForAnswer(String question, String expectedAnswer) {
            Scanner scanner = new Scanner(System.in);
            System.out.print(question);

            String answer;
            do {
                answer = scanner.nextLine();
                if (!answer.equalsIgnoreCase(expectedAnswer)) {
                    System.out.println("Incorrect answer. Try again.");
                    System.out.print(question);
                }
            } while (!answer.equalsIgnoreCase(expectedAnswer));
        }

        private void evaluateAnswer(String person) {
            System.out.println("Correct! " + person + " is correct.");
            System.out.println("Great job!");
            System.out.println();
            sleep();
        }

        private void sleep() {
            try {
                Thread.sleep(2000); // Retardo de 2 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
