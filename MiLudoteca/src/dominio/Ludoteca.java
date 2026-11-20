package dominio;

import java.util.ArrayList;

public class Ludoteca {

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
}