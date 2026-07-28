/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kennethvelasquez.exceptions;

/**
 *
 * @author STEPHRYS
 */
public class ExcepcionesPersonalizadas extends Exception {
    
    //CONSTRUCTOR
    public ExcepcionesPersonalizadas (String mensajeError) {
        super( mensajeError );
    }
    public ExcepcionesPersonalizadas(){
        
    }
    
    /**
     * Metodo que valida entrada en los campos de texto que leen numeros enteros
     * @param cadenaTexto Cadena que se valida que se pueda convertir a numero
     * @throws ExcepcionesPersonalizadas Clase de Exception de entradas del formulario
     */
    public void validarNumeroEntero( String cadenaTexto ) throws ExcepcionesPersonalizadas{
        String cadenaNumeros = "0123456789";
        for( char letraIngresada : cadenaTexto . toCharArray() ){
            if( ! cadenaNumeros . contains( String.valueOf( letraIngresada )  ) )
               throw new ExcepcionesPersonalizadas("INGRESO LETRAS EN EL CARNE");
        }
    }
    
    
    public void validarLongitudTexto(String cadenaTexto, int longitudMaxima) 
            throws ExcepcionesPersonalizadas{
        if( cadenaTexto . length() > longitudMaxima )
            throw new ExcepcionesPersonalizadas("TE PASASTE DEL LIMITE DE LETRAS: total "+longitudMaxima);
    }
    
    
}
