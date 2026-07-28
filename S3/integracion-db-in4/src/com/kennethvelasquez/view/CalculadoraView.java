/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kennethvelasquez.view;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class CalculadoraView {
    
        private final String RUTA_ESTILOS = "/com/kennethvelasquez/styles/";
        private static CalculadoraView instanciaCalculadoraView;
        private Pane instanciaPanel;
        private VBox cajaVertical;
        private GridPane cuadricula;
        private TextField txtResultado;
        private Button btnNumero0;
        private Button btnNumero1;
        private Button btnNumero2;
        private Button btnNumero3;
        private Button btnNumero4;
        private Button btnNumero5;
        private Button btnNumero6;
        private Button btnNumero7;
        private Button btnNumero8;
        private Button btnNumero9;
        private Button btnSuma;
        private Button btnResta;
        private Button btnMultiplicacion;
        private Button btnDivision;
        private Button btnPuntoDecimal;
        private Button btnResultado;
        private Button btnBorrar;
        private Button btnLimpiar;
        private TextField txtNombreUsuario;
        private Button btnBuscarNombreUsuario; // declarar atributo
        
        public CalculadoraView(){
            construirVista();
        }
        
        public void construirVista(){
            instanciaPanel = new Pane();            // Contenedor principal de la calculadora
           
            cajaVertical = new VBox(25);           //inicializo mi objeto con 25 de separacion
            
            txtNombreUsuario = new TextField();
             
            txtResultado = new TextField();
            txtResultado.setEditable(  false  );
            txtResultado.setPrefHeight(  65  ); // altura de 65px
            txtResultado.setPrefWidth(  400  );
            txtResultado.setFont(   new Font( 25 ) );
            
            cuadricula = new GridPane();           //contenedor de los botones
            cuadricula.getStyleClass().add(    "contenedor-botones"   );
            cuadricula.getStylesheets().add(   RUTA_ESTILOS +  "Contenedor-de-botones.css"   );
            
            btnNumero0 = new Button("0");
            btnNumero1 = new Button("1");
            btnNumero2 = new Button("2");
            btnNumero3 = new Button("3");
            btnNumero4 = new Button("4");
            btnNumero5 = new Button("5");
            btnNumero6= new Button("6");
            btnNumero7 = new Button("7");
            btnNumero8 = new Button("8");
            btnNumero9 = new Button("9");
            btnPuntoDecimal = new Button(".");
            btnResta = new Button("-");
            btnSuma = new Button("+");
            btnMultiplicacion = new Button ("*");
            btnDivision = new Button("/");
            btnBorrar = new Button("C");
            btnLimpiar = new Button("CA");
            btnResultado = new Button("=");
            
            btnBuscarNombreUsuario = new Button("Buscar Nombre de Usuario");
            
            //Fila 1
            cuadricula.add( btnBorrar , 0, 0);
            cuadricula.add(btnLimpiar, 1,0);
            cuadricula.add(btnPuntoDecimal, 2 , 0);
            cuadricula.add(btnSuma, 3, 0); 
            
            //Fila 2
            cuadricula.add(btnNumero7, 0, 1);
            cuadricula.add(btnNumero8, 1, 1);
            cuadricula.add(btnNumero9, 2, 1);
            cuadricula.add(btnResta, 3, 1);
            
            //Fila 3
            cuadricula.add(btnNumero4, 0, 2);
            cuadricula.add(btnNumero5, 1, 2);
            cuadricula.add(btnNumero6, 2, 2);
            cuadricula.add(btnMultiplicacion, 3, 2);
            
            //Fila 4
            cuadricula.add(btnNumero1, 0, 3);
            cuadricula.add(btnNumero2, 1, 3);
            cuadricula.add(btnNumero3, 2, 3);
            cuadricula.add(btnDivision, 3, 3 );
            
            //Fila 5
            cuadricula.add(btnNumero0, 1, 4);
            cuadricula.add(btnResultado, 3,4);
            
            // gridpane .  add(  boton , columna , fila );
            
            cajaVertical.getChildren().addAll(   txtResultado,  cuadricula, txtNombreUsuario
                                            , btnBuscarNombreUsuario);
            instanciaPanel.getChildren().add(  cajaVertical  );
            
        }
        public Pane getInstanciaPanel(){
            return this.instanciaPanel;
        }
        public static CalculadoraView getInstanciaCalculadoraView(){
                if( instanciaCalculadoraView == null )
                    instanciaCalculadoraView = new CalculadoraView();
                return instanciaCalculadoraView;
        }

    public VBox getCajaVertical() {
        return cajaVertical;
    }

    public void setCajaVertical(VBox cajaVertical) {
        this.cajaVertical = cajaVertical;
    }

    public GridPane getCuadricula() {
        return cuadricula;
    }

    public void setCuadricula(GridPane cuadricula) {
        this.cuadricula = cuadricula;
    }

    public TextField getTxtResultado() {
        return txtResultado;
    }

    public void setTxtResultado(TextField txtResultado) {
        this.txtResultado = txtResultado;
    }

    public Button getBtnNumero0() {
        return btnNumero0;
    }

    public void setBtnNumero0(Button btnNumero0) {
        this.btnNumero0 = btnNumero0;
    }

    public Button getBtnNumero1() {
        return btnNumero1;
    }

    public void setBtnNumero1(Button btnNumero1) {
        this.btnNumero1 = btnNumero1;
    }

    public Button getBtnNumero2() {
        return btnNumero2;
    }

    public void setBtnNumero2(Button btnNumero2) {
        this.btnNumero2 = btnNumero2;
    }

    public Button getBtnNumero3() {
        return btnNumero3;
    }

    public void setBtnNumero3(Button btnNumero3) {
        this.btnNumero3 = btnNumero3;
    }

    public Button getBtnNumero4() {
        return btnNumero4;
    }

    public void setBtnNumero4(Button btnNumero4) {
        this.btnNumero4 = btnNumero4;
    }

    public Button getBtnNumero5() {
        return btnNumero5;
    }

    public void setBtnNumero5(Button btnNumero5) {
        this.btnNumero5 = btnNumero5;
    }

    public Button getBtnNumero6() {
        return btnNumero6;
    }

    public void setBtnNumero6(Button btnNumero6) {
        this.btnNumero6 = btnNumero6;
    }

    public Button getBtnNumero7() {
        return btnNumero7;
    }

    public void setBtnNumero7(Button btnNumero7) {
        this.btnNumero7 = btnNumero7;
    }

    public Button getBtnNumero8() {
        return btnNumero8;
    }

    public void setBtnNumero8(Button btnNumero8) {
        this.btnNumero8 = btnNumero8;
    }

    public Button getBtnNumero9() {
        return btnNumero9;
    }

    public void setBtnNumero9(Button btnNumero9) {
        this.btnNumero9 = btnNumero9;
    }

    public Button getBtnSuma() {
        return btnSuma;
    }

    public void setBtnSuma(Button btnSuma) {
        this.btnSuma = btnSuma;
    }

    public Button getBtnResta() {
        return btnResta;
    }

    public void setBtnResta(Button btnResta) {
        this.btnResta = btnResta;
    }

    public Button getBtnMultiplicacion() {
        return btnMultiplicacion;
    }

    public void setBtnMultiplicacion(Button btnMultiplicacion) {
        this.btnMultiplicacion = btnMultiplicacion;
    }

    public Button getBtnDivision() {
        return btnDivision;
    }

    public void setBtnDivision(Button btnDivision) {
        this.btnDivision = btnDivision;
    }

    public Button getBtnPuntoDecimal() {
        return btnPuntoDecimal;
    }

    public void setBtnPuntoDecimal(Button btnPuntoDecimal) {
        this.btnPuntoDecimal = btnPuntoDecimal;
    }

    public Button getBtnResultado() {
        return btnResultado;
    }

    public void setBtnResultado(Button btnResultado) {
        this.btnResultado = btnResultado;
    }

    public Button getBtnBorrar() {
        return btnBorrar;
    }

    public void setBtnBorrar(Button btnBorrar) {
        this.btnBorrar = btnBorrar;
    }

    public Button getBtnLimpiar() {
        return btnLimpiar;
    }

    public void setBtnLimpiar(Button btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }
    
    public TextField getTxtNombreUsuario(){
        return this.txtNombreUsuario;
    }
    
    public void setTxtNombreUsuario( TextField txtNombreUsuario ){
        this.txtNombreUsuario = txtNombreUsuario;
    }
    
    public Button getBtnBuscarNombreUsuario(){
        return this.btnBuscarNombreUsuario;
    }

    public void setBtnBuscarNombreUsuario(Button btnBuscarNombreUsuario) {
        this.btnBuscarNombreUsuario = btnBuscarNombreUsuario;
    }
    
}
