/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kennethvelasquez.view;

import javafx.scene.layout.Pane;
import javafx.scene.control.ComboBox;
import com.kennethvelasquez.model.Persona;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Priority;

/**
 *
 * @author STEPHRYS
 */
public class RegistroView {

    private static RegistroView instanciaRegistroView;
    private Pane instanciaPanel;
    private Label lblTipoPersona;
    private ComboBox<Persona> cmbTipoPersona;
    private VBox cajaVertical;
    private GridPane formulario;
    private final String RUTA_ESTILOS = "/com/kennethvelasquez/styles/";

    //ATRIBUTOS DE PERSONA
    private Label lblNombres;
    private Label lblApellidos;
    private TextField txtNombres;
    private TextField txtApellidos;
    //ATRIBUTOS DE ESTUDIANTE
    private Label lblNumeroCarne;
    private Label lblGradoEstudiante;
    private Label lblAprobado;
    private TextField txtNumeroCarne;
    private TextField txtGradoEstudiante;
    private CheckBox cbAprobado;
    //ATRIBUTOS DE MAESTRO
    private Label lblActivo;
    private Label lblCurso;
    private Label lblGradoMaestro;
    private RadioButton rbActivo;
    private TextField txtCurso;
    private TextField txtGradoMaestro;

    //BOTONES
    private Button btnGuardar;
    private Button btnLimpiar;

    private RegistroView() {
        construirVista();
    }

    public void construirVista() {
        instanciaPanel = new Pane();
        
        cajaVertical = new VBox(10);

        lblTipoPersona = new Label("Seleccione el tipo de persona a registrar");
        cmbTipoPersona = new ComboBox<>();

        formulario = new GridPane();
        formulario.setHgap(10);
        formulario.setVgap(10);

        // Persona
        lblNombres = new Label("Nombres:");
        lblApellidos = new Label("Apellidos:");
        txtNombres = new TextField();
        txtApellidos = new TextField();

        // Estudiante
        lblNumeroCarne = new Label("Número de Carné:");
        lblGradoEstudiante = new Label("Grado:");
        lblAprobado = new Label("Aprobado:");
        txtNumeroCarne = new TextField();
        txtGradoEstudiante = new TextField();
        cbAprobado = new CheckBox();

        // Maestro
        lblActivo = new Label("Activo:");
        lblCurso = new Label("Curso:");
        lblGradoMaestro = new Label("Grado:");
        rbActivo = new RadioButton();
        txtCurso = new TextField();
        txtGradoMaestro = new TextField();

        // Botones
        btnGuardar = new Button("Guardar");
        btnGuardar.getStyleClass().add("btn-guardar");
        
        btnLimpiar = new Button("Limpiar");
        btnLimpiar.getStyleClass().add("btn-limpiar");

        int fila = 0;

        // Persona
        formulario.add(lblNombres, 0, fila);
        formulario.add(txtNombres, 1, fila++);

        formulario.add(lblApellidos, 0, fila);
        formulario.add(txtApellidos, 1, fila++);

        // Estudiante
        formulario.add(lblNumeroCarne, 0, fila);
        formulario.add(txtNumeroCarne, 1, fila++);

        formulario.add(lblGradoEstudiante, 0, fila);
        formulario.add(txtGradoEstudiante, 1, fila++);

        formulario.add(lblAprobado, 0, fila);
        formulario.add(cbAprobado, 1, fila++);

        // Maestro
        formulario.add(lblCurso, 0, fila);
        formulario.add(txtCurso, 1, fila++);

        formulario.add(lblGradoMaestro, 0, fila);
        formulario.add(txtGradoMaestro, 1, fila++);
        
        formulario.add(lblActivo, 0, fila);
        formulario.add(rbActivo, 1, fila++);

        // Botones
        formulario.add(btnGuardar, 0, fila);
        formulario.add(btnLimpiar, 1, fila);

        cajaVertical.getChildren().addAll(lblTipoPersona, cmbTipoPersona, formulario);
        instanciaPanel.getChildren().add(cajaVertical);

        instanciaPanel.getStylesheets().add(RUTA_ESTILOS + "RegistroStyles.css");
        instanciaPanel.getStyleClass().add("panel-registro"); //agrego el nombre panel-principal al contenedor panel
    }

    public ComboBox<Persona> getCmbTipoPersona() {
        return cmbTipoPersona;
    }

    public void setCmbTipoPersona(ComboBox<Persona> cmbTipoPersona) {
        this.cmbTipoPersona = cmbTipoPersona;
    }

    public VBox getCajaVertical() {
        return cajaVertical;
    }

    public void setCajaVertical(VBox cajaVertical) {
        this.cajaVertical = cajaVertical;
    }

    public static RegistroView getInstanciaRegistroView() {
        if (instanciaRegistroView == null) {
            instanciaRegistroView = new RegistroView();
        }
        return instanciaRegistroView;
    }

    public Pane getInstanciaPanel() {
        return instanciaPanel;
    }

    public Label getLblTipoPersona() {
        return lblTipoPersona;
    }

    public void setLblTipoPersona(Label lblTipoPersona) {
        this.lblTipoPersona = lblTipoPersona;
    }

    public GridPane getFormulario() {
        return formulario;
    }

    public void setFormulario(GridPane formulario) {
        this.formulario = formulario;
    }

    public Label getLblNombres() {
        return lblNombres;
    }

    public void setLblNombres(Label lblNombres) {
        this.lblNombres = lblNombres;
    }

    public Label getLblApellidos() {
        return lblApellidos;
    }

    public void setLblApellidos(Label lblApellidos) {
        this.lblApellidos = lblApellidos;
    }

    public TextField getTxtNombres() {
        return txtNombres;
    }

    public void setTxtNombres(TextField txtNombres) {
        this.txtNombres = txtNombres;
    }

    public TextField getTxtApellidos() {
        return txtApellidos;
    }

    public void setTxtApellidos(TextField txtApellidos) {
        this.txtApellidos = txtApellidos;
    }

    public Label getLblNumeroCarne() {
        return lblNumeroCarne;
    }

    public void setLblNumeroCarne(Label lblNumeroCarne) {
        this.lblNumeroCarne = lblNumeroCarne;
    }

    public Label getLblGradoEstudiante() {
        return lblGradoEstudiante;
    }

    public void setLblGradoEstudiante(Label lblGradoEstudiante) {
        this.lblGradoEstudiante = lblGradoEstudiante;
    }

    public Label getLblAprobado() {
        return lblAprobado;
    }

    public void setLblAprobado(Label lblAprobado) {
        this.lblAprobado = lblAprobado;
    }

    public TextField getTxtNumeroCarne() {
        return txtNumeroCarne;
    }

    public void setTxtNumeroCarne(TextField txtNumeroCarne) {
        this.txtNumeroCarne = txtNumeroCarne;
    }

    public TextField getTxtGradoEstudiante() {
        return txtGradoEstudiante;
    }

    public void setTxtGradoEstudiante(TextField txtGradoEstudiante) {
        this.txtGradoEstudiante = txtGradoEstudiante;
    }

    public CheckBox getCbAprobado() {
        return cbAprobado;
    }

    public void setCbAprobado(CheckBox cbAprobado) {
        this.cbAprobado = cbAprobado;
    }

    public Label getLblActivo() {
        return lblActivo;
    }

    public void setLblActivo(Label lblActivo) {
        this.lblActivo = lblActivo;
    }

    public Label getLblCurso() {
        return lblCurso;
    }

    public void setLblCurso(Label lblCurso) {
        this.lblCurso = lblCurso;
    }

    public Label getLblGradoMaestro() {
        return lblGradoMaestro;
    }

    public void setLblGradoMaestro(Label lblGradoMaestro) {
        this.lblGradoMaestro = lblGradoMaestro;
    }

    public RadioButton getRbActivo() {
        return rbActivo;
    }

    public void setRbActivo(RadioButton rbActivo) {
        this.rbActivo = rbActivo;
    }

    public TextField getTxtCurso() {
        return txtCurso;
    }

    public void setTxtCurso(TextField txtCurso) {
        this.txtCurso = txtCurso;
    }

    public TextField getTxtGradoMaestro() {
        return txtGradoMaestro;
    }

    public void setTxtGradoMaestro(TextField txtGradoMaestro) {
        this.txtGradoMaestro = txtGradoMaestro;
    }

    public Button getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(Button btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public Button getBtnLimpiar() {
        return btnLimpiar;
    }

    public void setBtnLimpiar(Button btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }
    
    
}
