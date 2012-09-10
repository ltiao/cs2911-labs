package tennis_one;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SinglesMatchTest {

	Player p1;
	Player p2;
	Match match;

	@Before
	public void setUp() throws Exception {
		p1 = new NamedPlayer("Williams, S.");
		p2 = new NamedPlayer("Williams, V.");
		match = new SinglesMatch(p1, p2, 3);
	}

	@Test
	public void testPlay() {
		assert match.isNew();
		assertTrue("server in game", match.players().has(p1));
		assertTrue("receiver in game", match.players().has(p2));
		match.play();
		assert match.isOver();
	}

}
