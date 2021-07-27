/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unal.crocante;

import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Manuel Martinez
 */
public class MysqlConexion {

    // ----------------------------- Datos Para iniciar la conexion ------------------------------------------------
    private static Connection conexion;

    private static final String bd = "proyecto";
    private String user;
    private String password;
    private static final String host = "localhost:3306";
    private static final String server = "jdbc:mysql://" + host + "/" + bd + "?zeroDateTimeBehavior=convertToNull&sessionVariables=LC_TIME_NAMES='es_CO'";

    public MysqlConexion() {
    }

    public MysqlConexion(String user, String password) {
        this.user = user;
        this.password = password;
    }

    // ----------------------------- Los respectivos get y sets de los datos ------------------------------------------------
    public static String getHost() {
        return host;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public static String getServer() {
        return server;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public static String getBd() {
        return bd;
    }

    // ----------------------------- Funcion para iniciar la conexion ------------------------------------------------
    public Connection iniciarConexion() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println(String.format("Info: %s %s %s", server, user, password));
            conexion = DriverManager.getConnection(server, user, password);

            System.out.println("Conexión a base de datos " + server + " ... OK");
            return conexion;
        } catch (ClassNotFoundException ex) {

            System.out.println("Error cargando el Driver MySQL JDBC ... FAIL");

        } catch (SQLException ex) {
            System.out.println("Imposible realizar conexión con " + server + " ... FAIL");
            ex.printStackTrace();
        }
        return null;

    }

    // ----------------------------- Funcion para cerrar la conexion ------------------------------------------------
    public static void cerrarConexion(Connection conexion) {

        try {
            conexion.close();
            System.out.println("Cerrar conexion con " + server + " ... OK");
        } catch (SQLException ex) {
            System.out.println("Imposible cerrar conexion ... FAIL");
        }

    }
    
    
    // ------------------------------ Funcion para contar Gastos ------------------------
    
    // ----------------------------- Funcion para cerrar la conexion ------------------------------------------------
    public static int Contar_tablas(Connection conexion, String tabla) {

        try {
        
        PreparedStatement s = conexion.prepareStatement("select count(*) from "+tabla);
        
        ResultSet resultado = s.executeQuery();
        
        resultado.next();

        String num_gastos_String = resultado.getString(1);
        
        int num_gastos = Integer.parseInt(num_gastos_String);  
        
        num_gastos = num_gastos + 20;
        
        return num_gastos;
        
 
        
                }catch (SQLException sqle) {
                System.out.println("Imposible realizar consulta ... FAIL");
                sqle.printStackTrace();
            }
        
        return 0;
        
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
