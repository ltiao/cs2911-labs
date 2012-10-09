/**
 * 
 */
package lab10;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author louistiao
 * Wrapper class for array representing the puzzle configuration.
 */
public class PuzzleConfiguration {
	int [] puzzle;
	int zeroPosition;
	int size;
	List <Integer> moves = new LinkedList<Integer>();
	
	public PuzzleConfiguration(int[] puzzle) {
		this.puzzle = Arrays.copyOf(puzzle, puzzle.length);
		for (zeroPosition = 0; zeroPosition < puzzle.length && puzzle[zeroPosition] != 0; zeroPosition++);
		size = (int) Math.sqrt(puzzle.length);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(puzzle);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PuzzleConfiguration other = (PuzzleConfiguration) obj;
		if (!Arrays.equals(puzzle, other.puzzle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		for (int i = 0; i < puzzle.length; i++) {
			sb.append(String.format("%2d ", puzzle[i]));
			if ((i+1)/size > i/size)
				sb.append("\n");
		}
		return sb.toString();
	}
	
	public List<Integer> incidentEdges() {
		LinkedList<Integer> incidentEdges = new LinkedList<Integer>();
		for (int d = -1 ; d < 2 ; d++) {
			if (d != 0) {
				// Check the column displacement will not alter the row
				if (zeroPosition+d >= 0 && (zeroPosition+d)/size == zeroPosition/size) {
					incidentEdges.add(zeroPosition+d);
				}
				if (zeroPosition+d*size >= 0 && zeroPosition+d*size < puzzle.length) {
					incidentEdges.add(zeroPosition+d*size);
				}
			}
		}
		return incidentEdges;
	}
	
	public PuzzleConfiguration opposite (int edge) {
		PuzzleConfiguration opposite = new PuzzleConfiguration(puzzle);
		int temp = opposite.puzzle[zeroPosition];
		opposite.puzzle[zeroPosition] = opposite.puzzle[edge];
		opposite.puzzle[edge] = temp;
		opposite.zeroPosition = edge;
		opposite.moves.addAll(moves);
		opposite.moves.add(edge);
		return opposite;
	}
	
	public List<PuzzleConfiguration> neighbors () {
		LinkedList<PuzzleConfiguration> neighbors = new LinkedList<PuzzleConfiguration>();
		for (int e: incidentEdges()) {
			neighbors.add(opposite(e));
		}
		return neighbors;
	}
	
	public int[] moves() {
		int[] moves = new int[this.moves.size()];
		Iterator<Integer> itr = this.moves.iterator();
		for (int i = 0; itr.hasNext(); i++) {
			moves[i] = itr.next();
		}
		return moves;
	}	
	
	public int heuristic () {
		int sum = 0;
		for (int i = 0 ; i < puzzle.length; i++) {
			if (puzzle[i] != 0) {
				sum += Math.abs(puzzle[i]/size-i/size)+Math.abs(puzzle[i]%size-i%size);
			}
		}
		return sum;
	}
	
	public int heuristic (PuzzleConfiguration goal) {
		int sum = 0;
		for (int i = 0 ; i < puzzle.length; i++) {
			if (puzzle[i] != 0) {
				sum += Math.abs(puzzle[i]/size-goal.puzzle[i]/size)+Math.abs(puzzle[i]%size-goal.puzzle[i]%size);
			}
		}
		return sum;
	}
	
}
