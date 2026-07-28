
package com.kennethvelasquez.controller;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import com.kennethvelasquez.view.CalculadoraView;
import com.kennethvelasquez.controller.CalculadoraController;

public class SceneManagerController {
        private static SceneManagerController instanciaSceneManagerController;
        private Stage escenarioPrincipal;
        //Constructor vacio
        public SceneManagerController(){
            
        }
        public SceneManagerController(Stage escenarioRoot){
            this.escenarioPrincipal = escenarioRoot;
        }
        
        public void vistaCalculadora(){
            try{
                this.escenarioPrincipal.setTitle("CALCULADORA GRAFICA JAVAFX");
                CalculadoraView calculadora = CalculadoraView.getInstanciaCalculadoraView();
                cambiarEscena( calculadora.getInstanciaPanel(), 415, 550  );
                CalculadoraController calculadoraController = new CalculadoraController( calculadora );
            } catch( NullPointerException errorNull ){
                System.out.println("Error de objeto nulo");
            } catch( Exception errorPadre ){
                System.out.println("Error top vista calculadora");
            }
        }
        
        /**
         * Metodo para cambiar escenas o vistas de mi aplicacion
         * @param panelView El panel que se mostrara en el escenario principal
         */
        public void cambiarEscena( Pane panelView, int ancho, int alto  ){
              Scene escenaPrincipal  = new Scene(panelView, ancho, alto);
              escenarioPrincipal.setScene(  escenaPrincipal  );
              escenarioPrincipal.sizeToScene(); //dimensiono mi ventana a la escena
              escenarioPrincipal.show();
        }
        
        public void setSceneManagerController( Stage  nuevoEscenarioPrincipal ){
            this.escenarioPrincipal = nuevoEscenarioPrincipal;
        }
        
        public static SceneManagerController getInstanciaSceneManagerController(){
            if( instanciaSceneManagerController == null )
                instanciaSceneManagerController = new SceneManagerController();
            return instanciaSceneManagerController;
        }
        
}
