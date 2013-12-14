package queue;

import list.MyLinkedList;

/**
 * @author Nanaha
 *
 */
public class MyQueue <T extends Comparable<T> > {
	
	private MyLinkedList<T> list = new MyLinkedList<T>();
	
	public void offer(T data) {
		list.add(data);
	}
	
	public T peek() {
		return list.getFirst();
	}
	
	public T poll() {
		T element = list.getFirst();
		list.removeFirst();
		return element;
	}
}
