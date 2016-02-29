package abhijeet.StaticMethod;
import static org.junit.Assert.*;
import mockit.Mocked;
import mockit.NonStrictExpectations;

import org.junit.Test;


public class MockingStaticMethodByExpectation {
@Mocked Account acc;
	@Test
	public void Mock_StaticMathod_Expectation() {
		Employee emp = new Employee();
		new NonStrictExpectations() {			
			{
				Account.getMoney(); 
				returns("DUPLICATE");
			}			
		};		
		String status = emp.makePayment();
		assertEquals("Status is FAIL","FAIL",status);
	}

}
