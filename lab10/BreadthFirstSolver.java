package lab10;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSolver implements SlidingBlockSolver {

	@Override
	public int[] solve(int[] start, int[] goal, int maxMoves) {
		//if (Arrays.equals(start, goal))
		//	return new int[0]; // Returns empty array if start state is already goal state		
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(start);
		
		List <int[]> marker = new LinkedList<int[]>();
		marker.add(start);
			
		int i = 0;

		int[] t;
		while (!q.isEmpty()) {
			System.out.println(i++);
			t = q.poll();
			printPuzzle(t);
			if (Arrays.equals(t, goal)) {
				return goal;
			}
			for (int[] o:neighbors(t)) {
				boolean contains = false;
				for (int[] e:marker) {
					if (Arrays.equals(e, o)) {
						contains = true;
						break;
					}
				}
				if (!contains) {
					marker.add(o);
					q.add(o);
					//i++;
				}
			}
		}
		
		return null;
	}
	
	public List<int[]> neighbors (int[] v) {
		LinkedList<int[]> neighbors = new LinkedList<int[]>();
		int n = (int) Math.sqrt(v.length);
		int zeroIndex;
		for (zeroIndex = 0; zeroIndex < v.length && v[zeroIndex] != 0; zeroIndex++);
		for (int d = -1 ; d < 2 ; d++) {
			if (d != 0) {
				// Check the column displacement will not alter the row
				if (zeroIndex+d >= 0 && (zeroIndex+d)/n == zeroIndex/n) {
					neighbors.add(transposition(v, zeroIndex, zeroIndex+d));
				}
				if (zeroIndex+d*n >= 0 && zeroIndex+d*n < v.length) {
					neighbors.add(transposition(v, zeroIndex, zeroIndex+d*n));
				}
			}
		}
		return neighbors;
	}

	public void printPuzzle (int[] array) {
		int n = (int) Math.sqrt(array.length);
		for (int i = 0; i < array.length; i++) {
			System.out.format("%2d ",array[i]);
			if ((i+1)/n != i/n) {
				System.out.println();
			}
		}
		System.out.println();
	}
	
	public int[] transposition (int[] array, int i, int j) {
		int[] copy = Arrays.copyOf(array, array.length);
		int temp = copy[i];
		copy[i] = copy[j];
		copy[j] = temp;
		return copy;
	}

}
