/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kennethvelasquez.controller;

import com.kennethvelasquez.conexiondb.ConexionDatabase;
import com.kennethvelasquez.view.CalculadoraView;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javax.swing.JOptionPane;

public class CalculadoraController {
        
        private final CalculadoraView calculadoraView;
        private String signoIngresado = "";
        private double numero1 = 0;
        private double numero2 = 0;
        private double resultado = 0;
        
        public CalculadoraController (  CalculadoraView calculadoraView  ){
            this.calculadoraView = calculadoraView;
            construirAcciones();
        }
        
        public void concatenarSigno(){
                if (  this.numero1 == 0  &&  !(this.calculadoraView.getTxtResultado()
                                                                     .getText()
                                                                     .isEmpty()  )
                     ) {
                            numero1 = Double.parseDouble(    this.calculadoraView.getTxtResultado().getText()   );
                            this.calculadoraView.getTxtResultado().setText("");
                }
        }
        
        public void mostrarResultado(){  
            switch( signoIngresado ){
                case "+":
                    resultado = numero1+numero2;
                    break;
                case "-":
                    resultado = numero1 - numero2;
                    break;
                case "*":
                    resultado = numero1 * numero2;
                    break;
                case "/":
//                    if( numero2 == 0 ) en vez de validar solo 1 vez
                    while( numero2 == 0 ) 
                        numero2  = Double.parseDouble(  JOptionPane.showInputDialog("Ingrese un valor valido para el valor 2")  );
                    resultado = numero1 / numero2;
            }
            this.calculadoraView.getTxtResultado().setText( String.valueOf(  resultado )  ); 
            String nombreUsuario = this.calculadoraView.getTxtNombreUsuario().getText();
            guardarResultadoDB( nombreUsuario, resultado);
        }
        
        public void guardarResultadoDB(String nombreUsuario, double resultado){
            try{
                PreparedStatement prepararLlamada = ConexionDatabase
                                                        .getInstanciaConexionDatabase()
                                                        .getInstanciaConnection()
                                                        .prepareCall("{call sp_create_registro_resultado(?,?)}");
                prepararLlamada.setString(1, nombreUsuario);
                prepararLlamada.setDouble(2, resultado);

                prepararLlamada.execute();  
            } catch(SQLException errorSQL){
                System.out.println("Error al Guardar el Resultado");
            } catch(Exception errorPadre){
                System.out.println("Error top");
            }
        }
        
        public void accionBorrar(){
                String textoPantalla = this.calculadoraView.getTxtResultado().getText();
                if( textoPantalla.length() >0  ){
                        String nuevoTexto = textoPantalla.substring(0,  textoPantalla.length() - 1);
                        this.calculadoraView.getTxtResultado().setText(nuevoTexto);
                }
        }
        
        public void accionLimpiar(){
              this.numero1 = 0;
              this.numero2 = 0;
              this.resultado = 0;
              this.signoIngresado = "";
              this.calculadoraView.getTxtResultado().clear();
        }
        
        public void accionBuscarNombreUsuario(){
            String nombreUsuario = this.calculadoraView.getTxtNombreUsuario()
                                                        .getText();
            if( nombreUsuario.trim().isEmpty()  ){
                JOptionPane.showMessageDialog(null, "EL NOMBRE DE USUARIO NO SE HA INGRESADO");
            }else {
                UsuarioController usuarioController = new UsuarioController();// instancial objeto
                
                boolean existeNombreUsuario =  usuarioController.buscarNombreUsuario(nombreUsuario); 
                if ( !existeNombreUsuario ){
                    JOptionPane.showMessageDialog(null, "NO EXISTE EL NOMBRE DE USUARIO INGRESADO");
                }else{
                    JOptionPane.showMessageDialog(null, "SE HE ENCONTRADO EL USUARIO");
                    this.calculadoraView.getTxtNombreUsuario().setEditable(false);
                }
            }
            
        }
        
        public void construirAcciones(){
                this.calculadoraView.getBtnBuscarNombreUsuario().setOnAction( 
                    new EventHandler <ActionEvent>(){
                        @Override
                        public void handle (ActionEvent evento){
                            accionBuscarNombreUsuario();
                        }
                        
                    }
                        
                );
                
                
                
            
                    this.calculadoraView.getBtnBorrar().setOnAction(
                                new EventHandler<ActionEvent>(){
                                        @Override
                                        public void handle( ActionEvent evento ){
                                               accionBorrar();
                                        }
                                }
                       );
                    this.calculadoraView.getBtnLimpiar().setOnAction(
                                new EventHandler<ActionEvent>(){
                                        @Override
                                        public void handle( ActionEvent evento ){
                                               accionLimpiar();
                                        }
                                }
                       );
            
                       this.calculadoraView.getBtnResultado().setOnAction(
                                new EventHandler<ActionEvent>(){
                                        @Override
                                        public void handle( ActionEvent evento ){
                                                if (   !signoIngresado. equals("") )
                                                       numero2 = Double.parseDouble(  calculadoraView.getTxtResultado().getText()   );
                                                      mostrarResultado();
                                        }
                                }
                       );
                       
                       this.calculadoraView.getBtnSuma().setOnAction(
                               new EventHandler<ActionEvent>(){
                                      @Override
                                      public void handle(ActionEvent evento){
                                          concatenarSigno();
                                          signoIngresado ="+";
                                      }
                               }
                       );
                       this.calculadoraView.getBtnResta().setOnAction(
                               new EventHandler<ActionEvent>(){
                                      @Override
                                      public void handle(ActionEvent evento){
                                          concatenarSigno();
                                          signoIngresado ="-";
                                      }
                               }
                       );
                       this.calculadoraView.getBtnMultiplicacion().setOnAction(
                               new EventHandler<ActionEvent>(){
                                      @Override
                                      public void handle(ActionEvent evento){
                                          concatenarSigno();
                                          signoIngresado ="*";
                                      }
                               }
                       );
                       this.calculadoraView.getBtnDivision().setOnAction(
                               new EventHandler<ActionEvent>(){
                                      @Override
                                      public void handle(ActionEvent evento){
                                          concatenarSigno();
                                          signoIngresado ="/";
                                      }
                               }
                       );
            
                    //darle acciones a los botones
                    this.calculadoraView.getBtnNumero0().setOnAction(  
                            new EventHandler <ActionEvent >(  ){ 
                                        @Override
                                        public void handle( ActionEvent evento ) {
                                              concatenarCaracter( "0");
                                        }
                            } 
                    );
                    this.calculadoraView.getBtnNumero1().setOnAction(  
                            new EventHandler <ActionEvent> (){
                                        @Override
                                        public void handle(ActionEvent evento){
                                              concatenarCaracter("1");
                                        }
                            }
                    );
                    this.calculadoraView.getBtnNumero2().setOnAction(  
                            new EventHandler <ActionEvent> (){
                                        @Override
                                        public void handle(ActionEvent evento){
                                              concatenarCaracter("2");
                                        }
                            }
                    );
                    this.calculadoraView.getBtnNumero3().setOnAction(  
                            new EventHandler <ActionEvent> (){
                                        @Override
                                        public void handle(ActionEvent evento){
                                              concatenarCaracter("3");
                                        }
                            }
                    );
                    this.calculadoraView.getBtnNumero4().setOnAction(  
                            new EventHandler <ActionEvent> (){
                                        @Override
                                        public void handle(ActionEvent evento){
                                              concatenarCaracter("4");
                                        }
                            }
                    );
                    this.calculadoraView.getBtnNumero5().setOnAction(  
                            new EventHandler <ActionEvent> (){
                                        @Override
                                        public void handle(ActionEvent evento){
                                              concatenarCaracter("5");
                                        }
                            }
                    );
                    this.calculadoraView.getBtnNumero6().setOnAction(  
                            new EventHandler <ActionEvent> (){
                                        @Override
                                        public void handle(ActionEvent evento){
                                              concatenarCaracter("6");
                                        }
                            }
                    );
                    this.calculadoraView.getBtnNumero7().setOnAction(  
                            new EventHandler <ActionEvent> (){
                                        @Override
                                        public void handle(ActionEvent evento){
                                              concatenarCaracter("7");
                                        }
                            }
                    );
                    this.calculadoraView.getBtnNumero8().setOnAction(  
                            new EventHandler <ActionEvent> (){
                                        @Override
                                        public void handle(ActionEvent evento){
                                              concatenarCaracter("8");
                                        }
                            }
                    );
                    this.calculadoraView.getBtnNumero9().setOnAction(  
                            new EventHandler <ActionEvent> (){
                                        @Override
                                        public void handle(ActionEvent evento){
                                              concatenarCaracter("9");
                                        }
                            }
                    );
                    
                    this.calculadoraView.getBtnPuntoDecimal().setOnAction(
                                 new EventHandler <ActionEvent> (){
                                        @Override
                                        public void handle(ActionEvent evento){
                                              concatenarPuntoDecimal(".");
                                        }
                            }
                    );
                    
                    
        }
        
        public void concatenarPuntoDecimal(String puntoDecimal){
                String textoPantalla = this.calculadoraView.getTxtResultado().getText();
                if(  textoPantalla.length() == 0  )
                      this.calculadoraView.getTxtResultado().setText("0.");
                else {
                      if (  existePunto()  == false  ){
                             this.calculadoraView.getTxtResultado().setText(textoPantalla + puntoDecimal);
                      }
                }
        }
        public boolean existePunto(){
                boolean existe = false;
                String textoPantalla = this.calculadoraView.getTxtResultado().getText();
                int longitudCaracteres = textoPantalla.length();
                int cantidadPuntos = 0;
                for( int indice = 0;    indice< longitudCaracteres ;   indice ++    ){
                        if(  textoPantalla.charAt( indice ) ==  '.'  )
                                cantidadPuntos++;
                }
                if(  cantidadPuntos >= 1   )  existe=true;
                return existe;
        }
        
        
        public void concatenarCaracter( String caracter ){
              String textoPantalla = this.calculadoraView.getTxtResultado().getText(); // obtengo valor de pantalla
               String nuevoTexto = textoPantalla + caracter; // junto lo de la pantalla con un valor
               this.calculadoraView.getTxtResultado().setText(   nuevoTexto  ); //mostrando en el campo
        }
        
}
