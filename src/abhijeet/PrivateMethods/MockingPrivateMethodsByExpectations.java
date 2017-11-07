package abhijeet.PrivateMethods;
import static org.junit.Assert.assertEquals;
import mockit.Deencapsulation;
import mockit.Expectations;

import org.junit.Test;


public class MockingPrivateMethodsByExpectations {
	@Test
	public void TC1_Mock_PrivateMethod_By_Expectation() {
		//Make simple final to be used in the Expectations inner class
		final PrivateMethods pri = new PrivateMethods();
		
		//pass simple as argument to make it a Mocked type
		//in the Expectations class
		new Expectations(pri) {
			{
				Deencapsulation.invoke(pri, "CallingPrivateMethod");
				returns("Private", any, null);
			}
		};
		String name = pri.CallingPublicMethod();
		assertEquals("Private Functions can also Be Mocked-Private", "Private", name);
		
	}
	

}
