//dince16@georgefox.edu
// Program 6
// 2016-02-20

import java.util.Random;

/**
 * This class holds all the components need to play a game of Rock Paper Scissors Lizard Spock.  
 * It has three arrays that hold possible valid moves, the winner of each match up and the verb used to describe
 * the outcome of each match up.  It also has methods with capabilities that include making moves, determining 
 * the winner, getting results, and testing the validity of a user's move.
 * @author danielleince
 *
 */
public class TheRockPaperScissorsLizardSpock {
	
	final static int TIE = 0;
	final static int P1WIN = 1;
	final static int P2WIN = 2;
	
	static final String[] VALID_MOVES = { "Rock", "Paper", "Scissors", "Lizard", "Spock" };
	static final int[][] RESULTS = 
		{
			{ TIE, P1WIN, P2WIN, P2WIN, P1WIN },
			{ P2WIN, TIE, P1WIN, P1WIN, P2WIN },
			{ P1WIN, P2WIN, TIE, P2WIN, P1WIN },
			{ P1WIN, P2WIN, P1WIN, TIE, P2WIN },
			{ P2WIN, P1WIN, P2WIN, P1WIN, TIE },
		};
	
	static final String[][] VERB_RESULTS = 
		{
			{ "ties", "covers", "crushes", "crushes", "vaporizes" },
			{ "covers", "ties", "cuts", "eats", "disproves" },
			{ "crushes", "cuts", "ties", "decapitates", "smashes" },
			{ "crushes", "eats", "decapitates", "ties", "poisons" },
			{ "vaporizes", "disproves", "smashes", "poisons", "ties" },
		};
	
	private int gameType;
	private int p1Move, p2Move;

	/**
	 * Constructs a TheRockPaperScissorsLizardSpock object with a specific game type and with the different
	 * player moves set to a default value of -1
	 * @param gameType
	 */
	public TheRockPaperScissorsLizardSpock(int gameType)
	{
		this.gameType = gameType;
		this.p1Move = -1;
		this.p2Move = -1;
	}
	
	/**
	 * This methods receives a new game type that the user wants to switch to 
	 * @param gameType
	 */
	public void resetGame(int gameType)
	{
		this.gameType = gameType;
		this.p1Move = -1;
		this.p2Move = -1;
	}
	
	/**
	 * This method receives a (String) player move and tests it against each element of the valid moves array.
	 * It then sets the player move variable to the index of the element that matches
	 * @param p1Move
	 */
	public void makeMove(String p1Move)
	{
		for (int i = 0; i < VALID_MOVES.length; i++)
		{
			if (VALID_MOVES[i].toLowerCase().equals(p1Move.toLowerCase()))
			{
					this.p1Move = i;
			}
		}
	}
	
	/**
	 * This methods receives two parameters and tests both of them against the elements in the valid moves array
	 * It then sets each players variable to the index of the matching element.
	 * @param p1Move
	 * @param p2Move
	 */
	public void makeMove(String p1Move, String p2Move)
	{
		for (int i = 0; i < VALID_MOVES.length; i++)
		{
			if (VALID_MOVES[i].toLowerCase().equals(p1Move.toLowerCase()))
			{
					this.p1Move = i;
			}
			if (VALID_MOVES[i].toLowerCase().equals(p2Move.toLowerCase()))
			{
					this.p2Move = i;
			}
		}
	}
	
	/**
	 * This method determines the winner by finding the element in the two dimensional array at the index that
	 * matches the the player 1 move and player 2 move.
	 * @return the winner(player 1, player 2, or tie).
	 */
	public int determineWinner()
	{
		return RESULTS[p2Move][p1Move];
	}
	
	/**
	 * This method tests the winner at index player 1 move and player 2 move in the results array and constructs 
	 * a string with the the winning player followed by the verb from the verb results array and the losing 
	 * player.
	 * @return a sting that describes how one player wins over the other
	 */
	public String getResults()
	{
		if (RESULTS[p2Move][p1Move] == 1)
		{
			return VALID_MOVES[p1Move] + " " + VERB_RESULTS[p2Move][p1Move] + " " + VALID_MOVES[p2Move];
		}
		if (RESULTS[p2Move][p1Move] == 2)
		{
			return VALID_MOVES[p2Move] + " " + VERB_RESULTS[p2Move][p1Move] + " " + VALID_MOVES[p1Move];
		}
		else
		{
			return VALID_MOVES[p1Move] + " " + VERB_RESULTS[p2Move][p1Move] + " " + VALID_MOVES[p2Move];
		}
	}
	
	public String getComputerMove()
	{
		int cMove = (int)(Math.random() * 5);
		this.p2Move = cMove;
		return VALID_MOVES[p2Move];
	}
	
	public boolean isValidMove(String move)
	{
		for (int i = 0; i < VALID_MOVES.length; i++)
		{
			String caseSensitiveMove = VALID_MOVES[i].toLowerCase();
			if (caseSensitiveMove.equals(move.toLowerCase()))
			{
					return true;
			}
		}
		return false;
	}

}
