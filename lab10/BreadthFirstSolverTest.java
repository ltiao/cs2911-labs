package lab10;

import java.util.Arrays;

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
		//System.out.println(Arrays.toString(sbs.solve(new int[] { 1,2,0,3,4,5,6,7,8 }, new int[] { 8,5,2,3,4,6,0,7,1 }, 40)));		
		System.out.println(Arrays.toString(sbs.solve(new int[] { 1, 5, 2, 3, 4, 6, 7, 11, 8, 9, 10, 0, 12, 13, 14, 15 }, new int[] { 4, 1, 5, 3, 6, 2, 0, 11, 8, 9, 7, 15, 12, 13, 10, 14 }, 100000)));		
		/*
		for (int[] e:sbs.neighbors(new int[] { 1,2,0,3,4,5,6,7,8 })) {
			for (int i = 0 ; i < e.length ; i++) {
				System.out.print(e[i]+" ");
			}
			System.out.println();
		}
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
