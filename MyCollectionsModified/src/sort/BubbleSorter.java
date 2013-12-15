package sort;

import list.MyList;
import java.util.Comparator;

/**
 * Class implements Bubble Sort algorithm for all types of <i>Comparable</i> elements.
 * Elements of the list are sorted in the given order.
 * 
 * @author Nanaha
 *
 */
public class BubbleSorter extends Sorter {
	
	/**
	* Sorts the given list into the order specified by the parameter <i>increase</i>
	* according to the
	* {@linkplain Comparable natural ordering} of its elements.
	* All elements in the list must implement the {@link Comparable}
	* interface. 
	* 
	* <p>Implementation note: 
	* The algorithm used is 
	* <a href="http://en.wikipedia.org/wiki/Bubble_sort">Bubble Sort</a> 
	* which goes through elements starting from the end of the list,
	* so the biggest(smallest) element "sinks".
	*
	*
	* @param  list the list to be sorted.
	* @param  increase specifies whether the list is to be sorted in the increasing order 
	* @throws IllegalArgumentException if list reference is null.
	*/
	public <T> void sortInternal(MyList<T> list, Comparator<T> comparator, boolean increase) throws IllegalArgumentException {
		if (list == null) {
			throw new IllegalArgumentException("list == null");
		}
		int n = list.size();
		for(int i = n; i > 1; i--) {
			boolean sorted = true;
			for(int j = n - 1; j > n - i; j--) {
				if (compare(list.get(j - 1), list.get(j), comparator, increase)) {
					swap(list, j - 1, j);
					sorted = false;
				}
			}
			if (sorted) {
				break;
			}
		}
	}
	
	@Override
	public <T extends Comparable<T> > void sort(MyList<T> list, boolean increase) throws IllegalArgumentException {
		sortInternal(list, null, increase);
	}
	
	@Override
	public <T> void sort(MyList<T> list, Comparator<T> comparator, boolean increase) throws IllegalArgumentException {
		sortInternal(list, comparator, increase);
	}

}
