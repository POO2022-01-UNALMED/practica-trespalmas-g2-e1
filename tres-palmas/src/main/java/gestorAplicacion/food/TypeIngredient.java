package gestorAplicacion.food;

public enum TypeIngredient {
    DEFAULT("No identificado",1),
    CONDIMENTO("Condimento", 1),
    CARNE("Carne", 3),
    VERDURA("Verdura", 2),
    FRUTA("Fruta", 1),
    LACTEO("Lacteo", 2);

    private final String name;
    private final int space;

    // CONSTRUCTOR
    TypeIngredient(String name, int space) {
        this.name = name;
        this.space = space;
    }

    // METHODS
    public String getName() {
        return name;
    }

    public int getSpace() {
        return space;
    }
}
