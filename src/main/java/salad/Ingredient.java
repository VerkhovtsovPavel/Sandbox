package salad;

import salad.constant.Type;

public record Ingredient(Type type, int calories, int fats, int carbohydrates, int proteins) { }
