package lab08;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {

	Display board = new Board();
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void test() {
		board.display("e8 e2 e7 e3 e6 e4 e5 e6 e4 e7 e3 e8 e2 e9");
	}

}
