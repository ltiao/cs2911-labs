package tennis_two;

public class TieBreakSet extends SerialContest implements Set {

	public TieBreakSet(Player firstServer, int targetScore, int advantage) {
		super(firstServer, targetScore, advantage);

	}

	@Override
	public String getContestName() {
		return getClass().getSimpleName();
	}

	@Override
	protected Contest makeSubContest() {
		Player server = firstServer;
		if (currentSubContest != null)
			server = currentSubContest.receiver();
		if (tieBreak ())
			return TennisFactory.instance().makeTieBreakGame(server);
		else
			return TennisFactory.instance().makeSinglesGame(server);
	}

	@Override
	public boolean isOver ()
    {
		if (tieBreak () == true) {
			return Math.max (score_1, score_2) >= 7
            && Math.abs (score_1 - score_2) >= 1;
		} else {
			return Math.max (score_1, score_2) >= targetScore
            && Math.abs (score_1 - score_2) >= targetAdvantage;
		}
    }
	
	public boolean tieBreak ()
	{
		return score(firstServer) >= 6 && score(players().other(firstServer)) >= 6;
	}

}