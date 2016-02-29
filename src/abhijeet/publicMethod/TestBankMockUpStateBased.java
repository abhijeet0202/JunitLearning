package abhijeet.publicMethod;
import static org.junit.Assert.*;
import mockit.Mock;
import mockit.MockUp;

import org.junit.Test;


public class TestBankMockUpStateBased {

	@Test
	public void TC2_MockDBManager_CallProcessAccount() {
		new MockUp<BankDBManager>() {
			@Mock public String accountHolderName(int accountID){
				return "Abhijeet";
			}			
		};
		Bank bankObj = new Bank();
		String name= bankObj.processAccount(10);
		assertEquals("ItShould Return Abhijeet", "Abhijeet", name);
	}
}
