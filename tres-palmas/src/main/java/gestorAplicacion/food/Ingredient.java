package gestorAplicacion.food;

import gestorAplicacion.store.Backup;
import gestorAplicacion.store.Cooler;
import gestorAplicacion.store.Shelf;
import gestorAplicacion.store.Store;

import java.util.ArrayList;

public abstract class Ingredient{
    protected String name;
    protected int id;
    protected TypeIngredient type;
    protected Store storage;
    private static final ArrayList<Ingredient> allIngredients = new ArrayList<Ingredient>();

    // CONSTRUCTOR
    public Ingredient(String name, int id, TypeIngredient type) {
        this.name = name;
        this.id = id;
        this.type = type;
        Ingredient.allIngredients.add(this);
    }

    // METHODS
    public String getName(){
        return this.name;
    }
    abstract int getAmount();
    abstract String getId();
    abstract int useIngredient();
    abstract int useIngredient(int amount);
    abstract boolean addIngredient(int amount);

    public static Ingredient ingredientReplace(Ingredient ingredient){
        for (Ingredient anotherIngredient:
             allIngredients) {
            if ( ingredient.type == anotherIngredient.type ){
                return anotherIngredient;
            }
        }
        return null;
    }
    public static String instructionIngredient(Ingredient ingredient){
        Store storage = ingredient.storage;
        if (storage instanceof Shelf){
            return ((Shelf) storage).getId();
        }
        if (storage instanceof Cooler){
            return ((Cooler) storage).getId();
        }
        if (storage instanceof Backup){
            return ((Backup) storage).getId();
        }
        return storage.getId();
    }
}
