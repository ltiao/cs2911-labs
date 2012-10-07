package lab10;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSolver implements SlidingBlockSolver {

	@Override
	public int[] solve(int[] start, int[] goal, int maxMoves) {
		PuzzleConfiguration startConf = new PuzzleConfiguration(start);
		PuzzleConfiguration goalConf = new PuzzleConfiguration(goal);
		Queue <PuzzleConfiguration> queue = new LinkedList<PuzzleConfiguration>();
		HashMap <PuzzleConfiguration,Boolean> marker = new HashMap<PuzzleConfiguration,Boolean>();
		// enqueue start configuration onto queue
		queue.add(startConf);
		// mark start configuration
		marker.put(startConf, true);
		while (!queue.isEmpty()) {
			PuzzleConfiguration t = queue.poll();
			//System.out.println(t);
			if (t.equals(goalConf)) {
				return goalConf.puzzle;
			}
			for (int e: t.incidentEdges()) {
				PuzzleConfiguration o = t.opposite(e);
				if (!marker.containsKey(o)) {
					marker.put(o, true);
					queue.add(o);
				}
			}
		}
		return null;
	}

}
