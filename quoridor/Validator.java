package quoridor;

import java.util.LinkedList;
import java.util.StringTokenizer;

public class Validator {

	// TODO complete this class using your project code
	// you must implement the no-arg constructor and the check method
	
	// you may add extra fields and methods to this class
	// but the ProvidedTests code will only call the specified methods

	Square player1Square = new Square("e9");
	Square player2Square = new Square("e1");
	LinkedList <Wall> walls = new LinkedList<Wall>();
	
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
		for (int i = 0; st.hasMoreTokens() ; i++) {
			String temp = st.nextToken();
			if (temp.length() == 3) {
				walls.add(new Wall(temp));
			} else {
				if (i%2==0) {
					if (validMove(player1Square, new Square(temp))) {
						player1Square = new Square (temp);
					} else {
						return false;
					}
				} else {
					if (validMove(player2Square, new Square(temp))) {
						player2Square = new Square (temp);
					} else {
						return false;
					}
				}
			}
		}
		return false;
	}
	
	private boolean validMove (Square from, Square to) {
		/* Nota Bene:
		 * 
		 * General Movement:
		 * A pawn can move to a square directly adjacent to itself, provided
		 * it is not obstructed by a wall or pawn. See below.
		 * 
		 * Wall obstruction:
		 * Say the current square has coordinate (x, y).
		 * The only walls that can possibly obstruct the
		 * pawn are those at (x, y), (x, y-1), (x-1, y) and (x-1, y-1).
		 * 
		 * Pawn obstruction:
		 * When a pawn, say B is on a square directly adjacent to pawn A,
		 * then pawn A can move to any square directly adjacent to pawn B,
		 * and vice versa.
		 * 
		 * tiao
		 */
		
		return true;
	}

	private boolean validWallPlacement (Square northWest) {
		return false;
	}
	
	public boolean isOver (String moves) {
		StringTokenizer st = new StringTokenizer(moves);
		for (int i = 0; st.hasMoreTokens() ; i++) {
			if (i%2==0) {
				if (st.nextToken().endsWith("1")) {
					return true;
				}
			} else {
				if (st.nextToken().endsWith("9")) {
					return true;
				}
			}
		}
		return false;
	}
}