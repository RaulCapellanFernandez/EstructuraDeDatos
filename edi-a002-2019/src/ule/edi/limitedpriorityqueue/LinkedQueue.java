package ule.edi.limitedpriorityqueue;

public class LinkedQueue<T> implements QueueADT<T> {
	
	protected static class Node<D> {
		D element;
		Node<D> next;
		
		Node() {
		this.element = null;
		this.next = null;
		}
		Node(D element) {
		this.element = element;
		this.next = null;
		}
		
		}

	private int count;
	private Node<T> front, rear; 
	
	public LinkedQueue()
	 {
		// TODO Auto-generated method stub
	 } 
	
	@Override
	public void enqueue(T element) {
		Node<T> actual  = front;
		Node<T> introducir = new Node<T>(element);
		
		if(actual == null) {
			front = introducir;
			introducir.next = rear;
			return;
		}
		while (actual != rear) {
			if(actual.next == rear) {
				introducir.next = rear;
				actual.next = introducir;
				return;
			}
			actual = actual.next;
		}
		
		
	}

	@Override
	public T dequeue() throws EmptyCollectionException
	   {
		// TODO Auto-generated method stub
		return null;

	   }

	@Override
	public T first()  throws EmptyCollectionException{
		if(front == null)
			throw new EmptyCollectionException("");
		else
			return front.element;
	}

	@Override
	public boolean isEmpty() {
		if(front == null)
			return true;
		else
			return false;
	}

	@Override
	public int size() {
		Node<T> actual  = front;
		while (actual != rear) {
			count++;
			actual = actual.next;
		}
		return count;
	}

	@Override
	public T dequeueLast() throws EmptyCollectionException {
	  // TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		if (! this.isEmpty()) {
			StringBuffer rx = new StringBuffer();
			Node<T> actual=front;
			while (actual!=null) {
				rx.append(actual.element.toString());
				rx.append(", ");
				actual=actual.next;
			}
			rx.delete(rx.length() - 2, rx.length());
			return rx.toString();
		}
		return ""; 


};

}
