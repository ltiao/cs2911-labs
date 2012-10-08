package lab10;

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
		// enqueue start configuration onto queue
		queue.add(startConf);
		// mark start configuration
		marker.put(startConf, true);
		while (!queue.isEmpty()) {
			PuzzleConfiguration t = queue.poll();
			if (t.equals(goalConf)) {
				/*
				for (PuzzleConfiguration e:parentNode.keySet()) {
					System.out.println("Parent: \n" + parentNode.get(e));
					System.out.println("Child: \n" + e);
				}
				System.out.println("Child: \n" + t);
				System.out.println("Parent: \n" + parentNode.get(t));
				System.out.println("Grandparent: \n" + parentNode.get(parentNode.get(t)));
				System.out.println("Great Grandparent: \n" + parentNode.get(parentNode.get(parentNode.get(t))));
				System.out.println("Great Great Grandparent: \n" + parentNode.get(parentNode.get(parentNode.get(parentNode.get(t)))));	
				 */
				PuzzleConfiguration temp = t;
				while (!temp.equals(startConf)) {
					System.out.println(temp);
					temp = parentNode.get(temp);
				}
				
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
