package ssp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

	private List<Integer> setA;
	private List<Integer> setB;
	
	public Solution(final List<Integer> setA, final List<Integer> setB) {
		this.setA = setA;
		this.setB = setB;
	}
	
	public Solution(final int setA[], final int setB[]) {
		List<Integer> setAList = new ArrayList<Integer>(setA.length);
		List<Integer> setBList = new ArrayList<Integer>(setB.length);
		for (int val : setA) setAList.add(val);
		for (int val : setB) setBList.add(val);
		this.setA = setAList;
		this.setB = setBList;
	}
	
	public Solution() {
		this.setA = new ArrayList<Integer>();
		this.setB = new ArrayList<Integer>();
	}
	
	public List<Integer> getA() {
		return this.setA;
	}
	
	public List<Integer> getB() {
		return this.setB;
	}
	
	public SumSolution getSum() {
		int sumA = 0;
		int sumB = 0;
		
		for (Integer val : this.getA())
			sumA += val;
		
		for (Integer val : this.getB())
			sumB += val;
		
		return new SumSolution(sumA, sumB);
	}	
	
	@Override
	public String toString() {
		return "{" + this.getA() + "," + this.getB() + "}";
	}

	public static SumSolution[] getSums(Solution[] sols) {
		SumSolution sums[] = new SumSolution[sols.length];
		
		for (int i = 0; i < sols.length; i++)
			sums[i] = sols[i].getSum();
		
		return sums;
	}

	public static Solution parse(String str) {
		Solution sol = new Solution();
		String regex = "\\{\\[(\\d+(?:,\\d+)*)\\],\\[(\\d+(?:,\\d+)*)\\]\\}";
		
		Pattern ptrn = Pattern.compile(regex);
		Matcher mtcr = ptrn.matcher(str);
		
		mtcr.find();
		
		String strA = mtcr.group(1);
		String strB = mtcr.group(2);
		
		String strAvals[] = strA.split(",");
		String strBvals[] = strB.split(",");
		
		for (String val : strAvals)
			sol.getA().add(Integer.valueOf(val));
		
		for (String val : strBvals)
			sol.getB().add(Integer.valueOf(val));
		
		return sol;
	}
}
