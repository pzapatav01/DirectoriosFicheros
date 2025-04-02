import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Escenario {
    private String nombre;
    private List<String> configuracion;
    
    public Escenario(String nombre) {
        this.nombre = nombre;
        this.configuracion = new ArrayList<>();
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public List<String> getConfiguracion() {
        return configuracion;
    }
    
    public void agregarLinea(String linea) {
        configuracion.add(linea);
    }
    
    public void guardar() {
        File directorio = new File("escenarios");
        if (!directorio.exists()) {
            directorio.mkdir();
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("escenarios/" + nombre + ".txt"))) {
            for (String linea : configuracion) {
                writer.write(linea + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error al guardar el escenario: " + e.getMessage());
        }
    }
    
    public static Escenario cargar(String nombre) {
        File archivo = new File("escenarios/" + nombre + ".txt");
        if (!archivo.exists()) {
            return null;
        }
        
        Escenario escenario = new Escenario(nombre);
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                escenario.agregarLinea(linea);
            }
            return escenario;
        } catch (IOException e) {
            System.err.println("Error al cargar el escenario: " + e.getMessage());
            return null;
        }
    }
    
    public static List<String> listarEscenarios() {
        List<String> escenarios = new ArrayList<>();
        File directorio = new File("escenarios");
        
        if (!directorio.exists()) {
            directorio.mkdir();
            return escenarios;
        }
        
        File[] archivos = directorio.listFiles((dir, name) -> name.endsWith(".txt"));
        if (archivos != null) {
            for (File archivo : archivos) {
                String nombre = archivo.getName();
                escenarios.add(nombre.substring(0, nombre.length() - 4));
            }
        }
        
        return escenarios;
    }
}