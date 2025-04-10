import java.util.List;
import java.util.Scanner;

/**
 * Clase responsable de mostrar el escenario y capturar las teclas para mover al jugador.
 * 
 * @author Carlos de Tena Muñoz
 * @author Paloma Zapata Velázquez
 * @version 2.0
 */
public class VistaEscenario {
    private Scanner scanner;

    /**
     * Constructor que inicializa el escáner para leer las entradas del usuario.
     */
    public VistaEscenario() {
        scanner = new Scanner(System.in);
    }

    /**
     * Muestra el escenario actual en la consola.
     * @param escenario 
     */
    public void mostrarEscenario(Escenario escenario) {
        System.out.println("\n=== Escenario ===");
        escenario.mostrar();
        System.out.println("\nControla el jugador con las teclas: WASD");
    }

    /**
     * Lee el movimiento del jugador desde el teclado.
     * @return tecla pulsada
     */
    public char leerMovimiento() {
        System.out.print("Movimientos (WASD): ");
        return scanner.nextLine().toLowerCase().charAt(0);
    }

    /**
     * Cierra el escáner.
     */
    public void cerrar() {
        scanner.close();
    }
}
