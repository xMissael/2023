package UsoHILOS2;

import java.util.Scanner;

    public class Cuestionario {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            String[] mensajes = {
                    "Hi, there!",
                    "Hi, Meg!",
                    "What are you doing?",
                    "I'm sitting on my bed with my laptop. I'm doing my homework",
                    "What are you working on?",
                    "I'm writing an essay for Spanish class :) Where are you?",
                    "I'm in a café with my friend Carmen. I'm having coffee, and she's talking on the phone outside. How is your family?",
                    "They're all fine! My father's watching a baseball game with his friends. My mother is out shopping.",
                    "Where's your brother?",
                    "John's playing soccer in the park. Oh, wait. My phone is ringing. My mother's calling me. I have to go! Bye!"
            };

            String respuestaPregunta1;
            String respuestaPregunta2;
            String respuestaPregunta3;
            String respuestaPregunta4;
            String respuestaPregunta5;
            String respuestaPregunta6;

            escribirMensajeConEspera("Megm: " + mensajes[0], 2000);
            escribirMensajeConEspera("Kathyo: " + mensajes[1], 2000);
            escribirMensajeConEspera("Megm: " + mensajes[2], 2000);
            escribirMensajeConEspera("Kathyo: " + mensajes[3], 2000);
            escribirMensajeConEspera("Megm: " + mensajes[4], 2000);
            escribirMensajeConEspera("Kathyo: " + mensajes[5], 2000);
            escribirMensajeConEspera("Megm: " + mensajes[6], 2000);
            escribirMensajeConEspera("Kathyo: " + mensajes[7], 2000);
            escribirMensajeConEspera("Megm: " + mensajes[8], 2000);
            escribirMensajeConEspera("Kathyo: " + mensajes[9], 2000);

            respuestaPregunta1 = hacerPreguntaConRetardo("Who is writing an essay?\n1. Megm\n2. Kathyo", "1", scanner);
            respuestaPregunta2 = hacerPreguntaConRetardo("Who is having coffee?\n1. Megm\n2. Kathyo", "2", scanner);
            respuestaPregunta3 = hacerPreguntaConRetardo("Who is talking on the phone?\n1. Megm\n2. Kathyo", "2", scanner);
            respuestaPregunta4 = hacerPreguntaConRetardo("Who is watching a baseball game?\n1. Megm\n2. Kathyo", "1", scanner);
            respuestaPregunta5 = hacerPreguntaConRetardo("Who is shopping?\n1. Megm\n2. Kathyo", "2", scanner);
            respuestaPregunta6 = hacerPreguntaConRetardo("Who is playing soccer?\n1. Megm\n2. Kathyo", "1", scanner);

            System.out.println("=== Retroalimentación ===");
            retroalimentarRespuesta("Who is writing an essay?", respuestaPregunta1, "Megm");
            retroalimentarRespuesta("Who is having coffee?", respuestaPregunta2, "Kathyo");
            retroalimentarRespuesta("Who is talking on the phone?", respuestaPregunta3, "Kathyo");
            retroalimentarRespuesta("Who is watching a baseball game?", respuestaPregunta4, "Megm");
            retroalimentarRespuesta("Who is shopping?", respuestaPregunta5, "Kathyo");
            retroalimentarRespuesta("Who is playing soccer?", respuestaPregunta6, "Megm");

            scanner.close();
        }

        public static String hacerPreguntaConRetardo(String pregunta, String respuestaCorrecta, Scanner scanner) {
            try {
                System.out.println(pregunta);
                Thread.sleep(2000);
                String respuesta = scanner.nextLine();

                System.out.println();

                return respuesta;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static void escribirMensajeConEspera(String mensaje, int tiempoEspera) {
            try {
                System.out.println(mensaje);
                Thread.sleep(tiempoEspera);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public static void retroalimentarRespuesta(String pregunta, String respuesta, String respuestaCorrecta) {
            System.out.println(pregunta);
            System.out.println("Tu respuesta: " + respuesta);
            System.out.println("Respuesta correcta: " + respuestaCorrecta);

            if (respuesta.equals(respuestaCorrecta)) {
                System.out.println("¡Respuesta correcta!");
            } else {
                System.out.println("Respuesta incorrecta.");
            }

            System.out.println();
        }
    }

