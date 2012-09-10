package tennis_one;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SinglesGameTest
{
    Player server;
    Player receiver;
    Game   game;
    
    @Before
    public void setUp () throws Exception
    {
        server = new NamedPlayer ("Williams, S.");
        receiver = new NamedPlayer ("Williams, V.");
        game = new SinglesGame (server, receiver);
    }
    
    @Test
    public void testPlay ()
    {
        assert game.isNew ();
        assertTrue ("server in game", game.players ().has (server));
        assertTrue ("receiver in game", game.players ().has (receiver));
        game.play ();
        assert game.isOver ();
    }
    
}
