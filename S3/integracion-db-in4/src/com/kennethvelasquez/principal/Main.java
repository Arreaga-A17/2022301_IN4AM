package com.kennethvelasquez.principal;

import com.kennethvelasquez.controller.UsuarioController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import com.kennethvelasquez.controller.SceneManagerController;

public class Main extends Application {

        public static void main(String[] args) {
            launch( args );
        }

        @Override
        public void start ( Stage escenarioRoot ){
            SceneManagerController.getInstanciaSceneManagerController().setSceneManagerController(  escenarioRoot );
            SceneManagerController.getInstanciaSceneManagerController().vistaCalculadora();
        }
}
