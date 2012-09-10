package tennis_two;

public class TieBreakMatch extends AbstractMatch {

	public TieBreakMatch(Player firstServer, int targetScore, int advantage) {
		super(firstServer, targetScore, advantage);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Contest makeSubContest() {
		return TennisFactory.instance().makeTieBreakSet(pickServer());
	}

	@Override
	public String getContestName() {
		return getClass().getSimpleName();
	}

}
