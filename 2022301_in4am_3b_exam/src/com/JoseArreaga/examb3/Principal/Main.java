/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JoseArreaga.examb3.Principal;

import com.JoseArreaga.examb3.Controller.LoginController;
import com.JoseArreaga.examb3.Model.UsuarioDAO;
import com.JoseArreaga.examb3.View.LoginView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author xjaat
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        UsuarioDAO dao = new UsuarioDAO();

        LoginView loginView = new LoginView();

        LoginController loginController = new LoginController(loginView, dao, primaryStage);

        Scene scene = new Scene(loginView.getRoot(), 350, 450);

        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.setTitle("kinal");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
