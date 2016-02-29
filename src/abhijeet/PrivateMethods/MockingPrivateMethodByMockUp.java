package abhijeet.PrivateMethods;
import static org.junit.Assert.*;
import mockit.Mock;
import mockit.MockUp;

import org.junit.Test;


public class MockingPrivateMethodByMockUp {

	@Test
	public void TC2_Mock_PrivateMethod_By_MockUp() {
		new MockUp<PrivateMethods>() {
			//Override the private method
			//Dont provide any ACCESSS MODIFIER!
			@Mock String CallingPrivateMethod(){
				return "Mocked Private Invoke";
			}
		};
		PrivateMethods pmObj = new PrivateMethods();
		String str = pmObj.CallingPublicMethod();
		assertEquals("String returned - MockUp Invoke","Mocked Private Invoke",str);
	}

}
