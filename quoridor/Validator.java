package quoridor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Validator {

	// TODO complete this class using your project code
	// you must implement the no-arg constructor and the check method
	
	// you may add extra fields and methods to this class
	// but the ProvidedTests code will only call the specified methods

	/**
	 * A hybrid of graph representation suggestions by van Rossum and Cormen et al:
	 * A hash table is used to associate each vertex with a doubly linked list of adjacent vertices
	 */
	HashMap <Square,LinkedList<Square>> adjacencyList = new HashMap <Square,LinkedList<Square>> ();
	
	Square player1Square = new Square("e9");
	Square player2Square = new Square("e1");
	LinkedList <Wall> walls = new LinkedList<Wall>();
	
	public Validator() {
		for (int i = 0; i < Board.BOARD_SIZE; i++) {
			for (int j = 0; j < Board.BOARD_SIZE; j++) {
				LinkedList<Square> temp = new LinkedList<Square>();
				for (int d = -1; d < 2; d++) {
					if (d != 0) { // Vertices are not self-connecting
						if (i+d >= 0 && i+d < Board.BOARD_SIZE)
							temp.add(new Square(i+d,j));
						if (j+d >= 0 && j+d < Board.BOARD_SIZE)
							temp.add(new Square(i,j+d));
					}
				}
				adjacencyList.put(new Square(i,j), temp);
			}
		}
	}
	
	public void displayAdjacencyList () {
		for (Square e:adjacencyList.keySet()) {
			System.out.println(e+": "+adjacencyList.get(e));
		}
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
					if (isAdjacent(player1Square, new Square(temp))) {
						player1Square = new Square (temp);
					} else {
						return false;
					}
				} else {
					if (isAdjacent(player2Square, new Square(temp))) {
						player2Square = new Square (temp);
					} else {
						return false;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * <b>General Movement:</b>
	 * A pawn can move to a square directly adjacent to itself, provided
	 * it is not obstructed by a wall or pawn. See below.
	 * <br/>
	 * <b>Wall obstruction:</b>
	 * Say the current square has coordinate (x, y).
	 * The only walls that can possibly obstruct the
	 * pawn are those at (x, y), (x, y-1), (x-1, y) and (x-1, y-1).
	 * <br/>
	 * <b>Pawn obstruction:</b>
	 * When a pawn, say B is on a square directly adjacent to pawn A,
	 * then pawn A can move to any square directly adjacent to pawn B,
	 * and vice versa.
	 *
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean isAdjacent (Square a, Square b) {
		return adjacencyList.get(a).contains(b);
	}

	public boolean validWallPlacement (Square northWest) {
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