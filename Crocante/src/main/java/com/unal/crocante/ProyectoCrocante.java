/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unal.crocante;

import com.mysql.cj.jdbc.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Manuel Martinez
 */
public class ProyectoCrocante {

    /** 
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
       new Inicio().setVisible(true);
       
      

            

            
    
     

    
        

      
            
            
            
    
            }
    }
   
    
    // ------------------------ ASI SE LLAMAN LAS FUNCIONES ------------------------- 
/*

Connection Conectar = Conexion.Iniciar_conexion();
            try {

Mysql_conexion Conexion = new Mysql_conexion();
// Preparamos la consulta para buscar el cargo de la persona y que pueda acceder a su vista correspondiente 

            String consulta = "select Mostrar_Cargo('"+nombre+"','"+apellido+"')";
            System.out.println(consulta);
            PreparedStatement s = Conectar.prepareStatement(consulta);
            ResultSet resultado = s.executeQuery();
            resultado.next();
            
            String cargo = resultado.getString(1);
            
            
            System.out.println(cargo);
       
// Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
            }catch (SQLException sqle){ 
            System.out.println(sqle);
            }
*/

