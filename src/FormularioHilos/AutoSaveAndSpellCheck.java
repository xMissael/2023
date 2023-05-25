package FormularioHilos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AutoSaveAndSpellCheck extends Thread {

    private final JTextArea textArea;
    private final String filename;
    private final List<String> dictionary;
    private boolean spellCheckEnabled;

    public AutoSaveAndSpellCheck(JTextArea textArea, String filename, List<String> dictionary) {
        this.textArea = textArea;
        this.filename = filename;
        this.dictionary = dictionary;
        this.spellCheckEnabled = true;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
                saveToFile();
                if (spellCheckEnabled) {
                    spellCheck();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveToFile() {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(textArea.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void spellCheck() {
        String text = textArea.getText();
        String[] words = text.split("\\s+");
        for (String word : words) {
            if (!dictionary.contains(word)) {
                textArea.setBackground(Color.RED);
                return;
            }
        }
        textArea.setBackground(Color.WHITE);
    }

    public void enableSpellCheck(boolean enable) {
        spellCheckEnabled = enable;
    }

    public static void main(String[] args) {
        List<String> dictionary = loadDictionary("dict.txt");
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));
        JFrame frame = new JFrame("AutoSave and SpellCheck");
        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new AutoSaveAndSpellCheck(textArea, "autosave.txt", dictionary).saveToFile();
                System.exit(0);
            }
        });
        String savedText = loadSavedText("autosave.txt");
        textArea.setText(savedText);
        AutoSaveAndSpellCheck autoSaveAndSpellCheck = new AutoSaveAndSpellCheck(textArea, "autosave.txt", dictionary);
        autoSaveAndSpellCheck.start();
    }

    private static List<String> loadDictionary(String filename) {
        List<String> dictionary = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                dictionary.addAll(Arrays.asList(words));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dictionary;
    }

    private static String loadSavedText(String filename) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
        } catch (IOException e) {
        }
        return filename;
    }
}

