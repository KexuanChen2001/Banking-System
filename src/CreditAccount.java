//Programmer: Kexuan Chen
//Date:12.26
public class CreditAccount extends Account {
	//The constructor of the CreditAccount class 
	//takes a name and an amount of money as arguments
	public CreditAccount(String name, int money) {
		super(name,money);
		//The CreditAccount class does not have any instance variable
	}
	@Override
	public void withdraw(int amount) {//the amount of money given as argument
		setMoney(getMoney() - amount);
		//A credit account is allowed to have a negative amount of money 
		//can be withdrawn account become negative.
		
	}
	public static void testCreditAccount() {
		System.out.println("----test the CreditAccount------");
		//create
		CreditAccount credit001 = new CreditAccount("Alice",1500);
		//test get name get money
		System.out.println(credit001.getName()=="Alice");
		System.out.println(credit001.getMoney()==1500);
		//test set money
		credit001.setMoney(2000);
		System.out.println(credit001.getMoney()==2000);
		//test withdraw
		credit001.withdraw(1100);//2000-1100=900
		System.out.println(credit001.getMoney()==900);
			//can be negative
		credit001.withdraw(1000);//900-1000=-100
		System.out.println(credit001.getMoney()==-100);
	}
}
