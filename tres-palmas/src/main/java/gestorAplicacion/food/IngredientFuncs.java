package gestorAplicacion.food;

public interface IngredientFuncs {
    int useIngredient();
    int useIngredient(int amount);
    boolean addIngredient(int amount);
    String getId();
}
