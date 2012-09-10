package tennis_one;

import util.Two;

public interface Point {
	Two<Player> players();
	int score(Player player);
	boolean isNew();
	boolean isOver();
	Player winner();
	Player loser();

		// updates
	void play();
}
