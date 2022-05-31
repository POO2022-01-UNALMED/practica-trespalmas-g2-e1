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
        this.storage = new Backup(id+1);
        storage.getFood().add(this);
        Ingredient.allIngredients.add(this);
    }

    // METHODS
    public String getName(){
        return this.name;
    }
    public Store getStorage(){return this.storage;}
    public static ArrayList<Ingredient> getAllIngredients(){return Ingredient.allIngredients;}
    public abstract int getAmount();
    public TypeIngredient getType(){return type;}
    abstract int useIngredient();
    abstract int useIngredient(int amount);
    public abstract boolean addIngredient(int amount);
    public abstract String getId();
    public abstract boolean isValidStore(Store store);
    public String genericId(){
        return "IT-"+this.hashCode();
    }
    public static Ingredient getIngredientById(String id){
        for (Ingredient ingredient:
             allIngredients) {
            if (id.charAt(0) == 'C'){
                if (Objects.equals( ((ClimateIngredient) ingredient).getId(), id)){
                    return ingredient;
                }
            } else if (id.charAt(0) == 'F') {
                if (Objects.equals( ((CoolIngredient) ingredient).getId(), id)){
                    return ingredient;
                }
            }
            if (Objects.equals(ingredient.name, id)){
                return ingredient;
            }
        }
        return null;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!(o instanceof CoolIngredient && this instanceof CoolIngredient)) return false;
        Ingredient that = (Ingredient) o;
        return type == that.type;
    }

}
