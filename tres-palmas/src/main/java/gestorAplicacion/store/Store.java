package gestorAplicacion.store;

import gestorAplicacion.food.Ingredient;

import java.util.ArrayList;

public abstract class Store {

    protected int id;
    protected int actualAmount;
    protected ArrayList<Ingredient> food;

    // CONSTRUCTOR
    public Store(int id) {
        this.id = id;
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

    // METHODS
    public int addIngredient(int amount){
        this.actualAmount += amount;
        return actualAmount;
    }
    public String getId() {
        return "SE-" + this.hashCode();
    }

}
