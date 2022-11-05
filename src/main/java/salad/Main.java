package salad;

import salad.constant.SortCriteria;

import static salad.constant.IngredientsLibrary.CUCUMBER;
import static salad.constant.IngredientsLibrary.OLIVE_OIL;
import static salad.constant.IngredientsLibrary.SALT;
import static salad.constant.IngredientsLibrary.TOMATO;

public class Main {

    public static void main(String[] args) {
        Salad simpleSalad = new Salad();
        simpleSalad.addIngredient(TOMATO, 150);
        simpleSalad.addIngredient(CUCUMBER, 100);
        simpleSalad.addIngredient(SALT, 3);
        simpleSalad.addIngredient(OLIVE_OIL, 30);

        FitnessGuru fitnessGuru = new FitnessGuru();
        var fatList = fitnessGuru.sortIngredients(simpleSalad, SortCriteria.FATS);
        var simpleSaladCalories = fitnessGuru.calories(simpleSalad);
        var caloriesFilter = fitnessGuru.calories(simpleSalad, 2, 25);
        System.out.println(fatList);
        System.out.println(simpleSaladCalories);
        System.out.println(caloriesFilter);
    }
}
