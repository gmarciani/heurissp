package ssp.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumSolution {
	
	private int sumA;
	private int sumB;
	
	public SumSolution(final int sumA, final int sumB) {
		this.sumA = sumA;
		this.sumB = sumB;
	}
	
	public int getA() {
		return this.sumA;
	}
	
	public int getB() {
		return this.sumB;
	}
	
	@Override
	public String toString() {
		return "{" + this.sumA + "," + this.sumB + "}";
	}
	
	public static SumSolution parse(final String str) {
		final String regex = "\\{(\\d+),(\\d+)\\}";
		
		
		Pattern ptrn = Pattern.compile(regex);
		Matcher mtcr = ptrn.matcher(str);
		mtcr.find();
		
		int sumA = Integer.valueOf(mtcr.group(1));
		int sumB = Integer.valueOf(mtcr.group(2));
		
		return new SumSolution(sumA, sumB);
	}

}
