package presentacion;

import dominio.Ludoteca;
import dominio.Videojuego;
import dominio.VideojuegoDeportivo;
import dominio.VideojuegoEstrategia;
import dominio.VideojuegoOnline;
import dominio.VideojuegoRol;

public class Main {
    public static void main(String[] args) {
        String ficheroDatos = "ludoteca.dat";
        Ludoteca ludoteca = new Ludoteca();

        ludoteca.cargarDesdeFichero(ficheroDatos);

        ludoteca.añadir(new VideojuegoDeportivo("EA Sports FC 26", "PS5", 8.5, 45.0, "Fútbol"));
        ludoteca.añadir(new VideojuegoRol("The Witcher 3", "PC", 9.8, 120.5, 50));
        ludoteca.añadir(new VideojuegoEstrategia("Age of Empires IV", "PC", 8.9, 60.0, 8));
        ludoteca.añadir(new VideojuegoOnline("Valorant", "PC", 8.2, 210.0, 10));

        System.out.println("\n=== CATALOGO DE LA LUDOTECA ===");
        ludoteca.listar();

        System.out.println("\n=== BUSQUEDA ===");
        Videojuego buscado = ludoteca.buscarPorTitulo("The Witcher 3");
        if (buscado != null) {
            buscado.mostrarFicha();
        } else {
            System.out.println("Videojuego no encontrado.");
        }

        System.out.println("\n=== ESTADISTICAS ===");
        System.out.println("Puntuacion media: " + ludoteca.calcularPuntuacionMedia());

        Videojuego mejor = ludoteca.obtenerMejorValorado();
        if (mejor != null) {
            System.out.println("Mejor valorado: " + mejor.getTitulo() + " (" + mejor.getPuntuacion() + ")");
        }

        System.out.println("\n=== GUARDADO ===");
        ludoteca.guardarEnFichero(ficheroDatos);
    }
}
