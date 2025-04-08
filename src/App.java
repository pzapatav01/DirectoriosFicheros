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
        /**
         * Inicia el juego
         */
        controlador.iniciar();

        // Vamos a crear la variable "rutaFichero" para utilizarla después
        //String rutaFichero = "FicheroConfiguracion.txt";
        // Vamos a crear el vector "carpetas" donde irán todas las carpetas
        //String[] carpetas = { "Jugadores", "Escenarios", "Partidas" };

        /**
         * Estamos creando el objeto fichero de la clase File y le pasamos por parámeto
         * "rutaFichero", para que cuando se utilice el fichero sepa la ruta
         * donde se debe guardar el fichero
         */
        //File fichero = new File(rutaFichero);

        // Aquí comprobamos si el fichero existe( nos iríamos al else), en el caso de
        // que no exista nos metemos dentro de la condición

        /** if (!fichero.exists()) {
         *   // Intenta ejecutar el código
         *   try {

         *       //Comrpueba si se puede crear el nuevo fichero
         *       if (fichero.createNewFile()) {
         *           System.out.println("El fichero ha sido creado.");
         *       }
         *   //Catch sirve para atrapar los errores que se hayan podido generar dentro del try
         *   } catch (IOException e) {
         *       System.err.println("Se ha producido un error al crear el fichero");
         *   }
         *   //Sirve para recorrer el vector "carpetas" qcreado anteriormente
         *   for (String carpeta : carpetas) {
         *       
         *   
         *       Estamos creando el objeto carpetita de la clase File y le pasamos por parámeto
         *        "carpeta", para que cuando se utilice el fichero sepa la ruta
         *        donde se debe guardar el fichero
         *    
         *       File carpetita = new File(carpeta);
         *       
         *       //Comprobamos si la carpeta existe, en el caso de que no, se entra dentro de la condición
         *       if (!carpetita.exists()) {
         *           //Esto para comprobar si se puede crear la carpeta
         *           if (carpetita.mkdirs()) {
         *               System.out.println("La carpeta se ha creado exitosamente");
         *           //En el caso de que no se pueda crear la carpeta, mostrar el siguiente mensaje de error
         *           } else {
         *               System.out.println("Se ha producido un erRor al crear la carpeta");
         *           }
         *       }
         *   }
         * En el caso de que a la hora de haber la comprobación de si el fichero existía, si exite, por lo tanto se muestra el mensaje.
         * else {
         *   System.out.println("EL fichero ya existe. No se han realizado cambios.");
         *
         */


    }
}
