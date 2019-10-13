package abhijeet.Exception;

import mockit.Expectations;

import org.junit.Test;

public class MockBankException {

	@Test(expected= Exception.class)
	public void TC1_Mock_Exception() throws Exception{
		final Bank bank = new Bank();
		new Expectations(bank){
			{
				bank.getConnection();
				result = new Exception();
			}
		};
		bank.getConnection();
	}
}
