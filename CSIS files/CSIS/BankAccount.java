public class BankAccount
{  
	private double _balance; 

	/**
      Constructs a bank account with a zero balance.
	 */
	public BankAccount()
	{  
		_balance = 0;
	}

	/**
      Constructs a bank account with a given balance.
      @param initialBalance the initial balance
	 */
	public BankAccount(double initialBalance)
	{  
		_balance = initialBalance;
	}

	/** 
      Withdraws money from the account.
      @param the amount of money to withdraw
	 */
	public void deposit(double amount) 
	{  
		_balance = _balance + amount;
	}

	/** 
      Deposits money into the account.
      @param the amount of money to deposit
	 */
	public void withdraw(double amount) 
	{  
		_balance = _balance - amount;
	}

	/** 
      Gets the account balance.
      @return the account balance
	 */
	public double getBalance()
	{  
		return _balance; 
	}
}

