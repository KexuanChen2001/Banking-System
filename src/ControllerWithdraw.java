//Programmer: Kexuan Chen
//Date:12.26
public class ControllerWithdraw extends Controller {
	public ControllerWithdraw(Bank m) {
		super(m);
	}

	public String withdraw(String name, String amount) {
		//The withdraw method takes the name of a bank customer and an amount of money (as a string) as arguments.
		try {
			m.withdraw(name, Integer.parseInt(amount));
			//using the Integer.parseInt static method
		} catch (UnknownCustomerException e) {
			//return as result the error message 
			return e.getMessage();
		} catch (NotEnoughMoneyException e) {
			//return as result the error message 
			return e.getMessage();
		}catch (NumberFormatException e) {
			//return as result the error message 
			return e.getMessage();
		}
		//a negative amount of money in this ¡°withdraw¡± view, 
		//so there is no need to check for that in the controller.
		return "";
		//If no exception occurs then the withdraw method of the controller returns the empty string.
	}
}
