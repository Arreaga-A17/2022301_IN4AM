/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JoseArreaga.examb3.Controller;

import com.JoseArreaga.examb3.model.Contacto;
import com.JoseArreaga.examb3.model.ContactoDAO;
import com.JoseArreaga.examb3.model.UserSession;
import com.JoseArreaga.examb3.view.DashboardView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import java.util.Optional;

public class DashboardController {

    private DashboardView view;
    private ContactoDAO dao;
    private Stage stage;
    private ObservableList<Contacto> listaContactos;
    private Contacto contactoSeleccionado;

    public DashboardController(DashboardView view, ContactoDAO dao, Stage stage) {
        this.view = view;
        this.dao = dao;
        this.stage = stage;
        inicializarEventos();
        cargarDatosTabla();
    }

    private void cargarDatosTabla() {
        int idActual = UserSession.getInstance().getIdUsuario();
        listaContactos = FXCollections.observableArrayList(dao.listar(idActual));
        view.getTablaContactos().setItems(listaContactos);
    }

    private void inicializarEventos() {

        view.getTablaContactos().getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                contactoSeleccionado = newSelection;
                view.getTxtNombre().setText(contactoSeleccionado.getNombre());
                view.getTxtTelefono().setText(contactoSeleccionado.getTelefono());
                view.getTxtCorreo().setText(contactoSeleccionado.getCorreo());
                view.getTxtDireccion().setText(contactoSeleccionado.getDireccion());

            
                view.getBtnGuardar().setDisable(true);
                view.getBtnEditar().setDisable(false);
                view.getBtnEliminar().setDisable(false);
            }
        });

        // Crear Contacto
        view.getBtnGuardar().setOnAction(e -> {
            if (validarTelefono()) {
                Contacto c = new Contacto(
                        UserSession.getInstance().getIdUsuario(),
                        view.getTxtNombre().getText(),
                        view.getTxtTelefono().getText(),
                        view.getTxtCorreo().getText(),
                        view.getTxtDireccion().getText()
                );
                if (dao.crear(c)) {
                    cargarDatosTabla(); 
                    limpiarFormulario();
                }
            }
        });

        // Editar Contacto
        view.getBtnEditar().setOnAction(e -> {
            if (contactoSeleccionado != null && validarTelefono()) {
                contactoSeleccionado.setNombre(view.getTxtNombre().getText());
                contactoSeleccionado.setTelefono(view.getTxtTelefono().getText());
                contactoSeleccionado.setCorreo(view.getTxtCorreo().getText());
                contactoSeleccionado.setDireccion(view.getTxtDireccion().getText());

                if (dao.actualizar(contactoSeleccionado)) {
                    cargarDatosTabla();
                    limpiarFormulario();
                }
            }
        });

        // Eliminar Contacto
        view.getBtnEliminar().setOnAction(e -> {
            if (contactoSeleccionado != null) {
                Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                alerta.setTitle("Confirmar Eliminación");
                alerta.setHeaderText("¿Está seguro de eliminar a " + contactoSeleccionado.getNombre() + "?");

                Optional<ButtonType> result = alerta.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    if (dao.eliminar(contactoSeleccionado.getIdContacto(), UserSession.getInstance().getIdUsuario())) {
                        cargarDatosTabla();
                        limpiarFormulario();
                    }
                }
            } else {
                mostrarAlerta(Alert.AlertType.WARNING, "Selección requerida", "Seleccione un contacto de la tabla.");
            }
        });

        view.getBtnLimpiar().setOnAction(e -> limpiarFormulario());

        view.getBtnCerrarSesion().setOnAction(e -> {
            UserSession.getInstance().cerrarSesion();
          
        });
    }

    private boolean validarTelefono() {
        if (view.getTxtTelefono().getText().trim().isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Dato Obligatorio", "No se pueden crear contactos sin número de teléfono.");
            return false;
        }
        return true;
    }

    private void limpiarFormulario() {
        view.getTxtNombre().clear();
        view.getTxtTelefono().clear();
        view.getTxtCorreo().clear();
        view.getTxtDireccion().clear();
        contactoSeleccionado = null;
        view.getTablaContactos().getSelectionModel().clearSelection();

        view.getBtnGuardar().setDisable(false);
        view.getBtnEditar().setDisable(true);
        view.getBtnEliminar().setDisable(true);
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String msj) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(msj);
        alert.showAndWait();
    }
}
