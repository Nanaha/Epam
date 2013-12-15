/**
 * 
 */
package list;

/**
 * @author Nanaha
 *
 */
public interface List <T extends Comparable<T> > {
	int size();
	T get(int index);
	void set(int index, T data) throws IndexOutOfBoundsException;
	void add(T data);
}
