package presentacion;

import dominio.Videojuego;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Videojuego> ludoteca = new ArrayList<>();

        ludoteca.add(new Videojuego("The Legend of Zelda: Tears of the Kingdom", "Nintendo Switch", 96, 85));
        ludoteca.add(new Videojuego("Elden Ring", "PC", 95, 120));
        ludoteca.add(new Videojuego("God of War Ragnarok", "PlayStation 5", 94, 45));
        ludoteca.add(new Videojuego("Hollow Knight", "PC", 90, 60));
        ludoteca.add(new Videojuego("Cyberpunk 2077", "PC", 86, 70));

        // REQ-05: Mostrar el total de elementos con size()
        System.out.println("Total de videojuegos en la ludoteca: " + ludoteca.size());
        System.out.println("--------------------------------------------------");

        for (Videojuego juego : ludoteca) {
            System.out.println(juego);
        }
    }
}