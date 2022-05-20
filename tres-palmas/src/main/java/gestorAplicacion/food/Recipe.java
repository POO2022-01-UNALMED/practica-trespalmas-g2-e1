package gestorAplicacion.food;

import java.util.ArrayList;

public class Recipe{
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

    public int getId() {
        return id;
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



}
