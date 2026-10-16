/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_fashion_beat;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author ignac
 */
public class Proyecto_fashion_beat {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Pregunta[] guardar = new Pregunta[12];

        guardar[0] = new VF("¿La capital de Chile es Santiago? ", true, 2);
        guardar[1] = new VF("¿2 + 2 = 5? ", false, 2);
        guardar[2] = new VF("¿la integral dx es x + c? ", true, 2);
        guardar[3] = new VF("¿? ", false, 2);

        guardar[4] = new Resp_cortas_preg("La Serena", "Cual es la capital de la IV Region", 3);
        guardar[5] = new Resp_cortas_preg("Buenos Aires", "Cual es la capital de Argentina", 3);
        guardar[6] = new Resp_cortas_preg("Lima", "Cual es la capital de Peru", 3);
        guardar[7] = new Resp_cortas_preg("Bogota", "Cual es la capital de Colombia", 3);

        String[] op1 = {"Valparaiso", "Concepcion", "Santiago", "Arica"};
        guardar[8] = new Selec_Mul_Pregunta(op1, 2, 5, "Cual es la capital de la Region Metropolitana");

        String[] op2 = {"Quito", "Caracas", "Montevideo", "Asuncion"};
        guardar[9] = new Selec_Mul_Pregunta(op2, 0, 5, "Cual es la capital de Ecuador");

        String[] op3 = {"La Paz", "Sucre", "Santa Cruz", "Cochabamba"};
        guardar[10] = new Selec_Mul_Pregunta(op3, 1, 5, "Cual es la capital constitucional de Bolivia");

        String[] op4 = {"Mendoza", "Cordoba", "Montevideo", "Rosario"};
        guardar[11] = new Selec_Mul_Pregunta(op4, 2, 5, "Cual es la capital de Uruguay");

        Examen miExamen = new Examen();
        int cantidadAgregadas = 0;
        int opcionMenu = 0;

        while (opcionMenu != 3) {
            System.out.println("\n=== SISTEMA DE EXAMENES ===");
            System.out.println("1. Modo Profesor (Elegir preguntas para el examen)");
            System.out.println("2. Modo Estudiante (Rendir examen y guardar nota)");
            System.out.println("3. Salir");
            System.out.print("Elija una opcion: ");

            if (teclado.hasNextInt()) {
                opcionMenu = teclado.nextInt();
                teclado.nextLine();
            } else {
                System.out.println("Error: Debe escribir un numero del 1 al 3, no letras.");
                teclado.nextLine();
                opcionMenu = 0;
            }

            if (opcionMenu == 1) {
                miExamen = new Examen();
                cantidadAgregadas = 0;

                System.out.println("\n--- BANCO DE PREGUNTAS DISPONIBLES ---");
                for (int i = 0; i < guardar.length; i++) {
                    System.out.println((i + 1) + ". " + guardar[i].getTexto() + " (" + guardar[i].getPeso() + " pts)");
                }

                int numElegido = -1;
                while (numElegido != 0 && cantidadAgregadas < 10) {
                    System.out.print("Preguntas en el examen (" + cantidadAgregadas + "/10). Ingrese numero de pregunta (si no, 0 para terminar): ");

                    if (teclado.hasNextInt()) {
                        numElegido = teclado.nextInt();
                        teclado.nextLine();

                        if (numElegido >= 1 && numElegido <= guardar.length) {
                            miExamen.addPregunta(guardar[numElegido - 1]);
                            cantidadAgregadas++;
                            System.out.println("-> Pregunta agregada.");
                        } else if (numElegido != 0) {
                            System.out.println("Ese numero de pregunta no existe en el banco.");
                        }
                    } else {
                        System.out.println("Error: No ingrese letras. Debe escribir el numero de la pregunta.");
                        teclado.nextLine();
                    }
                }
                System.out.println("¡Examen guardado con " + cantidadAgregadas + " preguntas!");

            } else if (opcionMenu == 2) {
                if (cantidadAgregadas == 0) {
                    System.out.println("Todavia no hay preguntas cargadas. Entre primero al Modo Profesor (Opcion 1).");
                } else {
                    System.out.println("\n--- COMIENZA EL EXAMEN ---");
                    int resultado = miExamen.darExamen();
                    System.out.println("\nExamen terminado. Su resultado es: " + resultado + "%");

                    System.out.print("Ingrese el nombre del estudiante para guardar su registro: ");
                    String nombreEstudiante = teclado.nextLine().trim();

                    try {
                        FileWriter archivo = new FileWriter("resultados.txt", true);
                        archivo.write("Estudiante: " + nombreEstudiante + " | Puntaje: " + resultado + "%\n");
                        archivo.close();
                        System.out.println("Registro guardado con exito en 'resultados.txt'.");
                    } catch (IOException e) {
                        System.out.println("No se pudo guardar el archivo de resultados.");
                    }
                }
            }
        }
        System.out.println("Programa finalizado.");
    }        
        
        
        
}
    
