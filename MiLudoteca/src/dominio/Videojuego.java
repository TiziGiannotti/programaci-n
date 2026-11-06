package dominio;

public class Videojuego {
    // REQ-01: Atributos privados
    private String titulo;
    private String plataforma;
    private int puntuacion;
    private int horasJugadas;
    public Videojuego(String titulo, String plataforma, int puntuacion, int horasJugadas) {
        setTitulo(titulo);
        setPlataforma(plataforma);
        setPuntuacion(puntuacion);
        setHorasJugadas(horasJugadas);
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        if (titulo != null && !titulo.trim().isEmpty()) {
            this.titulo = titulo;
        } else {
            this.titulo = "Sin título";
        }
    }
    public String getPlataforma() {
        return plataforma;
    }
    public void setPlataforma(String plataforma) {
        if (plataforma != null && !plataforma.trim().isEmpty()) {
            this.plataforma = plataforma;
        } else {
            this.plataforma = "Desconocida";
        }
    }
    public int getPuntuacion() {
        return puntuacion;
    }
    public void setPuntuacion(int puntuacion) {
        if (puntuacion >= 0 && puntuacion <= 100) {
            this.puntuacion = puntuacion;
        } else {
            this.puntuacion = 0; // Valor seguro por defecto
        }
    }
    public int getHorasJugadas() {
        return horasJugadas;
    }
    public void setHorasJugadas(int horasJugadas) {
        if (horasJugadas >= 0) {
            this.horasJugadas = horasJugadas;
        } else {
            this.horasJugadas = 0; // Evita valores negativos
        }
    }
    @Override
    public String toString() {
        return "Videojuego: " + titulo + 
               " | Plataforma: " + plataforma + 
               " | Puntuación: " + puntuacion + "/100" + 
               " | Horas: " + horasJugadas + "h";
    }
}