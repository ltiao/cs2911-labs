package quoridor;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ValidatorTest {

	Validator val = new Validator ();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIsOverTrue() {
		assertTrue ( "Game is over and Player 2 has won" ,val.isOver("e8 e2 e7 e3 e6 e4 e5 e6 e4 e7 e3 e8 e2 e9"));
	}
	
	@Test
	public void testIsOverFalse() {
		assertFalse ( "No one has won yet" ,val.isOver("e8 e2 e7 e3 e6 e4 e5 e6 e4 e7 e3 e8 e2 f8"));
	}
	
	@Test
	public void testGraphInit() {
		val.displayAdjacencyList();
	}
	
}
