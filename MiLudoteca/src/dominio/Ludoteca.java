package dominio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Ludoteca implements Serializable {

    private ArrayList<Videojuego> videojuegos;

    public Ludoteca() {
        this.videojuegos = new ArrayList<Videojuego>();
    }

    public void añadir(Videojuego videojuego) {
        if (videojuego != null && !this.videojuegos.contains(videojuego)) {
            this.videojuegos.add(videojuego);
        }
    }

    public void listar() {
        if (videojuegos.isEmpty()) {
            System.out.println("La ludoteca está vacía.");
            return;
        }
        for (Videojuego v : videojuegos) {
            v.mostrarFicha();
            System.out.println("-------------------------");
        }
    }

    public Videojuego buscarPorTitulo(String titulo) {
        Videojuego aux = new Videojuego(titulo);
        int posicion = videojuegos.indexOf(aux);

        if (posicion != -1) {
            return videojuegos.get(posicion);
        }
        return null;
    }

    public double calcularPuntuacionMedia() {
        if (videojuegos.isEmpty()) {
            return 0.0;
        }
        double suma = 0;
        for (Videojuego v : videojuegos) {
            suma += v.getPuntuacion();
        }
        return suma / videojuegos.size();
    }

    public Videojuego obtenerMejorValorado() {
        if (videojuegos.isEmpty()) {
            return null;
        }
        Videojuego mejor = videojuegos.get(0);
        for (Videojuego v : videojuegos) {
            if (v.getPuntuacion() > mejor.getPuntuacion()) {
                mejor = v;
            }
        }
        return mejor;
    }

    public void guardarEnFichero(String nombreFichero) {
        ObjectOutputStream escritor = null;
        try {
            escritor = new ObjectOutputStream(new FileOutputStream(nombreFichero));
            escritor.writeObject(this.videojuegos);
            System.out.println("Datos guardados correctamente en " + nombreFichero);
        } catch (IOException e) {
            System.out.println("Error: No se ha podido guardar el fichero de datos.");
        } finally {
            if (escritor != null) {
                try {
                    escritor.close();
                } catch (IOException e) {
                    System.out.println("Error al cerrar el fichero de guardado.");
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void cargarDesdeFichero(String nombreFichero) {
        File fichero = new File(nombreFichero);
        if (!fichero.exists()) {
            System.out.println("No existe fichero previo. Se iniciará una nueva ludoteca vacía.");
            return;
        }

        ObjectInputStream lector = null;
        try {
            lector = new ObjectInputStream(new FileInputStream(fichero));
            this.videojuegos = (ArrayList<Videojuego>) lector.readObject();
            System.out.println("Ludoteca cargada correctamente desde " + nombreFichero);
        } catch (FileNotFoundException e) {
            System.out.println("No se ha podido abrir el fichero de datos. Se iniciará una nueva ludoteca vacía.");
        } catch (IOException e) {
            System.out.println("Error al leer el fichero de datos. Se iniciará una nueva ludoteca vacía.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error de formato en el fichero de datos. Se iniciará una nueva ludoteca vacía.");
        } finally {
            if (lector != null) {
                try {
                    lector.close();
                } catch (IOException e) {
                    System.out.println("Error al cerrar el fichero de lectura.");
                }
            }
        }
    }
}
