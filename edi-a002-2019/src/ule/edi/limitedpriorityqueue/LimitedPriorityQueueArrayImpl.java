package ule.edi.limitedpriorityqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


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
    	int contador = 0;
    	for(int i = 0; i < npriorities; i++) {
    		if(capacity == colas.get(i).size()) 
    			contador++;
    	}
    	if(contador == npriorities)
    		return true;
    	return false;
    }

	@Override
	public T enqueue(int p, T element) {
		int prioridad = 1;
		
		for(int i = 0; i < npriorities; i++) {
			System.out.print("Prioridad: "+prioridad+"  Elemento:"+element);
			if(prioridad == p) {
				if(capacity > this.getSize()) {
					colas.get(i).enqueue(element);
					System.out.println(" Capacidad:"+capacity+"  Cola:"+colas.get(i).size());
					return null;
				}else {
					for(int j = 0; j < npriorities; j++) {
						if(!colas.get(j).isEmpty()) {
							try {
								colas.get(j).dequeue();
								System.out.println(toString());
								enqueue(p, element);
								System.out.println(toString());
							} catch (EmptyCollectionException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
					}
				}
			}
			System.out.println();
			
			prioridad++;
		}
		
		return element;
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
		for(int i = 0; i < npriorities; i++) {
			if(!colas.get(i).isEmpty())
				return false;
		}
		return true;
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
  

