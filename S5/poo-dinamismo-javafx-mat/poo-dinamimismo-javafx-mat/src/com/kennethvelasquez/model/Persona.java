/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kennethvelasquez.model;


public abstract class Persona {
    //DECLARAR ATRIBUTOS
    protected String nombres;
    protected String apellidos;
    
    //CONSTRUCTORES
    public Persona(){
        
    }
    public Persona (String nombres, String apellidos){
        this.nombres = nombres;
        this.apellidos = apellidos;
    }
    
    //Metodos
    //Getters y setters
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    //Personalizados
    public abstract String presentacionPersona();
    
    @Override
    public abstract String toString();
}
