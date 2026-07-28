/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kennethvelasquez.view;

import javafx.scene.layout.VBox;

/**
 *
 * @author STEPHRYS
 */
public class BienvenidaView extends VBox{
    private static BienvenidaView instanciaBienvenidaView;
    
    public BienvenidaView(){
        
    }

    public static BienvenidaView getInstanciaBienvenidaView() {
        //IF
        return instanciaBienvenidaView;
    }

    public static void setInstanciaBienvenidaView(BienvenidaView instanciaBienvenidaView) {
        BienvenidaView.instanciaBienvenidaView = instanciaBienvenidaView;
    }
}
