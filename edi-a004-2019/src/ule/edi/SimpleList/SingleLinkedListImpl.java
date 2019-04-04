package ule.edi.SimpleList;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;



public class SingleLinkedListImpl<T> extends AbstractSingleLinkedListImpl<T> {
	Node<T> first;
	
	public SingleLinkedListImpl(T ... elements) {
		int longitud = elements.length;
		first = new Node<T>(elements[0]);
	
		singleLinkedListImplRec(first, elements, longitud, 1);
		
    }
		
	private void singleLinkedListImplRec(Node<T> head,T[] elementos, int longitud, int contador) {
		System.out.println("Contador"+ contador+" Longitud"+ longitud);
		
		if(longitud != contador) {
			Node<T> intro = new Node<T>(elementos[contador]);
			head.next = intro; 
			System.out.println("Head: "+head.content);
			System.out.println("Head: "+head.next.content);
			singleLinkedListImplRec(head.next, elementos, longitud, ++contador);
		}
	}

	@Override
	public void addLast(T element) {
		
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addFirst(T element) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void addAtPos(T element, int p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addNTimes(T element, int n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int indexOf(T elem) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T removeLast() throws EmptyCollectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T removeLast(T elem) throws EmptyCollectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractSingleLinkedListImpl<T> reverse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int isSubList(AbstractSingleLinkedListImpl<T> part) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
