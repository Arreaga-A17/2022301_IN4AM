/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JoseArreaga.examb3.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author xjaat
 */
public class LoginView {

    private VBox root;
    private VBox card;
    private TextField txtUsername;
    private PasswordField txtPassword;
    private Button btnIngresar;
    private Button btnRegistrar;
    private Button btnCerrar;


    public LoginView() {
        root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));

        card = new VBox(16);
        card.setAlignment(Pos.CENTER);
        card.getStyleClass().add("card-container");
        card.setPrefWidth(340);

        HBox topBar = new HBox();
        topBar.getStyleClass().add("top-bar");
        btnCerrar = new Button("X");
        btnCerrar.getStyleClass().add("btn-close");
        topBar.getChildren().add(btnCerrar);

        topBar.setOnMousePressed(event -> {
           
        });
        topBar.setOnMouseDragged(event -> {
           
        });

        Label lblTitulo = new Label("Iniciar Sesión");
        lblTitulo.getStyleClass().add("title-label");

        txtUsername = new TextField();
        txtUsername.setPromptText("nombre de usu");

        txtPassword = new PasswordField();
        txtPassword.setPromptText("Contraseña");

        btnIngresar = new Button("Ingresar");
        btnIngresar.getStyleClass().add("btn-primary");
        btnIngresar.setMaxWidth(Double.MAX_VALUE);

        Label lblPregunta = new Label(" Nio tienes una cuenta?");
        lblPregunta.getStyleClass().add("lbl-secondary");

        btnRegistrar = new Button("Regístrate aquí");
        btnRegistrar.getStyleClass().add("btn-link");

        VBox registerBox = new VBox(4, lblPregunta, btnRegistrar);
        registerBox.setAlignment(Pos.CENTER);

        card.getChildren().addAll(topBar, lblTitulo, txtUsername, txtPassword, btnIngresar, registerBox);
        root.getChildren().add(card);
    }

    public VBox getRoot() {
        return root;
    }

    public TextField getTxtUsername() {
        return txtUsername;
    }

    public PasswordField getTxtPassword() {
        return txtPassword;
    }

    public Button getBtnIngresar() {
        return btnIngresar;
    }

    public Button getBtnRegistrar() {
        return btnRegistrar;
    }

    public Button getBtnCerrar() {
        return btnCerrar;
    }
}
