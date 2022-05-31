package gestorAplicacion.food;

import java.io.Serializable;

public class ClimateIngredient extends Ingredient implements IngredientFuncs, Serializable {

    private static int totalIngredient;
    private int amount;

    // CONSTRUCTOR
    public ClimateIngredient(String name, TypeIngredient type, int amount) {
        this(name, totalIngredient, type, amount);
    }
    public ClimateIngredient(String name, int id, TypeIngredient type, int amount) {
        super(name, id*ClimateConst, type);
        this.amount = amount;
        ClimateIngredient.totalIngredient++;
    }

    // GETTERS AND SETTERS
    @Override
    public int getAmount() {
        return amount;
    }
    public static int getTotalIngredient() {
        return totalIngredient;
    }

    // METHODS
    public int useIngredient(){
        if (this.amount < 0){
            return -1;
        }
        this.amount -= 1;
        return amount;
    }
    public int useIngredient(int amount){
        if (amount > this.amount){
            return -1;
        }
        this.amount -= amount;
        return amount;
    }
    public boolean addIngredient(int amount){
        if ( this.storage == null ){
            return false;
        }
        if ( this.storage.getFreeAmount() < this.type.getSpace() * amount){
            return false;
        }
        this.amount += amount;
        this.storage.addIngredient(amount*type.getSpace());
        return true;
    }
    @Override
    public String getId(){
        return "CA-"+ this.id + "-" + this.name.charAt(0);
    }

    @Override
    public String toString() {
        return "ClimateIngredient{" +
                "amount=" + amount +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", type=" + type +
                '}';
    }
}
