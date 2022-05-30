package gestorAplicacion.food;

public enum TypeRecipe {
    DEFAULT("Comida del Día"),
    TROPICAL("Comida Tropical"),
    ESPECIAL("Comida Especial"),
    EJECUTIVO("Comida Ejecutiva"),
    BEBIDA("Bebida");

    private final String type;

    // CONSTRUCTOR
    TypeRecipe(String type) {
        this.type = type;
    }

    // METHOD
    public String getType() {
        return type;
    }
}
