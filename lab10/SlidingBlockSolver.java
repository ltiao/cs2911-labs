package lab10;

/**
 * A solver for a Sliding Block puzzle of size n x n.
 */
public interface SlidingBlockSolver {
	/**
	 * Produce a solution for the puzzle with a given number of moves, with given start and goal states.
	 * States specify the state of a puzzle as arrays of length n x n.
	 * Each array index i represents a 2D index (i/n, i%n) for the positions in the puzzle: (0,0) through (n-1,n-1).
	 * The array entries are tile identifiers: 1 .. (n x n - 1), and 0 for the vacant position.
	 * Move sequences are an array of indices where each index must be a position adjacent to the current vacant position.
	 * The effect of a move is to swap the tile in the selected position with the vacancy.
	 * @param start the start state for the puzzle (entries must be a permutation of 0 .. (n x n - 1))
	 * @param goal the goal state for the puzzle (entries must be a permutation of 0 .. (n x n - 1))
	 * @param maxMoves maximum number of moves allowed for a solution
	 * @return a move sequence of length no more than maxMoves that converts the start state into the goal state
	 */
	int[] solve(int[] start, int[] goal, int maxMoves);
}