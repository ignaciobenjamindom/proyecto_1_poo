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
public class Resp_cortas_preg extends Pregunta{
    private String respuesta_correcta;
    
    public Resp_cortas_preg(String respuesta_correcta, String texto, int peso){
        super(texto,peso);
        this.respuesta_correcta = respuesta_correcta;
    }
    
    @Override 
    public boolean buscar(){
       Scanner teclado = new Scanner(System.in);
        System.out.println(getTexto() + " : ");
        String R_Estudiante = teclado.nextLine().trim();
        
        if(R_Estudiante.equalsIgnoreCase(respuesta_correcta)){
            System.out.println("Respuesta correcta :D ");
            return true;
        } else {
            System.out.println("Respuesta incorrecta ");
            return false;
        }
        
    }    
}
