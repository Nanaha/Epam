package list;

import  java.util.Arrays;

/**
 * @author Nanaha
 *
 */
public class MyArrayList <T extends Comparable<T> > implements List<T> {

	private int           size;
	private int           capacity = 10;	
	private Object[]      array;
	
	public MyArrayList() {
		array = new Object[capacity];
	}
	
	public MyArrayList(int capacity) {
		this.capacity = capacity;
		array = new Object[capacity];
	}
	
	private void copy(Object[] from, int fromStart, Object[] to, int toStart, int amount) {
		for (int i = 0; i < amount; i++) {
			to[toStart + i] = from[fromStart + i]; 
		}
	}
	
	private void resize(int to) {
		if (to >= this.size) {
			return;
		}
		capacity       = to;
		Object[] temp  = array;
		array          = new Object[capacity];
		copy(temp, 0, array, 0, size);
	}
	
	public void add(T item) {
		if (size == capacity) {
			resize(capacity * 2);
		}
		array[size] = item;
		size++;
	}
	
	public void add(int index, T item) throws IndexOutOfBoundsException {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException("Invalid index");
		}
		if (size == capacity) {
			resize(capacity * 2);
		}
		
		Object[] temp = new Object[capacity];
		copy(array, index, temp, 0, size - index);
		copy(temp, 0, array, index + 1, size - index);
		array[index] = item;
		size++;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < size; i++) {
			sb.append(array[i]).append(" ");
		}
		sb.append("]");
		return sb.toString();
	}
	
	public void addAll(T[] container) {
		if (container.length + size > capacity) {
			resize(capacity + container.length);
		}
		copy(container, 0, array, size, container.length);
		size += container.length;
	}
	
	public void addAll(int index, T[] container) throws IndexOutOfBoundsException {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException("Invalid index");
		}
		if (container.length + size > capacity) {
			resize(capacity + container.length);
		}
		
		Object[] temp = new Object[size];
		copy(array, index, temp, 0, size - index);
		copy(container, 0, array, index, container.length);
		copy(temp, 0, array, index + container.length, temp.length);
		size += container.length;
	}
	
	public void ensureCapacity(int minCapacity) {
		resize(minCapacity);
	}
	
	public T get(int index) throws IndexOutOfBoundsException {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException("Invalid index");
		}
		return (T)array[index];
	}
	
	public void remove(int index) throws IndexOutOfBoundsException {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException("Invalid index");
		}
		copy(array, index + 1, array, index, size - index);
		size--;
	}
	
	public void set(int index, T data) throws IndexOutOfBoundsException {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException("Invalid index");
		}
		array[index] = data;
	}
	
	public int size() {
		return size;
	}
}
