package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class TestSolution {
	
	@Rule 
	public TestName name = new TestName();
	
	@Before
	public void testInfo() {
		System.out.println("\n/********************************************************************************");
		System.out.println(" * TEST: " + this.getClass().getSimpleName() + " " + name.getMethodName());
		System.out.println(" ********************************************************************************/\n");
	}

	@Test
	public void fromString() {
		String strsol = "{[1,2,3],[4,5,6]}";
		Solution sol = Solution.parse(strsol);
		System.out.println(sol);
		
		assertTrue("Solution should contain 1 in A", sol.getA().contains(1));
		assertTrue("Solution should contain 2 in A", sol.getA().contains(2));
		assertTrue("Solution should contain 3 in A", sol.getA().contains(3));
		assertTrue("Solution should contain 4 in B", sol.getB().contains(4));
		assertTrue("Solution should contain 5 in B", sol.getB().contains(5));
		assertTrue("Solution should contain 6 in B", sol.getB().contains(6));
	}

}
