package queue;

/**
 * @author Nanaha
 *
 */
public interface MyQueue  <T> {
	void offer(T data);
	T peek();
	T poll();
}
