package salad;

import java.util.HashMap;

public class Salad {

    private HashMap<Ingredient, Integer> recipe;

    public Salad() {
        this.recipe = new HashMap<>();
    }

    public void addIngredient(Ingredient ingredient, int weight) {
        recipe.put(ingredient, weight);
    }

    public HashMap<Ingredient, Integer> getRecipe() {
        return recipe;
    }
}
