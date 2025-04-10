import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase que representa el escenario del juego.
 * Se encarga de generar un escenario con dimensiones específicas,
 * mostrarlo y permitir el movimiento del jugador dentro del escenario.
 * 
 * @author Carlos de Tena Muñoz
 * @author Paloma Zapata Velázquez
 * @version 2.0
 */
public class Escenario {
    private String nombre;
    private List<String> configuracion;
    private int largo;
    private int ancho;
    private int jugadorPosX;
    private int jugadorPosY;

    /**
     * Constructor que crea un escenario con las dimensiones proporcionadas.
     * @param largo 
     * @param ancho
     */
    public Escenario(int largo, int ancho) {
        this.largo = largo;
        this.ancho = ancho;
        this.configuracion = new ArrayList<>();
        generarEscenario();
    }

    /**
     * Genera el escenario automáticamente con obstáculos, objetos y bordes.
     * Coloca al jugador en una posición aleatoria.
     */
    private void generarEscenario() {
        Random random = new Random();
        for (int i = 0; i < largo; i++) {
            StringBuilder fila = new StringBuilder();
            for (int j = 0; j < ancho; j++) {
                if (i == 0 || i == largo - 1 || j == 0 || j == ancho - 1) {
                    fila.append("|");  // Bordes
                } else {
                    int chance = random.nextInt(10);
                    if (chance < 2) {
                        fila.append("x");  
                    } else if (chance < 4) {
                        fila.append("O");  
                    } else {
                        fila.append(" ");  
                    }
                }
            }
            configuracion.add(fila.toString());
        }
        // Posicionar al jugador en un lugar aleatorio dentro del mapa
        jugadorPosX = random.nextInt(largo - 2) + 1;
        jugadorPosY = random.nextInt(ancho - 2) + 1;
        configuracion.set(jugadorPosX, configuracion.get(jugadorPosX).substring(0, jugadorPosY) + "P" + configuracion.get(jugadorPosX).substring(jugadorPosY + 1));
    }

    /**
     * Muestra el escenario en la consola.
     */
    public void mostrar() {
        for (String fila : configuracion) {
            System.out.println(fila);
        }
    }

    /**
     * Mueve al jugador en la dirección indicada si la nueva posición es válida.
     * Si la nueva posición es un obstáculo o borde, el movimiento es rechazado.
     * @param direccion 
     */
    public void moverJugador(char direccion) {
        int nuevaPosX = jugadorPosX;
        int nuevaPosY = jugadorPosY;

        switch (direccion) {
            case 'w': nuevaPosX--; break;  
            case 's': nuevaPosX++; break; 
            case 'a': nuevaPosY--; break;  
            case 'd': nuevaPosY++; break;  
        }

        // Verificar si la nueva posición es válida
        if (configuracion.get(nuevaPosX).charAt(nuevaPosY) != '|' && configuracion.get(nuevaPosX).charAt(nuevaPosY) != 'x') {
            // Vacío o espacio disponible
            configuracion.set(jugadorPosX, configuracion.get(jugadorPosX).substring(0, jugadorPosY) + " " + configuracion.get(jugadorPosX).substring(jugadorPosY + 1)); // Limpiar anterior
            jugadorPosX = nuevaPosX;
            jugadorPosY = nuevaPosY;
            configuracion.set(jugadorPosX, configuracion.get(jugadorPosX).substring(0, jugadorPosY) + "P" + configuracion.get(jugadorPosX).substring(jugadorPosY + 1)); // Colocar jugador
        } else {
            System.out.println("ouch!");  // Mensaje que sale cunado el jugador choca
        }
    }
}
