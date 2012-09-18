package lab08;

import java.util.HashMap;
import java.util.StringTokenizer;

public class Board implements Display {

	static final int BOARD_SIZE = 9;
	static final char PLAYER_1_ICON = 'A';
	static final char PLAYER_2_ICON = 'B';
	
	public enum Orientation {
		VERTICAL, HORIZONTAL;
	}

	HashMap <Position,Orientation> walls = new HashMap<Position,Orientation>(); 
	Position player1Position = new Position(0,4);
	Position player2Position = new Position(8,4);
	
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
	     for (int i = 0; st.hasMoreTokens() ; i++) {
	    	 String temp = st.nextToken();
	    	 if (temp.length() == 3) {
	    		 walls.put(new Position(temp.charAt(1)-'1',temp.charAt(0)-'a'),temp.charAt(2)=='h'?Orientation.HORIZONTAL:Orientation.VERTICAL);
	    	 } else {
	    		 if (i%2==0) {
	    			 player1Position = new Position(temp.charAt(1)-'1',temp.charAt(0)-'a');
	    		 } else {
	    			 player2Position = new Position(temp.charAt(1)-'1',temp.charAt(0)-'a');
	    		 }
	    	 }
	     }
	     for (Position e : walls.keySet()) {
	    	 System.out.println(e + " = " + walls.get(e));
	     }
	     System.out.println(walls.containsKey(new Position(0,3)));
	}

	private boolean hasPlayer (int i, int j) {
		Position transformedPosition = new Position((i-1)>>1,(j-1)>>1);
		return player1Position.equals(transformedPosition) || player2Position.equals(transformedPosition);
	}

	private boolean hasWall (int i, int j) {
		//System.out.println(new Position(i,j));
		return walls.containsKey(new Position(i/2-1,j/2-1));
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