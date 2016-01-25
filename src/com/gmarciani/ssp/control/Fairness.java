package com.gmarciani.ssp.control;

import java.util.List;
import java.util.ArrayList;

import com.gmarciani.ssp.model.Solution;
import com.gmarciani.ssp.model.SumSolution;

public final class Fairness {

	public static final Solution maxMin(final Solution sols[]) {
		if (sols == null || sols.length == 0)
			return null;
		SumSolution sums[] = Solution.getSums(sols);
		int sol_id = sum_maxMin(sums);
		if (sol_id == -1)
			return null;
		return sols[sol_id];
	}

	public static final int sum_maxMin(final SumSolution sums[]) {
		if (sums == null || sums.length == 0)
			return -1;
		int sol = 0;
		for (int i = 0; i < sums.length; i++) {
			SumSolution sum_sol = sums[sol];
			SumSolution sum_cur = sums[i];
			float min_sum_sol = Math.min(sum_sol.getA(), sum_sol.getB());
			float min_sum_cur = Math.min(sum_cur.getA(), sum_cur.getB());
			sol = (min_sum_sol >= min_sum_cur) ? sol : i;
		}
		return sol;
	}

	public static final Solution kalaiSmorodinski(final Solution sols[], final float maxA, final float maxB) {
		if (sols == null || sols.length == 0)
			return null;
		SumSolution sums[] = Solution.getSums(sols);
		int sol_id = sum_kalaiSmorodinski(sums, maxA, maxB);
		if (sol_id == -1)
			return null;
		return sols[sol_id];
	}

	public static final int sum_kalaiSmorodinski(final SumSolution sums[], final float maxA, final float maxB) {
		if (sums == null || sums.length == 0)
			return -1;
		int sol = 0;
		for (int i = 0; i < sums.length; i++) {
			SumSolution sum_sol = sums[sol];
			SumSolution sum_cur = sums[i];

			float min_sum_sol = Math.min(sum_sol.getA() / maxA, sum_sol.getB() / maxB);
			float min_sum_cur = Math.min(sum_cur.getA() / maxA, sum_cur.getB() / maxB);
			sol = (min_sum_sol >= min_sum_cur) ? sol : i;
		}
		return sol;
	}

	public static final Solution proportional(final Solution sols[]) {
		if (sols == null || sols.length == 0)
			return null;
		SumSolution sums[] = Solution.getSums(sols);
		int sol_id = sum_proportional(sums);
		if (sol_id == -1)
			return null;
		return sols[sol_id];
	}

	public static final int sum_proportional(final SumSolution sums[]) {
		if (sums == null || sums.length == 0)
			return -1;
		boolean found = false;
		int sol = -1;
		List<SumSolution> delList = new ArrayList<SumSolution>();
		for (int i = 0; i < sums.length - 1; i++) {
			SumSolution sum_i = (found) ? sums[sol] : sums[i];
			SumSolution sum_j = sums[i + 1];
			if (delList.contains(sum_i) || delList.contains(sum_j))
				continue;
			System.out.println("sum_i: " + sum_i);
			System.out.println("sum_j: " + sum_j);
			if (sum_i.getA() != 0 && sum_i.getB() != 0) {
				if (sum_j.getA() / sum_i.getA() + sum_j.getB() / sum_i.getB() <= 2.0) {
					System.out.println("i è ok");
					if (!found) {
						sol = i;
						found = true;				
						System.out.println("found true");
					}
				} else {
					if (found) {
						found = false;
						System.out.println("found false");
						delList.add(sum_i);
					}
				}
				
			}

			if (sum_j.getA() != 0 && sum_j.getB() != 0) {
				if (sum_i.getA() / sum_j.getA() + sum_i.getB() / sum_j.getB() <= 2.0) {
					System.out.println("j è ok");
					sol = i + 1;
					found = true;
					System.out.println("found true");
				} else {
					delList.add(sum_j);
				}
			}
			
			if (!found)
				sol = -1;
			
			System.out.println("sol: " + ((sol!=-1)?sums[sol]:"none"));
		}

		return sol;
	}

}
