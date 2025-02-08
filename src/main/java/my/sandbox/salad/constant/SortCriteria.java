package my.sandbox.salad.constant;

import java.util.Comparator;
import java.util.function.Function;

import my.sandbox.salad.Ingredient;

public enum SortCriteria implements Comparator<Ingredient> {
    TYPE(i -> i.type().ordinal()),
    FATS(Ingredient::fats),
    CARBOHYDRATES(Ingredient::carbohydrates),
    PROTEINS(Ingredient::proteins),
    CALORIES(Ingredient::calories);

    private final Function<Ingredient, Integer> propertyGetter;

    SortCriteria(Function<Ingredient, Integer> propertyGetter) {
        this.propertyGetter = propertyGetter;
    }

    @Override
    public int compare(Ingredient o1, Ingredient o2) {
        return propertyGetter.apply(o1) - propertyGetter.apply(o2);
    }
}
