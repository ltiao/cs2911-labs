package tennis_two;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractMatch extends SerialContest implements Match {

	private List <Integer> history_1 = new LinkedList <Integer> ();
	private List <Integer> history_2 = new LinkedList <Integer> ();
	
	protected AbstractMatch(Player firstServer, int targetScore, int advantage) {
		super(firstServer, targetScore, advantage);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected  abstract Contest makeSubContest();

	@Override
	public abstract String getContestName();

	@Override
    protected void overridableDisplay ()
    {	
		displayPlayerHistory(players()._1);
		displayPlayerHistory(players()._2);
    }

	@Override
    protected void onSubContestOver ()
    {
		//require (currentSubContest != null, "Currently has subcontest");
        Player subWinner = currentSubContest.winner ();
        assert players ().has (subWinner);
        
        if (players ()._1.equals (subWinner))
            ++score_1;
        else
            ++score_2;
        
        history_1.add(currentSubContest.score(players()._1));
        history_2.add(currentSubContest.score(players()._2));

        display ();
    }
	
	protected Player pickServer () {
		Player server = firstServer;
		if ( currentSubContest != null) {
			if ((currentSubContest.score(players()._1) + currentSubContest.score(players()._2)) % 2 == 0)
				server = currentSubContest.server();
			else
				server = currentSubContest.receiver();
		}
		return server;
	}
	
    public List <Integer> history (Player player)
    {
        if (players ()._1 ().equals (player))
            return history_1;
        if (players ()._2 ().equals (player))
            return history_2;
        throw new IllegalArgumentException (player + " is not a valid player");
    }
    
    protected void displayPlayerHistory (Player player)
    {
        System.out.format ("%-15s", player);
        for (Integer e : history(player))
        	System.out.format ("%3s", e);
        System.out.println();
    }
}
