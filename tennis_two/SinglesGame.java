package tennis_two;

public class SinglesGame extends SerialContest implements Game {

	public SinglesGame(Player firstServer, int targetScore, int advantage) {
		super(firstServer, targetScore, advantage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getContestName() {
		return getClass().getSimpleName();
	}

	@Override
	protected Contest makeSubContest() {
		return TennisFactory.instance().makePoint(firstServer);
	}

	@Override
    public String scoreAsString (Player player)
    {
		int score = score(player);
		int other = score(players().other(player));
        assert score >= 0 && other >= 0;
        switch (score) {
            case 0:
                return "00";
            case 1:
                return "15";
            case 2:
                return "30";
            case 3:
                return "40";
            default:
                if (score <= other)
                    return "40";
                if (score == other + 1)
                    return "Advantage";
                return "Game";
        }
    }

}
