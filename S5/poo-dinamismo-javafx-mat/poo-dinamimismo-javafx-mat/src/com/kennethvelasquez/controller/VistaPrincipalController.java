 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kennethvelasquez.controller;

import com.kennethvelasquez.view.VistaPrincipalView;
import com.kennethvelasquez.view.RegistroView;
import com.kennethvelasquez.view.ResumenView;

public class VistaPrincipalController {
    private final VistaPrincipalView vistaPrincipalView;
    
    public VistaPrincipalController(VistaPrincipalView vistaPrincipal){
        this.vistaPrincipalView = vistaPrincipal;
        construirControladores();
        construirAcciones();
    }
    
    public void construirControladores(){
        new RegistroController( RegistroView.getInstanciaRegistroView() );
        new ResumenController( ResumenView.getInstanciaResumenView() );
    }
    
    public void construirAcciones(){
        this.vistaPrincipalView.getTabRegistro().setContent(
            RegistroView
                    .getInstanciaRegistroView()
                    .getInstanciaPanel()
        );
     
        this.vistaPrincipalView.getTabResumen().setContent(
            ResumenView
                    .getInstanciaResumenView()
                    .getInstanciaPanel()
        );
        
    }
    
}
