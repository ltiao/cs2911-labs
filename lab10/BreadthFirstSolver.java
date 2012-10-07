package lab10;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSolver implements SlidingBlockSolver {

	@Override
	public int[] solve(int[] start, int[] goal, int maxMoves) {
		if (Arrays.equals(start, goal))
			return new int[0]; // Returns empty array if start state is already goal state
		
		Queue<int[]> q = new LinkedList<int[]>();
		int[] solution = new int[maxMoves];
		int n = (int) Math.sqrt(start.length);
		q.add(start);
		
		for (int[] e: q) {
			if (Arrays.equals(e,goal)) {
				
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
					//System.out.println(zeroIndex+d);
					//System.out.println(Arrays.toString(v));
					//System.out.println(Arrays.toString(transposition(v, zeroIndex, zeroIndex+d)));
					neighbors.add(transposition(v, zeroIndex, zeroIndex+d));
				}
				if (zeroIndex+d*n >= 0 && zeroIndex+d*n < v.length) {
					//System.out.println(zeroIndex+d*n);
					neighbors.add(transposition(v, zeroIndex, zeroIndex+d*n));
				}
			}
		}
		/*
		int[][] a = new int[n][n];
		for (int i = 0; i < v.length; i++) {
			if (v[i]==0)
				zeroIndex = i;
			a[i/n][i%n] = v[i];
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				v[n*i+j]=a[i][j];
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		*/
		return neighbors;
	}

	public int[] transposition (int[] array, int i, int j) {
		int[] copy = Arrays.copyOf(array, array.length);
		int temp = copy[i];
		copy[i] = copy[j];
		copy[j] = temp;
		return copy;
	}

}
