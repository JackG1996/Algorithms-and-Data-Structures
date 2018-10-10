import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;


public class SelfDivisibleNumbersTest {

	static SelfDivisibleNumbers sdn;
	
	@BeforeClass
	public static void oneTimeSetUp() throws Exception 
	{
		sdn = new SelfDivisibleNumbers();
	}
	
	@Test
	public void constructorTest() 
	{
		assertNotNull("Checking the constructor",sdn);
	}
	
}