import java.util.List;

public class TurnoManager {
    private List<Jugador> jugadores;
    private int indiceActual;

    public TurnoManager(List<Jugador> jugadores) {
        this.jugadores = jugadores;
        this.indiceActual = 0;
    }

    public void cambiarTurno() {
        indiceActual = (indiceActual + 1) % jugadores.size();
    }

    public Jugador getJugadorActual() {
        return jugadores.get(indiceActual);
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }
}