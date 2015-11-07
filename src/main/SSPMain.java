package main;

import java.util.Collections;

import control.Faireness;
import control.Solver;
import model.SSPList;
import model.Solution;
import view.UIManager;

public class SSPMain {

	public static void main(String[] args) {	
		UIManager.welcome();
		
		SSPList a = getA(args);
		SSPList b = getB(args);
		int c = getCapacity(args);
		
		System.out.printf("Set-A: %s\n", a);
		System.out.printf("Set-B: %s\n", b);
		System.out.printf("Capacity: %d\n", c);
		
		Solver solver = new Solver(a, b, c);
		
		Solution sols[] = solver.getParetoOptimalSolutions();
		
		Solution solMaxMin = Faireness.maxMin(sols);
		Solution solKalaiSmorodinski = Faireness.kalaiSmorodinski(sols, Collections.max(a), Collections.max(b));
		Solution solProportional = Faireness.proportional(sols);
		
		System.out.printf("Max-Min Faireness: %s\n", solMaxMin);
		System.out.printf("Kalai-Smorodinski Faireness: %s\n", solKalaiSmorodinski);
		System.out.printf("Proportional Faireness: %s\n", solProportional);
		
		UIManager.goodbye();
	}	

	private static SSPList getA(String[] args) {
		SSPList a = new SSPList();
		String[] values = args[0].split(",");
		for (String value : values)
			a.add(Integer.valueOf(value));
		return a;
	}
	
	private static SSPList getB(String[] args) {
		SSPList b = new SSPList();
		String[] values = args[1].split(",");
		for (String value : values)
			b.add(Integer.valueOf(value));
		return b;
	}
	
	private static int getCapacity(String[] args) {
		int capacity;
		String value = args[2];
		capacity = Integer.valueOf(value);
		return capacity;
	}

}
