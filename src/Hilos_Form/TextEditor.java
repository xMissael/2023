package Hilos_Form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextEditor extends JFrame implements Runnable {
    private static final long serialVersionUID = 1L;
    private JTextArea textArea;
    private ArrayList<String> dictionary;
    private File file;
    private boolean running;
    private Thread spellCheckThread;

    public TextEditor() {
        setTitle("Text Editor");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                running = false;
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write(textArea.getText());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setPreferredSize(new Dimension(600, 400));
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        dictionary = new ArrayList<String>();
        try (BufferedReader reader = new BufferedReader(new FileReader("dict.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                dictionary.add(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        file = new File("text.txt");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                StringBuilder builder = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                    builder.append('\n');
                }
                textArea.setText(builder.toString());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        running = true;
        spellCheckThread = new Thread(this);
        spellCheckThread.start();

        setVisible(true);
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(60000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            String[] words = textArea.getText().split("\\s+");
            for (String word : words) {
                if (!dictionary.contains(word.toLowerCase())) {
                    textArea.setBackground(Color.RED);
                    break;
                } else {
                    textArea.setBackground(Color.WHITE);
                }
            }
        }
    }

    public static void main(String[] args) {
        new TextEditor();
    }
}
