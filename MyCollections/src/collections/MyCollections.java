package collections;

import list.List;

/**
 * @author Nanaha
 *
 */
public class MyCollections {

	public static <T extends Comparable<T> > void sort(List<T> list, boolean increase) {
		sort(list, 0, list.size() - 1, increase);
	}
	
	private static <T extends Comparable<T> >  boolean compare(T a, T b, boolean bigger){
		if (bigger) {
			return (a.compareTo(b) > 0);
		} else {
			return (a.compareTo(b) < 0);
		}
	};
	
	private static <T extends Comparable<T> >  void sort(List<T> list, int left, int right, boolean increase) {
	    int i = left;
	    int j = right;
	    T pivot = list.get(left + (right - left)/2);
	
	    while (i <= j) {
			while (compare(list.get(i), pivot, !increase)) {
				i++;
			}
			while (compare(list.get(j), pivot, increase)) {
				j--;
			}
			if (i <= j) {
				swap(list, i, j);
				i++;
				j--;
			}
	    }
	
		if (left < j)
			sort(list, left, j, increase);
		if (i < right)
			sort(list, i, right, increase);
	}
	
	public static <T extends Comparable<T> > void swap(List<T> list, int i, int j) {
		T t = list.get(i);
		list.set(i, list.get(j));
		list.set(j, t);
	}
	
	public static <T extends Comparable<T> > void copy(List<T> list1, List<T> list2) {
		for (int i = 0; i < list2.size(); i++) {
			list1.add(list2.get(i));
		}
	}
	
	public static <T extends Comparable<T> > void reverse(List<T> list) {
		for (int i = 0; i < list.size()/2; i++) {
			swap(list, i, list.size() - i - 1);
		}
	}
	
	public static <T extends Comparable<T> > int binarySearch(List<T> list, T item, boolean increasing) {
		return binarySearch(list, item, 0, list.size() - 1, increasing);
	}
	
	public static <T extends Comparable<T> > int binarySearch(List<T> list, T item, int from, int to, boolean increasing) {
		if (item.equals(list.get(from))) {
			return from;
		}
		
		if (item.equals(list.get(to))) {
			return to;
		}
		
		int length = to - from;
		if (length == 0 || length == 1) {
			return -to - 1;
		}
		int central = from + length/2;
		if (length % 2 == 1) {
			central++;
		}
		if (compare(list.get(central), item, increasing) || item.equals(list.get(central))) {
			return binarySearch(list, item, from, central, increasing);
		} else {
			return binarySearch(list, item, central + 1, to, increasing);
		}
	}
}
