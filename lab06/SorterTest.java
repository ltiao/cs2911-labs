package lab06;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

public abstract class SorterTest {
	
	final int	MAX_SIZE = 10;
	Integer[] 	intArray = new Integer[MAX_SIZE];
	Sorter 		sorter;
	
	public SorterTest(int[] primitiveIntegers) {
		for ( int i = 0 ; i < intArray.length ; i++ )
			intArray[i] = new Integer(primitiveIntegers[i]);
	}

	@Before
	public abstract void setUp() throws Exception;

	@Test
	public void testComparableSort() {
		sorter.sort(intArray);
		for (int i = 0 ; i < intArray.length ; i++)
			System.out.println(intArray[i]);
		assertEquals ("Has no inversions in array.", 0, countInversions(intArray));
	}

	@Test
	public void testComparatorSort() {
		sorter.sort(
				intArray,
				new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						return o1.compareTo(o2);
					}
				}
		);
		for (int i = 0 ; i < intArray.length ; i++)
			System.out.println(intArray[i]);
		assertEquals ("Has no inversions in array.", 0, countInversions(intArray));
	}
	
	private <E extends Comparable<? super E>> int countInversions (E items[])
	{
	    int inversions = 0;
	    for(int i = 0; i < items.length; i++) {
	        for(int j = i+1; j < items.length; j++) {
	            if(items[i].compareTo(items[j]) == 1)
	            	inversions++;
	        }
	    }
	    return inversions;
	}
}
