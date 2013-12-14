package list;

/**
 * @author Nanaha
 *
 */
public class Element <T extends Comparable<T> > implements Comparable<Element<T>> {
	
	private Element<T>    previous;
	private Element<T>    next;
	private T             data;
	
	public Element(T data) {
		this.data = data;
	} 
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public void setPrevious(Element<T> previous) {
		this.previous = previous;
	}
	
	public Element<T> getPrevious() {
		return this.previous;
	}
	
	public Element<T> getNext() {
		return this.next;
	}
	
	public void setNext(Element<T> next) {
		this.next = next;
	}
	
	public int compareTo(Element<T> element) {
		return this.data.compareTo(element.data);
	}
}
