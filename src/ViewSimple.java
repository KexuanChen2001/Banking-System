

import javax.swing.JFrame;
import javax.swing.JLabel;

//PROJECT!!!!!
//Programmer: Oliver,1930026012
//Date:12.26
public class ViewSimple extends View<Controller> implements ModelListener {
	//create a ViewSimple class that extends JFrame, implements the ModelListener interface
//	private Bank m;
//	private ControllerSimple c;
	//have only one instance variable: the label. 	
	private JLabel label;
	/**Then modify the ViewSimple class to be a subclass of the View<бн> class.**/
	public  ViewSimple(Bank m, ControllerSimple c) {
		/**Also make sure that the ViewSimple does not directly register itself with the model 
		 * since this is now done in the superclass View.
		**/
		super(m,c);
		//basic
		this.setTitle("View Simple");
		this.setSize(300,150);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// using the addListener method of the model
		//creates a JLabel object
		label = new JLabel();
		//stores it in the label instance variable
		this.add(label);
		update();
		this.setVisible(true);//visible
	}
	
	
	//update method
	@Override
	public void update() {
		//updates the text of the label
		//the label always displays the current value of the total amount of money in all the bank accounts of the bank.
		label.setText("total money:" + m.totalMoney());//the view simple's content
	}
}
