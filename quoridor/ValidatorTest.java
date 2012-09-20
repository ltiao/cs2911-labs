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
	
	@Test
	public void testIsAdjacent() {
		assertTrue (val.isAdjacent(new Square("e6"), new Square("e7")));
		assertTrue (val.isAdjacent(new Square("f7"), new Square("e7")));
	}
	
	@Test
	public void testIsNotAdjacent() {
		assertFalse (val.isAdjacent(new Square("e2"), new Square("e7")));
		assertFalse (val.isAdjacent(new Square("g7"), new Square("e7")));
	}
	
}
