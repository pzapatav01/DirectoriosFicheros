import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Jugador {
    private String nombre;
    private String correo;

    public Jugador(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.correo = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

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

    public boolean existe(){
        File archivo = new File("personajes/" + nombre + ".txt");
        return archivo.exists();
    }
}