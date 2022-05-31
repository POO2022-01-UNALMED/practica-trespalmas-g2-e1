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
    public static ArrayList<Store> getAllStores(){return allStores;}
    public boolean removeFood(Ingredient ingredient){
        if (ingredient == null){
            return false;
        }
        if (!food.contains(ingredient)){
            return false;
        }
        this.food.remove(ingredient);
        this.actualAmount -= ingredient.getType().getSpace()*ingredient.getAmount();
        return true;
    }
    public boolean addFood(Ingredient ingredient, int amount){
        if ( ingredient == null ){
            return false;
        }
        int space = ingredient.getType().getSpace()*ingredient.getAmount();
        if ( this.getFreeAmount() < space ){
            return false;
        }
        this.food.add(ingredient);
        this.actualAmount += space;
        return true;
    }

    // METHODS
    public int addAmount(int amount){
        this.actualAmount += amount;
        return actualAmount;
    }
    public abstract String getId();
    public String genericId() {
        return "SE-" + this.hashCode();
    }

}
