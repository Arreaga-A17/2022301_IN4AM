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
public class RegistroView {

    private VBox root;
    private TextField txtNombre;
    private TextField txtUsername;
    private TextField txtCorreo;
    private PasswordField txtPassword;
    private PasswordField txtConfirmPassword;
    private Button btnRegistrar;
    private Button btnVolver;
    private Button btnCerrar;

    private double xOffset = 0;
    private double yOffset = 0;

    public RegistroView() {
        root = new VBox(12);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20, 40, 30, 40));
        root.setStyle("-fx-background-color: #2b2b2b; -fx-border-color: #444; -fx-border-width: 2px;");

        HBox topBar = new HBox();
        topBar.setAlignment(Pos.CENTER_RIGHT);
        btnCerrar = new Button("X");
        btnCerrar.setStyle("-fx-background-color: transparent; -fx-text-fill: black; -fx-font-weight: bold;");
        topBar.getChildren().add(btnCerrar);

        topBar.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        topBar.setOnMouseDragged(event -> {
            root.getScene().getWindow().setX(event.getScreenX() - xOffset);
            root.getScene().getWindow().setY(event.getScreenY() - yOffset);
        });

        Label lblTitulo = new Label("REGISTRO DE USUARIO");
        lblTitulo.setStyle("-fx-font-size:"
                + " 20px; -fx-text-fill:"
                + " black; -fx-font-weight:"
                + " bold;");

        txtNombre = new TextField();
        txtNombre.setPromptText("Nombre Completo");

        txtUsername = new TextField();
        txtUsername.setPromptText("Nombre de Usuario");

        txtCorreo = new TextField();
        txtCorreo.setPromptText("Correo Electronico");

        txtPassword = new PasswordField();
        txtPassword.setPromptText("Contraseña");

        txtConfirmPassword = new PasswordField();
        txtConfirmPassword.setPromptText("Confirmar Contraseña");

        btnRegistrar = new Button("Registrar");
        btnRegistrar.setStyle("-fx-background-color: #28a745;"
                + " -fx-text-fill: black; -fx-font-size: 14px;"
                + " -fx-pref-width: 200px;");

        btnVolver = new Button("Volver Login");
        btnVolver.setStyle("-fx-background-color: transparent;"
                + " -fx-text-fill: #aaa;"
                + " -fx-underline: true;");

        root.getChildren().addAll(topBar, lblTitulo, txtNombre, txtUsername, txtCorreo, txtPassword, txtConfirmPassword, btnRegistrar, btnVolver);
    }

    
      public VBox getRoot() {
        return root;
    }

    public TextField getTxtNombre() {
        return txtNombre;
    }

    public TextField getTxtUsername() {
        return txtUsername;
    }

    public TextField getTxtCorreo() {
        return txtCorreo;
    }

    public PasswordField getTxtPassword() {
        return txtPassword;
    }

    public PasswordField getTxtConfirmPassword() {
        return txtConfirmPassword;
    }

    public Button getBtnRegistrar() {
        return btnRegistrar;
    }

    public Button getBtnVolver() {
        return btnVolver;
    }

    public Button getBtnCerrar() {
        return btnCerrar;
    }
}
    