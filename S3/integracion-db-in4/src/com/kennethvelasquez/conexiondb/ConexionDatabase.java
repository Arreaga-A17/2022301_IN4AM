/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kennethvelasquez.conexiondb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDatabase {

    private static ConexionDatabase instanciaConexionDatabase;
    private String usuario = "IN4AM";
    private String clave = "@dmin4AM"; // usuario de compu de kinal
    private String clave2 = "in4am"; // Mi compu personal
    private String url = "jdbc:mysql://localhost:3306/gestor_usuarios_in4av";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private Connection instanciaConnection;

    //Ocultar el constructor vacio
    private ConexionDatabase() {
        try {
            Class.forName(DRIVER);
            
            //Crear la conexion a la DB
            instanciaConnection = DriverManager.getConnection(url, usuario , clave2 );
            
        } catch( ClassNotFoundException errorClassNotFound){
            System.out.println("Error de clase no encontrada");
        } catch( SQLException errorSQL){
            System.out.println("Error de SQL");
        } catch (Exception errorPadre){
            System.out.println("Error top");
        }
    }
    
    public Connection getInstanciaConnection(){
        return instanciaConnection;
    }

    public static ConexionDatabase getInstanciaConexionDatabase() {
        if (instanciaConexionDatabase == null) {
            instanciaConexionDatabase = new ConexionDatabase();
        }
        return instanciaConexionDatabase;
    }
}
