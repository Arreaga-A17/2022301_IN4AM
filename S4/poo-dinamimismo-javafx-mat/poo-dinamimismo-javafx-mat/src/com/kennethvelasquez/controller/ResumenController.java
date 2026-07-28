/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kennethvelasquez.controller;

import com.kennethvelasquez.model.Persona;
import com.kennethvelasquez.view.RegistroView;
import com.kennethvelasquez.view.ResumenView;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

public class ResumenController {
    private final ResumenView resumenView;
    private ObservableList <Persona> listaObservablePersonas;
     
    public ResumenController( ResumenView resumenView  ){
        this.resumenView = resumenView;
        construirColumnas();
        cargarDatos();
        construirAcciones();
    }
    public void cargarDatos(){
        ArrayList<Persona> listaRegistroPersonas
        /* 
           La logica es que cada que se llama al metodo, el objeto se creaba nuevamente, entonces todo el controller  
           se construia nuevamente, osea todos los metodos del constructor se llamaban
        */
        // --->> linea de error logico  = new RegistroController(RegistroView.getInstanciaRegistroView())        
                  = RegistroController // Pero si coloco el metodo como estatico, no hay necesidad de instanciarlo con el constructor
                       .getListaRegistroPersonas();// importar el objeto lista de registro controller

       //Convertir la lista registro a una lista observable de objetos
       listaObservablePersonas = FXCollections.observableArrayList(listaRegistroPersonas);

       this.resumenView.getTblPersonas().setItems(listaObservablePersonas);

   }
    public void construirColumnas(){
        this.resumenView.getColNombres().setCellValueFactory(
            new PropertyValueFactory <Persona , String> ("nombres")  
        );
        this.resumenView.getColApellidos().setCellValueFactory(
            new PropertyValueFactory<Persona, String>("apellidos")
        );
    }
   
    public void construirAcciones(){
        
    }
    
}
