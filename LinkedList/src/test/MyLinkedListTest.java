/**
 * 
 */
package test;

import static org.junit.Assert.*;
import list.MyLinkedList;

import org.junit.Test;

/**
 * @author Nanaha
 *
 */
public class MyLinkedListTest {

	/**
	 * Test method for {@link list.MyLinkedList#size()}.
	 */
	@Test
	public void testSize() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		assertEquals(0, list.size());
		list.add(new Integer(2));
		assertEquals(1, list.size());
		list.add(0, new Integer(7));
		assertEquals(2, list.size());
		list.addFirst(new Integer(12));
		assertEquals(3, list.size());
		list.addLast(new Integer(8));
		assertEquals(4, list.size());
	}

	/**
	 * Test method for {@link list.MyLinkedList#add(java.lang.Comparable)}.
	 */
	@Test
	public void testAddT() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		list.add(new Integer(8));
		assertEquals(new Integer(8), list.getFirst());
		list.add(new Integer(4));
		assertEquals(new Integer(4), list.get(1));
		assertEquals(new Integer(4), list.getLast());
	}

	/**
	 * Test method for {@link list.MyLinkedList#get(int)}.
	 */
	@Test
	public void testGet() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		list.add(0, new Integer(5));
		assertEquals(new Integer(5), list.get(0));
		assertEquals(new Integer(5), list.getLast());
		list.addFirst(new Integer(7));
		assertEquals(new Integer(7), list.getFirst());
		assertEquals(new Integer(7), list.get(0));
		assertEquals(new Integer(5), list.get(1));
		list.addLast(new Integer(89));
		assertEquals(new Integer(89), list.get(2));
	}

	/**
	 * Test method for {@link list.MyLinkedList#add(int, java.lang.Comparable)}.
	 */
	@Test
	public void testAddIntT() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		list.add(0, new Integer(0));
		assertEquals(1, list.size());
		list.add(1, new Integer(5));
		list.add(2, new Integer(9));
		assertEquals(new Integer(0), list.get(0));
		assertEquals(new Integer(5), list.get(1));
		assertEquals(new Integer(9), list.get(2));
		list.add(1, new Integer(1));
		assertEquals(new Integer(1),  list.get(1));
	}

	/**
	 * Test method for {@link list.MyLinkedList#addFirst(java.lang.Comparable)}.
	 */
	@Test
	public void testAddFirst() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		list.add(0, new Integer(0));
		list.add(1, new Integer(1));
		list.add(2, new Integer(2));
		list.addFirst(new Integer(10));
		assertEquals(new Integer(10), list.getFirst());
		assertEquals(new Integer(0), list.get(1));
	}

	/**
	 * Test method for {@link list.MyLinkedList#addLast(java.lang.Comparable)}.
	 */
	@Test
	public void testAddLast() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		list.add(0, new Integer(0));
		list.add(1, new Integer(1));
		list.addLast(new Integer(2));
		assertEquals(new Integer(2), list.getLast());
		assertEquals(new Integer(2), list.get(2));
	}

	/**
	 * Test method for {@link list.MyLinkedList#remove(int)}.
	 */
	@Test
	public void testRemove() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		list.add(0, new Integer(0));
		list.add(1, new Integer(1));
		list.addLast(new Integer(2));
		list.remove(1);
		assertEquals(2, list.size());
		assertEquals(new Integer(2), list.getLast());
		list.remove(0);
		assertEquals(new Integer(2), list.getFirst());
		list.add(new Integer(9));
		list.remove(1);
		assertEquals(new Integer(2), list.getLast());
	}
	
	/**
	 * Test method for {@link list.MyLinkedList#remove(int)}.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveWrongIndex() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		list.add(0, new Integer(0));
		list.remove(2);
	}

	/**
	 * Test method for {@link list.MyLinkedList#removeFirst()}.
	 */
	@Test
	public void testRemoveFirst() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		list.add(0, new Integer(0));
		list.add(1, new Integer(1));
		list.addLast(new Integer(2));
		list.removeFirst();
		assertEquals(2, list.size());
		assertEquals(new Integer(1), list.getFirst());
	}

	/**
	 * Test method for {@link list.MyLinkedList#removeLast()}.
	 */
	@Test
	public void testRemoveLast() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		list.add(0, new Integer(0));
		list.add(1, new Integer(1));
		list.removeLast();
		assertEquals(1, list.size());
		assertEquals(new Integer(0), list.getLast());
	}

	/**
	 * Test method for {@link list.MyLinkedList#set(int, java.lang.Comparable)}.
	 */
	@Test
	public void testSet() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		list.add(0, new Integer(0));
		list.add(1, new Integer(1));
		list.add(1, new Integer(2));
		list.set(1, new Integer(4));
		assertEquals(new Integer(4), list.get(1));
	}

	/**
	 * Test method for {@link list.MyLinkedList#indexOf(java.lang.Comparable)}.
	 */
	@Test
	public void testIndexOf() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		list.add(0, new Integer(0));
		list.add(new Integer(1));
		list.add(new Integer(2));
		list.add(3, new Integer(3));
		assertEquals(new Integer(1), list.get(1));
		assertEquals(1, list.indexOf(new Integer(1)));
		assertEquals(-1, list.indexOf(new Integer(99)));
		assertEquals(3, list.indexOf(new Integer(3)));
	}

}
