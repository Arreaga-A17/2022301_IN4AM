/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JoseArreaga.examb3.model;

public class UserSession {

    private static UserSession instance;
    private int idUsuario;
    private String username;

    private UserSession() {
    }

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public void setUsuario(int idUsuario, String username) {
        this.idUsuario = idUsuario;
        this.username = username;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void cerrarSesion() {
        idUsuario = 0;
        username = null;
    }
}
