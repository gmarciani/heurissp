package control;

import model.Solution;

public final class Faireness {
	
	public static final Solution maxMin(final Solution sols[]) {
		int mmsol = 0;
		for (int i = 0; i < sols.length - 1; i++) {
			int sum_i[] = sols[mmsol].getSum();
			int sum_j[] = sols[mmsol + 1].getSum();
			int min_sum_i = (sum_i[0] <= sum_i[1]) ? sum_i[0] : sum_i[1];
			int min_sum_j = (sum_j[0] <= sum_j[1]) ? sum_j[0] : sum_j[1];
			mmsol = (min_sum_i >= min_sum_j) ? i : i + 1;
		}
		
		return sols[mmsol];
	}
	
	public static final Solution kalaiSmorodinski(final Solution sols[], final int maxA, final int maxB) {
		int kssol = 0;
		for (int i = 0; i < sols.length - 1; i++) {
			int sum_i[] = sols[kssol].getSum();
			int sum_j[] = sols[kssol + 1].getSum();
			int min_sum_i = (sum_i[0] / maxA <= sum_i[1] / maxB) ? sum_i[0] / maxA : sum_i[1] / maxB;
			int min_sum_j = (sum_j[0] / maxA <= sum_j[1] / maxB) ? sum_j[0] / maxA : sum_j[1] / maxB;
			kssol = (min_sum_i >= min_sum_j) ? i : i + 1;
		}
		
		return sols[kssol];
	}
	
	public static final Solution proportional(final Solution sols[]) {	
		boolean found = false;
		int psol = 0;
		for (int i = 0; i < sols.length - 1; i++) {
			int sum_i[] = (found) ? sols[psol].getSum() : sols[i].getSum();
			int sum_j[] = sols[i + 1].getSum();
			if (sum_j[0] / sum_i[0] + sum_j[1] / sum_i[1] <= 2) {
				psol = i;
				found = true;
			} else if (sum_i[0] / sum_j[0] + sum_i[1] / sum_j[1] <= 2) {
				psol = i + 1;
				found = true;
			}
		}
		
		if (!found)
			return null;
		
		return sols[psol];
	}

}
