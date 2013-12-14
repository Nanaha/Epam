/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import stack.MyStack;

/**
 * @author Nanaha
 *
 */
public class MyStackTest {

	/**
	 * Test method for {@link stack.MyStack#push(java.lang.Comparable)}.
	 * Test method for {@link stack.MyStack#pop()}.
	 */
	@Test
	public void testPushPop() {
		MyStack<Integer> stack = new MyStack<Integer>();
		stack.push(new Integer(1));
		stack.push(new Integer(2));
		stack.push(new Integer(3));
		assertEquals(new Integer(3), stack.pop());
		assertEquals(new Integer(2), stack.pop());
		assertEquals(new Integer(1), stack.pop());
	}

}
