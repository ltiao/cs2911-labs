package lab10;

import org.junit.Before;

public class BreadthFirstSolverTest extends SlidingBlockSolverTest {

	@Override @Before
	public void setUp() {
		sbs = new BreadthFirstSolver();
	}

}
