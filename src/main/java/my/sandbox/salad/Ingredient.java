package my.sandbox.salad;

import my.sandbox.salad.constant.Type;

public record Ingredient(Type type, int calories, int fats, int carbohydrates, int proteins) { }
