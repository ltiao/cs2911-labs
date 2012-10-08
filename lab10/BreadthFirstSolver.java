package lab10;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSolver implements SlidingBlockSolver {

	@Override
	public int[] solve(int[] start, int[] goal, int maxMoves) {
		PuzzleConfiguration startConf = new PuzzleConfiguration(start);
		PuzzleConfiguration goalConf = new PuzzleConfiguration(goal);
		Queue <PuzzleConfiguration> queue = new LinkedList<PuzzleConfiguration>();
		HashMap <PuzzleConfiguration,Boolean> marker = new HashMap<PuzzleConfiguration,Boolean>();
		HashMap <PuzzleConfiguration, Integer> parent = new HashMap<PuzzleConfiguration,Integer>();
		LinkedList <Integer> solutionList  = new LinkedList <Integer>();
		// enqueue start configuration onto queue
		queue.add(startConf);
		// mark start configuration
		marker.put(startConf, true);
		while (!queue.isEmpty()) {
			PuzzleConfiguration t = queue.poll();
			if (t.equals(goalConf)) {
				System.out.println(t.opposite(parent.get(t)));
				
				if (solutionList.size() <= maxMoves) {
					int[] solutionArray = new int[solutionList.size()];
					Iterator<Integer> itr = solutionList.iterator();
					for (int i = 0; itr.hasNext(); i++) {
						solutionArray[i] = itr.next();
					}
					return solutionArray;
				} else {
					return null;
				}
			}
			for (int e: t.incidentEdges()) {
				PuzzleConfiguration o = t.opposite(e);
				parent.put(o, e);
				if (!marker.containsKey(o)) {
					marker.put(o, true);
					queue.add(o);
				}
			}
		}
		return null;
	}

}