import java.util.Scanner;

/**
 * Clase responsable de manejar la interacción con el usuario en la fase de inicio del juego.
 * Solicita el nombre de usuario y el correo electrónico.
 * 
 * @author Carlos de Tena Muñoz
 * @author Paloma Zapata Velázquez
 * @version 2.0
 */
public class VistaInicio {
    private Scanner scanner;

    /**
     * Constructor que inicializa el escáner para leer las entradas del usuario.
     */
    public VistaInicio() {
        scanner = new Scanner(System.in);
    }

    /**
     * Solicita el nombre de usuario al jugador.
     * @return nombre del usuario
     */
    public String pedirNombreUsuario() {
        System.out.println("=== Bienvenido al juego ===");
        System.out.print("Por favor, introduce tu nombre de usuario: ");
        return scanner.nextLine();
    }

    /**
     * Solicita el correo electrónico del jugador.
     * @return correo electronico.
     */
    public String pedirCorreoUsuario() {
        System.out.print("Introduce tu correo electrónico: ");
        return scanner.nextLine();
    }

    /**
     * Muestra un mensaje en la consola.
     * @param mensaje 
     */
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    /**
     * Cierra el escáner.
     */
    public void cerrar() {
        scanner.close();
    }
}
