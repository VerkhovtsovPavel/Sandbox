package salad;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

import static salad.constant.SortCriteria.CALORIES;
import static salad.constant.SortCriteria.CARBOHYDRATES;
import static salad.constant.SortCriteria.FATS;
import static salad.constant.SortCriteria.PROTEINS;
import static salad.constant.SortCriteria.TYPE;
import static salad.constant.Type.FRUIT;
import static salad.constant.Type.NUT;
import static salad.constant.Type.SAUCE;
import static salad.constant.Type.SEASONING;
import static salad.constant.Type.VEGETABLE;

public class FitnessGuruTest {

    private final FitnessGuru fitnessGuru = new FitnessGuru();
    private final Salad salad = new Salad();
    private final Ingredient caloriesVegetable = new Ingredient(VEGETABLE, 10, 2, 2, 2);
    private final Ingredient fattyNut = new Ingredient(NUT, 1, 10, 1, 1);
    private final Ingredient carbohydrateFruit = new Ingredient(FRUIT, 3, 3, 10, 3);
    private final Ingredient proteinsSauce = new Ingredient(SAUCE, 4, 4, 4, 10);
    private final Ingredient balancedSeasoning = new Ingredient(SEASONING, 5, 5, 5, 5);

    @BeforeClass
    private void initSalad() {
        salad.addIngredient(caloriesVegetable, 100);
        salad.addIngredient(fattyNut, 100);
        salad.addIngredient(carbohydrateFruit, 100);
        salad.addIngredient(proteinsSauce, 100);
        salad.addIngredient(balancedSeasoning, 100);
    }

    @Test(dataProvider = "sortConditions")
    public void sorting(Comparator<Ingredient> sortCondition, List<Ingredient> expectedOrder) {
        Assert.assertEquals(fitnessGuru.sortIngredients(salad, sortCondition),
                expectedOrder, "Sorting order is incorrect");
    }

    @Test
    public void calories() {
        Assert.assertEquals(fitnessGuru.calories(salad),
                2300, "Calories calculation is incorrect");
    }

    @Test
    public void caloriesInInterval() {
        List<Ingredient> expectedIngredients = List.of(balancedSeasoning, caloriesVegetable);
        List<Ingredient> actualIngredients = fitnessGuru.calories(salad, 5, 10);

        Assert.assertEquals(actualIngredients.size(), expectedIngredients.size(), "Lists have different size");
        Assert.assertTrue(actualIngredients.containsAll(expectedIngredients), "Calories filtering is incorrect");
    }

    @DataProvider(name = "sortConditions")
    private Object[][] sortConditions() {
        return new Object[][]
        {
                {TYPE,          List.of(caloriesVegetable, carbohydrateFruit, proteinsSauce, fattyNut, balancedSeasoning)},
                {FATS,          List.of(caloriesVegetable, carbohydrateFruit, proteinsSauce, balancedSeasoning, fattyNut)},
                {CARBOHYDRATES, List.of(fattyNut, caloriesVegetable, proteinsSauce, balancedSeasoning, carbohydrateFruit)},
                {CALORIES,      List.of(fattyNut, carbohydrateFruit, proteinsSauce, balancedSeasoning, caloriesVegetable)},
                {PROTEINS,      List.of(fattyNut, caloriesVegetable, carbohydrateFruit, balancedSeasoning, proteinsSauce)}
        };
    }


}
