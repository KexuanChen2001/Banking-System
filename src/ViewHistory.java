//Programmer: Kexuan Chen
//Date:12.26
public class ViewHistory extends View<ControllerHistory> {
	public ViewHistory(Bank m, ControllerHistory c) {
		super(m, c);//super call the constructor
		//basic
		this.setTitle("View History");
		this.setSize(300, 150);
		//The ViewHistory shows only a HistoryPanel object, nothing else.
		this.add(new HistoryPanel(m));
		this.setVisible(true);
	}

	@Override
	public void update() {
		//The update method of the ViewHistory class calls Swing¡¯s repaint method 
		repaint();
	}
}