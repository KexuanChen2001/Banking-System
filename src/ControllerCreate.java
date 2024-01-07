//PROJECT!!!!!
//Programmer: Oliver,1930026012
//Date:12.26
public class ControllerCreate extends Controller {
	//ControllerCreate(Bank m) 
	public ControllerCreate(Bank m) {
		super(m);//call the super constructor
	}

	public String create(String name, String amount, int type) {
		if (type == 0) {
			// (where the integer 0 means a credit account and the
			//integer 1 means a student account)
			//in this case it is credit account
			try{
				IAccount CA = new CreditAccount(name, Integer.parseInt(amount));
				//(using the Integer.parseInt static method
				m.addAccount(CA);//add the account(create)
			}catch (NumberFormatException e) {
				//catch this exception and return as result the error message
				return "For input string:" + "\"" + amount + "\"";
				// return as result the error message from the exception object.
			}
			
		} else {//check ==1
			try {
				IAccount SA = new StudentAccount(name, Integer.parseInt(amount));
				m.addAccount(SA);
				//this is the student account and try catch the exceptions
			}catch (NumberFormatException e) {
				//catch this exception and return as result the error message
				return "For input string:" + "\"" + amount + "\"";
				// return as result the error message from the exception object.
			}catch (NotEnoughMoneyException e) {
				//catch this exception and return as result the error message
				return "Cannot create student account with negative amount of money";
			}
		}
		// If no exception occurs then the create method of the controller returns the empty string.
		return "";
	}
}
