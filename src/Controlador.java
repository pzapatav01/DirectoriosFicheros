import java.util.List;

/**
 * Clase que controla el flujo principal del juego.
 * Gestiona la creación y carga de jugadores y escenarios.
 * 
 * @author Carlos de Tena Muñoz
 * @author Paloma Zapata Velázquez
 * @version 2.0
 */
public class Controlador {
    private Jugador jugador;
    private Escenario escenarioActual;
    private VistaInicio vistaInicio;
    private VistaEscenario vistaEscenario;
    
    /**
     * Constructor que inicializa las vistas del juego.
     */
    public Controlador() {
        this.vistaInicio = new VistaInicio();
        this.vistaEscenario = new VistaEscenario();
    }
    
    /**
     * Método principal que inicia el flujo del juego.
     * Solicita los datos del usuario y gestiona los escenarios.
     */
    public void iniciar() {
        // Solicitar nombre de usuario
        String nombreUsuario = vistaInicio.pedirNombreUsuario();
        
        // Verificar si el jugador existe
        jugador = Jugador.cargar(nombreUsuario);
        
        if (jugador == null) {
            // Si no existe, crear nuevo jugador
            vistaInicio.mostrarMensaje("Usuario nuevo detectado. Por favor, completa tu registro.");
            String correo = vistaInicio.pedirCorreoUsuario();
            
            jugador = new Jugador(nombreUsuario, correo);
            jugador.guardar();
            vistaInicio.mostrarMensaje("¡Registro completado con éxito!");
        } else {
            vistaInicio.mostrarMensaje("¡Bienvenido de nuevo, " + jugador.getNombre() + "!");
        }
        
        // Pasar a la gestión de escenarios
        gestionarEscenarios();
        
        // Cerrar recursos
        vistaInicio.cerrar();
        vistaEscenario.cerrar();
    }
    
    /**
     * Método que gestiona la selección y creación de escenarios.
     * Permite al usuario elegir entre cargar un escenario existente o crear uno nuevo.
     */
    private void gestionarEscenarios() {
        List<String> escenarios = Escenario.listarEscenarios();
        
        if (escenarios.isEmpty()) {
            vistaInicio.mostrarMensaje("No hay escenarios disponibles. Vamos a crear uno nuevo.");
            crearNuevoEscenario();
        } else {
            int opcion = vistaEscenario.mostrarMenuEscenarios(escenarios);
            
            if (opcion == 0) {
                crearNuevoEscenario();
            } else if (opcion > 0 && opcion <= escenarios.size()) {
                cargarEscenario(escenarios.get(opcion - 1));
            }
        }
    }
    
    /**
     * Método que permite la creación de un nuevo escenario.
     * Solicita el nombre y la configuración del escenario y lo guarda en el sistema.
     */
    private void crearNuevoEscenario() {
        String nombreEscenario = vistaEscenario.pedirNombreEscenario();
        escenarioActual = new Escenario(nombreEscenario);
        
        List<String> configuracion = vistaEscenario.crearConfiguracionEscenario();
        for (String linea : configuracion) {
            escenarioActual.agregarLinea(linea);
        }
        
        escenarioActual.guardar();
        vistaInicio.mostrarMensaje("Escenario '" + nombreEscenario + "' creado con éxito.");
        
        vistaEscenario.mostrarEscenario(escenarioActual);
    }
    
    /**
     * Método que carga un escenario existente.
     * 
     * @param nombreEscenario Nombre del escenario a cargar.
     */
    private void cargarEscenario(String nombreEscenario) {
        escenarioActual = Escenario.cargar(nombreEscenario);
        
        if (escenarioActual != null) {
            vistaEscenario.mostrarEscenario(escenarioActual);
        } else {
            vistaInicio.mostrarMensaje("Error al cargar el escenario.");
        }
    }
}
