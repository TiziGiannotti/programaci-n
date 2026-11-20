package presentacion;
package presentacion;

import dominio.*;

public class Main {
    public static void main(String[] args) {
        Ludoteca ludoteca = new Ludoteca();

        ludoteca.añadir(new VideojuegoDeportivo(...));
        ludoteca.añadir(new VideojuegoRol(...));
        ludoteca.añadir(new VideojuegoEstrategia(...));
        ludoteca.añadir(new VideojuegoOnline(...));

        System.out.println("=== CATALOGO DE LA LUDOTECA ===");
        ludoteca.listar();

        System.out.println("\n=== BUSQUEDA ===");
        Videojuego buscado = ludoteca.buscarPorTitulo("NombreDeUnJuegoDeTuLista");
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
    }
}