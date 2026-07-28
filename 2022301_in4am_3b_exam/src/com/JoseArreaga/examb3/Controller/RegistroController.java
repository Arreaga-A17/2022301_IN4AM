/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JoseArreaga.examb3.Controller;

import com.JoseArreaga.examb3.Model.Usuario;
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
public class RegistroController {
    private RegistroView view;
    private UsuarioDAO dao;
    private Stage stage;

    public RegistroController(RegistroView view, UsuarioDAO dao, Stage stage) {
        this.view = view;
        this.dao = dao;
        this.stage = stage;
        inicializarEventos();
    }
    private void inicializarEventos() {
        view.getBtnCerrar().setOnAction(e -> Platform.exit());
        view.getBtnVolver().setOnAction(e -> volverAlLogin());
        view.getBtnRegistrar().setOnAction(e -> {
            String nombre = view.getTxtNombre().getText().trim();
            String user = view.getTxtUsername().getText().trim();
            String correo = view.getTxtCorreo().getText().trim();
            String pass = view.getTxtPassword().getText();
            String confirmPass = view.getTxtConfirmPassword().getText();
            
            if (nombre.isEmpty() || user.isEmpty() || correo.isEmpty() || pass.isEmpty() || confirmPass.isEmpty()) {
                mostrarAlerta(Alert.AlertType.WARNING, "Error de Validación",
                                                      "Todos los campos son obligatorios.");
                return;
            }
            if (!pass.equals(confirmPass)) {
                mostrarAlerta(Alert.AlertType.ERROR, "Error de Validación",
                                                    "Las contraseñas no coinciden.");
                return;
            }
            Usuario nuevoUsuario = new Usuario(nombre, user, correo, pass);
            boolean exito = dao.registrarUsuario(nuevoUsuario);
            
               if (exito) {
                mostrarAlerta(Alert.AlertType.INFORMATION, "Registro Exitoso",
                                                            "El usuario ha sido registrado correctamente.");
                volverAlLogin();
            } else {
                mostrarAlerta(Alert.AlertType.ERROR, "Error en Base De Datos",
                                                     "No se pudo registrar, Es posible que el Usuario o Correo ya existan.");
            }
        });
    }

    private void volverAlLogin(){
        LoginView loginView = new LoginView();
        LoginController loginCtrl = new LoginController(loginView, dao, stage);
        Scene scene = new Scene(loginView.getRoot(), 350, 450);
        stage.setScene(scene);
    }
    
    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje){
    Alert alerta = new Alert(tipo);
    alerta.setTitle(titulo);
    alerta.setHeaderText(null);
    alerta.setContentText(mensaje);
    alerta.showAndWait();
    
    }
}