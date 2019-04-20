/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jhonny
 */
public class JavaApplication2 {

    
    public static void main(String[] args) {
       
        try { 
            Conexion con = new Conexion();
            
            Paciente pepe = new Paciente("pepe","eva peron", 455663, 44565);
            PacienteData pd = new PacienteData(con);
            ComidaData cd = new ComidaData(con);
            DietaData dt = new DietaData(con);
            pd.guardarPaciente(pepe);
            System.out.println(pepe.getId());
            Comida fideos = new Comida("fideos",5662.5,"porciones");
            Comida asado = new Comida("asado",5662.5,"porciones");
            Comida alfajores = new Comida("alfajores",5662.5,"porciones");
            Comida peras = new Comida("peras",5662.5,"porciones");
            cd.guardarComida(fideos);
            cd.guardarComida(asado);
            cd.guardarComida(alfajores);
            cd.guardarComida(peras);
            Dieta miDieta = new Dieta(pepe);
            miDieta.addDieta(fideos);
             miDieta.addDieta(asado);
              miDieta.addDieta(alfajores);
               miDieta.addDieta(peras);
            dt.guardarDieta(miDieta);
               
               
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JavaApplication2.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       
}
      
    }
    

