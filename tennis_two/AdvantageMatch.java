package tennis_two;

public class AdvantageMatch extends AbstractMatch {

	public AdvantageMatch(Player firstServer, int targetScore, int advantage) {
		super(firstServer, targetScore, advantage);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Contest makeSubContest() {
		return TennisFactory.instance().makeAdvantageSet(pickServer());
	}

	@Override
	public String getContestName() {
		return getClass().getSimpleName();
	}
	
}
