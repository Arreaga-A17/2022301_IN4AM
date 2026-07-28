/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JoseArreaga.examb3.Controller;



import com.JoseArreaga.examb3.Controller.DashboardController;
import com.JoseArreaga.examb3.Model.UsuarioDAO;
import com.JoseArreaga.examb3.View.LoginView;
import com.JoseArreaga.examb3.View.RegistroView;
import com.JoseArreaga.examb3.model.ContactoDAO;
import com.JoseArreaga.examb3.model.UserSession;
import com.JoseArreaga.examb3.view.DashboardView;
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

              
                int idUsuarioLogueado = dao.obtenerIdUsuario(user, pass);

              
                if (idUsuarioLogueado != -1) {
                    mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "¡Bienvenido al sistema, " + user + "!");

             
                    UserSession.getInstance().setUsuario(idUsuarioLogueado, user);

                    DashboardView dashView = new DashboardView();
                    ContactoDAO contactoDAO = new ContactoDAO();
                    DashboardController dashCtrl = new DashboardController(dashView, contactoDAO, stage);

                  
                    Scene scene = new Scene(dashView.getRoot(), 800, 500);  
                    scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

                    stage.setScene(scene);
                    stage.centerOnScreen();
                }

            } else {
                mostrarAlerta(Alert.AlertType.ERROR, "Error", "Credenciales incorrectas.");
            }
        });
        view.getBtnRegistrar().setOnAction(e -> {

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
