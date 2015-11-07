package model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.MutablePair;

public class Solution extends MutablePair<List<Integer>, List<Integer>> {

	private static final long serialVersionUID = -8136519204641620720L;
	
	public Solution(final List<Integer> solA, final List<Integer> solB) {
		super();
		super.setLeft(solA);
		super.setRight(solB);
	}
	
	public Solution(final int solA[], final int solB[]) {
		super();
		List<Integer> solAList = new ArrayList<Integer>(solA.length);
		List<Integer> solBList = new ArrayList<Integer>(solB.length);
		for (int val : solA) solAList.add(val);
		for (int val : solB) solBList.add(val);
		super.setLeft(solAList);
		super.setRight(solBList);
	}
	
	public List<Integer> getA() {
		return super.getLeft();
	}
	
	public List<Integer> getB() {
		return super.getRight();
	}
	
	public int[] getSum() {
		int sum[] = {0, 0};
		
		for (Integer val : this.getA())
			sum[0] += val;
		
		for (Integer val : this.getB())
			sum[1] += val;
		
		return sum;
	}

}
