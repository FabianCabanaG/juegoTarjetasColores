public class Tablero {
    private Tarjeta[][] tarjetas;
    private int filas;
    private int columnas;
    private Tarjeta[][] tableroCompleto;

    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.tarjetas = new Tarjeta[filas][columnas];
        this.tableroCompleto = new Tarjeta[filas][columnas];
        inicializarTarjetas();
        almacenarTableroCompleto();
    }

    private void inicializarTarjetas() {
        Tarjeta.Color[] colores = Tarjeta.Color.values();
        int numColores = colores.length;
        int index = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas / 2; j++) {
                Tarjeta.Color color = colores[index % numColores];
                tarjetas[i][j * 2] = new Tarjeta(color, index);
                tarjetas[i][j * 2 + 1] = new Tarjeta(color, index);
                index++;
            }
        }
    }

    public void dibujarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (tarjetas[i][j].isVisible()) {
                    System.out.print(tarjetas[i][j].getColor() + " ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    public void voltearTarjeta(int fila, int columna) {
        tarjetas[fila][columna].voltear();
    }

    public Tarjeta getTarjeta(int fila, int columna) {
        return tarjetas[fila][columna];
    }

    public int getColumnas() {
        return columnas;
    }

    public boolean isCompleto() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!tarjetas[i][j].isVisible()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void almacenarTableroCompleto() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tableroCompleto[i][j] = tarjetas[i][j];
            }
        }
    }

    public Tarjeta[][] getTableroCompleto() {
        return tableroCompleto;
    }
}