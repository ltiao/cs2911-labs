package lab08;

import java.util.LinkedList;
import java.util.StringTokenizer;

public class Board implements Display {

	static final int BOARD_SIZE = 9;
	static final char PLAYER_1_ICON = 'A';
	static final char PLAYER_2_ICON = 'B';
	
	@SuppressWarnings("unchecked")
	LinkedList<String>[] playerMoves = (LinkedList<String>[]) new LinkedList[2];
	Position[] playerPosition = new Position[2];
	
	public Board() {
		// Have to initialize these array elements due to dodgy Java generic flaw/features
		playerMoves[0] = new LinkedList<String>();
		playerMoves[1] = new LinkedList<String>();
		playerPosition[0] = new Position(0,4);
		playerPosition[1] = new Position(8,4);
	}

	@Override
	public void display(String moves) {
		parse(moves);
		System.out.print("   ");
		for (char c = 'a' ; c < 'j' ; c++)
			System.out.print(c+"   ");
		System.out.println ();
		for (int i = 0 ; i < 2*BOARD_SIZE+1 ; i++) {
			for (int j = 0 ; j < 2*BOARD_SIZE+1 ; j++) {
				if (j == 0) {		
					if (i%2==0)
						System.out.print(" ");
					else
						System.out.print((i+1)>>1);
				}
				print (i,j);
			}
		}
	}
	
	private void parse (String moves) {
	     StringTokenizer st = new StringTokenizer(moves);
	     String temp = null;
	     for (int i = 0 ; st.hasMoreTokens() ; i++) {
	    	 temp = st.nextToken();
	    	 playerMoves[i%2].add(temp);
	    	 //System.out.println(temp);
	     }
	     /*for (String e : playerMoves[0]) {
	    	 System.out.println(e);
	     }
	     for (String e : playerMoves[1]) {
	    	 System.out.println(e);
	     }*/
	     System.out.println(playerMoves[0].getLast());
	     System.out.println(playerMoves[1].getLast());
	     playerPosition[0] = new Position(playerMoves[0].getLast().charAt(1)-'1',playerMoves[0].getLast().charAt(0)-'a');
	     playerPosition[1] = new Position(playerMoves[1].getLast().charAt(1)-'1',playerMoves[1].getLast().charAt(0)-'a');
	}
	
	private boolean hasPlayer (int i, int j) {
		Position transformedPosition = new Position((i-1)>>1,(j-1)>>1);
		return playerPosition[0].equals(transformedPosition) || playerPosition[1].equals(transformedPosition);
	}
	
	private boolean hasWall (int i, int j) {
		return false;
	}
	
	private void print (int i, int j) {
		if ((i+j)%2 == 0) {
			if (j%2 == 0) {
				System.out.print ("+");
			}				
			else {
				if (hasPlayer(i,j)) {
					System.out.print (" * ");
				} else {
					System.out.print ("   ");	
				}
			}
		} else {
			if (i%2 == 0)
				if (hasWall(i,j))
					System.out.print ("###");
				else
					System.out.print ("---");
			else {
				if (hasWall(i,j))
					System.out.print ("#");
				else
					System.out.print ("|");		
			}
				
		}
		if (j == 2*BOARD_SIZE) 
			System.out.println ();
	}

}
