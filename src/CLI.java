
import java.util.InputMismatchException;
import java.util.Scanner;

//PROJECT!!!!!
//Programmer: Oliver,1930026012
//Date:12.26
public class CLI {
	//the CLI class that you will now use to run the interactive 
	//text-based interface of your program.
	private static Scanner input = new Scanner(System.in);
	//it is static
	
	//The readLine method is static and private, 
	//it takes a string as argument, 
	//and returns another string as result
	/**
	 * the readLine method uses the input scanner object to 
	 * read a whole line of text from the user of the program and 
	 * returns the text as result.
	 * @return
	 */
	private static String readLine (String demo) {
		System.out.print(demo);//show the typed
		String s;
		s = input.nextLine();//uses the input scanner object to read a whole line of text 
		return s;//another string
	}
	//readPosInt method is static and private, 
	//it takes a string as argument, 
	//and returns a positive integer as result.
	/**
	 * Then the readPosInt method uses the input scanner object to
	 * read an integer from the user of the program
	 * @return
	 */
	private static int readPosInt(String demo) throws InputMismatchException {
		//if input not integer, throw InputMismatchException
		//the error message "You must type an integer!"
		System.out.print(demo);//show the typed
		// put the whole code of the method inside a while loop
		while(true) {
			try {
				//add try catch for main codes previously
				int i;
				i = input.nextInt();//reading the integer
				// use the scanner¡¯s nextLine method to read the 
				//single newline character that comes from the user
				//pressing the Enter key on the keyboard after typing the integer
				if(i % 1 == 0) {//an integer
					if(i >= 0) {
						input.nextLine();
						return i;//positive integer
					}else{
						System.out.println("Positive integers only!");
						//then do again the loop
						System.out.print(demo);
					}
				}else {
					throw new InputMismatchException(null);
					//it already in the catch to print
				}
			}catch(InputMismatchException e) {
				System.out.println("You must type an integer!");
				System.out.print(demo);
			}
			input.nextLine();
			//Enter key on the keyboard after typing the integer
			//read this newline character using the nextLine method
		}	
	}
	public static void main(String[] args) throws UnknownCustomerException  {
		//remove all the code inside the main method of the CLI class 
		//so that the main method is empty again.
		
		//In the empty main method of the CLI class, 
		//create a single Bank object with the name "UIC Bank".
		Bank UICB = new Bank("UIC Bank");
		//hint: put the whole code of the main method inside a while loop, 
		//except for the one line of code that creates the single bank object
		while(true) {//always looping
			
			switch(readPosInt("Type an action (total:1 add:2 list:3 withdraw:4 deposit:5 quit:6): ")) {
			//the readPosInt method that you implemented automatically repeat the menu 
			//so you do not have to worry about this in the code of the main method of your CLI class.
			case 1:
				 
				System.out.println("Total amount of money in the bank: " + UICB.totalMoney());
				break;
			case 2:
				// To add a new account, your program needs to ask the user three things: 
				int i = readPosInt("Type the account type (credit:1 student:2): ");
				//any other integer must result in an error message
				if(i < 1 || i > 2) {
					System.out.println("Unknown type of account!");
				}else {
					//get name and money and put into bank in different types
					//create name and money
					String putName = readLine("Enter the name of the customer: ");
					int putMoney = readPosInt("Enter the initial amount of money: ");
					//use if statement get the type of account
					//use try catch
					if(i == 1) {//credit
						
						IAccount credit003 = new CreditAccount(putName,putMoney);
						UICB.addAccount(credit003);//add
						System.out.println("Credit account for " + putName + " with " + putMoney + " yuan has been added");
					}else if(i == 2) {
						try {
							IAccount student003 = new StudentAccount(putName,putMoney);
							UICB.addAccount(student003);//add
						}catch(NotEnoughMoneyException e) {
							System.out.println("BUG! This must never happen!");
							System.exit(1);
							/**
							 * Nevertheless the code of the main method of your CLI class must handle this exception by printing
							 *  the error message "BUG! This must never happen!" and immediately terminating the program using
							 *  System.exit(1);
							 */
						}
						System.out.println("Student account for " + putName + " with " + putMoney + " yuan has been added");
					}
					
				}
				break;// The program then goes back to the menu.

			case 3:
				String putName02 = readLine("Enter the name of the customer: ");
				//UnknownCustomerException
				// and then it just goes back to printing the menu of actions 
				try {
					//the get money method
					System.out.println(putName02 + " has " + UICB.getMoney(putName02) +" yuan in the bank");
				}catch(UnknownCustomerException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				String putName03 = readLine("Enter the name of the customer: ");
				int withdrawMoney = readPosInt("Enter the amount of money to withdraw: ");
				try {
					UICB.withdraw(putName03, withdrawMoney);//withdraw
					
				}catch(UnknownCustomerException e) {
					//If the name of the customer is wrong
					System.out.println(e.getMessage());
				}catch(NotEnoughMoneyException e) {
					//a student account the amount of money to withdraw is too big 
					//NotEnoughMoneyException exception will be thrown by the StudentAccount object
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				// simulate a deposit by simply doing a withdrawal of the negative amount!
				String putName04 = readLine("Enter the name of the customer: ");
				int deposit = -readPosInt/*in negative to deposit*/("Enter the amount of money to deposit: ");
				try {
					UICB.withdraw(putName04, deposit);//deposit
				}catch(UnknownCustomerException e) {
					System.out.println(e.getMessage());
				}catch(NotEnoughMoneyException e) {
					//If the name of the customer is wrong (the bank does not have an account for this customer) then an
					//UnknownCustomerException exception will be thrown by the Bank object. 
					//never being this exception
					System.out.println("BUG! This must never happen!");
					System.exit(1);
				}
				break;
			case 6:
				//call the saveData method 
				UICB.saveData();
				//print a "Goodbye!" message 
				//terminate using: System.exit(0).
				System.out.println("Goodbye!");
				System.exit(0);
				
				break;
			default:
				//If the user types an integer which is not between 1 and 6, 
				//then your program must print an error message
				System.out.println("Unknown action!");
			}
		}
	}
	
}
