package abhijeet.StaticMethod;
public class Employee {
	public String makePayment(){
		//some connection related code goes here
		   
		  // call to static method
		  String conStr = Account.getMoney();
		   
		  // If the connection String is anything other than ORIGINAL return FAIL 
		  if(conStr.equals("ORIGINAL"))
			  return "SUCCESS";
		  else
			  return "FAIL";
	}
}
