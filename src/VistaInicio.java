import java.util.List;
import java.util.Scanner;

public class VistaInicio {
    private Scanner scanner;
    
    public VistaInicio() {
        scanner = new Scanner(System.in);
    }
    
    public String pedirNombreUsuario() {
        System.out.println("=== Bienvenido al juego ===");
        System.out.print("Por favor, introduce tu nombre de usuario: ");
        return scanner.nextLine();
    }
    
    public String pedirCorreoUsuario() {
        System.out.print("Introduce tu correo electrónico: ");
        return scanner.nextLine();
    }
    
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    
    public void cerrar() {
        scanner.close();
    }
}