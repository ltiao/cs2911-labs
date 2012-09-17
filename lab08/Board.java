package lab08;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Board implements Display {

	static final int BOARD_SIZE = 9;
	//List<String>[] playerMoves = new LinkedList<String>[2];
	
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
						System.out.print((i+1)/2);
				}
				print (i,j);
			}
		}
	}
	
	private void parse (String moves) {
	     StringTokenizer st = new StringTokenizer(moves);
	     while (st.hasMoreTokens()) {
	         System.out.println(st.nextToken());
	     }
	}
	
	private void print (int i, int j) {
		if ((i+j)%2 == 0) {
			if (j%2 == 0) {
				System.out.print ("+");
			}				
			else
				System.out.print ("   ");
		} else {
			if (i%2 == 0)
				System.out.print ("---");
			else {
				System.out.print ("|");
			}
				
		}
		if (j == 2*BOARD_SIZE) 
			System.out.println ();
	}

}
