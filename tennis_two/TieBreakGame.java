package tennis_two;

public class TieBreakGame extends SerialContest implements Game {

	int point;
	Player currentServer = firstServer;
	
	public TieBreakGame(Player firstServer, int targetScore, int advantage) {
		super(firstServer, targetScore, advantage);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Contest makeSubContest() {
		if (point%2==1) {
			currentServer = players().other(currentServer);
		}
		point++;
		return TennisFactory.instance().makePoint(currentServer);
	}

	@Override
	public String getContestName() {
		return getClass().getSimpleName();
	}

}
