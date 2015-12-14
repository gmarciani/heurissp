package knapsack;

import org.junit.Test;

import ssp.control.Knapsack;

public class KnapsackTest {

	@Test
	public void test() {
		int elements[] = {3,5,7};
		int maxSum = Knapsack.getMaxSum(elements, 3);
		System.out.println(maxSum);
	}

}
