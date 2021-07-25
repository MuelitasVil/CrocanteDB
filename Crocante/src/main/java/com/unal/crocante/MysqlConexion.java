/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unal.crocante;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Manuel Martinez
 */
public class MysqlConexion {
    
    
    // ----------------------------- Datos Para iniciar la conexion ------------------------------------------------ 
    private static Connection conexion;
 
    private static String bd = "proyecto";
    private static String user;
    private static String password;
    private static String host = "localhost";
    private static String server = "jdbc:mysql://" + host + "/" + bd + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";



        // ----------------------------- Los respectivos get y sets de los datos ------------------------------------------------ 
    
    public static void setHost(String host) {
        MysqlConexion.host = host;
    }

    public static String getHost() {
        return host;
    }

    public static void setPassword(String password) {
        MysqlConexion.password = password;
    }

    public static String getPassword() {
        return password;
    }
    

    public static void setServer(String server) {
        MysqlConexion.server = server;
    }

    public static String getServer() {
        return server;
    }
    
    

    public static void setUser(String user) {
        MysqlConexion.user = user;
    }

    public static String getUser() {
        return user;
    }
    
    
    public static void setbd(String bd) {
        
        MysqlConexion.bd = bd;
    
    }

    public static String getBd() {
        return bd;
    }
    
        public static void setBd(String bd) {
        MysqlConexion.bd = bd;
    }
    
        // ----------------------------- Funcion para iniciar la conexion ------------------------------------------------ 
        
        
    public static Connection Iniciar_conexion(){
    
        
         try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(server, user, password);

            System.out.println("ConexiÃ3n a base de datos " + server + " ... OK");
            return  conexion;
           } catch (ClassNotFoundException ex) {

            System.out.println("Error cargando el Driver MySQL JDBC ... FAIL");

        } catch (SQLException ex) {
            System.out.println("Imposible realizar conexion con " + server + " ... FAIL");
        }
        return null;
         
         
         
    }
    
    
           // ----------------------------- Funcion para cerrar la conexion ------------------------------------------------ 
    
    
     public static void cerrar_conexion(Connection conexion){
   
            try {
            conexion.close();
            System.out.println("Cerrar conexion con " + server + " ... OK");
        } catch (SQLException ex) {
            System.out.println("Imposible cerrar conexion ... FAIL");
        }
    
     }

    /*
    public static void main(String[] args) {
//conectar
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(server, user, password);

            System.out.println("ConexiÃ3n a base de datos " + server + " ... OK");
        } catch (ClassNotFoundException ex) {

            System.out.println("Error cargando el Driver MySQL JDBC ... FAIL");

        } catch (SQLException ex) {
            System.out.println("Imposible realizar conexion con " + server + " ... FAIL");
        }
//realizar consulta
        try {
// Preparamos la consulta
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery("select * from obra");

// Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt(1)
                        + "\tNombre: " + rs.getString(2)
                        + "\ttippo: " + rs.getString(3)
                        + "\tcosto: " + rs.getString("obr_costo")
                        + "\tid_expo: " + rs.getString(5)
                );
            }
        } catch (SQLException ex) {
            System.out.println("Imposible realizar consulta ... FAIL");

        }

        try {
// Preparamos la actualziacion

            PreparedStatement actualizar = conexion.prepareStatement("Update obra set obr_costo = ? where obr_tipo = ?");
            actualizar.setString(1, "1000");
            actualizar.setString(2, "pintura");

            int retorno = actualizar.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Imposible realizar consulta ... FAIL");

        }

        try {
// Preparamos la entrada de datos

            PreparedStatement subir = conexion.prepareStatement("insert into obra (obr_id, obr_nombre, obr_tipo, obr_costo, obr_exposicion) values (?, ?, ?, ?, ?)");

            subir.setInt(1, 501);
            subir.setString(2, "The dancers");
            subir.setString(1, "Pintura");
            subir.setInt(1, 200);
            subir.setInt(1, 1007);

        } catch (SQLException ex) {
            System.out.println("Imposible realizar consulta ... FAIL");

        }

        try {
            conexion.close();
            System.out.println("Cerrar conexion con " + server + " ... OK");
        } catch (SQLException ex) {
            System.out.println("Imposible cerrar conexion ... FAIL");
        }
    }
*/

 //To change body of generated methods, choose Tools | Templates.
    


}

    

