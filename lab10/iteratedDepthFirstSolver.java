package lab10;

import java.util.HashMap;

public class iteratedDepthFirstSolver implements SlidingBlockSolver {

	HashMap <PuzzleConfiguration,Boolean> marker = new HashMap<PuzzleConfiguration,Boolean>();
	
	@Override
	public int[] solve (int[] start, int[] goal, int maxMoves) {
		//marker.put(new PuzzleConfiguration(start), true);
		for (int depth = 0; depth < maxMoves; depth++) {
			int[] result = DLS(new PuzzleConfiguration(start), new PuzzleConfiguration(goal), depth);
			if (result != null) {
				return result;
			}
		}
		return null;
	}
	
	private int[] DLS(PuzzleConfiguration node, PuzzleConfiguration goal, int depth) {
		System.out.println(node);
		if (depth == 0 && node.equals(goal)) {
			return node.moves();
		} else if (depth > 0) {
			for (PuzzleConfiguration e:node.neighbors()) {
				int[] temp = DLS(e, goal, depth-1);
				if (temp != null) {
					return temp;
				}
			}
		}
		return null;
	}
		
}
