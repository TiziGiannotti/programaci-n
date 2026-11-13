package dominio;
public class Videojuego {
    private final String titulo;
    private final String plataforma;
    private double puntuacion;
    private double horasJugadas;
 
    public Videojuego(String titulo, String plataforma, double puntuacion, double horasJugadas) {
        this.titulo = titulo;
        this.plataforma = plataforma;
        if (puntuacion >= 0 && puntuacion <= 10) {
            this.puntuacion = puntuacion;
        }
        if (horasJugadas >= 0) {
            this.horasJugadas = horasJugadas;
        }
    }
 
    public String getTitulo() { return titulo; }
    public String getPlataforma() { return plataforma; }
    public double getPuntuacion() { return puntuacion; }
    public double getHorasJugadas() { return horasJugadas; }
 
    public void setPuntuacion(double puntuacion) {
        if (puntuacion >= 0 && puntuacion <= 10) {
            this.puntuacion = puntuacion;
        }
    }
 
    public void setHorasJugadas(double horasJugadas) {
        if (horasJugadas >= 0) {
            this.horasJugadas = horasJugadas;
        }
    }
 
    public String descripcion() {
        return titulo + " (" + plataforma + ") - Puntuación: " + puntuacion
                + " - Horas jugadas: " + horasJugadas;
    }
 
    @Override
    public String toString() {
        return descripcion();
    }
}
