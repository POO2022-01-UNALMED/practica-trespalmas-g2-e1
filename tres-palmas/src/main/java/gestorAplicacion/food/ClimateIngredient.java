package gestorAplicacion.food;

public class ClimateIngredient extends Ingredient implements IngredientFuncs{

    private static final int ingredientConst = 680;
    private static int totalIngredient;
    private int amount;

    // CONSTRUCTOR
    public ClimateIngredient(String name, int amount) {
        this(name, totalIngredient, TypeIngredient.DEFAULT, amount);
    }
    public ClimateIngredient(String name, int id, TypeIngredient type, int amount) {
        super(name, ingredientConst*id, type);
        this.amount = amount;
        ClimateIngredient.totalIngredient++;
    }

    // GETTERS AND SETTERS

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
        this.amount += amount;
        return true;
    }

    public String getId(){
        return "C:"+ this.id + this.name.charAt(0);
    }
}
