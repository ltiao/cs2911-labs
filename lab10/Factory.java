package lab10;


/**
 * Various factory methods for constructing a solver for a sliding block puzzle of given size.
 * Each factory method takes an integer argument n, specifying the size of the n x n puzzle.
 */
public class Factory {
	/**
	 * A solver using a breadth-first strategy. 
	 * Relies on a FIFO queue for adding newly seen search states, and removing states for further expansion.
	 */
	public static SlidingBlockSolver breadthFirst(int n) {
		// TODO
		return null;
	}

	/**
	 * A solver using an iterated depth-first strategy.
	 * The depth-first strategy can be implemented using a LIFO queue (in other words, a stack),
	 * or by using a (depth-bounded) recursive implementation.
	 */
	public static SlidingBlockSolver iteratedDepthFirst(int n) {
		// TODO
		return null;
	}

	/**
	 * A solver using Dijkstra's shortest path algorithm.
	 * In this algorithm search states are added to a priority queue.
	 * The priorities are determined by the number of moves (the cost so far) to reach the given state.
	 * The next state to be expanded is one on the queue with a minimal number of moves.
	 */
	public static SlidingBlockSolver dijkstra(int n) {
		// TODO
		return null;
	}

	/**
	 * A solver using the A* algorithm.
	 * In this algorithm search states are added to a priority queue.
	 * The priorities are determined by the estimated cost via the current search state
	 * (the cost so far + a heuristic estimate of the cost to go), where cost = number of moves.
	 * The next state to be expanded is one on the queue with a minimal estimated total cost.
	 */
	public static SlidingBlockSolver aStar(int n) {
		// TODO
		return null;
	}
}