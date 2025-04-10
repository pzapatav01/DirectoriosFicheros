import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Clase que representa un jugador en el juego.
 * Permite la creación, almacenamiento y carga de jugadores desde archivos de texto.
 * 
 * Los jugadores se almacenan en la carpeta "personajes" con extensión ".txt".
 * 
 * @author Carlos de Tena Muñoz
 * @author Paloma Zapata Velázquez
 * @version 2.0
 */
public class Jugador {
    private String nombre;
    private String correo;

    /**
     * Constructor de la clase Jugador
     * @param nombre
     * @param correo
     */
    public Jugador(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    /**
     * Constructor alternativo que solo recibe el nombre del jugador.
     * 
     * @param nombre Nombre del jugador.
     */
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.correo = "";
    }

    /**
     * Obtiene el nombre del jugador.
     * 
     * @return Nombre del jugador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece un nuevo nombre para el jugador.
     * 
     * @param nombre Nuevo nombre del jugador.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el correo del jugador.
     * 
     * @return Correo del jugador.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece un nuevo correo para el jugador.
     * 
     * @param correo Nuevo correo del jugador.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Guarda la información del jugador en un archivo de texto dentro de la carpeta "personajes".
     */
    public void guardar(){
        File directorio = new File("personajes");

        if(!directorio.exists()){
            directorio.mkdir();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("personajes/" + nombre + ".txt"))) {
            writer.write(nombre + "\n");
            writer.write(correo);            
        } catch (IOException e) {
            System.err.println("Error al guardar el jugador");
        }
    }

    /**
     * Carga un jugador desde un archivo de texto.
     * 
     * @param nombre Nombre del jugador a cargar.
     * @return Objeto Jugador con la información cargada o null si el archivo no existe o hay un error de lectura.
     */
    public static Jugador cargar(String nombre){
        File archivo = new File("personajes/" + nombre + ".txt");
        
        if(!archivo.exists()){
            return null;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String nombreLeido = reader.readLine();
            String correoLeido = reader.readLine();
            return new Jugador(nombreLeido, correoLeido);
        } catch (IOException e) {
            System.err.println("Error al cargar el jugador: " + e.getMessage());
            return null;
        }
    }

    /**
     * Verifica si el jugador ya existe en la carpeta "personajes".
     * 
     * @return true si el archivo del jugador existe, false en caso contrario.
     */
    public boolean existe(){
        File archivo = new File("personajes/" + nombre + ".txt");
        return archivo.exists();
    }
}
