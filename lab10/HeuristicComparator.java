package lab10;

import java.util.Comparator;

public class HeuristicComparator implements Comparator<PuzzleConfiguration> {

	@Override
	public int compare(PuzzleConfiguration a, PuzzleConfiguration b) {
		Integer sizeA = a.moves.size()+a.heuristic();
		Integer sizeB = b.moves.size()+b.heuristic();
		return sizeA.compareTo(sizeB);
	}

}
