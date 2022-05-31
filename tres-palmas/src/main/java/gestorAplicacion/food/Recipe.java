package gestorAplicacion.food;

import java.io.Serializable;
import java.util.ArrayList;

public class Recipe implements Serializable {
    public static int total = 0;
    private String name;
    private final int id;
    private TypeRecipe type;
    private final ArrayList<Ingredient> ingredients;

    // CONSTRUCTORS
    public Recipe(String name){
        this(name, TypeRecipe.DEFAULT);
    }
    public Recipe(String name, TypeRecipe type){
        this(name, type, new ArrayList<Ingredient>());
    }
    public Recipe(String name, TypeRecipe type, ArrayList<Ingredient> ingredients) {
        this.name = name;
        this.id = Recipe.total;
        this.type = type;
        this.ingredients = ingredients;
        Recipe.total++;
    }

    // GETTERS AND SETTERS

    public String getName() {
        return name;
    }

    public String getId(){
        return "RE-"+ this.id + "-" + this.name.charAt(0);
    }

    public TypeRecipe getType() {
        return type;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(TypeRecipe type) {
        this.type = type;
    }

    // METHODS
    public String prepare(ArrayList<Integer> amounts, boolean replace){
        if ( amounts.size() != ingredients.size() ){
            return "Cantidad de Ingredientes inválida, se requieren " + ingredients.size() + " ingredientes";
        }
        String recipe = this.name+ "\tIngrediente\tCantidad\n";
        for (int i=0; i < ingredients.size(); i++){
            int amountToUse = amounts.get(i);
            Ingredient ingredientToUse = ingredients.get(i);
            if ( ingredientToUse.getAmount() < amountToUse && !replace){
                return "No hay suficiente " + ingredientToUse.getName() + " para la receta.";
            } else if (ingredientToUse.getAmount() < amountToUse && Ingredient.ingredientReplace(ingredientToUse) == null ) {
                return "No hay suficiente " + ingredientToUse.getName() + " para la receta." +
                        " Tampoco hay reemplazo";
            } else if (ingredientToUse.getAmount() < amountToUse) {
                ingredientToUse = Ingredient.ingredientReplace(ingredientToUse);
            }
            assert ingredientToUse != null;
            ingredientToUse.useIngredient(amountToUse);
            recipe += Ingredient.instructionIngredient(ingredientToUse) + "\t"+ ingredientToUse.getName()+"\t"+ amountToUse + "\n";
        }
        return recipe;
    }
}
