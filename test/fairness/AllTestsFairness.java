package fairness;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	TestMaxMinFairness.class,
	TestKalaiSmorodinskiFairness.class,	 
	TestProportionalFairness.class })
public class AllTestsFairness {

}
