package lab10;

import java.util.Arrays;
import java.util.HashMap;
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
		
		//List <int[]> marker = new LinkedList<int[]>();
		//marker.add(start);
		
		HashMap <PuzzleConfiguration,Boolean> marked = new HashMap<PuzzleConfiguration,Boolean>();
		marked.put(new PuzzleConfiguration(start), true);

		while (!q.isEmpty()) {
			int[] t = q.poll();
			printPuzzle(t);
			if (Arrays.equals(t, goal)) {
				System.out.println(q.size());
				return goal;
			}
			for (Integer e:incidentEdges(t)) {
				int[] o = transposition(t,e,zeroIndex(t));
				PuzzleConfiguration temp = new PuzzleConfiguration(o);
				if (!marked.containsKey(temp)) {
					marked.put(temp, true);
					q.add(o);
				}
			}
		}
		
		return null;
	}
	
	public int zeroIndex(int[] v) {
		int zeroIndex;
		for (zeroIndex = 0; zeroIndex < v.length && v[zeroIndex] != 0; zeroIndex++);
		return zeroIndex;
	}
	
	public List<int[]> neighbors (int[] v) {
		LinkedList<int[]> neighbors = new LinkedList<int[]>();
		int n = (int) Math.sqrt(v.length);
		int zeroIndex = zeroIndex(v);
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
	
	public List<Integer> incidentEdges (int[] v) {
		LinkedList<Integer> incidentEdges = new LinkedList<Integer>();
		int n = (int) Math.sqrt(v.length);
		int zeroIndex;
		for (zeroIndex = 0; zeroIndex < v.length && v[zeroIndex] != 0; zeroIndex++);
		for (int d = -1 ; d < 2 ; d++) {
			if (d != 0) {
				// Check the column displacement will not alter the row
				if (zeroIndex+d >= 0 && (zeroIndex+d)/n == zeroIndex/n) {
					incidentEdges.add(zeroIndex+d);
				}
				if (zeroIndex+d*n >= 0 && zeroIndex+d*n < v.length) {
					incidentEdges.add(zeroIndex+d*n);
				}
			}
		}
		return incidentEdges;
	}


	public void printPuzzle (int[] array) {
		int n = (int) Math.sqrt(array.length);
		for (int i = 0; i < array.length; i++) {
			System.out.format("%2d ",array[i]);
			if ((i+1)/n > i/n)
				System.out.println();
		}
		System.out.println();
	}
	
	public int[] transposition (int[] array, int i, int j) {
		//int[] copy = Arrays.copyOf(array, array.length);
		int[] copy = array.clone();
		int temp = copy[i];
		copy[i] = copy[j];
		copy[j] = temp;
		return copy;
	}

}
