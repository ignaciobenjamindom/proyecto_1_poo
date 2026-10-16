/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_fashion_beat;
import java.util.Scanner;
/**
 *
 * @author ignac
 */
public class Selec_Mul_Pregunta extends Pregunta {
        private String[] alternativas;
    private int respuesta;
    
    public Selec_Mul_Pregunta(String [] alternativas, int respuesta, int peso, String texto){
        super(texto,peso);
        this.alternativas = alternativas;
        this.respuesta = respuesta;
    }
    
    @Override 
    public boolean buscar(){
        Scanner teclado = new Scanner(System.in);
        System.out.println(getTexto() + " : ");
        
        String abc[] = {"a","b","c","d","e"};
        
        for(int i = 0 ; i < alternativas.length; i++){
            System.out.println(" " + abc[i]+ ") " + alternativas[i]);
        }   
        System.out.print("Eliga una opcion: ");
        String respuestaEstudiante = teclado.nextLine().trim().toLowerCase();
        
        int numeroPrueba = -1;
        for(int i = 0; i < alternativas.length; i++){
            if(respuestaEstudiante.equals(abc[i])){
                numeroPrueba = i;
            }
        }
        if(numeroPrueba == respuesta){
            System.out.println("Respuesta correcta :D ");
            return true;
        } else{
            System.out.println("Incorrecto");
            return false;
        }   
    }
}
