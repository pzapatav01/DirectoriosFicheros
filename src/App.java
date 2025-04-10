import java.io.File; //Este import sirve para poder utilizar la clase File.
import java.io.IOException; //Este import sirve para poder utilizar la excepcion IO porque estamos utilizando java.io (es el paquete que se usa para fichero :).

/**
* Esta clase es la que tiene el main en el cual se inicia el juego a través de un controlador también creado en el main.
* @author Carlos de Tena Muñoz
* @author Paloma Zapata Velázquez
* @version 2.0
*/
public class App {
    public static void main(String[] args) throws Exception {

        /**
         * Creación de un controlador (se encarga de crear la vista y el modelo; y de cambiar las vista), el modelo vista-controlador
         * se utiliza para mantener la independencia del código y así el código es más escalable(que se puede añadir más cosas),
         * mantenible, y permite reutilizar código.
         * El modelo es una clase(para crear los objetos jugadores y escenarios)
         */
        Controlador controlador = new Controlador();
        
        controlador.iniciar();


    }
}
