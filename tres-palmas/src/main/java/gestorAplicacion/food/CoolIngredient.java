package gestorAplicacion.food;

public class CoolIngredient extends Ingredient implements IngredientFuncs{

    private static final int ingredientConst = 394;
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
        super(name, id* ingredientConst, type);
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
        this.amount += amount;
        return true;
    }

    public String getId(){
        return "F:" + this.id + this.name.charAt(0);
    }

}
