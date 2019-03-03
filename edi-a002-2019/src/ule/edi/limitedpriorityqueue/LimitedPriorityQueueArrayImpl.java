package ule.edi.limitedpriorityqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import ule.edi.limitedpriorityqueue.LinkedQueue.Node;


public class LimitedPriorityQueueArrayImpl<T> implements LimitedPriorityQueue<T> {
	    private int capacity;
	    private int npriorities;
	    private int count;

	    private ArrayList<LinkedQueue<T>> colas = new ArrayList<LinkedQueue<T>>();
	
	

	public LimitedPriorityQueueArrayImpl(int capacity, int npriorities) {
		this.capacity = capacity;
		this.npriorities = npriorities;
		for(int i = 0; i < npriorities; i++) {
			LinkedQueue<T> cola = new LinkedQueue<T>();
			colas.add(cola);
		}
	}
	



    @Override
    public int getCapacity() {
		return capacity;
    }

    @Override
    public int getSize() {
    	count  =0;
    	for(int i = 0; i < colas.size(); i++) {
			count = count +colas.get(i).size();
    	}
    	return count;
    }

    @Override
    public boolean isFull() {
		if(capacity == getSize()) 
    		return true;
    	return false;
    }

	@Override
	public T enqueue(int p, T element) {
		int prioridad = 1;
		int pMin = 0;
		T borrar = null;
		
		for(int i = 0; i < npriorities; i++) {
			if(!colas.get(i).isEmpty())
				pMin = i+1;
		}
		
		for(int i = 0; i < npriorities; i++) {
			if(prioridad == p) {
				if(capacity > this.getSize()) {
					colas.get(i).enqueue(element);
					return null;
				}else {
					for(int j = npriorities-1; j >= 0 ; j--) {
						if(!colas.get(j).isEmpty()) {
							try {
								if(pMin <= p) {
									return element;
								}else {
									borrar = colas.get(j).dequeueLast();
									enqueue(p, element);
									return borrar;
								}
							
							} catch (EmptyCollectionException e) { 
								e.printStackTrace();
							}
						}
					}
				}
			}
			prioridad++;
		}
		return element;
	}


	@Override
	public T first() throws EmptyCollectionException {
		if(isEmpty())
			throw new EmptyCollectionException("");
		for(int j = 0; j < npriorities ; j++) {
			if(!colas.get(j).isEmpty()) {
				return colas.get(j).first();
			}
		}
      return null;
	}



	@Override
	public T dequeue() throws EmptyCollectionException {
		T aux = null;
		if(isEmpty())
			throw new EmptyCollectionException("");
		for(int j = 0; j < npriorities; j++) {
			if(!colas.get(j).isEmpty()) {
				aux = colas.get(j).first();
				colas.get(j).dequeue();
				return aux;
			}
		}
		return aux;
	}

	@Override
	public boolean isEmpty() {
		if(getSize() == 0)
			return true;
		return false;
	}

	
	@Override
	public String toString() {
		if (! this.isEmpty()) {
			StringBuffer rx = new StringBuffer();
			rx.append("[");
			for (int n = 0; n < this.npriorities; n++) {
				rx.append("( Priority:"+(n+1)+" (");
				rx.append(colas.get(n).toString());
				rx.append(")), ");
			}
			rx.delete(rx.length() - 2, rx.length());
			rx.append("]");
			return rx.toString();
		} else {
			return "[]";
		}
	}

};
  

