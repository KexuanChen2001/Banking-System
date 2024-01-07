//PROJECT!!!!!
//Programmer: Oliver,1930026012
//Date:12.26
public class Controller {
	//Also create a Controller class which is going to be the superclass of all controllers.
	protected Bank m;
	public Controller(Bank m) {
		this.m = m;
	}
	/**add the shut down method**/
	protected void shutdown() {
		//calls the saveData method of the model;
		m.saveData();
		//manually terminates the program using System.exit(0).
		System.exit(0);
	}
}
