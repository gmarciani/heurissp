package faireness;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	TestMaxMinFaireness.class,
	TestKalaiSmorodinskiFaireness.class,	 
	TestProportionalFaireness.class })
public class AllTestsFaireness {

}
