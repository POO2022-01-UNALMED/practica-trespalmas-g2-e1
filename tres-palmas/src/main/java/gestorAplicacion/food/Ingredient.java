package gestorAplicacion.food;

import gestorAplicacion.store.Store;

public abstract class Ingredient{
    protected String name;
    protected int id;
    protected TypeIngredient type;
    protected Store storage;

    // CONSTRUCTOR
    public Ingredient(String name, int id, TypeIngredient type) {
        this.name = name;
        this.id = id;
        this.type = type;
    }

    // METHODS
    abstract String getId();
    abstract int useIngredient();
    abstract int useIngredient(int amount);
    abstract boolean addIngredient(int amount);

}
