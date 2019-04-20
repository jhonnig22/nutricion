/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author jhonny
 */

   public class Paciente {
    private int dni;
    private String nombre;
    private String domicilio;
    private int celular;
    private Dieta dieta;
    private int id;

    
    public Paciente(){
    }
    
    public Paciente(String nombre, String domicilio, int celular, int dni) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.celular = celular;
        this.dni = dni;
    }

    public Paciente(int dni, String nombre, String domicilio, int celular,Dieta dieta) {
        this.dni = dni;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.celular = celular;
        this.dieta = dieta;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public int getCelular() {
        return celular;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }
     
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   
}
 

