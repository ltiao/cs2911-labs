package tennis_one;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SinglesSetTest
{
    
    Player p1;
    Player p2;
    Set    set;
    
    @Before
    public void setUp () throws Exception
    {
        p1 = new NamedPlayer ("Williams, S.");
        p2 = new NamedPlayer ("Williams, V.");
        set = new SinglesSet (p1, p2);
    }
    
    @Test
    public void testPlay ()
    {
        assert set.isNew ();
        assertTrue ("server in game", set.players ().has (p1));
        assertTrue ("receiver in game", set.players ().has (p2));
        set.play ();
        assert set.isOver ();
    }
    
}
