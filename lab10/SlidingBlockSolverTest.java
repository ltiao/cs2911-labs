package lab10;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public abstract class SlidingBlockSolverTest {

	SlidingBlockSolver sbs;
	
	@Before
	public abstract void setUp();
	
	@Test
	public void test4by4_1() {
		System.out.println(Arrays.toString(sbs.solve(new int[] { 1, 5, 2, 3, 4, 6, 7, 11, 8, 9, 10, 0, 12, 13, 14, 15 }, new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, 100000)));		
	}
	
	//@Test
	public void testUnsolvable() {
		System.out.println(Arrays.toString(sbs.solve(new int[] { 1, 0, 3, 2 }, new int[] { 0, 1, 2, 3 }, 20)));		
	}
	
	//@Test
	public void testSolved() {
		System.out.println(Arrays.toString(sbs.solve(new int[] { 0, 1, 2, 3 }, new int[] { 0, 1, 2, 3 }, 20)));	
	}

	//@Test
	public void test4by4_2() {
		System.out.println(Arrays.toString(sbs.solve(new int[] { 1, 5, 2, 3, 4, 6, 7, 11, 8, 9, 10, 0, 12, 13, 14, 15 }, new int[] { 4, 1, 5, 3, 6, 2, 0, 11, 8, 9, 7, 15, 12, 13, 10, 14 }, 100000)));		
	}
	
	//@Test
	public void test3by3() {
		System.out.println(Arrays.toString(sbs.solve(new int[] { 1,2,0,3,4,5,6,7,8 }, new int[] { 8,5,2,3,4,6,0,7,1 }, 40)));		
		// View move step by step
		/*	
		int[] solution = sbs.solve(new int[] { 1,2,0,3,4,5,6,7,8 }, new int[] { 8,5,2,3,4,6,0,7,1 }, 40);
		PuzzleConfiguration temp = new PuzzleConfiguration(new int[] { 1,2,0,3,4,5,6,7,8 });
		for (int i = 0; i < solution.length; i++) {
			temp = temp.opposite(solution[i]);
			System.out.println("Move: "+solution[i]+temp);
		}
		 */
	}
}
