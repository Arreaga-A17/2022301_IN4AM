/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kennethvelasquez.controller;

import com.kennethvelasquez.view.VistaPrincipalView;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;
/**
 *
 * @author STEPHRYS
 */
public class SceneManagerController {
    private static SceneManagerController instanciaSceneManagerController;
    private Stage escenarioPrincipal;
    
    public SceneManagerController(){
        
    }
    
    public SceneManagerController(Stage escenarioRaiz){
        this.escenarioPrincipal = escenarioRaiz;
    }

    public static SceneManagerController getInstanciaSceneManagerController() {
        if( instanciaSceneManagerController == null )
            instanciaSceneManagerController = new SceneManagerController();
        return instanciaSceneManagerController;
    }
    
    public void setEscenarioPrincipal(Stage escenarioPrincipal){
        this.escenarioPrincipal = escenarioPrincipal;
    }
    public Stage getEscenarioPrincipal(){
        return escenarioPrincipal;
    }
    
    public void cambiarEscena(Pane panelView, int ancho,int alto){
        try{
           Scene escenaPrincipal = new Scene(panelView, ancho, alto);
           this.escenarioPrincipal.setScene(escenaPrincipal);
           this.escenarioPrincipal.sizeToScene();
           this.escenarioPrincipal.show();
        }catch(NullPointerException objetoNulo){
          JOptionPane.showMessageDialog(null, 
              "Objeto nulo en cambiar escena");
        }
    }
    
    public void vistaPrincipal(){
        try {
            //Le doy nombre a la ventana
            this.escenarioPrincipal.setTitle("JAVAFX-POO | REGISTRO Y LISTA");
            this.escenarioPrincipal.setResizable(false);
            VistaPrincipalView vistaPrincipal = VistaPrincipalView.getInstanciaVistaPrincipalView();
            cambiarEscena(vistaPrincipal.getInstanciaPanel() , 680, 580);
            new VistaPrincipalController( vistaPrincipal );
            
        }catch(NullPointerException objetoNulo){
            JOptionPane.showMessageDialog(null, "Objeto nulo en vista principal");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error padre vista principal");
        }
    }
    
}
