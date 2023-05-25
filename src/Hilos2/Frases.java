package Hilos2;

public class Frases {
    public static void main(String[] args) {
        String frasel = "Preguntarse cuándo los ordenadores podrán pensar es como " + "\n" +
                "preguntarse cuándo los submarinos podrán nadar.";
        String autorFrasel = "-- Edsger W. Dijkstra";
        String frase2 = "No importa lo estupendamente que haya ido la demo en " + " \n " +
                "los ensayos, cuando lo haces frente a t u audiencia la " + " \n" +
                "probabilidad de que sea una presentación existosa es " + "\n" +
                "inversamente proporcional al número de personas mirando, " + "\n" +
                "elevado a la cantidad de dinero que hay en juego " + "\n" +
                "-- Mark Gibbs ";
        EscrituraLenta.escribir(frasel, 20);
        EscrituraLenta.escribir(autorFrasel, 400);
        System.out.println();
        EscrituraLenta.escribir("-------------------------------------------------", 200);
        EscrituraLenta.escribir(" ", 2000);
        System.out.println();
        EscrituraLenta.escribir(frase2, 10);
    }
}
