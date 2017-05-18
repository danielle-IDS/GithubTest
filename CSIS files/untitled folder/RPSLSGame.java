//dince16@georgefox.edu
// Program 6
// 2016-02-20

import java.util.Scanner;

/**
 * This class handles menu selections, user input, and scoring for a Rock, Paper, Scissors, Lizard, Spock game.
 * @author danielleince
 *
 */
public class RPSLSGame {
	
	final static int ONE_PLAYER = 1;
	final static int TWO_PLAYERS = 2;
	final static int QUIT = 3;
	
	final static int TIE_COUNT = 0;
	final static int P1_COUNT = 1;
	final static int P2_COUNT = 2;
	
	final static String MENU = "1. Play Human vs Computer (1 Player) \n"
								+ "2. Play Human vs Human (2 Player) \n"
								+ "3. Quit";

	/**
	 * This method prints out the menu and then prompts the user to choose an option.
	 * @param in
	 * @return the user's menu choice (string)
	 */
	private static int getMenuChoice(Scanner in)
	{
		int menuChoice = 0;
		do
		{
			System.out.println(MENU);
			System.out.println();
			System.out.print("Choice.................... ");
			if (in.hasNextInt())
			{
				menuChoice = in.nextInt();
			}				
		}
		while (menuChoice != ONE_PLAYER && menuChoice != TWO_PLAYERS && menuChoice != QUIT);
		return menuChoice;	
	}
	
	/**
	 * This method Prompts the user for their move then executes the makeMove() method of the RPSPS class.
	 * It then continues to prompt the user if their input is not valid and prints the computers move and 
	 * results of the match.
	 * @param RPSLS
	 * @param in
	 */
	private static void player1Mode(TheRockPaperScissorsLizardSpock RPSLS, Scanner in)
	{
		System.out.print("Player-1, Your Move (Rock, Paper, Scissors, Lizard, Spock): ");
		in.skip("\n");
		String move = in.next();
		RPSLS.makeMove(move);
		while (!(RPSLS.isValidMove(move)))
		{
			System.out.println("Not a valid move. Please enter Rock, Paper, Scissors, Lizard, Spock");
			System.out.print("Player-1, Your Move (Rock, Paper, Scissors, Lizard, Spock): ");
			move = in.next();

		}
		RPSLS.makeMove(move);
		System.out.println("Computer's move: " + RPSLS.getComputerMove());
		System.out.println("Results: " + RPSLS.getResults());
		System.out.println();
	}
	
	/**
	 * This method Prompts both users for their move then executes the makeMove() method of the RPSPS class.
	 * It then continues to prompt the users if their input is not valid and prints the results of the match.
	 * @param RPSLS
	 * @param in
	 */
	private static void player2Mode(TheRockPaperScissorsLizardSpock RPSLS, Scanner in)
	{
		System.out.print("Player-1, Your Move (Rock, Paper, Scissors, Lizard, Spock): ");
		in.skip("\n");
		String p1Move = in.next();
		while (!(RPSLS.isValidMove(p1Move)))
		{
			System.out.println("Not a valid move. Please enter Rock, Paper, Scissors, Lizard, Spock");
			System.out.print("Player-1, Your Move (Rock, Paper, Scissors, Lizard, Spock): ");
			p1Move = in.next();
		}
		System.out.print("Player-2, Your Move (Rock, Paper, Scissors, Lizard, Spock): ");
		in.skip("\n");
		String p2Move = in.next();
		while (!(RPSLS.isValidMove(p2Move)))
		{
			System.out.println("Not a valid move. Please enter Rock, Paper, Scissors, Lizard, Spock");
			System.out.print("Player-2, Your Move (Rock, Paper, Scissors, Lizard, Spock): ");
			p2Move = in.next();
		}
		RPSLS.makeMove(p1Move, p2Move);
		System.out.println("Results: " + RPSLS.getResults());
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
				
		System.out.println("Welcome to Rock-Paper-Scissors-Lizard-Spock");
		System.out.println("Please choose from the following menu:");
		System.out.println();
		
		int gameType = getMenuChoice(in);
		TheRockPaperScissorsLizardSpock RPSLS = new TheRockPaperScissorsLizardSpock(gameType);

		
		while (gameType != QUIT)
		{
			System.out.print("How many rounds to play... ");
			int numRounds = in.nextInt();
			System.out.println();
			
			int[] tallyCount = { 0, 0, 0 };
			
			for (int i = 0; i < numRounds; i++)
			{				
				if (gameType == ONE_PLAYER)
				{
					player1Mode(RPSLS, in);
				}
				else
				{
					player2Mode(RPSLS, in);
				}
				tallyCount[RPSLS.determineWinner()]++;
			}
			if(gameType == ONE_PLAYER)
			{
				System.out.println("Game Results: Player 1: " + tallyCount[P1_COUNT] + " wins, Computer: "+ tallyCount[P2_COUNT] + ", Ties: " + tallyCount[TIE_COUNT]);
			}
			else if(gameType == TWO_PLAYERS)
			{
				System.out.println("Game Results: Player 1: " + tallyCount[P1_COUNT] + ", Player 2: "+ tallyCount[P2_COUNT] + ", Ties: " + tallyCount[TIE_COUNT]);
			}
			System.out.println();
			gameType = getMenuChoice(in);
			RPSLS.resetGame(gameType);						
		}
		System.out.println("Thank you for playing!");
	}

}
