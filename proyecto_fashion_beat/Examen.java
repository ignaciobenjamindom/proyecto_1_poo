/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_fashion_beat;

/**
 *
 * @author ignac
 */
public class Examen {
    private Pregunta[] listaPreguntas;
    private int contador;
    
    public Examen(){
        this.listaPreguntas = new Pregunta[10];
        this.contador = 0;
    }
    public void addPregunta(Pregunta nueva){
        if(contador < 10){
            listaPreguntas[contador] = nueva;
            contador ++;
        }else{
            System.out.println("------Examen completo------- ");
        }
        
    }
    public int darExamen(){
        double puntajeTotal = 0;
        double puntajeEstudiante = 0;
        
        for(int i = 0; i < contador; i++ ){
            puntajeTotal = puntajeTotal + listaPreguntas[i].getPeso();
            boolean verificar = listaPreguntas[i].buscar();
            
            if(verificar){
                puntajeEstudiante = puntajeEstudiante + listaPreguntas[i].getPeso();
            }
        }
        
        if(puntajeTotal == 0){
            return 0;
        }
        
        double porcentaje = (puntajeEstudiante / puntajeTotal) * 100;
        return(int) Math.round(porcentaje);   
    }
}
