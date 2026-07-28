/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JoseArreaga.examb3.view;

import com.JoseArreaga.examb3.model.Contacto;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;

public class DashboardView {

    private BorderPane root;
    private TableView<Contacto> tablaContactos;
    private TextField txtNombre, txtTelefono, txtCorreo, txtDireccion;
    private Button btnGuardar, btnEditar, btnEliminar, btnLimpiar, btnCerrarSesion;

    public DashboardView() {
        root = new BorderPane();
        root.setPadding(new Insets(20));
        root.getStyleClass().add("root");

        // PANEL ARRIBA 
        HBox topPanel = new HBox();
        topPanel.setSpacing(20);
        Label lblTitulo = new Label("Mi Agenda de Contactos");
        lblTitulo.getStyleClass().add("title-label");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        btnCerrarSesion = new Button("Cerrar Sesión");
        btnCerrarSesion.getStyleClass().add("btn-close");
        topPanel.getChildren().addAll(lblTitulo, spacer, btnCerrarSesion);
        root.setTop(topPanel);

        // TABLA DE DATOS
        tablaContactos = new TableView<>();
        tablaContactos.getStyleClass().add("card-container");

        TableColumn<Contacto, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<Contacto, String> colTel = new TableColumn<>("Teléfono");
        colTel.setCellValueFactory(new PropertyValueFactory<>("telefono"));

        TableColumn<Contacto, String> colCorreo = new TableColumn<>("Correo");
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));

        tablaContactos.getColumns().addAll(colNombre, colTel, colCorreo);
        tablaContactos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        root.setCenter(tablaContactos);
        BorderPane.setMargin(tablaContactos, new Insets(20, 20, 0, 0));

        // FORMULARIO LADO
        VBox formPanel = new VBox(15);
        formPanel.getStyleClass().add("card-container");
        formPanel.setPrefWidth(250);

        Label lblForm = new Label("Gestión de Contacto");
        lblForm.getStyleClass().add("subtitle-label");

        txtNombre = new TextField();
        txtNombre.setPromptText("Nombre");
        txtNombre.getStyleClass().add("text-field");
        txtTelefono = new TextField();
        txtTelefono.setPromptText("Teléfono *");
        txtTelefono.getStyleClass().add("text-field");
        txtCorreo = new TextField();
        txtCorreo.setPromptText("Correo");
        txtCorreo.getStyleClass().add("text-field");
        txtDireccion = new TextField();
        txtDireccion.setPromptText("Dirección");
        txtDireccion.getStyleClass().add("text-field");

        btnGuardar = new Button("Nuevo Contacto");
        btnGuardar.getStyleClass().add("btn-success");
        btnEditar = new Button("Actualizar");
        btnEditar.getStyleClass().add("btn-primary");
        btnEliminar = new Button("Eliminar");
        btnEliminar.getStyleClass().add("btn-close");
        btnLimpiar = new Button("Limpiar Formulario");
        btnLimpiar.getStyleClass().add("btn-link");

        btnEditar.setDisable(true);
        btnEliminar.setDisable(true);

        formPanel.getChildren().addAll(lblForm, txtNombre, txtTelefono, txtCorreo, txtDireccion,
                btnGuardar, btnEditar, btnEliminar, btnLimpiar);
        root.setRight(formPanel);
        BorderPane.setMargin(formPanel, new Insets(20, 0, 0, 0));
    }

    public BorderPane getRoot() {
        return root;
    }

    public TableView<Contacto> getTablaContactos() {
        return tablaContactos;
    }

    public TextField getTxtNombre() {
        return txtNombre;
    }

    public TextField getTxtTelefono() {
        return txtTelefono;
    }

    public TextField getTxtCorreo() {
        return txtCorreo;
    }

    public TextField getTxtDireccion() {
        return txtDireccion;
    }

    public Button getBtnGuardar() {
        return btnGuardar;
    }

    public Button getBtnEditar() {
        return btnEditar;
    }

    public Button getBtnEliminar() {
        return btnEliminar;
    }

    public Button getBtnLimpiar() {
        return btnLimpiar;
    }

    public Button getBtnCerrarSesion() {
        return btnCerrarSesion;
    }
}
