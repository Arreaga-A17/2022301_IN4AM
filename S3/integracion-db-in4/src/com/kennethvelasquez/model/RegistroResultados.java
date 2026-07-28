/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kennethvelasquez.model;

/**
 *
 * @author LOREM
 */
public class RegistroResultados {

    private int idRegistroResultado;
    private double resultado;
    private String usuario;

    //Bloque de constructores
    // public/private    NombreClase   ( parametros ) {    }
    //Constructor Vacio
    public RegistroResultados() {
        
    }

    public RegistroResultados(int idRegistroResultado, double resultado, String usuario) {
        this.idRegistroResultado = idRegistroResultado;
        this.resultado = resultado;
        this.usuario = usuario;
    }

    public int getIdRegistroResultado() {
        return idRegistroResultado;
    }

    public void setIdRegistroResultado(int idRegistroResultado) {
        this.idRegistroResultado = idRegistroResultado;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
    

}
