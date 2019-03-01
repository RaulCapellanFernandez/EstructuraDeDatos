package ule.edi.limitedpriorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

import javax.swing.text.AbstractDocument.Content;


public class LimitedPriorityQueueLinkedImpl<T> implements LimitedPriorityQueue<T> {
	    private int capacity;

	    private QueueNode<T> first;
	    private int count;
	

	private static class QueueNode<E> {
	
		public QueueNode(int priority, E content) {
			this.priority = priority;
			this.content = content;
			this.next = null;
		}
		
		
		public int priority;
		
		public E content;
		
		public QueueNode<E> next;
	};
	

	
	public LimitedPriorityQueueLinkedImpl(int capacity) {
		this.capacity = capacity;
   
	}
	
  

  
    @Override
    public int getCapacity() {

        return capacity;
    }
    
    @Override
    public int getSize() {
    	int esp = 0;
    	QueueNode<T> actual = first;
    
	   while(actual != null) { 
    		   esp++;
    	   actual = actual.next;
	   }
    	
    	return esp;
    }

    @Override
    public boolean isFull() {
    	// TODO Auto-generated method stub
    	return false;
    	
    }

	@Override
	public T enqueue(int p, T element) {
		QueueNode<T> actual = first;
		QueueNode<T> anterior;
		QueueNode<T> introducir = new QueueNode<T>(p, element);
		
		//Cuando la cola esta vacia
		if(getSize() < capacity) {
			if(first == null) {
				first = introducir;
				introducir.next  = null;
				return element;
			}
			//Se introduce en la primera posicion
			if(p < actual.priority) {
				introducir.next = first;
				first = introducir;
				return element;
			}
			
			//Bucle para el resto de casos
			while(actual != null) {
				if(p >= actual.priority && actual.next == null) {
					actual.next = introducir;
					introducir = null;
					return element;
				}
				//Introducir un elemento en el medio de una cola 
				if(p >= actual.priority && p < actual.next.priority) {
					introducir.next = actual.next;
					actual.next = introducir;
					return element;
				}
				actual = actual.next;
			}
		}
		
		return null;
	}

	@Override
	public T first() throws EmptyCollectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T dequeue() throws EmptyCollectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		QueueNode<T> actual = first;
		if (! this.isEmpty()) {
			StringBuffer rx = new StringBuffer();
			rx.append("[");
		      while(actual != null) {
		    	  rx.append(actual.content);
		    	  rx.append(" , ");
		    	  actual = actual.next;
		      }
		
			rx.append("]");
			return rx.toString();
		} else {
			return "[]";
		}
	}


  
}
