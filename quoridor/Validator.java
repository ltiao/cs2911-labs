package quoridor;

import java.util.LinkedList;
import java.util.StringTokenizer;

public class Validator {

	// TODO complete this class using your project code
	// you must implement the no-arg constructor and the check method
	
	// you may add extra fields and methods to this class
	// but the ProvidedTests code will only call the specified methods
	LinkedList <String> player1Moves = new LinkedList<String>();
	LinkedList <String> player2Moves = new LinkedList<String>();
	
	public Validator() {
		// TODO
	}

	/**
	 * Check the validity of a given sequence of moves.
	 * The sequence is valid if and only if each (space separated)
	 * move in the list is valid,
	 * starting from the initial position of the game.
	 * When the game has been won, no further moves are valid.
	 * @param moves a list of successive moves
	 * @return validity of the list of moves
	 */
	public boolean check(String moves) {
		StringTokenizer st = new StringTokenizer(moves);
		for (int i = 0 ; st.hasMoreTokens() ; i++) {
			if (i%2 == 0) {
				player1Moves.add(st.nextToken());
			} else {
				player2Moves.add(st.nextToken());
			}
		}
		return false;
	}

}