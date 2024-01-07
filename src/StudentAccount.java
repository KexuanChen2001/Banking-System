//Programmer: Kexuan Chen
//Date:12.26
public class StudentAccount extends Account {
	//The constructor of the StudentAccount class 
	//takes a name and an amount of money as arguments.
	public StudentAccount(String name, int money) throws NotEnoughMoneyException {
		//NotEnoughMoneyException with the message 
		//"Cannot create student account with negative amount of money".
		super(name,money);
		if(money < 0) {
			throw new NotEnoughMoneyException("Cannot create student account with negative amount of money");
		}
	}
	@Override
	public void withdraw(int amount) throws NotEnoughMoneyException {
		//NotEnoughMoneyException with the message 
		//"Cannot withdraw XXX yuan from account, only YYY yuan is available"
		if(amount > getMoney()) {
			throw new NotEnoughMoneyException("Cannot withdraw " + amount + " yuan from account, only " + getMoney() + " yuan is available");
			/** Change other classes and interfaces as necessary **/
		}else {
			setMoney(getMoney()-amount);
		}
	}
	
	public static void testStudentAccount() {
		System.out.println("----test the StudentAccount------");
		//create
		try {
			StudentAccount student001 = new StudentAccount("Alice",3000);//this is okay
			System.out.println("Alice account is created");
			//test get name get money
			System.out.println(student001.getName()=="Alice");
			System.out.println(student001.getMoney()==3000);
			//test set money
			student001.setMoney(2000);
			System.out.println(student001.getMoney()==2000);
			//test withdraw
			try {
				student001.withdraw(1100);//2000-1100=900
				System.out.println(student001.getMoney()==900);
			}catch(NotEnoughMoneyException e) {
				System.out.println(e.getMessage());
			}
				//can not be negative
			try {
				student001.withdraw(1000);//900-1000=-100 but can not be negative
				System.out.println(student001.getMoney()==-100);
			}catch(NotEnoughMoneyException e) {
				System.out.println(e.getMessage());
			}
		}catch(NotEnoughMoneyException e) {
			System.out.println(e.getMessage());
		}
		//create negative account
		try {
			StudentAccount student002 = new StudentAccount("Bob",-3000);//not allow
		}catch(NotEnoughMoneyException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
