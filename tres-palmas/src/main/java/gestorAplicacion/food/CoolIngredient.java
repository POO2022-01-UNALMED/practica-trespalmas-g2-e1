package gestorAplicacion.food;

import gestorAplicacion.store.Cooler;

import java.io.Serializable;

public class CoolIngredient extends Ingredient implements IngredientFuncs, Serializable {

    private static int totalIngredient;
    private final int degrees;
    private int amount;

    // CONSTRUCTOR
    public CoolIngredient(String name, int amount){
        this(name, TypeIngredient.DEFAULT, 5, amount);
    }
    public CoolIngredient(String name, TypeIngredient type, int degrees, int amount){
        this(name, totalIngredient, type, degrees, amount);
    }
    public CoolIngredient(String name, int id, TypeIngredient type, int degrees, int amount) {
        super(name, id* CoolConst, type);
        this.degrees = degrees;
        this.amount = amount;
        CoolIngredient.totalIngredient++;
    }

    // GETTERS AND SETTERS

    @Override
    public int getAmount() {
        return amount;
    }

    public static int getTotalIngredient() {
        return totalIngredient;
    }

    public int getDegrees() {
        return degrees;
    }

    // METHODS

    public int useIngredient() {
        if (this.amount < 0){
            return -1;
        }
        this.amount -= 1;
        return amount;
    }

    public int useIngredient(int amount) {
        if (amount > this.amount){
            return -1;
        }
        this.amount -= amount;
        return amount;
    }

    public boolean addIngredient(int amount) {
        if ( this.storage == null ){
            return false;
        }
        if ( this.storage.getFreeAmount() < this.type.getSpace() * amount){
            return false;
        }
        if ( ! (this.storage instanceof Cooler) ){
            return false;
        }
        if ( ((Cooler) storage).getDegrees() > this.degrees ) {
            return false;
        }

        this.amount += amount;
        this.storage.addIngredient(amount*type.getSpace());
        return true;
    }

    @Override
    public String getId(){
        return "FO-" + this.id + "-" + this.name.charAt(0);
    }

    @Override
    public String toString() {
        return "CoolIngredient{" +
                "degrees=" + degrees +
                ", amount=" + amount +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", type=" + type +
                '}';
    }
}
