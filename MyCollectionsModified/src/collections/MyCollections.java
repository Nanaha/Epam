package collections;

import list.MyList;
import java.util.RandomAccess;
import sort.*;
/**
 * @author Nanaha
 *
 */
public class MyCollections {

	public static <T extends Comparable<T> > void sort(MyList<T> list, boolean increase) {
		Sorter sorter;
		if (list instanceof RandomAccess) {
			sorter = new QuickSorter();
		} else {
			sorter = new BubbleSorter();
		}
		sorter.sort(list, increase);
	}
	
	private static <T extends Comparable<T> >  boolean compare(T a, T b, boolean bigger){
		if (bigger) {
			return (a.compareTo(b) > 0);
		} else {
			return (a.compareTo(b) < 0);
		}
	};
	
	public static <T> void swap(MyList<T> list, int i, int j) {
		T t = list.get(i);
		list.set(i, list.get(j));
		list.set(j, t);
	}
	
	public static <T> void copy(MyList<T> list1, MyList<T> list2) {
		for (int i = 0; i < list2.size(); i++) {
			list1.add(list2.get(i));
		}
	}
	
	public static <T> void reverse(MyList<T> list) {
		for (int i = 0; i < list.size()/2; i++) {
			swap(list, i, list.size() - i - 1);
		}
	}
	
	public static <T extends Comparable<T> > int binarySearch(MyList<T> list, T item, boolean increasing) {
		return binarySearch(list, item, 0, list.size() - 1, increasing);
	}
	
	public static <T extends Comparable<T> > int binarySearch(MyList<T> list, T item, int from, int to, boolean increasing) {
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
