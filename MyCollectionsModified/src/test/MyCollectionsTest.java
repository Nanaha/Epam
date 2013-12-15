/**
 * 
 */
package test;

import static org.junit.Assert.*;
import list.*;

import org.junit.Test;

import collections.MyCollections;

/**
 * @author Nanaha
 *
 */
public class MyCollectionsTest {

	/**
	 * Test method for {@link collections.MyCollections#sort(list.List, boolean)}.
	 */
	@Test
	public void testSortArrayList() {
		MyArrayList<Integer> arrayList = new MyArrayList<Integer>();
		arrayList.add(new Integer(7));
		arrayList.add(new Integer(6));
		arrayList.add(new Integer(5));
		arrayList.add(new Integer(4));
		
		assertEquals(new Integer(4), arrayList.get(3));
		
		MyCollections.sort(arrayList, true);
		
		assertEquals(new Integer(4), arrayList.get(0));
		assertEquals(new Integer(5), arrayList.get(1));
		assertEquals(new Integer(6), arrayList.get(2));
		assertEquals(new Integer(7), arrayList.get(3));
	}
	
	/**
	 * Test method for {@link collections.MyCollections#sort(list.List, boolean)}.
	 */
	@Test
	public void testSortLinkedList() {
		MyLinkedList<Integer> linkedList = new MyLinkedList<Integer>();
		linkedList.add(new Integer(4));
		linkedList.add(new Integer(5));
		linkedList.add(new Integer(6));
		linkedList.add(new Integer(7));		
		
		
		assertEquals(new Integer(7), linkedList.get(3));
		
		MyCollections.sort(linkedList, false);
		
		assertEquals(new Integer(7), linkedList.get(0));
		assertEquals(new Integer(6), linkedList.get(1));
		assertEquals(new Integer(5), linkedList.get(2));
		assertEquals(new Integer(4), linkedList.get(3));
	}

	/**
	 * Test method for {@link collections.MyCollections#swap(list.List, int, int)}.
	 */
	@Test
	public void testSwapLinkedList() {
		MyLinkedList<Integer> linkedList = new MyLinkedList<Integer>();
		linkedList.add(new Integer(1));
		linkedList.add(new Integer(2));
		linkedList.add(new Integer(3));
		linkedList.add(new Integer(4));	
		
		assertEquals(new Integer(3), linkedList.get(2));
		assertEquals(new Integer(4), linkedList.get(3));
		
		MyCollections.swap(linkedList, 2, 3);
		
		assertEquals(new Integer(4), linkedList.get(2));
		assertEquals(new Integer(3), linkedList.get(3));
	}
	
	/**
	 * Test method for {@link collections.MyCollections#swap(list.List, int, int)}.
	 */
	@Test
	public void testSwapArrayList() {
		MyArrayList<Integer> arrayList = new MyArrayList<Integer>();
		arrayList.add(new Integer(1));
		arrayList.add(new Integer(2));
		arrayList.add(new Integer(3));
		arrayList.add(new Integer(4));	
		
		assertEquals(new Integer(3), arrayList.get(2));
		assertEquals(new Integer(4), arrayList.get(3));
		
		MyCollections.swap(arrayList, 2, 3);
		
		assertEquals(new Integer(4), arrayList.get(2));
		assertEquals(new Integer(3), arrayList.get(3));
	}

	/**
	 * Test method for {@link collections.MyCollections#copy(list.List, list.List)}.
	 */
	@Test
	public void testCopy() {
		MyArrayList<Integer> arrayList = new MyArrayList<Integer>();
		arrayList.add(new Integer(1));
		arrayList.add(new Integer(2));
		arrayList.add(new Integer(3));
		
		MyLinkedList<Integer> linkedList = new MyLinkedList<Integer>();
		linkedList.add(new Integer(4));
		linkedList.add(new Integer(5));
		linkedList.add(new Integer(6));
		
		MyCollections.copy(arrayList, linkedList);
		
		assertEquals(new Integer(4), arrayList.get(3));
		assertEquals(new Integer(5), arrayList.get(4));
		assertEquals(new Integer(6), arrayList.get(5));
	}
	
	/**
	 * Test method for {@link collections.MyCollections#reverse(list.List)}.
	 */
	@Test
	public void testReverseArrayList() {
		MyArrayList<Integer> arrayList = new MyArrayList<Integer>();
		arrayList.add(new Integer(1));
		arrayList.add(new Integer(2));
		arrayList.add(new Integer(3));
		
		assertEquals(new Integer(3), arrayList.get(2));
		
		MyCollections.reverse(arrayList);
		
		assertEquals(new Integer(3), arrayList.get(0));
		assertEquals(new Integer(2), arrayList.get(1));
		assertEquals(new Integer(1), arrayList.get(2));
		
	}
	
	/**
	 * Test method for {@link collections.MyCollections#reverse(list.List)}.
	 */
	@Test
	public void testReverseLinkedList() {
		MyLinkedList<Integer> linkedList = new MyLinkedList<Integer>();
		linkedList.add(new Integer(1));
		linkedList.add(new Integer(2));
		linkedList.add(new Integer(3));
		
		assertEquals(new Integer(3), linkedList.get(2));
		
		MyCollections.reverse(linkedList);
		
		assertEquals(new Integer(3), linkedList.get(0));
		assertEquals(new Integer(2), linkedList.get(1));
		assertEquals(new Integer(1), linkedList.get(2));
		
	}

	/**
	 * Test method for {@link collections.MyCollections#binarySearch(list.List, java.lang.Comparable, boolean)}.
	 */
	@Test
	public void testBinarySearchListOfTTBooleanArrayList() {
		MyArrayList<Integer> arrayList = new MyArrayList<Integer>();
		arrayList.add(new Integer(7));
		arrayList.add(new Integer(4));
		arrayList.add(new Integer(1));
		arrayList.add(new Integer(8));
		arrayList.add(new Integer(2));
		arrayList.add(new Integer(5));
		arrayList.add(new Integer(3));
		
		MyCollections.sort(arrayList, true);
		
		int pos4 = MyCollections.binarySearch(arrayList, new Integer(4), true);
		assertEquals(3, pos4);
		assertEquals(new Integer(2), arrayList.get(1));
		int pos2 = MyCollections.binarySearch(arrayList, new Integer(2), true);
		assertEquals(1, pos2);
		int pos7 = MyCollections.binarySearch(arrayList, new Integer(7), true);
		assertEquals(5, pos7);
		int pos6 = MyCollections.binarySearch(arrayList, new Integer(6), true);
		assertEquals(-6, pos6);
	}
	
	/**
	 * Test method for {@link collections.MyCollections#binarySearch(list.List, java.lang.Comparable, boolean)}.
	 */
	@Test
	public void testBinarySearchListOfTTBooleanLinkedList() {
		MyLinkedList<Integer> linkedList = new MyLinkedList<Integer>();
		linkedList.add(new Integer(7));
		linkedList.add(new Integer(4));
		linkedList.add(new Integer(1));
		linkedList.add(new Integer(8));
		linkedList.add(new Integer(2));
		linkedList.add(new Integer(5));
		linkedList.add(new Integer(3));
		
		MyCollections.sort(linkedList, true);
		
		int pos4 = MyCollections.binarySearch(linkedList, new Integer(4), true);
		assertEquals(3, pos4);
		assertEquals(new Integer(2), linkedList.get(1));
		int pos2 = MyCollections.binarySearch(linkedList, new Integer(2), true);
		assertEquals(1, pos2);
		int pos7 = MyCollections.binarySearch(linkedList, new Integer(7), true);
		assertEquals(5, pos7);
		int pos6 = MyCollections.binarySearch(linkedList, new Integer(6), true);
		assertEquals(-6, pos6);
	}
}
