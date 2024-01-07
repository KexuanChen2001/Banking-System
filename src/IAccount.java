//PROJECT!!!!!
//Programmer: Oliver,1930026012
//Date:12.26
public interface IAccount {
	//Write an IAccount interface for bank accounts
	public String getName();
	public int getMoney();
	public void withdraw(int amount) throws NotEnoughMoneyException;
	/** throw the exception **/
}
