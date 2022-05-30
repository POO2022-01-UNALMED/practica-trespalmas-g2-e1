package gestorAplicacion.food;

import gestorAplicacion.store.Cooler;

public class CoolIngredient extends Ingredient implements IngredientFuncs{

    private static int totalIngredient;
    private final int degrees;
    private int amount;

    // CONSTRUCTOR
    public CoolIngredient(String name, int amount){
        this(name, 5, amount);
    }
    public CoolIngredient(String name, int degrees, int amount){
        this(name, totalIngredient, TypeIngredient.DEFAULT, degrees, amount);
    }
    public CoolIngredient(String name, int id, TypeIngredient type, int degrees, int amount) {
        super(name, id* CoolConst, type);
        this.degrees = degrees;
        this.amount = amount;
        CoolIngredient.totalIngredient++;
    }

    // GETTERS AND SETTERS

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
        if ( ! (this.storage instanceof Cooler) ){
            return false;
        }
        if ( ((Cooler) storage).getDegrees() > this.degrees ) {
            return false;
        }

        this.amount += amount;
        this.storage.addIngredient(amount);
        return true;
    }

    @Override
    public String getId(){
        return "FO-" + this.id + "-" + this.name.charAt(0);
    }

}
