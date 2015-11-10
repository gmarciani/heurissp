package fairness;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import control.fairness.Fairness;
import model.Solution;

public class TestMaxMinFairness {
	
	@Rule 
	public TestName name = new TestName();
	
	@Before
	public void testInfo() {
		System.out.println("\n/********************************************************************************");
		System.out.println(" * TEST: " + this.getClass().getSimpleName() + " " + name.getMethodName());
		System.out.println(" ********************************************************************************/\n");
	}

	@Test
	public void test() {
		Solution sols[] = {
			new Solution(new int[] {2}, new int[] {1}),
			new Solution(new int[] {2}, new int[] {4}),
			new Solution(new int[] {3}, new int[] {1}),
			new Solution(new int[] {3}, new int[] {4}),				
		};
		
		Solution mmsol = Fairness.maxMin(sols);
		
		System.out.printf("Max-Min Faireness: %s\n", mmsol);
	}

}
