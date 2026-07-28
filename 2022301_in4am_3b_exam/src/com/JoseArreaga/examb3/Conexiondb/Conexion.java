/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JoseArreaga.examb3.Conexiondb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author xjaat
 */
public class Conexion {

    
    private static final String URL = "jdbc:mysql://localhost:3306/db_kinal_in4am";
    private static final String usuario = "IN4AM";
    private static final String usuario2 = "root";
    private static final String contraseña = "@dmin4AM";
    private static final String contraseña2 = "POMBO2312";

    public static Connection getConnection() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, usuario2, contraseña2);
        } catch (SQLException e) {
            System.out.println("Error al conectar a la Base de datos: " + e.getMessage());
        }
        return conexion;
    }
}

