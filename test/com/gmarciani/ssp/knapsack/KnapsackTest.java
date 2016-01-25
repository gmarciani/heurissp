package com.gmarciani.ssp.knapsack;

import org.junit.Test;

import com.gmarciani.ssp.control.Knapsack;

public class KnapsackTest {

	@Test
	public void test() {
		int elements[] = {3,5,7};
		float maxSum = Knapsack.getMaxSum(elements, 3);
		System.out.println(maxSum);
	}

}
