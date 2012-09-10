package tennis_two;

/**
 * A two-player contest played as a sequence of sub-contests. A serial contest
 * is over when one player reaches the target score, with a specified advantage
 * over the other player. For most types of contest, this advantage should be
 * set to 1 or 2. Subclasses should define the actual sub-contest type. To
 * specify use the SerialContest constructor
 */
public abstract class SerialContest extends AbstractContest
{
    
    final int targetScore;
    final int targetAdvantage;
    int       score_1;
    int       score_2;
    Contest   currentSubContest;
    
    /**
     * Initialise this instance. SerialContest is abstract, and so this
     * constructor is intended for use via calls to super(...) in subclasses.
     * This is where the target score and target advantage should be specified
     * for the particular type of contest being defined.
     * 
     * @param firstServer
     *            the player that starts serving in this contest
     * @param targetScore
     *            the minimum score required to win the contest
     * @param advantage
     *            the minimum lead required to win the contest
     */
    protected SerialContest (Player firstServer, int targetScore, int advantage)
    {
        super (firstServer);
        this.targetScore = targetScore;
        this.targetAdvantage = advantage;
        score_1 = 0;
        score_2 = 0;
    }
    
    public int score (Player player)
    {
        if (players ()._1 ().equals (player))
            return score_1;
        if (players ()._2 ().equals (player))
            return score_2;
        throw new IllegalArgumentException (player + " is not a valid player");
    }
    
    public boolean isOver ()
    {
        return Math.max (score_1, score_2) >= targetScore
               && Math.abs (score_1 - score_2) >= targetAdvantage;
    }
    
    public void play ()
    {
        start ();
        while (!isOver ())
            playSubContest ();
        finish ();
        
    }
    
    protected void start ()
    {
        if (TennisFactory.instance ().displayIsEnabled ()) {
            System.out.print (getContestName ());
            System.out.println (" starts");
        }
    }
    
    protected void playSubContest ()
    {
        currentSubContest = makeSubContest ();
        currentSubContest.play ();
        
        onSubContestOver ();
    }
    
    protected abstract Contest makeSubContest ();
    
    protected void onSubContestOver ()
    {
        Player subWinner = currentSubContest.winner ();
        assert players ().has (subWinner);
        
        if (players ()._1.equals (subWinner))
            ++score_1;
        else
            ++score_2;
        
        display ();
    }

    protected void finish ()
    {
        if (TennisFactory.instance ().displayIsEnabled ()) {
            System.out.print (winner ());
            System.out.print (" wins ");
            System.out.println (getContestName ());
            System.out.println ();
        }
    }
}
