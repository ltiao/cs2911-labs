package tennis_two;

import static util.Contract.require;
import util.Two;

public abstract class AbstractContest implements Contest
{
    
    public final Player             firstServer;
    
    public AbstractContest (Player firstServer)
    {
        this.firstServer = firstServer;
    }
    
    public Two <Player> players ()
    {
        return TennisFactory.instance ().players ();
    }
    
    public abstract int score (Player player);
    
    public boolean isNew ()
    {
        return score (server ()) == 0 && score (receiver ()) == 0;
    }
    
    public String scoreAsString (Player player)
    {
        return Integer.toString (score (player));
    }
    
    public abstract boolean isOver ();
    
    public Player winner ()
    {
        require (isOver (), "isOver");
        if (score (players ()._1) > score (players ()._2))
            return players ()._1;
        else
            return players ()._2;
    }
    
    public Player loser ()
    {
        return players ().other (winner ());
    }
    
    public Player server ()
    {
        return firstServer;
    }
    
    public Player receiver ()
    {
        return players ().other (server ());
    }
    
    public abstract void play ();

    public void display ()
    {
        if (TennisFactory.instance ().displayIsEnabled())
            overridableDisplay ();
    }

    protected void overridableDisplay ()
    {
        displayPlayerScore (players()._1);
        displayPlayerScore (players()._2);
    }

    protected void displayPlayerScore (Player player)
    {
        System.out.format ("%-15s%s%n", player, scoreAsString (player));
    }
    
}