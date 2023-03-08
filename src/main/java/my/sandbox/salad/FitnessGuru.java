package my.sandbox.salad;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FitnessGuru {

    public List<Ingredient> sortIngredients(Salad salad, Comparator<Ingredient> criteria) {
        var recipe = salad.getRecipe();
        var list = new ArrayList<>(recipe.keySet());
        list.sort(criteria);
        return list;
    }
    
    public int calories(Salad salad) {
       return salad.getRecipe().entrySet().stream().mapToInt((k) -> k.getKey().calories() * k.getValue()).sum();
    }

    public List<Ingredient> calories(Salad salad, int from, int to) {
        return salad.getRecipe().keySet().stream()
                .filter(i -> i.calories() >= from && i.calories() <= to)
                .collect(Collectors.toList());
    }
}
