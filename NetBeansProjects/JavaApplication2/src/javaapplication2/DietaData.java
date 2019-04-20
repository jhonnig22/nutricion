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

public class DietaData {
     private Connection connection = null;
     private Conexion conexion;

    public DietaData(Conexion conexion) {
        try {
            this.conexion=conexion;
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
    
    
    public void guardarDieta(Dieta dieta){
        try {
            
            String sql = "INSERT INTO dieta (idComida, idPaciente, fechaInicio, fechaFin, pesoInicial, pesoBuscado ) VALUES ( ? , ?, 0000-00-00, 0000-00-00, 0, 0 );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            Paciente paciente = dieta.getPaciente();
;
            for(Comida d:dieta.getArrayComidas()){
                
                statement.setInt(1,d.getId());
            
            statement.setInt(2, paciente.getId());
            
            statement.executeQuery();
            
            }
       
            
            
            
            
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                dieta.setId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un alumno");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un alumno: " + ex.getMessage());
        }
    }
    
    
    
    
    
    
}

    
    
   
 