/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kennethvelasquez.model;

/**
 *
 * @author STEPHRYS
 */
public class Estudiante extends Persona{
    private int numeroCarne;
    private String grado;
    private boolean esAprobado;

    //Constructores
    
    public Estudiante( int numeroCarne, String grado, boolean esAprobado, String nombres, String apellidos){
        super(nombres, apellidos);
        this.numeroCarne = numeroCarne;
        this.grado = grado;
        this.esAprobado = esAprobado;
    }

    public Estudiante() {
    }
    
    public int getNumeroCarne() {
        return numeroCarne;
    }

    public void setNumeroCarne(int numeroCarne) {
        this.numeroCarne = numeroCarne;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public boolean isAprobado() {
        return esAprobado;
    }

    public void setAprobado(boolean esAprobado) {
        this.esAprobado = esAprobado;
    }
    
    @Override
    public String presentacionPersona(){
        return "Mi nombre es "       + this.nombres
                +"\nMi apellido es " + this.apellidos
                +"\nMi carne es "    + this.numeroCarne
                +"\nMi grado es "    + this.grado
                +"\nMi estado de curso es " + this.esAprobado;
    }
    
    @Override
    public String toString(){
        return "Estudiante";
    }
}
