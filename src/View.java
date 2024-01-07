import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

//Programmer: Kexuan Chen
//Date:12.26
public abstract class View<T> extends JFrame implements ModelListener {
	//This View class is generic, extends JFrame, implements the ModelListener interface
	//The m and c instance variables of the View class are protected
	protected Bank m;
	protected T c;
	
	public View(Bank m, T c) {
		this.m = m;
		this.c = c;
		m.addListener(this);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//move
		//hide the frame when the user clicks on the "close" button;
		this.addWindowListener(new WindowAdapter() {
			//add a "window closing" event handler 
			//(use an anonymous window adapter) 
			//that calls the controller's shutdown method.
			@Override
			public void windowClosing(WindowEvent e) {
				((Controller) c).shutdown();
			}
		});
	}
	@Override
	public abstract void update();//The update method of the View class is abstract.
}
