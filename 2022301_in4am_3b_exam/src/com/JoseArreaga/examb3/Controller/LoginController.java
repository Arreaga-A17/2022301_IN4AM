/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JoseArreaga.examb3.Controller;

import com.JoseArreaga.examb3.Model.UsuarioDAO;
import com.JoseArreaga.examb3.View.LoginView;
import com.JoseArreaga.examb3.View.RegistroView;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author xjaat
 */
public class LoginController {

    private LoginView view;
    private UsuarioDAO dao;
    private Stage stage;

    public LoginController(LoginView view, UsuarioDAO dao, Stage stage) {
        this.view = view;
        this.dao = dao;
        this.stage = stage;
        inicializarEventos();
    }

    private void inicializarEventos() {
        view.getBtnCerrar().setOnAction(e -> Platform.exit());
        view.getBtnIngresar().setOnAction(e -> {
            String user = view.getTxtUsername().getText().trim();
            String pass = view.getTxtPassword().getText().trim();

            if (user.isEmpty() || pass.isEmpty()) {
                mostrarAlerta(Alert.AlertType.WARNING, "Campos Vacíos", "Por favor ingresa usuario y contraseña.");
                return;
            }

            if (dao.validarLogin(user, pass)) {
                mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "¡Bienvenido al sistema, " + user + "!");
                // Aquí iría el cambio a la ventana principal de la app si existiera
            } else {
                mostrarAlerta(Alert.AlertType.ERROR, "Error", "Credenciales incorrectas.");
            }
        });
        view.getBtnRegistrar().setOnAction(e -> {
            // Navegar a registro
            RegistroView regView = new RegistroView();
            RegistroController regController = new RegistroController(regView, dao, stage);
            Scene scene = new Scene(regView.getRoot(), 250, 450);
            stage.setScene(scene);
        });
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
