
package com.kennethvelasquez.system;

import javafx.application.Application;
import javafx.stage.Stage;
import com.kennethvelasquez.controller.SceneManager;

public class ClasePrincipal extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
    
    @Override
    public void start(Stage escenarioRaiz){
        SceneManager.getInstanciaSceneManager().setEscenarioPrincipal(escenarioRaiz);
        SceneManager.getInstanciaSceneManager().ventanaLogin();
    }
}
