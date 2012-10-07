package lab10;

import org.junit.Before;
import org.junit.Test;

public class BreadthFirstSolverTest {

	BreadthFirstSolver sbs = new BreadthFirstSolver();
	
	@Before
	public void setUp() throws Exception {
	}
/*	
	@Test
	public void test() {
		 sbs.solve(new int[] { 1,2,0,3,4,5,6,7,8 },new int[] { 1,0,2,3,4,5,6,7,8 },10);
	}
*/
	
	@Test
	public void testNeighbors() {
		for (int[] e:sbs.neighbors(new int[] { 1,2,0,3,4,5,6,7,8 })) {
			for (int i = 0 ; i < e.length ; i++) {
				System.out.print(e[i]+" ");
			}
			System.out.println();
		}
		/*
		int a[] = sbs.transposition(new int[] { 1,2,0,3,4,5,6,7,8 }, 0, 3);
		for (int i = 0 ; i < a.length ; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();

		int b[] = sbs.solve(new int[] { 1,2,0,3,4,5,6,7,8 },new int[] { 1,2,0,3,4,5,6,7,8 },10);
		//for (int i = 0 ; i < b.length ; i++) {
		//	System.out.print(b[i]+" ");
		//}
		System.out.println(b.length);
		 */
	}
}
