package fairness;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import control.Fairness;
import model.Solution;

public class TestKalaiSmorodinskiFairness {
	
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
		int maxA = 3;
		int maxB = 4;
		
		Solution kssol = Fairness.kalaiSmorodinski(sols, maxA, maxB);
		
		System.out.printf("Kalai-Smorodinski Faireness: %s\n", kssol);
	}

}
