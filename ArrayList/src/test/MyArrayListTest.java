/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Test;
import list.MyArrayList;

/**
 * @author Nanaha
 *
 */
public class MyArrayListTest {

	/**
	 * Test method for {@link list.MyArrayList#add(java.lang.Comparable)}.
	 */
	@Test
	public void testAddT() {
		MyArrayList<Integer> arrayList = new MyArrayList<Integer>();
		arrayList.add(new Integer(1));
		arrayList.add(new Integer(3));
		assertEquals(2, arrayList.size());
		assertEquals(new Integer(1), arrayList.get(0));
		assertEquals(new Integer(3), arrayList.get(1));
	}

	/**
	 * Test method for {@link list.MyArrayList#add(int, java.lang.Comparable)}.
	 */
	@Test
	public void testAddIntT() {
		MyArrayList<Integer> arrayList = new MyArrayList<Integer>();
		arrayList.add(new Integer(0));
		arrayList.add(new Integer(1));
		arrayList.add(0, new Integer(4));
		assertEquals(3, arrayList.size());
		assertEquals(new Integer(4), arrayList.get(0));
		assertEquals(new Integer(0), arrayList.get(1));
		assertEquals(new Integer(1), arrayList.get(2));
		arrayList.add(3, new Integer(8));
		assertEquals(new Integer(8), arrayList.get(3));
		arrayList.add(3, new Integer(10));
		assertEquals(new Integer(8), arrayList.get(4));
		assertEquals(new Integer(10), arrayList.get(3));
	}

	/**
	 * Test method for {@link list.MyArrayList#addAll(T[])}.
	 */
	@Test
	public void testAddAllTArray() {
		MyArrayList<Integer> arrayList = new MyArrayList<Integer>();
		arrayList.add(new Integer(0));
		arrayList.add(new Integer(1));
		arrayList.add(new Integer(2));
		
		Integer[] array = new Integer[3];
		array[0] = new Integer(3);
		array[1] = new Integer(4);
		array[2] = new Integer(5);
		
		arrayList.addAll(array);
		
		assertEquals(new Integer(0), arrayList.get(0));
		assertEquals(new Integer(1), arrayList.get(1));
		assertEquals(new Integer(2), arrayList.get(2));
		assertEquals(new Integer(3), arrayList.get(3));
		assertEquals(new Integer(4), arrayList.get(4));
		assertEquals(new Integer(5), arrayList.get(5));
	}

	/**
	 * Test method for {@link list.MyArrayList#addAll(int, T[])}.
	 */
	@Test
	public void testAddAllIntTArray() {
		MyArrayList<Integer> arrayList = new MyArrayList<Integer>();
		arrayList.add(new Integer(0));
		arrayList.add(new Integer(4));
		arrayList.add(new Integer(5));
		
		Integer[] array = new Integer[3];
		array[0] = new Integer(1);
		array[1] = new Integer(2);
		array[2] = new Integer(3);
		
		arrayList.addAll(1, array);
		
		assertEquals(new Integer(0), arrayList.get(0));
		assertEquals(new Integer(1), arrayList.get(1));
		assertEquals(new Integer(2), arrayList.get(2));
		assertEquals(new Integer(3), arrayList.get(3));
		assertEquals(new Integer(4), arrayList.get(4));
		assertEquals(new Integer(5), arrayList.get(5));
	}

	/**
	 * Test method for {@link list.MyArrayList#remove(int)}.
	 */
	@Test
	public void testRemove() {
		MyArrayList<Integer> arrayList = new MyArrayList<Integer>();
		arrayList.add(new Integer(0));
		arrayList.add(new Integer(1));
		arrayList.add(new Integer(2));
		arrayList.add(new Integer(3));
		arrayList.add(new Integer(4));
		arrayList.add(new Integer(5));
		
		arrayList.remove(2);
		assertEquals(5, arrayList.size());
		assertEquals(new Integer(3), arrayList.get(2));
		assertEquals(new Integer(5), arrayList.get(4));
	}

	/**
	 * Test method for {@link list.MyArrayList#set(int, java.lang.Comparable)}.
	 */
	@Test
	public void testSet() {
		MyArrayList<Integer> arrayList = new MyArrayList<Integer>();
		arrayList.add(new Integer(0));
		arrayList.add(new Integer(1));
		arrayList.add(new Integer(2));
		arrayList.add(new Integer(3));
		arrayList.set(0, new Integer(4));
		arrayList.set(1, new Integer(5));
		arrayList.set(2, new Integer(6));
		
		assertEquals(new Integer(4), arrayList.get(0));
		assertEquals(new Integer(5), arrayList.get(1));
		assertEquals(new Integer(6), arrayList.get(2));
	}
}
