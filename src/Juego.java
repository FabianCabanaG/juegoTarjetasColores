import java.util.List;
import java.util.Scanner;

public class Juego {
    private Tablero tablero;
    private TurnoManager turnoManager;

    public Juego(List<Jugador> jugadores) {
        this.tablero = new Tablero(4, jugadores.size() * 2);
        this.turnoManager = new TurnoManager(jugadores);
    }

    public void jugar() {
        while (true) {
            Jugador jugadorActual = turnoManager.getJugadorActual();
            System.out.println("Turno de " + jugadorActual.getNombre());
            tablero.dibujarTablero();
            realizarJugada(jugadorActual);
            turnoManager.cambiarTurno();
            if (tablero.isCompleto()) {
                break;
            }
        }
        determinarGanador();
    }

    public Tablero getTablero() {
        return tablero;
    }
    private void realizarJugada(Jugador jugadorActual) {
        Scanner scanner = new Scanner(System.in);
        int[] posiciones = new int[2];

        // Seleccionar primera tarjeta
        System.out.println("Ingrese fila y columna de la primera tarjeta (separados por espacio):");
        String[] inputs = scanner.nextLine().split(" ");
        int fila1 = Integer.parseInt(inputs[0]);
        int columna1 = Integer.parseInt(inputs[1]);
        posiciones[0] = fila1 * tablero.getColumnas() + columna1;

        // Seleccionar segunda tarjeta
        System.out.println("Ingrese fila y columna de la segunda tarjeta (separados por espacio):");
        inputs = scanner.nextLine().split(" ");
        int fila2 = Integer.parseInt(inputs[0]);
        int columna2 = Integer.parseInt(inputs[1]);
        posiciones[1] = fila2 * tablero.getColumnas() + columna2;

        // Voltear tarjetas
        Tarjeta tarjeta1 = tablero.getTarjeta(fila1, columna1);
        Tarjeta tarjeta2 = tablero.getTarjeta(fila2, columna2);
        tarjeta1.voltear();
        tarjeta2.voltear();

        // Verificar si tienen el mismo color
        if (tarjeta1.getColor() == tarjeta2.getColor()) {
            System.out.println("Tarjetas coincidentes! Se quedan volteadas.");
            jugadorActual.sumarPuntuacion(1);
        } else {
            System.out.println("Tarjetas no coincidentes. Se vuelven a ocultar.");
            tarjeta1.voltear();
            tarjeta2.voltear();
        }

        tablero.dibujarTablero();
    }

    private void determinarGanador() {
        Jugador ganador = null;
        int maxPuntuacion = 0;
        for (Jugador jugador : turnoManager.getJugadores()) {
            if (jugador.getPuntuacion() > maxPuntuacion) {
                maxPuntuacion = jugador.getPuntuacion();
                ganador = jugador;
            }
        }
        System.out.println("Ganador: " + ganador.getNombre() + " con " + maxPuntuacion + " puntos");
    }
}