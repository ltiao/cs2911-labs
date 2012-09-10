package tennis_one;

import util.Two;

public class SinglesGame implements Game
{
    
    public static String scoreAsString (int score, int other)
    {
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
    
    /** Players in game. First player is server. */
    // final indicates players do not change in game
    public final Two <Player> players;
    
    /** Score for player._1. */
    private int               score_1 = 0;
    
    /** Score for player._2. */
    private int               score_2 = 0;
    
    protected Point           point   = null;
    
    public SinglesGame (Player server, Player receiver)
    {
        if (server.equals (receiver))
            throw new IllegalArgumentException (
                    "Two players in game must be different");
        
        players = Two.two (server, receiver);
    }
    
    public Two <Player> players ()
    {
        return players;
    }
    
    public int score (Player player)
    {
        if (player.equals (players._1))
            return score_1;
        else if (player.equals (players._2))
            return score_2;
        else
            throw new IllegalArgumentException (
                    player + " is not a player in this game");
    }
    
    public boolean isNew ()
    {
        return score_1 == 0 && score_2 == 0;
    }
    
    public boolean isOver ()
    {
        return Math.max (score_1, score_2) >= 4
               && Math.abs (score_1 - score_2) >= 2;
    }
    
    public Player winner ()
    {
        assert isOver () : "require game over";
        return score_1 > score_2 ? players._1 : players._2;
    }
    
    public Player loser ()
    {
        return players ().other (winner ());
    }
    
    public Player server ()
    {
        return players ()._1;
    }
    
    public Player receiver ()
    {
        return players ()._2;
    }
    
    public void play ()
    {
        start ();
        while (!isOver ())
            playPoint ();
        finish ();
    }
    
    protected void playPoint ()
    {
        assert !isOver ();
        displayScore ();
        point = makePoint ();
        point.play ();
        Player winner = point.winner ();
        assert players ().has (winner);
        if (winner.equals (server ()))
            ++score_1;
        else
            ++score_2;
    }

    public Point makePoint ()
    {
//        return new SinglesPoint (server (), receiver ());
        return new RandomPoint (server (), receiver ());
    }
    
    protected void start ()
    {
        System.out.println ("Game");
        System.out.println ("====");
        System.out.format ("%-15s%s%n", "Server", "Receiver");
        System.out.format ("%-15.14s%s%n", server (), receiver ());
    }
    
    protected void displayScore ()
    {
        String serverScore = scoreAsString (server ());
        String receiverScore = scoreAsString (receiver ());
        System.out.format ("%-15s%s%n", serverScore, receiverScore);
    }
    
    protected void finish ()
    {
        displayScore ();
        System.out.println ("== Game winner: " + winner ());
    }
    
    protected String scoreAsString (Player p)
    {
        Player other = players.other (p);
        return scoreAsString (score (p), score (other));
    }
    
}
