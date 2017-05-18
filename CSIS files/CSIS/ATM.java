import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class ATM extends JFrame
{  
	private int _state;
	private int _customerNumber;
	private Customer _currentCustomer;
	private BankAccount _currentAccount;
	private final Bank _theBank;

	private final JButton _aButton;
	private final JButton _bButton;
	private final JButton _cButton;
	private final JButton _dButton;

	private final KeyPad _pad;
	private final JTextArea _display;

	private static final int START_STATE = 1;
	private static final int PIN_STATE = 2;
	private static final int ACCOUNT_STATE = 3;
	private static final int FAST_CASH_STATE = 4;
	private static final int TRANSACT_STATE = 5;
	private static final int INSUFFICIENT_FUNDS_STATE = 6;
	
	private static final double FAST_20 = 20.0;
	private static final double FAST_40 = 40.0;
	private static final double FAST_60 = 60.0;
	private static final double FAST_100 = 100.0;

	private static final long serialVersionUID = 1L;

	/**
      Constructs the user interface of the ATM application.
	 */
	public ATM()
	{  
		final int FRAME_WIDTH = 600;
		final int FRAME_HEIGHT = 200;
		
		JPanel buttonPanel;
		Container contentPane;
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);

		addWindowListener(new WindowCloser());

		// initialize bank and customers

		_theBank = new Bank();
		try
		{  
			_theBank.readCustomers("customers.txt");
		}
		catch(final IOException e)
		{  
			JOptionPane.showMessageDialog(null, "Error opening accounts file.");
		}

		// construct components

		_pad = new KeyPad();

		_display = new JTextArea(4, 20);

		_aButton = new JButton("  A  ");
		_aButton.addActionListener(new AButtonListener());

		_bButton = new JButton("  B  ");
		_bButton.addActionListener(new BButtonListener());

		_cButton = new JButton("  C  ");
		_cButton.addActionListener(new CButtonListener());

		_dButton = new JButton("  D  ");
		_dButton.addActionListener(new DButtonListener());

		// add components to content pane

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 1));
		buttonPanel.add(_aButton);
		buttonPanel.add(_bButton);
		buttonPanel.add(_cButton);
		// ADDED
		buttonPanel.add(_dButton);

		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.add(_pad);
		contentPane.add(_display);
		contentPane.add(buttonPanel);

		setState(START_STATE); 
		setVisible(true);     
	}
   
	/** 
      Sets the current customer number to the keypad value
      and sets state to PIN.
	 */
	public void setCustomerNumber() 
	{  
		_customerNumber = (int)_pad.getValue();
		setState(PIN_STATE);
	}

	/** 
      Gets PIN from keypad, finds customer in bank.
      If found sets state to ACCOUNT, else to START.
	 */
	public void selectCustomer()
	{  
		int pin = (int)_pad.getValue();
		_currentCustomer = _theBank.findCustomer(_customerNumber, pin);
		if (_currentCustomer == null) 
			setState(START_STATE);
		else 
			setState(ACCOUNT_STATE);
	}

	/** 
      Sets current account to checking or savings. Sets 
      state to TRANSACT
      @param account one of Customer.CHECKING_ACCOUNT
      or Customer.SAVINGS_ACCOUNT
	 */
	public void selectAccount(final int account)
	{  
		_currentAccount = _currentCustomer.getAccount(account);
		/*
		if (account == 2 || account == 3)
		{
			setState(TRANSACT_STATE);
		}
		else
			setState(FAST_CASH_STATE);
		*/
	}

	/** 
      Withdraws amount typed in keypad from current account if and only if it is less the the 
      currenAccount's balance. 
      Sets state to ACCOUNT. 
	 */

	public void withdraw(double amount)
	{
		if (amount > _currentAccount.getBalance())
		{
			setState(INSUFFICIENT_FUNDS_STATE);
		}
		else
		{
			_currentAccount.withdraw(amount);
			setState(ACCOUNT_STATE);
		}
	}
	
	public void withdraw()
	{  
		double amount = _pad.getValue();
		withdraw(amount);
	}

	/** 
      Deposits amount typed in keypad to current account. 
      Sets state to ACCOUNT. 
	 */
	public void deposit()
	{  
		_currentAccount.deposit(_pad.getValue());
		setState(ACCOUNT_STATE);
	}

	/** 
      Sets state and updates display message.
      @param state the next state
	 */
	public void setState(final int newState)
	{  
		_state = newState;
		_pad.clear();
		if (_state == START_STATE)
		{
			_display.setText("Enter customer number\nA = OK");
		}
		else if (_state == PIN_STATE)
		{
			_display.setText("Enter PIN\nA = OK");
		}
		else if (_state == ACCOUNT_STATE)
		{
			_display.setText("Select Account\n" 
					+ "A = Fast Cash\nB = Checkings\nC = Savings\nD = Exit");
		}
		else if (_state == TRANSACT_STATE)
		{
			_display.setText("Balance = " 
					+ String.format("%1$.2f", _currentAccount.getBalance())
					+ "\nEnter amount and select transaction\n"
					+ "A = Withdraw\nB = Deposit\nC = Cancel");
		}
		else if (_state == FAST_CASH_STATE)
		{
			_display.setText("A = $20\nB = $40\nC = $60\nD = $100");

		}
		else if (_state == INSUFFICIENT_FUNDS_STATE)
		{
			_display.setText("Insufficient Funds\nA = Ok");
		}
	}


	private class AButtonListener implements ActionListener
	{  
		public void actionPerformed(final ActionEvent event)
		{  
			if (_state == START_STATE)
			{
				setCustomerNumber();
			}
			else if (_state == PIN_STATE)
			{
				selectCustomer();
			}
			else if (_state == ACCOUNT_STATE)
			{
				selectAccount(Customer.CHECKING_ACCOUNT);
				setState(FAST_CASH_STATE);
			}
			else if (_state == FAST_CASH_STATE)
			{
				withdraw(FAST_20);
			}
			else if (_state == TRANSACT_STATE)
			{
				withdraw();
			}
			else if (_state == INSUFFICIENT_FUNDS_STATE)
			{
				setState(ACCOUNT_STATE);
			}
			/*
			if (_state == START_STATE)
				setCustomerNumber();
			else if (_state == PIN_STATE)
				selectCustomer();
			else if (_state == ACCOUNT_STATE)
				selectAccount(Customer.CHECKING_ACCOUNT);
			else if (_state == TRANSACT_STATE)
				withdraw();
			*/
		}
	}

	private class BButtonListener implements ActionListener
	{  
		public void actionPerformed(final ActionEvent event)
		{  
			if (_state == ACCOUNT_STATE)
			{
				selectAccount(Customer.CHECKING_ACCOUNT);
				setState(TRANSACT_STATE);
			}
			else if (_state == FAST_CASH_STATE)
			{
				selectAccount(Customer.CHECKING_ACCOUNT);
				withdraw(FAST_40);
				setState(ACCOUNT_STATE);
			}
			else if (_state == TRANSACT_STATE)
				deposit();
			/*
			if (_state == ACCOUNT_STATE)
				selectAccount(Customer.SAVINGS_ACCOUNT);
			else if (_state == TRANSACT_STATE)
				deposit();
				*/
		}
	}

	private class CButtonListener implements ActionListener
	{  
		public void actionPerformed(final ActionEvent event)
		{  
			if (_state == ACCOUNT_STATE)
			{
				selectAccount(Customer.SAVINGS_ACCOUNT);
				setState(TRANSACT_STATE);
			}
			else if (_state == FAST_CASH_STATE)
			{
				selectAccount(Customer.CHECKING_ACCOUNT);
				withdraw(FAST_60);
				setState(ACCOUNT_STATE);
			}
			else if (_state == TRANSACT_STATE)
				setState(ACCOUNT_STATE);
			/*
			if (_state == ACCOUNT_STATE)
				setState(START_STATE);
			else if (_state == TRANSACT_STATE)
				setState(ACCOUNT_STATE);
				*/
		}
	}
	
	private class DButtonListener implements ActionListener
	{  
		public void actionPerformed(final ActionEvent event)
		{  
			if (_state == ACCOUNT_STATE)
				setState(START_STATE);
			else if (_state == FAST_CASH_STATE)
			{
				selectAccount(Customer.CHECKING_ACCOUNT);
				withdraw(FAST_100);
				setState(ACCOUNT_STATE);
			}
			else if (_state == TRANSACT_STATE)
				setState(ACCOUNT_STATE);
			/*
			if (_state == ACCOUNT_STATE)
				setState(FAST_CASH_STATE);
			else if (_state == FAST_CASH_STATE)
				fastCashWithdraw();
				setState(ACCOUNT_STATE);
				*/
			
		}
	}

	private class WindowCloser extends WindowAdapter
	{  
		public void windowClosing(final WindowEvent event)
		{  
			System.exit(0);
		}
	}
}