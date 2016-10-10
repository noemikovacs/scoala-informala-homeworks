/**
 * This class presents the bubble sorting method
 * Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm that
 * repeatedly steps through the list to be sorted, compares each pair of adjacent items and swaps
 * them if they are in the wrong order. The pass through the list is repeated until no swaps are
 * needed, which indicates that the list is sorted. The algorithm, which is a comparison sort, is
 * named for the way smaller elements "bubble" to the top of the list. Although the algorithm is
 * simple, it is too slow and impractical for most problems even when compared to insertion
 * sort. It can be practical if the input is usually in sort order but may occasionally have
 * some out-of-order elements nearly in position.
 * @exception EmptyStackException if the array is empty
 */
package siit.java4.generics.bubblesort;

import java.util.Comparator;
import java.util.EmptyStackException;

public class BubbleSort<T extends Comparator<T>> {

	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
		if (arr.length == 0){
			throw new EmptyStackException();
		}
		boolean swapped = true;
		while (swapped) {
			swapped = false;
			for (int i = 1; i < arr.length; i++) {
				if (arr[i - 1].compareTo(arr[i]) > 0) {
					T newVar = arr[i - 1];
					arr[i - 1] = arr[i];
					arr[i] = newVar;
					swapped = true;
				}
			}
		}
	}
}


