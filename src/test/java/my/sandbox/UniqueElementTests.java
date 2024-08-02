package my.sandbox;

import static my.sandbox.Small.uniqueElements;
import static my.sandbox.util.ParameterUtils.intArr;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import my.sandbox.common.structure.Pair;


public class UniqueElementTests {
	@Test(dataProvider = "arrays")
	public void validArray(Pair<int[], int[]> arrays) {
		int[] actual = uniqueElements(arrays.left());
		Assert.assertEquals(actual, arrays.right());
	}

	@Test
	public void emptyArray() {
		int[] emptyArray = new int[0];
		int[] actual = uniqueElements(emptyArray);
		Assert.assertEquals(actual, emptyArray);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void nullArray() {
		uniqueElements(null);
	}

	@DataProvider
	@SuppressWarnings("checkstyle:MagicNumber")
	Object[] arrays() {
		return new Object[] {
            new Pair<>(intArr(1, 2, 3, 1, 6, 3), intArr(1, 2, 3, 6)),
				new Pair<>(intArr(1, 2, 3, 1, 6, 3), intArr(1, 2, 3, 6)),
            new Pair<>(intArr(1, 2, 3), intArr(1, 2, 3)),
				new Pair<>(intArr(1, 1, 1, 1, 1, 1), intArr(1)),
            new Pair<>(intArr(3, 2, 1, 1, 2), intArr(3, 2, 1)),
				new Pair<>(intArr(1), intArr(1)) };
	}
}
