/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.kennethvelasquez.system;

import com.kennethvelasquez.controller.SceneManagerController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Principal extends Application {

    
    public static void main(String[] args) {
        launch( args );
    }

    public void start( Stage escenarioRaiz ){
        SceneManagerController
                .getInstanciaSceneManagerController()
                .setEscenarioPrincipal(escenarioRaiz);//setear el escenario
        
        SceneManagerController
                .getInstanciaSceneManagerController()
                .vistaPrincipal(); //llamar al metodo que construye la vista
    }
}
