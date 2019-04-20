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
public class PacienteData {
     private Connection connection = null;

    public PacienteData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } 
        catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
   public void guardarPaciente(Paciente paciente){
        try {
            
            String sql = "INSERT INTO paciente (nombre, domicilio, celular, dni) VALUES ( ? , ? , ? ,? );";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getDomicilio());
            ps.setInt(3, paciente.getCelular());
            ps.setInt(4, paciente.getDni());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                paciente.setId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un paciente");
            }
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un paciente: " + ex.getMessage());
        }
    }
   
    public void borrarPaciente(int id){
    try {
            
            String sql = "DELETE FROM paciente WHERE id =?;";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
                      
            ps.executeUpdate();
                        
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al borrar un paciente : " + ex.getMessage());
        }
        
    
    }
    
   public List<Paciente> obtenerPaciente(){
        List<Paciente> pacientes = new ArrayList<Paciente>();
            

        try {
            String sql = "SELECT * FROM paciente;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            Paciente paciente;
            while(resultSet.next()){
                paciente = new Paciente();
                paciente.setId(resultSet.getInt("id"));
                paciente.setNombre(resultSet.getString("nombre"));
                paciente.setDomicilio(resultSet.getString("domicilio"));
                paciente.setCelular(resultSet.getInt("celular"));
                paciente.setDni(resultSet.getInt("dni"));

                pacientes.add(paciente);
            }      
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los alumnos: " + ex.getMessage());
        }
        
        
        return pacientes;
    } 
    
}
