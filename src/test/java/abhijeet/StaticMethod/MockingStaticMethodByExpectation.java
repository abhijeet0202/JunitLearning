package abhijeet.StaticMethod;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import mockit.Expectations;
import mockit.Mocked;


public class MockingStaticMethodByExpectation {
@Mocked Account acc;
	@Test
	public void Mock_StaticMathod_Expectation() {
		Employee emp = new Employee();
		new Expectations() {			
			{
				Account.getMoney(); 
				returns("DUPLICATE", any, null);
			}			
		};		
		String status = emp.makePayment();
		assertEquals("Status is FAIL","FAIL",status);
	}

}
