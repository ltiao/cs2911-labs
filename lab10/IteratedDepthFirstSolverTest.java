package lab10;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class IteratedDepthFirstSolverTest extends SlidingBlockSolverTest {

	@Override @Before
	public void setUp() {
		sbs = new iteratedDepthFirstSolver();
	}
	
	@Test
	public void trivialTest() {
		System.out.println(Arrays.toString(sbs.solve(new int[] { 1, 5, 2, 3, 4, 6, 7, 11, 8, 9, 10, 0, 12, 13, 14, 15 }, new int[] { 1, 5, 2, 3, 4, 6, 7, 11, 8, 9, 0, 10, 12, 13, 14, 15}, 100000)));		
	}

}
