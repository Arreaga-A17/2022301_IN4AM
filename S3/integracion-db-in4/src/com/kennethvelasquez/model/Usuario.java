/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kennethvelasquez.model;

/**
 *
 * @author LOREM
 */
public class Usuario {
    
    //Atributos de clase
    private String idUsuario;
    private String nombres;
    private String apellidos;
    private String nombreUsuario;
    private String clave;
    private String rol;
    
    //Constructores
    public Usuario () {} //constructor vacio
    
    //constructor con parametros
    public Usuario (String idUsuario, String nombres,
                    String apellidos, String nombreUsuario,
                    String clave, String rol){
        // this. diferencia la variable global
        // de una variable local
        this.idUsuario = idUsuario; //this. variable global =variable local
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.rol = rol;
    }
    
    // Getters y Setters
    public String getIdUsuario (){
        return this.idUsuario;
    }
    
    public void setIdUsuario( String idUsuario){
        this.idUsuario = idUsuario;
    }
    
    public String getNombres(){
        return this.nombres;
    }
    public void setNombres (String nombres){
        // valorAntiguo = valorNuevo
        this.nombres = nombres;
    }
    
    public String getApellidos (){
        return this.apellidos;
    }
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }

    public String getNombreUsuario(){
        return this.nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario){
        this.nombreUsuario = nombreUsuario;
    }
    
    public String getClave(){
        return this.clave;
    }
    public void setClave( String clave){
        this.clave = clave;
    }
    
    public String getRol(){
        return this.rol;
    }
    
    public void setRol(String rol){
        this.rol = rol;
    }
    
    @Override
    public String toString(){
        return  "ID " + this.idUsuario + " Nombres "+ this.nombres + " Apellidos " + this.apellidos
                    + " Nombre de usuario " + this.nombreUsuario + " Clave " + this.clave 
                    + " Rol " + this.rol;
    }
    
    
}


