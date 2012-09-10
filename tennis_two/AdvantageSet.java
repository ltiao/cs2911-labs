package tennis_two;

public class AdvantageSet extends SerialContest implements Set {
		
	public AdvantageSet(Player firstServer, int targetScore, int advantage) {
		super(firstServer, targetScore, advantage);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Contest makeSubContest() {		
		Player server = firstServer;
		if (currentSubContest != null)
			server = currentSubContest.receiver();
		return TennisFactory.instance().makeSinglesGame(server);
	}

	@Override
	public String getContestName() {
		return getClass().getSimpleName();
	}

}
