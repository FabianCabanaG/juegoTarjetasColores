public class Jugador {
    // Atributos
    private String nombre;
    private int puntuacion;
    private boolean turno;

    // Constructor
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntuacion = 0;
        this.turno = false;
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public void sumarPuntuacion(int puntos) {
        this.puntuacion += puntos;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", puntuacion=" + puntuacion +
                ", turno=" + turno +
                '}';
    }
}