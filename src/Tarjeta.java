public class Tarjeta {
    // Enum para representar los colores
    public enum Color {
        ROJO, VERDE, AZUL, AMARILLO, MORADO, NARANJA, NEGRO, BLANCO
    }
    private Color color;
    private boolean visible;
    private int id;

    public Tarjeta(Color color, int id) {
        this.color = color;
        this.visible = false;
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public boolean isVisible() {
        return visible;
    }

    public void voltear() {
        visible = !visible;
    }

    public int getId() {
        return id;
    }
}