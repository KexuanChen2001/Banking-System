import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

//PROJECT!!!!!
//Programmer: Oliver,1930026012
//Date:12.26
public class Bank implements java.io.Serializable {
	/**Make other classes implement Java's Serializable interface as appropriate.*/
	private String name;
	private ArrayList<IAccount> accounts;
	//When a bank is created, it has an array list of accounts 
	//but the array list does not contain any bank account
	//Therefore add to the Bank class an array list of ModelListener
	private ArrayList<ModelListener> modelListeners;
	/**
	 * track of how the total amount of money in all the bank 
	 * accounts of the bank changes
	 */
	private ArrayList<Integer> history;//an array list of integers
	private File file;//Add to the Bank class a new private file instance variable. 
	
	//Also add to the Bank class a getHistory method that 
	//returns as result the array list of integers which is the bank¡¯s history
	public ArrayList<Integer> getHistory() {
		return history;
	}
	public Bank(String name) {
		this.name = name;
		accounts = new ArrayList<IAccount>();
		// it has an array list of accounts
		modelListeners = new ArrayList<ModelListener>();
		/**the constructor create the modelListeners**/
		
		history = new ArrayList<Integer>();
		history.add(0);//initialize
		
		// initialize the file instance variable
		//to be a File object for a binary file named "XXX.bin"
		file = new File(name + ".bin");
		// if it exists, and put it into the corresponding array lists 
		//(if the binary file does not exist then the array lists must be initialized as before).
		if (file.exists() == true) { 
			try {
				//input the content that file have
				FileInputStream fileIn = new FileInputStream(file);
				ObjectInputStream in = new ObjectInputStream(fileIn);
				history = (ArrayList<Integer>) in.readObject();
				accounts = (ArrayList<IAccount>) in.readObject();
				fileIn.close();//over and close the file
				in.close();
			} catch (IOException e) {
				//the IOException
				System.out.println(e.getMessage());
			} catch (ClassNotFoundException e) {
				//the ClassNotFoundException
				System.out.println(e.getMessage());
			}
		} else { // does not exist then the array lists must be initialized as before
			history = new ArrayList<Integer>();
			history.add(0); 
			accounts = new ArrayList<IAccount>();
		}
	}
	
	public void saveData() {
		//the Bank class a new public method called saveData that takes no argument, returns nothing
		try {
			//save into the binary file the accounts and history arraylists of the bank
			FileOutputStream output = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(output);
			out.writeObject(history);
			out.writeObject(accounts);
			out.close();
			output.close();//close it 
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**Also add to the Bank class a private notifyListeners method that
	 * takes nothing as argument and calls the update method of all the listeners of the bank**/
	private void notifyListeners() {
		for (ModelListener modelListener : modelListeners) {
			modelListener.update();//enhanced for loop 
		}
	}
	/**Also add to the Bank class an addListener method 
	 * that takes a ModelListener as argument and 
	 * adds it to the array list of listeners.**/
	public void addListener(ModelListener modelListener) {
		modelListeners.add(modelListener);
	}
	/**Then change the addAccount and withdraw methods so that 
	 * they call the notifyListeners every time a change is made to the bank's data**/
	public void addAccount(IAccount account) {
		// adds the account to the array list of accounts for the bank
		accounts.add(account);
		/**call the totalMoney method and add the result to the history array list.**/
		history.add(totalMoney());
		//before notifyListeners is called
		notifyListeners();
		
	}
	public int totalMoney() {
		// the total amount of money in all the bank accounts of the bank
		int totalmoney = 0;
		for(int i = 0; i < accounts.size(); i++) {
			totalmoney = totalmoney + accounts.get(i).getMoney();
		}
		return totalmoney;
	}
	public int getMoney(String name) throws UnknownCustomerException {
		// use the equals method to compare strings, not the == operator which only works with constant strings.
		//returns as result the amount of money belongs to that customer
		for(int i = 0; i < accounts.size(); i++) {
			if(accounts.get(i).getName().equals(name)) {//equal then return the current money
				return accounts.get(i).getMoney();
			}
		}
		//if there is no return that means no one fit this case then throw
		throw new UnknownCustomerException("Customer " + name + " unknown");
		
	}
	public void withdraw(String name, int amount) throws UnknownCustomerException, NotEnoughMoneyException {
		// use the equals method to compare strings, not the == operator which only works with constant strings.
		/**
		 * use enhanced for loop to simply
		 * getMoney and totalMoney also can use the enhanced for loop, just use both for practice
		 */
		int n = 0;
		for(int i = 0; i < accounts.size(); i++) {
			if(accounts.get(i).getName().equals(name)) {//the same
				accounts.get(i).withdraw(amount);
				
				//set money is in the Account class
				n = 1;
				/**call the totalMoney method and add the result to the history array list.**/
				history.add(totalMoney());
			}
		}
		if(n == 0) {
			//if there is no return that means no one fit this case then throw
			throw new UnknownCustomerException("Customer " + name + " unknown");
		}
		notifyListeners();
	}
	
	public static void testBank() {
		System.out.println("----test the Bank------");
		Bank ZHB = new Bank("ZhuHaiCentreBank");
		try {
			//set account objects
			IAccount student002 = new StudentAccount("Alice",5000);
			IAccount creidt002 = new CreditAccount("Bili",6000);
			//add account method
			ZHB.addAccount(student002);
			ZHB.addAccount(creidt002);
			//test the IAccount methods
				//get money
				System.out.println(creidt002.getMoney()==6000);//1
				//get name
				System.out.println(creidt002.getName()=="Bili");//2
				//withdraw
				creidt002.withdraw(5000);//6000-5000=1000
				System.out.println(creidt002.getMoney()==1000);//3
			//test total money
			System.out.println(ZHB.totalMoney()==6000);//5000+1000=6000//4
			//test get money
			System.out.println(ZHB.getMoney("Alice")==5000);//5
			System.out.println(ZHB.getMoney("Bili")==1000);//6
				//test an unknown get money
				try {
					System.out.println(ZHB.getMoney("Cili")==2000);
				}catch (UnknownCustomerException e) {
					System.out.println(e.getMessage());
				}
			//test withdraw Bank
			ZHB.withdraw("Alice", 3000);//5000-3000=2000
			ZHB.withdraw("Bili",200);
			System.out.println(ZHB.getMoney("Alice")==2000);//7
			System.out.println(ZHB.getMoney("Bili")==800);//8
				//test an unknown withdraw
				try {
					ZHB.withdraw("Cili", 3000);
				}catch (UnknownCustomerException e) {
					System.out.println(e.getMessage());
				}
			//then check the total money change or not
				System.out.println(ZHB.totalMoney()==2800);//2000+800=2800//9
		}catch (NotEnoughMoneyException e) {
			System.out.println(e.getMessage());
		} catch (UnknownCustomerException e) {
			System.out.println(e.getMessage());
		}
	}
}
