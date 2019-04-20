/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author jhonny
 */
public class Dieta {
    
   private int id;
   private ArrayList<Comida> comidas = new ArrayList<Comida>();
   private Paciente paciente;
  public Dieta() {
    
      
}
  public Dieta(Paciente paciente){
  this.paciente = paciente;
  
  }
 
public void addDieta(Comida p) {   
     this.comidas.add(p);
}
 
public ArrayList<Comida> getArrayComidas() {
  return comidas;
}

    public Paciente getPaciente() {
        return paciente;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setComidas(ArrayList<Comida> comidas) {
        this.comidas = comidas;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    
    
    
    
    
    
}
