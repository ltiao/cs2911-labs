package quoridor;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {

	Display board = new Board();
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void test() {
		//board.display("e8 e2 e7 e3 e6 e4 d5 e6 d4 e7 c4 f8 g2 i8");
		board.display("e8 e2 e7 d1h e6 e3 e5 e2h e3h d6v d2v c2h");
		//board.display("d6v d2v c2h");
	}

}
