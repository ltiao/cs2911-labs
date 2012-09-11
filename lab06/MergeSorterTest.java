package lab06;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith (Parameterized.class)
public class MergeSorterTest extends SorterTest {

    @Parameters
    public static List<Object[]> data()
    {
        return Arrays.asList (
                new Object [] [] {
                	{ new int[] {1, 4, 2, 3, 43, 7, 4, 13, 5, 2} },
                	{ new int[] {5, 2, 32, 65, 12, 65, 12, 134, 1, 2} },
                	{ new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1} }
                }
            );
    }
	
	public MergeSorterTest(int[] primitiveIntegers) {
		super(primitiveIntegers);
	}

	@Override @Before
	public void setUp() throws Exception {
		sorter = new MergeSorter();
	}

}