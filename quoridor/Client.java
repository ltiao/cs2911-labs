package quoridor;

import java.util.Scanner;

public class Client {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Display board = new Board();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine())
			board.display(sc.nextLine());
	}

}
