//Programmer: Oliver,1930026012
//Date:12.26
public abstract class Account implements IAccount, java.io.Serializable {
	private String name;
	private int money;//variables
	
	public  Account(String name, int money) {
		this.name = name;
		this.money = money;//this element
		
	}
	
	@Override
	public String getName() {
		return name;//the method that get name
	}
	@Override
	public int getMoney() {
		return money;//the method that get money
	}
	protected void setMoney(int money) {
		this.money = money;//the method that set the money
	}
	@Override
	public abstract void withdraw(int amount) throws NotEnoughMoneyException;
	/**
	 * throw the exception
	 */
		// (subtract) the amount of money given as argument
		//The withdraw method of the Account class is abstract 
		//different types of bank accounts withdraw money in different ways.
	
	public static void testAccount() {
		System.out.println("----test the account------");
		//it is a abstract class, so we can not create object
	}
}
