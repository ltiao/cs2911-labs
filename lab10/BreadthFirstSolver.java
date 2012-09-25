package lab10;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BreadthFirstSolver implements SlidingBlockSolver {

	@Override
	public int[] solve(int[] start, int[] goal, int maxMoves) {
		if (Arrays.equals(start, goal))
			return new int[0]; // Returns empty array if start state is already goal state
		return null;
	}

	public List<int[]> neighbors (int[] puzzle) {
		LinkedList<int[]> neighbors = new LinkedList<int[]>();
		int n = (int) Math.sqrt(puzzle.length);
		int zeroIndex;
		for (zeroIndex = 0; zeroIndex < puzzle.length && puzzle[zeroIndex] != 0; zeroIndex++);
		//System.out.println(zeroIndex);
		for (int d = -1 ; d < 2 ; d++) {
			if (d != 0) {
				if (zeroIndex+d >= 0 && zeroIndex+d < puzzle.length-1) {
					System.out.println(zeroIndex+d);
					neighbors.add(swap(puzzle, zeroIndex, zeroIndex+d));
				}
				if (zeroIndex+d*n >= 0 && zeroIndex+d*n < puzzle.length-1) {
					System.out.println(zeroIndex+d*n);
					neighbors.add(swap(puzzle, zeroIndex, zeroIndex+d*n));
				}
			}
		}
		return neighbors;
	}
	
	public int[] swap (int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		return array;
	}
}
