import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//PROJECT!!!!!
//Programmer: Oliver,1930026012
//Date:12.26
public class ViewWithdraw extends View<ControllerWithdraw> {
	//We now want to add a new ¡°withdraw¡± view 
	//that allows the user of the software to withdraw money
	private JTextField t1;
	private JTextField t2;//variables
	public ViewWithdraw(Bank m, ControllerWithdraw c) {
		super(m, c);
		//basic
		this.setTitle("View Withdraw");
		this.setSize(300,150);
		GridLayout Glayout = new GridLayout(3, 1);//3 line one column
		//The ViewWithdraw shows the two text field called t1 and t2 (where the user can type text) and a button. Use a
		//grid layout manager to position the three components
		JPanel jpanel = new JPanel(Glayout);
		t1 = new JTextField("Type a customer name here");
		t2 = new JTextField("Type an mount of money here");
		jpanel.add(t1);
		jpanel.add(t2);
		JButton b = new JButton("Withdraw");
		jpanel.add(b);
		b.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					//(using the getText method of the text field) and the amount of money that was
					//typed in the second text field (using again the getText method) and must call the withdraw method of the
					//controller with these two strings as arguments
					String putName = t1.getText();
					String withdraw = t2.getText();
					String message = c.withdraw(putName, withdraw);
					if (message != "") {//if it should have something
						JOptionPane.showMessageDialog(jpanel, message);
						//using the showMessageDialog method of the JOptionPane class
					}
				}
			}
		});
		
		this.add(jpanel);//add the panel
		this.setVisible(true);
	}

	@Override
	public void update() {//The update method of the ViewWithdraw class does nothing, because the ViewWithdraw class does not
		//graphically display any data from the bank (the model).

	}
}
