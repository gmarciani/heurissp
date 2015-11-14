package ssp.control;

public final class Knapsack {
	
	public static int getMaxSum(int weights[], int capacity) {
		if (capacity == 0)
			return 0;
		
        int N = weights.length;
        int[][] V = new int[N + 1][capacity + 1]; 

        for (int col = 0; col <= capacity; col++)
            V[0][col] = 0;
        
        for (int row = 0; row <= N; row++)
            V[row][0] = 0;
        
        for (int item = 1; item <= N; item++) {
            for (int weight = 1; weight <= capacity; weight++) {
                if (weights[item - 1] <= weight)
                	V[item][weight] = Math.max(weights[item - 1] + V[item - 1][weight - weights[item - 1]], V[item - 1][weight]);
                else
                	V[item][weight] = V[item - 1][weight];
             }
        }
        
        return V[N][capacity];
	}

}
