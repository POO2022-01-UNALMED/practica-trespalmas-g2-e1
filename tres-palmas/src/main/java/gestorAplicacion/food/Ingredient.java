package gestorAplicacion.food;

public abstract class Ingredient{
    protected String name;
    protected int id;
    protected TypeIngredient type;

    // CONSTRUCTOR
    public Ingredient(String name, int id, TypeIngredient type) {
        this.name = name;
        this.id = id;
        this.type = type;
    }

    // METHODS

}
