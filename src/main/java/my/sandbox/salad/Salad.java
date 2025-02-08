package my.sandbox.salad;

import java.util.HashMap;
import java.util.Map;

public class Salad {
    private final Map<Ingredient, Integer> recipe;

    public Salad() {
        this.recipe = new HashMap<>();
    }

    public void addIngredient(final Ingredient ingredient, final int weight) {
        recipe.put(ingredient, weight);
    }

    public Map<Ingredient, Integer> getRecipe() {
        return recipe;
    }
}
