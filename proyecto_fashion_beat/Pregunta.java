/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_fashion_beat;

/**
 *
 * @author ignac
 */
public abstract class Pregunta {
    private String texto;
    private int peso;
    
    public Pregunta(String texto,int peso){
        this.peso = peso;
        this.texto = texto;
        
    }
    public String getTexto(){
        return texto;
    }
    public int getPeso(){
        return peso;
    }
    public void setPeso(int personew){
        this.peso = personew;
    }
    public abstract boolean buscar();
}
