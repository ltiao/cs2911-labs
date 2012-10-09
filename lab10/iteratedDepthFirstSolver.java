package lab10;

import java.util.HashMap;
import java.util.Stack;

public class iteratedDepthFirstSolver implements SlidingBlockSolver {

	@Override
	public int[] solve(int[] start, int[] goal, int maxMoves) {
		PuzzleConfiguration startConf = new PuzzleConfiguration(start);
		PuzzleConfiguration goalConf = new PuzzleConfiguration(goal);
		Stack <PuzzleConfiguration> queue = new Stack<PuzzleConfiguration>();
		HashMap <PuzzleConfiguration,Boolean> marker = new HashMap<PuzzleConfiguration,Boolean>();

		// enqueue start configuration onto queue
		queue.add(startConf);
		// mark start configuration
		marker.put(startConf, true);
		while (!queue.isEmpty()) {
			PuzzleConfiguration t = queue.pop();
			System.out.println(t);
			if (t.equals(goalConf)) {
				if (t.moves.size() <= maxMoves) {
					return t.moves();
				} else {
					return null;
				}
			}
			for (int e: t.incidentEdges()) {
				PuzzleConfiguration o = t.opposite(e);
				if (!marker.containsKey(o)) {
					marker.put(o, true);
					queue.push(o);
				}
			}
		}
		return null;
	}
		
}
