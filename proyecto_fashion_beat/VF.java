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
public class VF extends Pregunta {
    private boolean v_respuesta;
    
    public VF(String texto, boolean v_respuesta, int peso){
        super(texto,peso);
        this.v_respuesta = v_respuesta; 
    }
    
    @Override
    public boolean buscar(){
        Scanner teclado = new Scanner(System.in);
        String respuestaEstudiante;
        boolean entrada = false;
        int intentos = 0;
        
        do{
            System.out.print(getTexto() + "Ingrese si es V o F : ");
            respuestaEstudiante = teclado.nextLine().trim().toUpperCase();
            
            if(respuestaEstudiante.equals("V") || respuestaEstudiante.equals("F")){
                entrada = true;
            }
            else{
                System.out.println("xxxxxxxxxx| Letra equivocada |xxxxxxxxxx");
                
            }
        }
        while(!entrada);
            boolean boleanoFinal = respuestaEstudiante.equals("V");
            
            if(boleanoFinal == v_respuesta){
                System.out.println("Respuesta correcta :D ");
                return true;
            } else {
                System.out.println("Respuesta incorrecta X");
                return false;
                
            }
            
        }

}
