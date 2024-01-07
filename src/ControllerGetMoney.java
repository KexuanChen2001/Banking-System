//PROJECT!!!!!
//Programmer: Oliver,1930026012
//Date:12.26
public class ControllerGetMoney extends Controller {

	public ControllerGetMoney(Bank m) {
		super(m);
	}
	public String getMoney(String name) {
		// The getMoney method of the controller then transforms the integer result of the 
		//getMoney method of the bank into a string and returns that string as result (to the view)
		try {
			return String.valueOf((m.getMoney(name)));
			//method of the bank into a string and returns that string as result (to the view).
		} catch (UnknownCustomerException e) {
			//must catch this exception and return as result the error message from the exception object.
			return (e.getMessage());
		}
	}

}
