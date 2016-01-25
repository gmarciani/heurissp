package com.gmarciani.ssp.control;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.gmarciani.ssp.model.SumSolution;

public final class Pareto {

	private Pareto () {}

	public static SumSolution[] getOptimalSums(final int a[], final int b[], final int capacity) {
		Set<SumSolution> sums = new HashSet<SumSolution>();
		int c = capacity;
		while (c >= 0) {
			float sumA = Knapsack.getMaxSum(a, c);
			float sumB = Knapsack.getMaxSum(b, Math.round(capacity - sumA));
			SumSolution sum = new SumSolution(sumA, sumB);
			sums.add(sum);
			c--;
		}
		Set<SumSolution> dominants = getDominants(sums);
		return dominants.toArray(new SumSolution[dominants.size()]);
	}

	private static final Set<SumSolution> getDominants(final Set<SumSolution> sums) {
		if (sums == null || sums.isEmpty())
			return null;
		Set<SumSolution> dominants = new HashSet<SumSolution>(sums);
		Iterator<SumSolution> iter = dominants.iterator();
		while (iter.hasNext()) {
			SumSolution sum = iter.next();
			if (SumSolution.isDominated(sum, dominants))
				iter.remove();
		}

		return dominants;
	}

}
