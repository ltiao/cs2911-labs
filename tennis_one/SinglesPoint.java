package tennis_one;

import java.util.Scanner;

import util.Two;

public class SinglesPoint implements Point {
	
    public final Two<Player> players;
	Player winner;
	
	public SinglesPoint(Player server, Player receiver) {
		players = Two.two (server, receiver);
	}

	@Override
    public Two <Player> players ()
    {
        return players;
    }

    public void play() {
		if (yesNoPrompt())
			winner = players._1;
		else
			winner = players._2;		

	}

	boolean yesNoPrompt() {
		Scanner input = new Scanner(System.in);
		do {
			System.out.print(players._1 + " serves. And wins? ");
			String line = input.nextLine().toLowerCase();
			if ("yes".startsWith(line)) return true;
			if ("no".startsWith(line)) return false;
			System.out.print("Server wins? ");
			System.out.println("Enter [\"yes\"] or \"no\"");
		} while (true);
	}

	@Override
	public boolean isNew() {
		return winner == null;
	}
	
	public boolean isOver() {
		return winner != null;
	}

	public Player winner() {
		return winner;
	}
	
    public Player loser() {
        return players.other (winner);
    }
    
	public int score(Player player) {
		if (player.equals(winner())) return 1;
		if (player.equals(loser())) return 0;
		throw new IllegalArgumentException(player + " is not a valid player");
	}
}
