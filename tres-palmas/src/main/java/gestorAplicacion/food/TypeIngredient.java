package gestorAplicacion.food;

public enum TypeIngredient {
    DEFAULT("No identificado",1),
    CONDIMENTO("Condimento", 1),
    CARNE("Carne", 3),
    VERDURA("Verdura", 2),
    FRUTA("Fruta", 1),
    LACTEO("Lacteo", 2);

    private final String type;
    private final int space;

    // CONSTRUCTOR
    TypeIngredient(String type, int space) {
        this.type = type;
        this.space = space;
    }

    // METHODS
    public String getType() {
        return type;
    }

    public int getSpace() {
        return space;
    }
}
