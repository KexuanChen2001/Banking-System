import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//Programmer: Kexuan Chen
//Date:12.26
public class ViewCreate extends View<ControllerCreate> {
	private JTextField t1;
	private JTextField t2;
	private JComboBox<String> cb;//variables
	public ViewCreate(Bank m, ControllerCreate c) {
		super(m, c);
		//basic
		this.setTitle("View Create");
		this.setSize(300,150);
		GridLayout Glayout = new GridLayout(4, 1);//4 lines 1 column
		JPanel jpanel = new JPanel(Glayout);
		//text
		t1 = new JTextField("Type a customer name here");
		t2 = new JTextField("Type an mount of money here");
		jpanel.add(t1);
		jpanel.add(t2);
		//check box
		cb = new JComboBox<String>();
		cb.addItem("credit account");
		cb.addItem("student account");
		jpanel.add(cb);
		//button
		JButton b = new JButton("Create");
		b.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					// (using the getText method of the text field)
					String putName = t1.getText();
					String money = t2.getText();
					int check = cb.getSelectedIndex();
					//which returns the integer 0 or 1 depending on which menu option
					//the user selected in the combo box
					String message = c.create(putName, money, check);
					//call the create method to create account
					if (message != "") {
						JOptionPane.showMessageDialog(jpanel, message);
						//show the message
					}
				}
			}
		});
		jpanel.add(b);
		//add panel and set visible
		this.add(jpanel);
		this.setVisible(true);
	}

	@Override
	public void update() {
		//The update method of the ViewCreate class does nothing,
		//because the ViewCreate class does not graphically
		//display any data from the bank (the model)
	}
}
