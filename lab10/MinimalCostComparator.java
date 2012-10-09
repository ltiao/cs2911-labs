package lab10;

import java.util.Comparator;

public class MinimalCostComparator implements Comparator<PuzzleConfiguration> {

	@Override
	public int compare(PuzzleConfiguration a, PuzzleConfiguration b) {
		Integer sizeA = a.moves.size();
		Integer sizeB = b.moves.size();
		return sizeA.compareTo(sizeB);
	}

}
