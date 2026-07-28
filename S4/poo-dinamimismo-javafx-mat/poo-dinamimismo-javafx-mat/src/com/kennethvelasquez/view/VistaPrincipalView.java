/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kennethvelasquez.view;

import javafx.scene.layout.Pane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author STEPHRYS
 */
public class VistaPrincipalView {
    private static VistaPrincipalView instanciaVistaPrincipalView;
    private Pane instanciaPanel;
    private TabPane seccionTabs;
    private Tab tabRegistro;
    private Tab tabResumen;
    private VBox cajaVertical;
    private final String RUTA_ESTILOS = "/com/kennethvelasquez/styles/";
    
    public VistaPrincipalView(){
        construirVista();
    }
    public void construirVista(){
        /*El problema con que no se ve el formulario es por el tamaño, con css voy arreglar lo visual
            usare un archivo css para todo el contenido del panel
        */
        instanciaPanel = new Pane();
        //Como ya cree el objeto puedo agregar el css global del panel
        instanciaPanel.getStylesheets().add(RUTA_ESTILOS + "VistaPrincipalStyle.css");
        instanciaPanel.getStyleClass().add("panel-principal"); //agrego el nombre panel-principal al contenedor panel
        
        cajaVertical = new VBox(15);
        cajaVertical.getStyleClass().add("caja-vertical");
        //Contenedor de pestañas
        seccionTabs = new TabPane();
        seccionTabs.getStyleClass().add("seccion-tabs");
        seccionTabs.setPrefWidth(680);
        //Pestañas
        tabRegistro = new Tab("Registro");
        tabRegistro.setClosable(false);
        
        tabResumen = new Tab("Resumen");
        tabResumen.setClosable(false);
        
        seccionTabs.getTabs().addAll( tabRegistro, tabResumen );
        cajaVertical.getChildren().add(seccionTabs);
        instanciaPanel.getChildren().add(cajaVertical);
        
    }

    public TabPane getSeccionTabs() {
        return seccionTabs;
    }

    public void setSeccionTabs(TabPane seccionTabs) {
        this.seccionTabs = seccionTabs;
    }

    public Tab getTabRegistro() {
        return tabRegistro;
    }

    public void setTabRegistro(Tab tabRegistro) {
        this.tabRegistro = tabRegistro;
    }

    public Tab getTabResumen() {
        return tabResumen;
    }

    public void setTabResumen(Tab tabResumen) {
        this.tabResumen = tabResumen;
    }

    public VBox getCajaVertical() {
        return cajaVertical;
    }

    public void setCajaVertical(VBox cajaVertical) {
        this.cajaVertical = cajaVertical;
    }

    public static VistaPrincipalView getInstanciaVistaPrincipalView() {
        if( instanciaVistaPrincipalView == null )
            instanciaVistaPrincipalView = new VistaPrincipalView();
        return instanciaVistaPrincipalView;
    }

    public Pane getInstanciaPanel() {
        return instanciaPanel;
    }
    
}
