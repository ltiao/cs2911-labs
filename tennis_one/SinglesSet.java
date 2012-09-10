package tennis_one;

import util.Two;

public class SinglesSet implements Set
{
    
    /** Players in set. First player is server of first game. */
    public final Two <Player> players;
    
    private int               score_1;
    private int               score_2;
    private Game              game;
    
    public SinglesSet (Player firstServer, Player firstReceiver)
    {
        if (firstServer.equals (firstReceiver))
            throw new IllegalArgumentException (
                    "Two players in set must be different");
        
        players = Two.two (firstServer, firstReceiver);
    }
    
    public Two <Player> players ()
    {
        return players;
    }
    
    public int score (Player player)
    {
        if (player.equals (players ()._1 ()))
            return score_1;
        else if (player.equals (players ()._2 ()))
            return score_2;
        else
            throw new IllegalArgumentException (
                    player + " is not a player in this set");
    }
    
    public boolean isNew ()
    {
        return score_1 == 0 && score_2 == 0;
    }
    
    public boolean isOver ()
    {
        return Math.max (score_1, score_2) >= 6
               && Math.abs (score_1 - score_2) >= 2;
    }
    
    public Player winner ()
    {
        assert isOver () : "require set over";
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
            playGame ();
        finish ();
    }
    
    protected void start ()
    {}
    
    protected void playGame ()
    {
        assert !isOver ();
        
        Player server = serverNextGame ();
        
        game = new SinglesGame (server, players.other (server));
        displayScore ();
        
        game.play ();
        if (game.winner ().equals (players._1))
            ++score_1;
        else
            ++score_2;
    }
    
    protected Player serverNextGame ()
    {
        assert game == null || game.isOver ();
        Player firstServer = players._1;
        if ((score_1 + score_2) % 2 == 0)
            return firstServer;
        else
            return players ().other (firstServer);
    }
    
    protected void finish ()
    {
        displayScore ();
        System.out.println ("== Set winner is " + winner ());
    }
    
    void displayScore ()
    {
        System.out.println ("Set Score");
        System.out.println ("=========");
        System.out.format ("%-15.15s %-15.15s%n", players ()._1 (),
                players ()._2 ());
        System.out.format ("%-15.15s %-15.15s%n", score_1, score_2);
    }
}
