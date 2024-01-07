import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//Programmer: Kexuan Chen
//Date:12.26
public class ViewGetMoney extends View<ControllerGetMoney> {
	//We now want to add a new ¡°get money¡± view that allows the user of the software to check how much money
	private JTextField t;
	//The ViewGetMoney shows the text field called t
	//(where the user can type text) and a button. 
	//Use a grid layout manager to position the two components.
	
	public ViewGetMoney(Bank m, ControllerGetMoney c) {
		super(m, c);
		//basic
		this.setTitle("View Money");
		this.setSize(300,150);
		
		//create layout	
		JPanel jpanel = new JPanel();
		GridLayout Glayout = new GridLayout(2, 1);
		jpanel.setLayout(Glayout);
		//The ViewGetMoney shows the text field called t
		//text
		t = new JTextField("Type a customer name here");
		jpanel.add(t);
		//button
		JButton b = new JButton("Tell me the money");
		jpanel.add(b);
		//clicks on the button, the action listener of the button must read the name of the customer
		// (using the getText method of the text field) and must call the getMoney method
		//using the showMessageDialog method of the JOptionPane class
		b.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String message = c.getMoney(t.getText());
				if(e.getButton() == MouseEvent.BUTTON1) {
					//the case that the mouse click the button
					JOptionPane.showMessageDialog(jpanel, message);
				}
			}
		});
		this.add(jpanel);
		this.setVisible(true);
		
	}
	//The update method of the ViewGetMoney class does nothing
	@Override
	public void update() {
	}
}
