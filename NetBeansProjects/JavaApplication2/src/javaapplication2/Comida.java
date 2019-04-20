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
public class Comida {
    //clase alumno con los atributos que representan los campos de la tabla comida
    private int id=-1;
    private String nombre;
    private double calorias;
    private String detalle;

    //Constructor con todos los atributos
    public Comida(int id, String nombre, double calorias, String detalle) {
        this.id= id;
        this.nombre = nombre;
        this.calorias = calorias;
        this.detalle = detalle;
    }

    
    //Constructor con todos los atributos menos el id
    public Comida(String nombre, double calorias, String detalle) {
        this.nombre = nombre;
        this.calorias = calorias;
        this.detalle = detalle;
    }

    //Constructor vacio
    public Comida() {}

    
    //inicio de getters y setters para los atributos
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCalorias() {
        return calorias;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
       
}