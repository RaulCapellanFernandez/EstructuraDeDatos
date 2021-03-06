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
    	if(getSize() < getCapacity()) 
    		return false;
    	return true;
    }

	@Override
	public T enqueue(int p, T element) {
		QueueNode<T> actual = first;
		QueueNode<T> min = first;
		QueueNode<T> aux = null;
		QueueNode<T> introducir = new QueueNode<T>(p, element);
		int pMin = 0;
		
		if(p <= 0)
			throw new IllegalArgumentException("Inutil hazlo bien");
		if(element == null)
			throw new NullPointerException("Inutil hazlo bien");
		
		while(min != null) {
			if(min.next == null)
				pMin = min.priority;
			min = min.next;
		}
		//Cuando la cola esta llena
		if(!isFull()) {
			//Cuando la lista esta vacia
			if(isEmpty()) {
				first = introducir;
				introducir.next  = null;
				return null;
			}
			//Se introduce en la primera posicion
			if(p < actual.priority) {
				introducir.next = first;
				first = introducir;
				return null;
			}
			
			//Bucle para el resto de casos
			while(actual != null) {
				if(p >= actual.priority && actual.next == null) {
					actual.next = introducir;
					introducir = null;
					return null;
				}
				//Introducir un elemento en el medio de una cola 
				if(p >= actual.priority && p < actual.next.priority) {
					introducir.next = actual.next;
					actual.next = introducir;
					return null;
				}
				actual = actual.next;
			}
		}
		//La lista esta llena y el proceso tiene menos prioridad que el ultimo introducido
		if(pMin <= p) {
			return element;
		}
		//La lista esta llena y el proceso tiene mas prioridad que el ultimo introducido
		actual = first;
		while(actual != null) {
			if(actual.next.next == null) {
				aux = actual.next;
				actual.next = null;
			}
			actual = actual.next;
		}
		enqueue(p, element);
		
		return aux.content;
	}

	@Override
	public T first() throws EmptyCollectionException {
		if(first == null)
			throw new EmptyCollectionException("La cola esta vacia");
		else 
			return first.content;
	}

	@Override
	public T dequeue() throws EmptyCollectionException {
		QueueNode<T> actual = first;
		QueueNode<T> aux;
		if(first == null)
			throw new EmptyCollectionException("");
		
			aux = actual;
			first = null;
			
		return aux.content;
	}

	@Override
	public boolean isEmpty() {
		if(first == null)
			return true;
		return false;
	}

	@Override
	public String toString() {
		QueueNode<T> actual = first;
		boolean pene = true;
		if (! this.isEmpty()) {
			StringBuffer rx = new StringBuffer();
			rx.append("[");
		      while(actual !=null) {
		    	  if(pene) {
		    		  rx.append("( Priority:"+(actual.priority)+" (");
		    		  //System.out.println(rx.toString());
		    		  pene = false;
		    	  }
		    	  rx.append(actual.content+", ");
		    	  //System.out.println(rx.toString());
		    	  if(actual.next == null||actual.priority != actual.next.priority) {
		    		  rx.delete(rx.length() - 2, rx.length());
		    		  pene = true;
		    		  rx.append(")), ");
		    	  }
		    	  actual = actual.next;
		      }
		      
		    rx.delete(rx.length() - 2, rx.length());
			rx.append("]");
			//System.out.println("---->"+rx.toString());
			return rx.toString();
		} else {
			return "[]";
		}
	}


  
}
