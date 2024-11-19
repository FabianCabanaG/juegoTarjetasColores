import java.util.ArrayList;
import java.util.List;

public class juegoTarjetasColores {
    public static void main(String[] args) {
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(new Jugador("Juan"));
        jugadores.add(new Jugador("María"));
        jugadores.add(new Jugador("Pedro"));
        jugadores.add(new Jugador("Ana"));

        Juego juego = new Juego(jugadores);
        Tablero tablero = juego.getTablero();
        System.out.println("Tablero completo:");
        imprimirTableroCompleto(tablero.getTableroCompleto());
        juego.jugar();
    }

    private static void imprimirTableroCompleto(Tarjeta[][] tableroCompleto) {
        for (int i = 0; i < tableroCompleto.length; i++) {
            for (int j = 0; j < tableroCompleto[0].length; j++) {
                System.out.print(tableroCompleto[i][j].getColor() + " ");
            }
            System.out.println();
        }
    }
}
