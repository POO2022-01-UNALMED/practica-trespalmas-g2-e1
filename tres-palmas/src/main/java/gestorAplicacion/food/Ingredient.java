package gestorAplicacion.food;

import gestorAplicacion.store.Backup;
import gestorAplicacion.store.Cooler;
import gestorAplicacion.store.Shelf;
import gestorAplicacion.store.Store;

import java.util.ArrayList;
import java.util.Objects;

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
        this.storage = new Backup(id);
        storage.getFood().add(this);
        Ingredient.allIngredients.add(this);
    }

    // METHODS
    public String getName(){
        return this.name;
    }
    public Store getStorage(){return this.storage;}
    abstract int getAmount();
    abstract int useIngredient();
    abstract int useIngredient(int amount);
    abstract boolean addIngredient(int amount);
    public abstract String getId();
    public String genericId(){
        return "IT-"+this.hashCode();
    }

    public static Ingredient ingredientReplace(String id){
        for (Ingredient ingredient:
             allIngredients) {
            if (id.charAt(0) == 'C'){
                if (Objects.equals( ((ClimateIngredient) ingredient).getId(), id)){
                    return ingredientReplace(ingredient);
                }
            } else if (id.charAt(0) == 'F') {
                if (Objects.equals( ((CoolIngredient) ingredient).getId(), id)){
                    return ingredientReplace(ingredient);
                }
            }
            if (Objects.equals(ingredient.name, id)){
                return ingredientReplace(ingredient);
            }
        }
        return null;
    }
    public static Ingredient ingredientReplace(Ingredient ingredient){
        for (Ingredient anotherIngredient:
             allIngredients) {
            if ( ingredient.equals(anotherIngredient) && anotherIngredient.getAmount() > 1){
                return anotherIngredient;
            }
        }
        return null;
    }
    public static String instructionIngredient(Ingredient ingredient){
        Store storage = ingredient.storage;
        if (storage == null){
            return "No Tiene Almacenamiento";
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!(o instanceof CoolIngredient && this instanceof CoolIngredient)) return false;
        Ingredient that = (Ingredient) o;
        return type == that.type;
    }

}
