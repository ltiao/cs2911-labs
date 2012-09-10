package tennis_one;

import util.Two;

public interface Game {
	Two<Player> players();
	int score(Player player);
	boolean isNew();
	boolean isOver();
	Player winner();
	Player loser();

		// updates
	void play();
}
