package Array;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * Given an array of numbers, arrange them in a way that yields the largest
 * value. For example, if the given numbers are {54, 546, 548, 60}, the
 * arrangement 6054854654 gives the largest value. And if the given numbers are
 * {1, 34, 3, 98, 9, 76, 45, 4}, then the arrangement 998764543431 gives the
 * largest value.
 *
 */

public class ArrangeNumbersToFormBiggestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void printLargest(List<Integer> arr) {
		Collections.sort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer X, Integer Y) {
				String XY = String.valueOf(X) + String.valueOf(Y);
				String YX = String.valueOf(Y) + String.valueOf(X);
				return XY.compareTo(YX) > 0 ? -1 : 1;
			}
		});

		Iterator it = arr.iterator();

		while (it.hasNext())
			System.out.print(it.next());
	}

}
