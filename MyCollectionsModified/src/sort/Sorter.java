package sort;

import list.MyList;
import java.util.Comparator;

/**
 * <p>An abstract interface-class for different realizations of sorting algorithms.
 * Provides all the necessary utilities for the implementations to use.
 * 
 * @author Nanaha
 *
 */
public abstract class Sorter {
	/**
	* An interface function for heir classes to implement.
	* 
	* @param  list the list to be sorted.
	* @param  increase specifies whether the list is to be sorted in the increasing order 
	* @throws IllegalArgumentException if list reference is null.
	*/
	
	public <T extends Comparable<T> > void sort(MyList<T> list, boolean increase) throws IllegalArgumentException {};
	public <T> void sort(MyList<T> list, Comparator<T> comparator, boolean increase) throws IllegalArgumentException {};
	
	protected static <T>  boolean compare(T a, T b, Comparator<T> comparator, boolean bigger) throws IllegalArgumentException {
		if (bigger) {
			if (a instanceof Comparable<?>) {
				return (((Comparable<T>)a).compareTo(b) > 0);
			} else if (comparator != null) {
				return (comparator.compare(a, b) > 0);
			} else {
				throw new IllegalArgumentException("Neither the type is Comparable nor the comparator provided");
			}
		} else {
			if (a instanceof Comparable<?>) {
				return (((Comparable<T>)a).compareTo(b) < 0);
			} else if (comparator != null) {
				return (comparator.compare(a, b) < 0);
			} else {
				throw new IllegalArgumentException("Neither the type is Comparable nor the comparator provided");
			}
		}
	};
	
	
	protected static <T>  boolean equal(T a, T b) {
		return a.equals(b);
	}
	
	public static <T> void swap(MyList<T> list, int i, int j) {
		T t = list.get(i);
		list.set(i, list.get(j));
		list.set(j, t);
	}
}
