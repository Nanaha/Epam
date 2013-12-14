/**
 * 
 */
package stack;

import list.MyLinkedList;

/**
 * @author Nanaha
 *
 */
public class MyStack <T extends Comparable<T> > {

	private MyLinkedList<T> list = new MyLinkedList<T>();
	
	public void push(T data) {
		list.add(data);
	}
	
	public T pop() {
		T element = list.getLast();
		list.removeLast();
		return element;
	}
}
