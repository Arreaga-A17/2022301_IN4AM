/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kennethvelasquez.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.kennethvelasquez.conexiondb.ConexionDatabase;
import java.sql.SQLException;
import com.kennethvelasquez.model.Usuario;
import java.util.ArrayList;

public class UsuarioController {

        private ArrayList <Usuario> listaUsuarios = new ArrayList<Usuario>();

        public boolean buscarNombreUsuario(String nombreUsuario){
            boolean existe = false; // bandera booleana
            
            for(Usuario obtenerUsuario: listaUsuarios  ){
                
                if ( obtenerUsuario.getNombreUsuario().equals(nombreUsuario)  )
                    existe = true;
                
            }
            
            
            return existe;
        }

        public void menuPrincipal(){
            readUsuarios();
            getUsuarios();
        }

        public void getUsuarios(){
            System.out.println( listaUsuarios );
            //Listar usuarios de 3 maneras diferentes
            //For normal con indice
            for( int indice = 0; indice< listaUsuarios.size(); indice ++ ){
                Usuario   usuarioElegido = listaUsuarios.get(indice);
                System.out.println("ID usuario " + usuarioElegido.getIdUsuario()   );
                System.out.println("Nombres " + usuarioElegido.getNombreUsuario() );
                System.out.println("Apellidos " + usuarioElegido.getApellidos() );
                System.out.println("Nombre de usuario " + usuarioElegido.getNombreUsuario());
                System.out.println("Clave " +  usuarioElegido.getClave() );
                System.out.println("Rol  "+ usuarioElegido.getRol()  );
            }
            System.out.println("--------------------------------------------------- ");
            //For each
            for( Usuario  usuarioElegido  :   listaUsuarios  ){
                System.out.println("ID usuario " + usuarioElegido.getIdUsuario()   );
                System.out.println("Nombres " + usuarioElegido.getNombreUsuario() );
                System.out.println("Apellidos " + usuarioElegido.getApellidos() );
                System.out.println("Nombre de usuario " + usuarioElegido.getNombreUsuario());
                System.out.println("Clave " +  usuarioElegido.getClave() );
                System.out.println("Rol  "+ usuarioElegido.getRol()  );
            }
            
            // to String
            
        }

        public void readUsuarios(){

                try{
                    PreparedStatement prepararLlamada = ConexionDatabase
                                                            .getInstanciaConexionDatabase()
                                                            .getInstanciaConnection()
                                                            .prepareCall("{call sp_read_usuarios()}");

                    ResultSet tablaResultados = prepararLlamada.executeQuery();

                    while ( tablaResultados.next() ){
                        //Crear mi objeto usuario
                        Usuario objetoUsuarioDB = new Usuario();
                        //Darle los valores a mi objeto
                        objetoUsuarioDB.setIdUsuario(  tablaResultados.getString("id_usuario") );
                        objetoUsuarioDB.setNombres( tablaResultados.getString("nombres") );
                        objetoUsuarioDB.setApellidos( tablaResultados.getString("apellidos") );
                        objetoUsuarioDB.setNombreUsuario( tablaResultados.getString("nombre_usuario"));
                        objetoUsuarioDB.setClave( tablaResultados.getString("clave"));
                        objetoUsuarioDB.setRol( tablaResultados.getString("rol"));
                        
                        listaUsuarios.add(objetoUsuarioDB);
                    }

                } catch(SQLException errorSQL){
                    System.out.println("Error al leer usuarios");
                } catch(Exception errorPadre){
                    System.out.println("Error top");
                }
        }
    
    
}
