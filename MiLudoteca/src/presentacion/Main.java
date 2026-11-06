package presentacion;

import dominio.Ludoteca;
import dominio.Videojuego;

public class Main {

    public static void main(String[] args) {
        Ludoteca ludoteca = new Ludoteca();

        // Los videojuegos se crean de forma independiente a la Ludoteca
        Videojuego v1 = new Videojuego("The Legend of Zelda", "Nintendo Switch", 98, 120);
        Videojuego v2 = new Videojuego("FIFA 24", "PlayStation 5", 70, 35);
        Videojuego v3 = new Videojuego("Minecraft", "PC", 90, 250);

        ludoteca.agregar(v1);
        ludoteca.agregar(v2);
        ludoteca.agregar(v3);

        System.out.println("Colección de la ludoteca:");
        System.out.println(ludoteca);

        // Búsqueda existente
        Videojuego encontrado = ludoteca.buscarPorTitulo("Minecraft");
        System.out.println("Búsqueda de 'Minecraft': " + encontrado);

        // Búsqueda inexistente
        Videojuego noEncontrado = ludoteca.buscarPorTitulo("Tetris");
        System.out.println("Búsqueda de 'Tetris': " + noEncontrado);
    }
}
