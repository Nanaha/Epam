package list;

import stack.MyStack;
import queue.MyQueue;

/**
 * @author Nanaha
 *
 */
public class MyLinkedList <T> implements MyList<T>, MyStack<T>, MyQueue<T> {
	
	private Element<T> head;
	private Element<T> tail;
	private int        size;
	
	
	public int size() {
		return size;
	}
	
	public T pop() {
		return removeLast();
	}
	
	public void push(T data) {
		addLast(data);
	}
	
	public void offer(T data) {
		add(data);
	}
	
	public T peek() {
		return getFirst();
	}
	
	public T poll() {
		return removeFirst();
	}
	
	public void add(T data) {
		Element<T> element = new Element<T>(data);
		if (head == null) {
			head = element;
			tail = head;
		} else {
			tail.setNext(element);
			element.setPrevious(tail);
			tail = element;
		}
		size++;
	}
	
	private Element<T> getElement(int index) throws IndexOutOfBoundsException {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Invalid index");
		}
		Element<T> current = head;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current;
	}
	
	public T get(int index) throws IndexOutOfBoundsException {
		return getElement(index).getData();
	}
	
	public void add(int index, T data) throws IndexOutOfBoundsException {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException("Invalid index");
		}
		Element<T> element = new Element<T>(data);
		if (head == null) {
			head = element;
			tail = head;
		} else if (index == size) {
			add(data);
			return;
		} else {
			Element<T> current = getElement(index);
			if (current.getPrevious() != null) {
				current.getPrevious().setNext(element);
			}
			element.setPrevious(current.getPrevious());			
			element.setNext(current);
			current.setPrevious(element);
		}
		if (element.getNext() == null) {
			tail = element;
		}
		
		if (element.getPrevious() == null) {
			head = element;
		}
		size++;
	}
	
	public void addFirst(T data) {
		add(0, data);
	}
	
	public void addLast(T data) {
		add(data);
	}
	
	public T getFirst() {
		if (head == null) {
			return null;
		}
		return head.getData();
	}
	
	public T getLast() {
		if (tail == null) {
			return null;
		}
		return tail.getData();
	}
	
	public T remove(int index) throws IndexOutOfBoundsException {
		Element<T> element = getElement(index);
		
		if (element.getPrevious() != null) {
			element.getPrevious().setNext(element.getNext());
		} else {
			head = element.getNext();
		}
		
		if (element.getNext() != null) {
			element.getNext().setPrevious(element.getPrevious());
		} else {
			tail = element.getPrevious();
		}
		size--;
		return element.getData();
	}
	
	public T removeFirst() {
		if (head == null) {
			return null;
		}
		
		Element<T> element = head;
		if (head.getNext() != null) {
			head.getNext().setPrevious(null);
		} else {
			tail = null;
		}
		
		head = head.getNext();
		size--;
		return element.getData();
	}
	
	public void addAll(T[] data) {
		for (int i = 0; i < data.length; i++) {
			add(data[i]);
		}
	}
	
	public T removeLast() {
		if (tail == null) {
			return null;
		}
		
		Element<T> element = tail;
		if (tail.getPrevious() != null) {
			tail.getPrevious().setNext(tail.getNext());
		} else {
			head = null;
		}
		tail = tail.getPrevious();
		size--;
		return element.getData();
	}
	
	public void set(int index, T data) throws IndexOutOfBoundsException {
		Element<T> element = getElement(index);
		element.setData(data);
	}
	
	public Object[] toArray() {
		Object[] data = new Object[size];
		Element<T> current = head;
		int i = 0;
		while(i < size) {
			data[i] = current.getData();
			current = current.getNext();
			i++;
		}
		return data;
	}
	
	public int indexOf(T data) {
		Element<T> current = head;
		for (int i = 0; i < size; i++) {
			if (current.getData().equals(data)) {
				return i;
			}
			current = current.getNext();
		}
		return -1;
	}

}
