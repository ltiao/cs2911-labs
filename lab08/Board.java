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

	HashMap <Square,Orientation> walls = new HashMap<Square,Orientation>(); 
	Square player1Square = new Square("e9");
	Square player2Square = new Square("e1");
	private HashMap <Square,Orientation> johnWalls = new HashMap<Square,Orientation>();
	
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
	    		 walls.put (translateSquare(temp), translateOrientation(temp));
	    	 } else {
	    		 if (i%2==0) {
	    			 player1Square = new Square (temp);
	    		 } else {
	    			 player2Square = new Square (temp);
	    		 }
	    	 }
	     }
	     for (Square e : walls.keySet()) {
	    	 //System.out.println(e + " = " + walls.get(e));
	    	 if (walls.get(e) == Orientation.HORIZONTAL) {
	    		 johnWalls.put(new Square((e.getX()+1)<<1,((e.getY()+1)<<1)+1), walls.get(e));
	    		 johnWalls.put(new Square((e.getX()+1)<<1,((e.getY()+1)<<1)-1), walls.get(e));
	    	 } else {
	    		 johnWalls.put(new Square(((e.getX()+1)<<1)+1,(e.getY()+1)<<1), walls.get(e));
	    		 johnWalls.put(new Square(((e.getX()+1)<<1)-1,(e.getY()+1)<<1), walls.get(e));
	    	 }
	     }
	     //System.out.println(walls.containsKey(new Position(0,3)));
	}
	
	private boolean hasPlayer (int i, int j) {
		Square transformedPosition = new Square((i-1)>>1,(j-1)>>1);
		return player1Square.equals(transformedPosition) || player2Square.equals(transformedPosition);
	}

	private boolean hasWall (int i, int j) {
		return johnWalls.containsKey(new Square(i, j));
	}

	private void print (int i, int j) {
		if ((i+j)%2 == 0) {
			if (j%2 == 0) {
				System.out.print ("+");
			} else {
				if (hasPlayer(i,j))
					System.out.print (" * ");
				else
					System.out.print ("   ");	
			}
		} else {
			if (i%2 == 0) {
				if (hasWall(i,j))
					System.out.print ("###");
				else
					System.out.print ("---");
			} else {
				if (hasWall(i,j))
					System.out.print ("#");
				else
					System.out.print ("|");		
			}

		}
		if (j == 2*BOARD_SIZE) 
			System.out.println ();
	}

	private Square translateSquare (String move) {
		return new Square(move);
	}
	
	private Orientation translateOrientation (String move) {
		return move.charAt(2)=='h'?Orientation.HORIZONTAL:Orientation.VERTICAL;	
	}
	
}