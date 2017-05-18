// dince16@georgefox.edu
// Program 11
// 2017-04-13

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This class contains a transaction string and boolean return. Its capable of returning its attributes
 * and loaded transactions from a specified file.
 * @author danielleince
 *
 */
public class Transaction {
	private String _transaction;
	private boolean _isReturn;
	
	/**
	 * This constructs a Transaction object with a given string and boolean
	 * @param transaction - the object transaction string
	 * @param isReturn - whether or not the object is a return
	 */
	public Transaction(String transaction, boolean isReturn)
	{
		_transaction = transaction;
		_isReturn = isReturn;
	}
	
	/**
	 * Retrieves and returns the transaction's string
	 * @return _transaction - the object's transaction string
	 */
	public String getTransaction()
	{
		return _transaction;
	}
	
	/**
	 * Retrieves and returns whether the object is a return.
	 * @return _isReturn - whether or not the object is a return
	 */
	public boolean isReturn()
	{
		return _isReturn;
	}
	
	/**
	 * This method receives a filename of transactions and adds a newly constructed Transaction object
	 * to the array that it then returns
	 * @param filename - a filename of transactions
	 * @return Transaction[] - an array of transactions from the specified file
	 */
	public static Transaction[] loadTransactions(String filename)
	{
		String[] transactionList = filename.split("");
		String[] transactionLine;
		ArrayList<Transaction> loadedTransactions = new ArrayList<Transaction>();
		Transaction[] transactions;
		for (String transaction : transactionList)
		{
			transactionLine = transaction.split(",");
			if (transactionList.length > 2)
			{
				loadedTransactions.add(new Transaction(transactionLine[0], true));
			}
			else
			{
				loadedTransactions.add(new Transaction(transactionLine[0], false));
				
			}
		}
		transactions = new Transaction[loadedTransactions.size()];
		return loadedTransactions.toArray(transactions);
		
	}

}
