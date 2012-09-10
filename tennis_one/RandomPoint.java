package tennis_one;

import java.util.Random;

public class RandomPoint extends SinglesPoint {
	
    public static Random random = new Random ();
    
    public Player randomPlayer ()
    {
        if (random.nextBoolean ())
            return players._1;
        else
            return players._2;
    }
    
	public RandomPoint(Player server, Player receiver) {
		super(server, receiver);
	}

	@Override
	public void play() {
		winner = randomPlayer();
	}

}
