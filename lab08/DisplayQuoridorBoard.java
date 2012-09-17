package lab08;

public class DisplayQuoridorBoard implements Display {

	static final int BOARD_SIZE = 9;
	
	@Override
	public void display(String moves) {
		for (int i = 0 ; i < 2*BOARD_SIZE+1 ; i++) {
			for (int j = 0 ; j < 2*BOARD_SIZE+1 ; j++) {
				print (i,j);
			}
		}
	}
	
	private void print (int i, int j) {
		if ((i+j)%2 == 0) {
			if (j%2==0) {
				System.out.print ("+");
			}				
			else
				System.out.print ("   ");
		} else {
			if (i%2==0)
				System.out.print ("---");
			else {
				System.out.print ("|");
			}
				
		}
		if (j==2*BOARD_SIZE) 
			System.out.println ();
	}

}
