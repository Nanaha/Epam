package sort;

import java.util.Comparator;

import list.MyList;

/**
 * Class implements Quick Sort algorithm for all types of <i>Comparable</i> elements.
 * Elements of the array are sorted in the given order.
 * 
 * @author Nanaha
 *
 */
public class QuickSorter extends Sorter {
	
	/**
	* Sorts the given list into the order specified by the parameter <i>increase</i>
	* according to the
	* {@linkplain Comparable natural ordering} of its elements.
	* All elements in the list must implement the {@link Comparable}
	* interface. 
	* 
	* <p>Implementation note: 
	* The algorithm used is 
	* <a href="http://en.wikipedia.org/wiki/Quicksort">Quicksort</a>
	*
	*
	* @param  list the array to be sorted.
	* @param  increase specifies whether the list is to be sorted in the increasing order 
	* @throws IllegalArgumentException if list reference is null.
	*/
	@Override
	public <T extends Comparable<T> > void sort(MyList<T> list, boolean increase) throws IllegalArgumentException {
		if (list == null) {
			throw new IllegalArgumentException("list == null");
		}
		sort(list, null, 0, list.size() - 1, increase);
	}
	
	@Override
	public <T> void sort(MyList<T> list, Comparator<T> comparator, boolean increase) throws IllegalArgumentException {
		if (list == null) {
			throw new IllegalArgumentException("list == null");
		}
		if (comparator == null) {
			throw new IllegalArgumentException("comparator == null");
		}
		
		sort(list, comparator, 0, list.size() - 1, increase);
	}
	
	private <T> void sort(MyList<T> list, Comparator<T> comparator, int left, int right, boolean increase) {
	    int i = left;
	    int j = right;
	    T pivot = list.get(left + (right - left)/2);
	
	    while (i <= j) {
			while (compare(list.get(i), pivot, comparator, !increase)) {
				i++;
			}
			while (compare(list.get(j), pivot, comparator, increase)) {
				j--;
			}
			if (i <= j) {
				swap(list, i, j);
				i++;
				j--;
			}
	    }
	
		if (left < j)
			sort(list, comparator, left, j, increase);
		if (i < right)
			sort(list, comparator, i, right, increase);
	}
}
