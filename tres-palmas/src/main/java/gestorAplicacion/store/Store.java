package gestorAplicacion.store;

import gestorAplicacion.food.Ingredient;

import java.util.ArrayList;

public abstract class Store {

    protected int id;
    protected int actualAmount;
    protected ArrayList<Ingredient> food = new ArrayList<Ingredient>();
    private static final ArrayList<Store> allStores = new ArrayList<Store>();
    protected static int totalStoresCreated;
    // CONSTRUCTOR
    public Store(int id) {
        this.id = id;
        allStores.add(this);
        totalStoresCreated++;
    }

    // GETTERS AND SETTERS
    public int getActualAmount() {
        return actualAmount;
    }
    public void setActualAmount(int actualAmount) {
        this.actualAmount = actualAmount;
    }
    public abstract int getFreeAmount();
    public ArrayList<Ingredient> getFood() {
        return food;
    }
    public ArrayList<Store> getAllStores(){return allStores;}

    // METHODS
    public int addIngredient(int amount){
        this.actualAmount += amount;
        return actualAmount;
    }
    public abstract String getId();
    public String genericId() {
        return "SE-" + this.hashCode();
    }

}
