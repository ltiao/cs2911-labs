package tennis_one;

import java.util.ArrayList;
import java.util.List;

import util.Two;

public class SinglesMatch implements Match
{
    
    public final Two <Player> players;
    public final int          maxSetCount;
    
    private int               score_1 = 0;
    private int               score_2 = 0;
    
    private final List <Set>  listOfSets;
    private int         completedGameCount;
    
    public SinglesMatch (Player firstServer, Player firstReceiver,
            int maxSetCount)
    {
        if (firstServer.equals (firstReceiver))
            throw new IllegalArgumentException ("players must be distinct");
        if (maxSetCount % 2 == 0)
            throw new IllegalArgumentException (
                    "require maximum number of sets to be odd");
        
        players = Two.two (firstServer, firstReceiver);
        this.maxSetCount = maxSetCount;
        listOfSets = new ArrayList <Set> (maxSetCount);
        completedGameCount = 0;
    }
    
    public Two <Player> players ()
    {
        return players;
    }
    
    public int score (Player player)
    {
        if (player.equals (players._1 ()))
            return score_1;
        else if (player.equals (players._2 ()))
            return score_2;
        else
            throw new IllegalArgumentException (
                    player + " is not a player in this match");
    }
    
    public boolean isNew ()
    {
        return score_1 == 0 && score_2 == 0;
    }
    
    public boolean isOver ()
    {
        return Math.max (score_1, score_2) > maxSetCount / 2;
    }
    
    public Player winner ()
    {
        assert isOver () : "require match over";
        return score_1 > score_2 ? players._1 : players._2;
    }
    
    public Player loser ()
    {
        return players ().other (winner ());
    }
    
    public void play ()
    {
        start ();
        while (!isOver ())
            playSet ();
        finish ();
    }
    
    protected void start ()
    {}
    
    protected void playSet ()
    {
        assert !isOver ();
        displayScore ();
        
        Player server = serverNextSet ();
        
        Set set = new SinglesSet (server, players.other (server));
        listOfSets.add (set);
        
        set.play ();
        if (set.winner ().equals (players ()._1 ()))
            ++score_1;
        else
            ++score_2;
        
        assert set.isOver ();
        
        completedGameCount += set.score (players._1) + set.score (players._2);
        
    }
    
    protected Player serverNextSet ()
    {
        // only valid in between sets
        assert listOfSets.isEmpty () || allSetsAreOver ();
        Player firstServer = players._1;
        if (completedGameCount % 2 == 0)
            return firstServer;
        else
            return players.other (firstServer);
    }
    
    boolean allSetsAreOver ()
    {
        for (Set set : listOfSets)
            if (!set.isOver ())
                return false;
        return true;
    }
    
    protected void finish ()
    {
        displayScore ();
        System.out.println ("== Match winner is " + winner ());
        
    }
    
    protected void displayScore ()
    {
        System.out.println ("Match Score");
        System.out.println ("===========");
        System.out.format ("%3.3s : %-15.15s %-15.15s%n", "Set", players._1,
                players._2);
        
        int setNumber = 0;
        for (Set set : listOfSets) {
            ++setNumber;
            int setScore_1 = set.score (players._1);
            int setScore_2 = set.score (players._2);
            System.out.format ("%3.3s : %-15.15s %-15.15s%n", "#" + setNumber,
                    setScore_1, setScore_2);
        }
    }
}
