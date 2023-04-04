package my.sandbox.salad;

import java.util.HashMap;

public class Salad {

    private final HashMap<Ingredient, Integer> recipe;

    public Salad() {
        this.recipe = new HashMap<>();
    }

    public void addIngredient(final Ingredient ingredient, final int weight) {
        recipe.put(ingredient, weight);
    }

    public HashMap<Ingredient, Integer> getRecipe() {
        return recipe;
    }
}
