package salad.constant;

import salad.Ingredient;

import static salad.constant.Type.*;

public interface IngredientsLibrary
{
    Ingredient TOMATO = new Ingredient(VEGETABLE, 1, 22, 3, 32);
    Ingredient CUCUMBER = new Ingredient(VEGETABLE, 5, 20, 13, 2);
    Ingredient SALT = new Ingredient(SEASONING, 100, 21, 6, 1);
    Ingredient OLIVE_OIL = new Ingredient(SAUCE, 1, 2, 3, 25);
}
