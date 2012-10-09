package lab10;

import org.junit.Before;

public class DijkstraSolverTest extends SlidingBlockSolverTest {

	@Override @Before
	public void setUp() {
		sbs = new DijkstraSolver();
	}

}
