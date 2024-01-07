import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

//Programmer: Kexuan Chen
//Date:12.26
public class HistoryPanel extends JPanel {
	//Create a HistoryPanel class that extends JPanel.
	private Bank b;

	public HistoryPanel(Bank b) {
		////store in some private instance variable
		this.b = b;
	}

	//private historyMax method
	private int historyMax(ArrayList<Integer> numbers) {
		// return as result the maximum number in the array list
		int maxNum = 0;
		for (int i = 0; i < numbers.size(); i++) {
			if (maxNum <= numbers.get(i)) {
				//in this case max is smaller then want the bigger one
				maxNum = numbers.get(i);
			}
		}
		return maxNum;//find the maximum
	}

	//private historyMin method
	private int historyMin(ArrayList<Integer> numbers) {
		// return as result the minimum number in the array list
		int minNum = 0;
		for (int i = 0; i < numbers.size(); i++) {
			if (minNum >= numbers.get(i)) {
				//in this case min is larger then want the smaller one
				minNum = numbers.get(i);
			}
		}
		return minNum;
	}

	//add to the HistoryPanel class a private method called
	//historyRange that takes an array list of integers as argument and returns as result the difference between the
	//max and min of the integers in the array list, or returns as result 100 if the difference between the man and min of
	//the integers in the array list is strictly less than 100.
	private int historyRange(ArrayList<Integer> numbers) {
		int range = historyMax(numbers) - historyMin(numbers);
		// the difference between the max and min of the integers in the arraylist
		if (range <= 100) {
			return 100;
		} else {
			return range;
		}
	}

	
	@Override
	protected void paintComponent(Graphics g) {
		//Override the protected void paintComponent(Graphics g) method inherited from JPanel
		super.paintComponent(g);
		int min = historyMin(b.getHistory());
		int range = historyRange(b.getHistory());
		int maxX = getWidth() - 1;
		int maxY = getHeight() - 1;
		int zero = maxY + min * maxY / range;
		//Draw a blue line between the point (0, zero) and the point (maxX, zero)
		g.setColor(Color.blue);
		g.drawLine(0, zero, maxX, zero);
		//Draw red lines between all the points (x, y) 
		//one value in the array list
		//draw a rectangle of size 1 by 1 at position (x, y)
		g.setColor(Color.red);
		if(b.getHistory().size() == 1) {
			//this case is only one point to draw
			int x = 0;
			int y = zero;
			g.drawRect(x, y, 1, 1);
		} 
		else{
			for(int i = 1; i < b.getHistory().size(); i++) {
				//Use x = 10 * i for the horizontal coordinate
				//Use y = zero - v * maxY / range for the vertical coordinate
				
				//horizontal
				int x1 = 10 * (i - 1);
				int x2 = 10 * i;
				//range
				int y1 = zero - b.getHistory().get(i - 1) * maxY / range;
				int y2 = zero - b.getHistory().get(i) * maxY / range;
				g.drawLine(x1, y1, x2, y2);
			}
		}
	}
}