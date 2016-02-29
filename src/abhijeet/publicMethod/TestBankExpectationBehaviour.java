package abhijeet.publicMethod;
import static org.junit.Assert.assertEquals;
import mockit.Expectations;
import mockit.Mocked;

import org.junit.Test;

public class TestBankExpectationBehaviour {
@Mocked BankDBManager myDBManager;
	@Test
	public void TC1_MockDBManager_CallProcessAccount() {
		Bank myBank = new Bank();
		
		//Defining The Expectation Block Here
		new Expectations() {			
			{
				myDBManager.accountHolderName(anyInt);
				returns("Abhijeet");
			}	
		};
		String name = myBank.processAccount(10);
		assertEquals("Accoont number is 10 and name is Abhijeet", "Abhijeet", name);
	}

}
