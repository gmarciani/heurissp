package fairness;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import control.Fairness;
import model.Solution;

public class TestProportionalFairness {
	
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
		
		Solution psol = Fairness.proportional(sols);
		
		System.out.printf("Proportional Faireness: %s\n", (psol != null)?psol:"none");
	}

}
