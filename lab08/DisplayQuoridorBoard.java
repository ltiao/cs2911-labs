package lab08;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class DisplayQuoridorBoard implements Display {

	static final int BOARD_SIZE = 9;
	//private List <String> moves = new LinkedList<String>();
	
	@Override
	public void display(String moves) {
		for (int i = 0 ; i < 2*BOARD_SIZE+1 ; i++) {
			for (int j = 0 ; j < 2*BOARD_SIZE+1 ; j++) {
				print (i,j);
			}
		}
		/*
		parseString (moves);
		for (int i = 0 ; i < 2*BOARD_SIZE+1 ; i++) {
			if (i%2 == 0) { 
				printHorizontal ();
			} 
			else {
				printVertical ();	
			}
		}
		*/
	}
	
	private void parseString (String moves) {
		 StringTokenizer st = new StringTokenizer(moves);
		 while (st.hasMoreTokens()) {
	         System.out.println(st.nextToken());
	     }
		 //System.out.println(moves);
	}
	
	private void printHorizontal() {
		for (int i = 0 ; i < 2*BOARD_SIZE+1 ; i++) {
			if (i%2 == 0) {
				System.out.print("+");
				//System.out.print(i);
			}
			else {
				System.out.print("---");
			}
			
		}
		System.out.println();
	}
	
	private void printVertical() {
		for (int i = 0 ; i < 2*BOARD_SIZE+1 ; i++) {
			if (i%2 == 0) {
				System.out.print("|");
				//System.out.print(i);
			}
			else {
				System.out.print("   ");
			}
		}
		System.out.println();
	}
	
	private void print (int i, int j) {
		if ((i+j)%2 == 0) {
			if (j%2==0) {
				System.out.print ("+");
				if (j==2*BOARD_SIZE) 
					System.out.println ();
			}				
			else
				System.out.print ("   ");
		} else {
			if (i%2==0)
				System.out.print ("---");
			else {
				System.out.print ("|");
				if (j==2*BOARD_SIZE) 
					System.out.println ();
			}
				
		}
	}

}
