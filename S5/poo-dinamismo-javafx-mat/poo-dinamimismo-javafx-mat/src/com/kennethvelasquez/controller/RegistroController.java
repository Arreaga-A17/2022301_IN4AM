
package com.kennethvelasquez.controller;

import com.kennethvelasquez.exceptions.ExcepcionesPersonalizadas;
import java.util.ArrayList;
import com.kennethvelasquez.model.Persona;
import com.kennethvelasquez.model.Estudiante;
import com.kennethvelasquez.model.Maestro;
import com.kennethvelasquez.view.RegistroView;
import com.kennethvelasquez.view.ResumenView;
import javafx.collections.FXCollections;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class RegistroController {

    private final RegistroView registroView;
    private ArrayList<Persona> listaPersonas;
    //Coloque como static la lista de registro de personas
    //para que no sea obligatorio instanciar la clase controller
    private static ArrayList<Persona> listaRegistroPersonas;

    public RegistroController(RegistroView registroView) {
        this.registroView = registroView;
        cargarDatos();
        construirComboBox();
        construirAcciones();
    }

    public void cargarDatos() {
        Estudiante objetoEstudiante = new Estudiante();
        Maestro objetoMaestro = new Maestro();

        listaPersonas = new ArrayList<>();

        listaPersonas.add(objetoEstudiante);
        listaPersonas.add(objetoMaestro);

        listaRegistroPersonas = new ArrayList<>();

    }

    public void construirComboBox() {
        this.registroView.getCmbTipoPersona().setItems(
                FXCollections.observableArrayList(listaPersonas)
        );
    }

    public void construirAcciones() {
        this.registroView.getCmbTipoPersona().setOnAction(
                (evento) -> { // FUNCIONES LAMBDA
                    validarCampos(this.registroView.getCmbTipoPersona().getValue());
                }
        );

        this.registroView.getBtnGuardar().setOnAction(
                (evento) -> {
                    guardarPersona();
                    limpiarCampos();
                }
        );

        this.registroView.getBtnLimpiar().setOnAction(
                (evento) -> {
                    limpiarCampos();
                    mostrarCampos();
                }
        );
    }

    public void limpiarCampos() {
        this.registroView.getTxtNombres().clear();
        this.registroView.getTxtApellidos().clear();
        this.registroView.getTxtCurso().clear();
        this.registroView.getTxtNumeroCarne().clear();
        this.registroView.getTxtGradoEstudiante().clear();
        this.registroView.getTxtGradoMaestro().clear();
        this.registroView.getCbAprobado().setSelected(false);
        this.registroView.getRbActivo().setSelected(false);
        this.registroView.getCmbTipoPersona().getSelectionModel().select(null);
    }

    public void mostrarCampos() {
//        //Mostramos los campos de estudiante
//        this.registroView.getLblAprobado().setVisible(true);
//        this.registroView.getLblNumeroCarne().setVisible(true);
//        this.registroView.getLblGradoEstudiante().setVisible(true);
//        //TextField
//        this.registroView.getTxtNumeroCarne().setVisible(true);
//        this.registroView.getTxtGradoEstudiante().setVisible(true);
//        //RadioButton
//        this.registroView.getCbAprobado().setVisible(true);
//
//        //Mostramos los campos de maestros
//        this.registroView.getLblActivo().setVisible(true);
//        this.registroView.getLblCurso().setVisible(true);
//        this.registroView.getLblGradoMaestro().setVisible(true);
//        //TextField
//        this.registroView.getTxtCurso().setVisible(true);
//        this.registroView.getTxtGradoMaestro().setVisible(true);
//        //RadioButton
//        this.registroView.getRbActivo().setVisible(true);
 //Cambiar Visibilidad Campo Estudiante
        boolean seleccion = true;
        
        cambiarVisibilidadCampo(this.registroView.getLblGradoEstudiante(), this.registroView.getTxtGradoEstudiante(), seleccion);
        cambiarVisibilidadCampo(this.registroView.getLblNumeroCarne(), this.registroView.getTxtNumeroCarne(),seleccion);
        //Agrego ahora el campo de aprobado
        cambiarVisibilidadCampo(this.registroView.getLblAprobado(), 
                                this.registroView.getCbAprobado(), 
                                seleccion);
        
        //Cambiar Visibilidad Campo Maestro
        cambiarVisibilidadCampo(this.registroView.getLblGradoMaestro(), this.registroView.getTxtGradoMaestro(),seleccion);
        cambiarVisibilidadCampo(this.registroView.getLblCurso(), this.registroView.getTxtCurso(), seleccion);
        //Agrego ahora el campo de activo
        cambiarVisibilidadCampo(this.registroView.getLblActivo(), 
                                this.registroView.getRbActivo(), 
                                seleccion);
    }

    public void guardarPersona() {
        if (this.registroView.getCmbTipoPersona().getValue() == null) {
            JOptionPane.showMessageDialog(null, "TIENES QUE ELEGIR EL TIPO DE REGISTRO");
            return;
        }

        if (this.registroView.getCmbTipoPersona().getValue() instanceof Estudiante) {
            try {
                ExcepcionesPersonalizadas objetoMisExcepciones = new ExcepcionesPersonalizadas();
                
                Estudiante nuevoEstudiante = new Estudiante();
                //CARNE
                objetoMisExcepciones.validarNumeroEntero(this.registroView.getTxtNumeroCarne().getText());
                //Nombres y apellidos
                objetoMisExcepciones.validarLongitudTexto( this.registroView.getTxtNombres().getText(), 10);
                objetoMisExcepciones.validarLongitudTexto( this.registroView.getTxtApellidos().getText(), 11);

                nuevoEstudiante.setNombres(this.registroView.getTxtNombres().getText());
                nuevoEstudiante.setApellidos(this.registroView.getTxtApellidos().getText());
                nuevoEstudiante.setAprobado(this.registroView.getCbAprobado().isSelected());
                nuevoEstudiante.setGrado(this.registroView.getTxtGradoEstudiante().getText());

                listaRegistroPersonas.add(nuevoEstudiante);
                
                JOptionPane.showMessageDialog(null, "SE HA GUARDADO EL ESTUDIANTE CON EXITO");
                
            } catch (ExcepcionesPersonalizadas miExcepcion) {
               JOptionPane.showMessageDialog(null, miExcepcion . getMessage());
               miExcepcion.printStackTrace();
            }
            /* Linea del error logico en el registro
               es lo que mencionaba, que cada que guardaba tenia que instanciar la clase
             */
            //new ResumenController(ResumenView.getInstanciaResumenView()).cargarDatos();
        } else {
            try {
                ExcepcionesPersonalizadas objetoMisExcepciones = new ExcepcionesPersonalizadas();
                
                Maestro nuevoMaestro = new Maestro();
                
                //Nombres y apellidos
                objetoMisExcepciones.validarLongitudTexto( this.registroView.getTxtNombres().getText(), 50);
                objetoMisExcepciones.validarLongitudTexto( this.registroView.getTxtApellidos().getText(), 50);
                //Curso
                objetoMisExcepciones.validarLongitudTexto( this.registroView.getTxtCurso().getText(), 30);
                
                nuevoMaestro.setNombres(this.registroView.getTxtNombres().getText());
                nuevoMaestro.setApellidos(this.registroView.getTxtApellidos().getText());

                nuevoMaestro.setActivo(this.registroView.getRbActivo().isSelected());
                nuevoMaestro.setGrado(this.registroView.getTxtGradoMaestro().getText());
                nuevoMaestro.setCurso(this.registroView.getTxtCurso().getText());

                listaRegistroPersonas.add(nuevoMaestro);
                
                JOptionPane.showMessageDialog(null, "SE HA GUARDADO EL MAESTRO CON EXITO");
            } catch (ExcepcionesPersonalizadas miExcepcion) {
               JOptionPane.showMessageDialog(null, miExcepcion . getMessage());
               miExcepcion.printStackTrace();
            }
        }
        //Cada que agrego a la lista, independientemente del objeto actualizare la lista en el resument
        new ResumenController(ResumenView.getInstanciaResumenView()).cargarDatos();
    }

    public void validarCampos(Persona objetoPersonaSeleccionado) {
        if (objetoPersonaSeleccionado == null) {
            return;
        }
        String claseSeleccionada = objetoPersonaSeleccionado.toString();
        
        boolean seleccion = claseSeleccionada.equals("Estudiante");
        
        //Cambiar Visibilidad Campo Estudiante
        cambiarVisibilidadCampo(this.registroView.getLblGradoEstudiante(), 
                                this.registroView.getTxtGradoEstudiante(),
                                seleccion);
        cambiarVisibilidadCampo(this.registroView.getLblNumeroCarne(),
                                this.registroView.getTxtNumeroCarne(),
                                seleccion);
        //Agrego ahora el campo de aprobado
        cambiarVisibilidadCampo(this.registroView.getLblAprobado(), 
                                this.registroView.getCbAprobado(), 
                                seleccion);
        
        //Cambiar Visibilidad Campo Maestro
        cambiarVisibilidadCampo(this.registroView.getLblGradoMaestro(), 
                                this.registroView.getTxtGradoMaestro(), 
                                !seleccion);
        cambiarVisibilidadCampo(this.registroView.getLblCurso(), 
                                this.registroView.getTxtCurso(), 
                                !seleccion);
        //Agrego ahora el campo de activo
        cambiarVisibilidadCampo(this.registroView.getLblActivo(), 
                                this.registroView.getRbActivo(), 
                                !seleccion);
    }
    
    /**
     * Metodo que permite controlar si se visualiza o no, el siguiente grupo de campos
     * @param etiqueta Etiqueta que nombra al campo
     * @param campoTexto Campo de tipo TextField referido por la etiqueta
     * @param visible Valor true para visualizarse y false para ocultarse
     */

    public void cambiarVisibilidadCampo(Label etiqueta, TextField campoTexto, boolean visible){
        etiqueta.setVisible(visible);
        etiqueta.setManaged(visible);
        
        campoTexto.setVisible(visible);
        campoTexto.setManaged(visible);
    }

    /**
    * Metodo que permite controlar si se visualiza o no, el siguiente grupo de campos
    * @param etiqueta Etiqueta que nombra al campo
    * @param cajaSeleccion Campo de tipo CheckBox referido por la etiqueta
    * @param visible Valor true para visualizarse y false para ocultarse
    */ 
    public void cambiarVisibilidadCampo(Label etiqueta, CheckBox cajaSeleccion, boolean visible){
        etiqueta.setVisible(visible);
        etiqueta.setManaged(visible);
        
        cajaSeleccion.setVisible(visible);
        cajaSeleccion.setManaged(visible);
    }
    
    /**
     * Metodo que permite controlar si se visualiza o no, el siguiente grupo de campos
     * @param etiqueta Etiqueta que nombra al campo
     * @param botonSeleccion Campo de tipo RadioButton referido por la etiqueta
     * @param visible Valor true para visualizarse y false para ocultarse
     */
    public void cambiarVisibilidadCampo(Label etiqueta, RadioButton botonSeleccion, boolean visible){
        etiqueta.setVisible(visible);
        etiqueta.setManaged(visible);
        
        botonSeleccion.setVisible(visible);
        botonSeleccion.setManaged(visible);
    }
    
    //Como el atributo es static, el metodo tambien debe serlo
    public static ArrayList<Persona> getListaRegistroPersonas() {
        return listaRegistroPersonas;
    }

}
