package abhijeet.StaticMethod;

import static org.junit.Assert.*;
import mockit.Mock;
import mockit.MockUp;

import org.junit.Test;

public class MockingStaticMethodByMockUp {
	@Test
	public void TC2_Mock_StaticMathod_MockUp() {
		new MockUp<Account>() {
			// Redefine the method here
			// But With No static modifier
			@Mock
			public String getMoney(){
			return "DUPLICATE";
			}
		};
		Employee emp = new Employee();
		String str = emp.makePayment();
		assertEquals("Please Returns Fails", "FAIL", str);
	}

}
