/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kennethvelasquez.view;

import com.kennethvelasquez.controller.ImageController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
public class LoginView extends BorderPane {
    
    private static LoginView instanciaLoginView;
    private HBox barraDeVentana;
    private Button btnCerrarVentana;
    private Label lblTituloVentana;
    
    private ImageView imgLogoLogin;
    private TextField txtNombreUsuario;
    private Label lblNombreUsuario;
    private PasswordField pwdClave;
    private Label lblClave;
    private GridPane formulario;
    private Button btnIniciarSesion;
    private VBox cajaVertical;
    private final String RUTA_ESTILOS ="/com/kennethvelasquez/styles/";

    private LoginView(){
        this.getStylesheets().add(RUTA_ESTILOS + "LoginStyles.css");
        this.setPadding( new Insets(20) );
        //COLOCAR BORDES CON OBJETOS
        this.setBorder( new Border(
            new BorderStroke(Color.DARKBLUE, //Color del borde
                     BorderStrokeStyle.SOLID,  // estilo de linea
                     new CornerRadii(22), // pixeles de redondeado
                     new BorderWidths(2)) //Ancho del Borde
        ));
        //COLOCAR FONDO CON OBJETOS
        this.setBackground(new Background(
             new BackgroundFill(Paint.valueOf("#AFC06A"), // Color del fondo
                      new CornerRadii(25), // Pixeles de redondeado
                     Insets.EMPTY) //Espaciado del fondo
        ));
        
        barraDeVentana = new HBox(20);
        
        btnCerrarVentana = new Button("X");
        lblTituloVentana = new Label("JAVAFX - MAT - SIMULADOR LOGIN");
        
        barraDeVentana.getChildren().addAll(btnCerrarVentana, lblTituloVentana);
        
        this.setTop( barraDeVentana );
        
        cajaVertical = new VBox(15);
        
        formulario = new GridPane();
        
        lblNombreUsuario = new Label("Ingrese su Nombre Usuario");
        txtNombreUsuario = new TextField();
        
        lblClave = new Label("Ingrese su Contraseña");
        pwdClave = new PasswordField();
        
        formulario.add(lblNombreUsuario, 0, 0);
        formulario.add(txtNombreUsuario, 1, 0);
        
        formulario.add(lblClave, 0, 1);
        formulario.add(pwdClave, 1, 1);
        
        btnIniciarSesion = new Button("Iniciar Sesión");
        
        imgLogoLogin = new ImageView( new ImageController().getImageLogin("logo") );
        imgLogoLogin.setFitHeight(100);
        imgLogoLogin.setFitWidth(100);
        imgLogoLogin.setCache(true);
        
        cajaVertical.setAlignment(Pos.CENTER);
        
        cajaVertical.getChildren().addAll(
                imgLogoLogin,
                formulario,
                btnIniciarSesion
        );
        
        this.setCenter(cajaVertical);
        
    }

    public ImageView getImgLogoLogin() {
        return imgLogoLogin;
    }

    public void setImgLogoLogin(ImageView imgLogoLogin) {
        this.imgLogoLogin = imgLogoLogin;
    }

    public TextField getTxtNombreUsuario() {
        return txtNombreUsuario;
    }

    public void setTxtNombreUsuario(TextField txtNombreUsuario) {
        this.txtNombreUsuario = txtNombreUsuario;
    }

    public Label getLblNombreUsuario() {
        return lblNombreUsuario;
    }

    public void setLblNombreUsuario(Label lblNombreUsuario) {
        this.lblNombreUsuario = lblNombreUsuario;
    }

    public PasswordField getPwdClave() {
        return pwdClave;
    }

    public void setPwdClave(PasswordField pwdClave) {
        this.pwdClave = pwdClave;
    }

    public Label getLblClave() {
        return lblClave;
    }

    public void setLblClave(Label lblClave) {
        this.lblClave = lblClave;
    }

    public GridPane getFormulario() {
        return formulario;
    }

    public void setFormulario(GridPane formulario) {
        this.formulario = formulario;
    }

    public Button getBtnIniciarSesion() {
        return btnIniciarSesion;
    }

    public void setBtnIniciarSesion(Button btnIniciarSesion) {
        this.btnIniciarSesion = btnIniciarSesion;
    }

    public VBox getCajaVertical() {
        return cajaVertical;
    }

    public void setCajaVertical(VBox cajaVertical) {
        this.cajaVertical = cajaVertical;
    }
    
    
    
    public static LoginView getInstanciaLoginView() {
        if( instanciaLoginView == null )
            instanciaLoginView = new LoginView();
        return instanciaLoginView;
    }

    public static void setInstanciaLoginView(LoginView instanciaLoginView) {
        LoginView.instanciaLoginView = instanciaLoginView;
    }

    public HBox getBarraDeVentana() {
        return barraDeVentana;
    }

    public void setBarraDeVentana(HBox barraDeVentana) {
        this.barraDeVentana = barraDeVentana;
    }

    public Button getBtnCerrarVentana() {
        return btnCerrarVentana;
    }

    public void setBtnCerrarVentana(Button btnCerrarVentana) {
        this.btnCerrarVentana = btnCerrarVentana;
    }

    public Label getLblTituloVentana() {
        return lblTituloVentana;
    }

    public void setLblTituloVentana(Label lblTituloVentana) {
        this.lblTituloVentana = lblTituloVentana;
    }
    
}
