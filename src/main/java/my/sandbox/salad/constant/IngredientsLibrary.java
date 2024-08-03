package my.sandbox.salad.constant;

import my.sandbox.salad.Ingredient;

import static my.sandbox.salad.constant.Type.*;

public final class IngredientsLibrary {
    public static final Ingredient TOMATO = new Ingredient(VEGETABLE, 1, 22, 3, 32);
    public static final Ingredient CUCUMBER = new Ingredient(VEGETABLE, 5, 20, 13, 2);
    public static final Ingredient SALT = new Ingredient(SEASONING, 100, 21, 6, 1);
    public static final Ingredient OLIVE_OIL = new Ingredient(SAUCE, 1, 2, 3, 25);

    private IngredientsLibrary() {}
}
