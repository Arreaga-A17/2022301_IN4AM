/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JoseArreaga.examb3.Model;

import com.JoseArreaga.examb3.Conexiondb.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author xjaat
 */
public class UsuarioDAO {


    public int obtenerIdUsuario(String username, String password) {
        String sql = "SELECT id_usuario FROM usuarios WHERE username = ? AND password = ?";
        try (java.sql.Connection con = Conexion.getConnection(); // Verifica si tu método de conexión se llama así
                 java.sql.PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            java.sql.ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id_usuario"); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1; 
    }

    public boolean registrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre_completo, username, correo, password) VALUES (?, ?, ?, ?)";

        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario.getNombreCompleto());
            ps.setString(2, usuario.getUsername());
            ps.setString(3, usuario.getCorreo());
            ps.setString(4, usuario.getPassword());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("Error al registrar: " + e.getMessage());
            return false;
        }
    }

    public boolean validarLogin(String username, String password) {
        String sql = "SELECT * FROM usuarios WHERE username = ? AND password = ?";

        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next(); 
            }

        } catch (SQLException e) {
            System.out.println("Error en login: " + e.getMessage());
            return false;
        }
    }
}
