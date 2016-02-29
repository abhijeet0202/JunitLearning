/**
 * 
 */
package abhijeet.publicMethod;

/**
 * @author abhibane
 *
 */
public class Bank {
	BankDBManager dbManager =new BankDBManager();	
	
	 public String processAccount(int accountID){
		 //Some other code goes here
		 String accountHolderName = dbManager.accountHolderName(accountID);
		 //some more processing code 
	  return accountHolderName;
	 }
}
