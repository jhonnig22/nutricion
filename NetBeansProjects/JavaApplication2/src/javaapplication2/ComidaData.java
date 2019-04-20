/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jhonny
 */
public class ComidaData {
    private Connection connection = null;

    public ComidaData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
    
     //metodo que recibe una comida con su nombre, cantidad de calorias, un detalle y lo inserta en la base de datos
    public void guardarComida(Comida comida){ 
        try {
            //en los values del string se usan ? para representar los valores reales que van a llevar
            //dinamicamente estan ordenados, el primer ? es nombre, el segundo es calorias y el tercero es detalle
            String sql = "INSERT INTO comida (nombre, calorias, detalle) VALUES ( ? , ? , ? );";

            //al ps le decimos valores van en los values ?
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, comida.getNombre());
            ps.setDouble(2, comida.getCalorias() ); 
            ps.setString(3, comida.getDetalle());
            
            ps.executeUpdate();//sentencia que cuando se ejecuta hace el insert sobre la tabla alumnos
            
            ResultSet rs = ps.getGeneratedKeys(); //obtengo las claves 

            if (rs.next()) { //seteo id
                comida.setId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar una comida");
            }
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar una comida: " + ex.getMessage());
        }
    }
    
    //metodo que recibe un id de una comida y hace un delete en la base de datos y la borra
    public void borrarComida(int id){
    try {
            
            String sql = "DELETE FROM comida WHERE idComida =?;";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
                      
            ps.executeUpdate();//hace executeUpdate porque estamos haciendo un delete
                        
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un alumno: " + ex.getMessage());
        }
        
    
    }
    
    
    
    public void actualizarComida(Comida comida){
    
        try {
            
            String sql = "UPDATE comida SET nombre = ?, calorias = ? , "
                    + "detalle =? WHERE idComida = ?;";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, comida.getNombre());
            ps.setDouble(2, comida.getCalorias() ); 
            ps.setString(3, comida.getDetalle());
            ps.setInt(4, comida.getId());
            ps.executeUpdate();//hace executeUpdate porque estamos haciendo un update
            
          
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un alumno: " + ex.getMessage());
        }
    
    }
    
    //metodo que busca una comida unica a partir de un id
    public Comida buscarComida(int id){
    Comida comida=null;
    try {
            
            String sql = "SELECT * FROM comida WHERE idComida =?;";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
           
            
            ResultSet resultSet=ps.executeQuery(); //hace executeQuery porque estamos haciendo un Select
            
            while(resultSet.next()){
                comida = new Comida();
                comida.setId(resultSet.getInt("idComida"));
                comida.setNombre(resultSet.getString("nombre"));
                comida.setCalorias(resultSet.getDouble("calorias"));
                comida.setDetalle(resultSet.getString("detalle"));
                             
            }      
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un alumno: " + ex.getMessage());
        }
        
        return comida;
    }
    
    
    //metodo que devuelve lista de comidas cuyas calorias son menores
    //al parametro indicado
    public List<Comida> obtenerComidas(Double calorias){
        List<Comida> comidas = new ArrayList<Comida>();
            

        try {
            String sql = "SELECT * FROM comida WHERE comida.calorias < ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, calorias);
            ResultSet resultSet = statement.executeQuery();
            Comida comida;
            while(resultSet.next()){
                comida = new Comida();
                comida.setId(resultSet.getInt("id"));
                comida.setNombre(resultSet.getString("nombre"));
                comida.setCalorias(resultSet.getDouble("calorias"));
                comidas.add(comida);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los alumnos: " + ex.getMessage());
        }
        
        
        return comidas;
    }
    
    
      
    }
    

