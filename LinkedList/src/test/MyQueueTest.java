/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import queue.MyQueue;

/**
 * @author Nanaha
 *
 */
public class MyQueueTest {

	/**
	 * Test method for {@link queue.MyQueue#offer(java.lang.Comparable)}.
	 */
	@Test
	public void testOffer() {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		queue.offer(new Integer(2));
		queue.offer(new Integer(3));
		assertEquals(new Integer(2), queue.poll());
		assertEquals(new Integer(3), queue.peek());
	}

	/**
	 * Test method for {@link queue.MyQueue#peek()}.
	 * Test method for {@link queue.MyQueue#poll()}.
	 */
	@Test
	public void testPeekPoll() {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		queue.offer(new Integer(81));
		queue.offer(new Integer(18));
		assertEquals(new Integer(81), queue.peek());
		assertEquals(new Integer(81), queue.poll());
		assertEquals(new Integer(18), queue.peek());
	}
}
