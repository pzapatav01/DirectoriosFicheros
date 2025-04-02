import java.util.List;
import java.util.Scanner;

public class VistaEscenario {
    private Scanner scanner;
    
    public VistaEscenario() {
        scanner = new Scanner(System.in);
    }
    
    public void mostrarEscenario(Escenario escenario) {
        System.out.println("\n=== Escenario: " + escenario.getNombre() + " ===");
        for (String linea : escenario.getConfiguracion()) {
            System.out.println(linea);
        }
        System.out.println("===========================\n");
    }
    
    public int mostrarMenuEscenarios(List<String> escenarios) {
        System.out.println("\n=== Escenarios disponibles ===");
        for (int i = 0; i < escenarios.size(); i++) {
            System.out.println((i + 1) + ". " + escenarios.get(i));
        }
        System.out.println("0. Crear nuevo escenario");
        System.out.print("Selecciona una opción: ");
        return Integer.parseInt(scanner.nextLine());
    }
    
    public String pedirNombreEscenario() {
        System.out.print("Introduce el nombre del nuevo escenario: ");
        return scanner.nextLine();
    }
    
    public List<String> crearConfiguracionEscenario() {
        System.out.println("Introduce las líneas del escenario (línea vacía para terminar):");
        Escenario escenario = new Escenario("temp");
        
        String linea;
        while (true) {
            linea = scanner.nextLine();
            if (linea.isEmpty()) {
                break;
            }
            escenario.agregarLinea(linea);
        }
        
        return escenario.getConfiguracion();
    }
    
    public void cerrar() {
        scanner.close();
    }
}