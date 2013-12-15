/**
 * 
 */
package list;

/**
 * @author Nanaha
 *
 */
public interface MyList <T> {
	int size();
	T get(int index);
	void set(int index, T data) throws IndexOutOfBoundsException;
	void add(T data);
	void add(int index, T data);
	void addAll(T[] data);
	T remove(int index);
	int indexOf(T data);
	Object[] toArray();
}
