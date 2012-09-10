package lab01;

//import java.util.*;

class MinimiseUtils {

    /**
     * Minimum of two integers.
     * @param i first of two integers
     * @param j second of two integers
     * @return minimum of i and j
     */
    static int min2(int i, int j) {
        return i < j ? i : j;
    }

    static int min3(int i, int j, int k) {
        int temp = min2(j, k);
        int result = min2(i, temp);
        return result;
    }

    static int min(int[] data) {
        return min(data, 0, data.length - 1);
    }

//	Cheating Version of array minimum computation
/*
	private static int min(int[] data, int start, int end) {
		Arrays.sort(data);
		return data[0];	
	}
*/

//	Iterative Version of array minimum computation
	private static int min(int[] data, int start, int end) {
		int min = data[start];
		for (int i = start ; i <= end ; i++) {
			for (int j = i + 1 ; j <= end ; j++) {
				if (min > min2( data[i], data[j] )) {
					min = min2( data[i], data[j] );
				}
			}
		}
		return min;
	}

//	Recursive Version of array minimum computation
/*
    private static int min(int[] data, int start, int end) {
        return start == end ?
                data[start] : // There is only one element
                start > end ?
                    Integer.MAX_VALUE : // Return a massive value I guess to show that there the min is doesn't really exist in a bizarre array where start > end
                    min2(data[start], min(data, start + 1, end)); // Find the min recursively
    }
*/

    public static void main(String[] args) {
        int i = 99;
        int j = 55;
        int k = 11;
        System.out.print("Minimum of " + i + ", " + j + ", " + k + " is ");
        System.out.println(min3(i, j, k));

        int[] data = {45, 23, 65, 24, 36, 63, 62, 15};
        System.out.println("Minimum of test data array is " + min(data));
    }
}