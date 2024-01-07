//Programmer: Kexuan Chen
//Date:12.26
public class GUI {
	public static void main(String[] args) {
		//with a main method
		/**
		 *  create an anonymous class that implements the Runnable interface 
		 *  with a run method and use the javax.swing.SwingUtilities.invokeLater
		 *  method to run that code on the event dispatch thread.
		 */
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				//create a Bank object (the model object) with the name "UIC Bank";
				Bank bank = new Bank("UIC Bank");
				//then create a ControllerSimple object (the controller object) that takes the model object as argument;
				ControllerSimple controllerS = new ControllerSimple(bank);
				//then create a ViewSimple object that takes the model object and the controller object as argument;
				ViewSimple viewS = new ViewSimple(bank, controllerS);
				
				ControllerGetMoney controlgetmoney = new ControllerGetMoney(bank);
				ViewGetMoney viewgetmoney = new ViewGetMoney(bank, controlgetmoney);
				/**put the withdraw money**/
				ControllerWithdraw controlwithdraw = new ControllerWithdraw(bank);
				ViewWithdraw viewwithdraw = new ViewWithdraw(bank, controlwithdraw);
				/**put with create **/
				ControllerCreate controlcreate = new ControllerCreate(bank);
				ViewCreate viewcreate = new ViewCreate(bank, controlcreate);
				/**put with history lines**/
				ControllerHistory controlhistory = new ControllerHistory(bank);
				ViewHistory viewhistory = new ViewHistory(bank, controlhistory);
			}
		});
	}
}
