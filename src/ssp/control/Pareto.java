package ssp.control;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import ssp.model.SumSolution;

public class Pareto {	
	
	private Pareto () {}

	public static SumSolution[] getOptimalSums(final int a[], final int b[], final int capacity) {
		Set<SumSolution> sums = new HashSet<SumSolution>();
		int c = capacity;
		while (c >= 0) {
			int sumA = Knapsack.getMaxSum(a, c);
			int sumB = Knapsack.getMaxSum(b, capacity - sumA);
			SumSolution sum = new SumSolution(sumA, sumB);
			sums.add(sum);
			c--;
		}		
		Set<SumSolution> doms = getDominants(sums);
		return doms.toArray(new SumSolution[doms.size()]);
	}
	
	private static final Set<SumSolution> getDominants(final Set<SumSolution> sums) {
		Set<SumSolution> doms = new HashSet<SumSolution>();
		if (sums == null || sums.isEmpty())
			return null;
		for (SumSolution sum_i : sums) {
			for (SumSolution sum_j : sums.stream().filter(s -> s.getA() == sum_i.getA()).collect(Collectors.toList())) {
				if (sum_i.getB() >= sum_j.getB()) {					
					if (doms.contains(sum_j)) doms.remove(sum_j);
					doms.add(sum_i);
				} else {
					if (doms.contains(sum_i)) doms.remove(sum_i);
					doms.add(sum_j);
				}
			}				
		}			
		return doms;
	}

}
