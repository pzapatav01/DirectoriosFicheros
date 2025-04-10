import java.util.List;

/**
 * Clase que controla la lógica del flujo del juego.
 * Gestiona la creación del jugador y la interacción con el escenario.
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
     * Solicita el nombre de usuario y gestiona la creación o carga del jugador y escenario.
     */
    public void iniciar() {
        // Solicitar nombre de usuario
        String nombreUsuario = vistaInicio.pedirNombreUsuario();
        jugador = Jugador.cargar(nombreUsuario);

        if (jugador == null) {
            vistaInicio.mostrarMensaje("Usuario nuevo detectado. Por favor, completa tu registro.");
            String correo = vistaInicio.pedirCorreoUsuario();
            jugador = new Jugador(nombreUsuario, correo);
            jugador.guardar();
            vistaInicio.mostrarMensaje("¡Registro completado con éxito!");
        } else {
            vistaInicio.mostrarMensaje("¡Bienvenido de nuevo, " + jugador.getNombre() + "!");
        }

        // Crear el escenario automáticamente
        int largo = 10;  
        int ancho = 10;  
        escenarioActual = new Escenario(largo, ancho);

        gestionarEscenarios();
    }

    /**
     * Gestiona la interacción con el escenario, permitiendo que el jugador se mueva.
     */
    private void gestionarEscenarios() {
        while (true) {
            vistaEscenario.mostrarEscenario(escenarioActual);
            char movimiento = vistaEscenario.leerMovimiento();
            escenarioActual.moverJugador(movimiento);
        }
    }
}
