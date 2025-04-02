import java.util.List;

public class Controlador {
    private Jugador jugador;
    private Escenario escenarioActual;
    private VistaInicio vistaInicio;
    private VistaEscenario vistaEscenario;
    
    public Controlador() {
        this.vistaInicio = new VistaInicio();
        this.vistaEscenario = new VistaEscenario();
    }
    
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
    
    private void cargarEscenario(String nombreEscenario) {
        escenarioActual = Escenario.cargar(nombreEscenario);
        
        if (escenarioActual != null) {
            vistaEscenario.mostrarEscenario(escenarioActual);
        } else {
            vistaInicio.mostrarMensaje("Error al cargar el escenario.");
        }
    }
}