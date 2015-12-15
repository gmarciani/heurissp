package ssp.model;

import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumSolution implements Comparable<SumSolution> {
	
	private float sumA;
	private float sumB;
	
	public SumSolution(final float sumA, final float sumB) {
		this.sumA = sumA;
		this.sumB = sumB;
	}
	
	public float getA() {
		return this.sumA;
	}
	
	public float getB() {
		return this.sumB;
	}	
	
	public static boolean isDominated(final SumSolution sum, final Set<SumSolution> sums) {
		for (SumSolution other_sum : sums) {
			if (sum.equals(other_sum))
				continue;
			if (sum.getA() == other_sum.getA() && sum.getB() < other_sum.getB())
				return true;
			if (sum.getB() == other_sum.getB() && sum.getA() < other_sum.getA())
				return true;
		}
		
		return false;
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

	@Override
	public int compareTo(SumSolution other) {
		if (this.getA() > other.getA())
			return 1;
		else if (this.getA() < other.getA())
			return -1;
		else
			return Double.compare(this.getB(), other.getB());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this.getClass() != obj.getClass())
			return false;
		SumSolution other = (SumSolution) obj;
		return this.getA() == other.getA() && this.getB() == other.getB();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.getA(), this.getB());
	}
	
	@Override
	public String toString() {
		return "{" + this.sumA + "," + this.sumB + "}";
	}

}
