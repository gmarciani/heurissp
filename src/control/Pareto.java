package control;

import java.util.ArrayList;
import java.util.List;

import model.SSPList;
import model.Solution;

public class Pareto {	
	
	private Pareto () {}

	public static Solution[] getOptimalSolutions(final SSPList a, final SSPList b, final int c) {
		List<Solution> psols = new ArrayList<Solution>();

		//
		
		return psols.toArray(new Solution[psols.size()]);
	}
	
	public static int knapsack(int wt[], int W) {
        int N = wt.length;
        int[][] V = new int[N + 1][W + 1]; 

        for (int col = 0; col <= W; col++)
            V[0][col] = 0;
        
        for (int row = 0; row <= N; row++)
            V[row][0] = 0;
        
        for (int item = 1; item <= N; item++) {
            for (int weight = 1; weight <= W; weight++) {
                if (wt[item - 1] <= weight)
                	V[item][weight] = Math.max(wt[item - 1] + V[item - 1][weight - wt[item - 1]], V[item - 1][weight]);
                else
                	V[item][weight] = V[item - 1][weight];
             }
        }
        
        return V[N][W];
	}

}
