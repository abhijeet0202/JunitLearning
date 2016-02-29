/**
 * 
 */
package abhijeet.staticBlock;
/**
 * @author abhibane
 *
 */
public class MyBank {
	static int amount;
	  
	 //Static block begins 
	 static {
	  updateBalance(100);
	 }
	  
	 public static void updateBalance(float balance) {
	  amount += balance;
	 }
	}
