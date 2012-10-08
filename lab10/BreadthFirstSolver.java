package lab10;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSolver implements SlidingBlockSolver {

	@Override
	public int[] solve(int[] start, int[] goal, int maxMoves) {
		PuzzleConfiguration startConf = new PuzzleConfiguration(start);
		PuzzleConfiguration goalConf = new PuzzleConfiguration(goal);
		Queue <PuzzleConfiguration> queue = new LinkedList<PuzzleConfiguration>();
		HashMap <PuzzleConfiguration,Boolean> marker = new HashMap<PuzzleConfiguration,Boolean>();
		HashMap <PuzzleConfiguration,PuzzleConfiguration> parentNode = new HashMap<PuzzleConfiguration,PuzzleConfiguration>();
		List <Integer> solutionList  = new LinkedList <Integer>();
		List <PuzzleConfiguration> nodeList  = new LinkedList <PuzzleConfiguration>();

		// enqueue start configuration onto queue
		queue.add(startConf);
		// mark start configuration
		marker.put(startConf, true);
		while (!queue.isEmpty()) {
			PuzzleConfiguration t = queue.poll();
			if (t.equals(goalConf)) {
				PuzzleConfiguration temp = t;
				nodeList.add(t);
				while (!temp.equals(startConf)) {
					temp = parentNode.get(temp);
					nodeList.add(temp);
				}
				Collections.reverse(nodeList);
				System.out.println(nodeList);
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
				if (!marker.containsKey(o)) {
					marker.put(o, true);
					queue.add(o);
					parentNode.put(o, t);
				}
			}
		}
		return null;
	}

}
