package ule.edi.SimpleList;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;



public class SingleLinkedListImpl<T> extends AbstractSingleLinkedListImpl<T> {
	
	public SingleLinkedListImpl(T ... elements) {
		header = null;
		
		if(elements.length > 0) {
			Node<T> intro = new Node<T>(elements[0]);
			header = intro;
		}
	
		singleLinkedListImplRec(header, elements, elements.length, 1);
		
    }
		
	private void singleLinkedListImplRec(Node<T> head,T[] elementos, int longitud, int contador) {
		if(longitud != contador && contador < longitud) {
			Node<T> intro = new Node<T>(elementos[contador]);
			head.next = intro; 
			singleLinkedListImplRec(head.next, elementos, longitud, ++contador);
		}
	}

	@Override
	public void addLast(T element) {
		Node<T> intro = new Node<T>(element);
		if(header == null) { 
			header = intro;
		}else
			addLastRec(header, intro);
			
	}

	private void addLastRec(Node<T> head, Node<T> intro) {
		if(head.next != null)
			addLastRec(head.next, intro);
		else
			head.next = intro;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		if(header == null)
			return true;
		return false;
	}

	@Override
	public int size() {
		
		 return sizeRec(header);
	}

	private int sizeRec(Node<T> head) {
		if(head == null)
			return 0;
		else
			return 1+sizeRec(head.next);
		
	}

	@Override
	public void addFirst(T element) {
		Node<T> intro = new Node<T>(element);
		if(header == null) 
			header = intro;
		else {
			intro.next = header;
			header = intro;
		}
		
	}

	

	@Override
	public void addAtPos(T element, int p) {
		if(header == null || p == 1) 
			addFirst(element);
			
		else if(p > size())
			addLast(element);
		else
			addAtPosRec(header, element, p, 1);
	}

	private void addAtPosRec(Node<T> head, T element, int p, int num) {
		Node<T> intro = new Node<T>(element);
		if(p-1 != num)
			addAtPosRec(head.next, element, p, ++num);
		else {
			intro.next = head.next;
			head.next = intro;
		}
	}

	@Override
	public void addNTimes(T element, int n) {
		addNTimesRec(element, n);
	}

	private void addNTimesRec(T element, int n) {
		if(n > 0) {
			addLast(element);
			addNTimesRec(element, --n);
		}
		
	}

	@Override
	public int indexOf(T elem) {
		return indexOfRec(header, elem);
	}

	private int indexOfRec(Node<T> head, T elem) {
		if(head == null)
			throw new NoSuchElementException();
		if(head.content.equals(elem))
			return 1;
		else
			return 1+indexOfRec(head.next, elem);
	}

	@Override
	public T removeLast() throws EmptyCollectionException {
		T sol;
		if(header  == null)
			throw new EmptyCollectionException("");
		else if(size() == 1) {
			Node<T> borrar = new Node<T>(header.content);
			header = null;
			return borrar.content;
		}else if(size() == 2) {
			Node<T> borrar = new Node<T>(header.next.content);
			header.next = null;
			return borrar.content;
		}else
			return sol  = removeLastRec(header);
	}

	private T removeLastRec(Node<T> head) {
		if(head.next.next != null)
			return removeLastRec(head.next);
		else {
			Node<T> borrar = new Node<T>(head.next.content);
			head.next = null;
			return borrar.content;
		}
			
	}

	@Override
	public T removeLast(T elem) throws EmptyCollectionException {
		return null;
	}


	@Override
	public AbstractSingleLinkedListImpl<T> reverse() {
		SingleLinkedListImpl<T> listaReverse = new SingleLinkedListImpl<T>();
		listaReverse = reverseRec(header, listaReverse);
		return listaReverse;
	}

	private SingleLinkedListImpl<T> reverseRec(Node<T> head, SingleLinkedListImpl<T> listaReverse) {
		if(head != null) {
			listaReverse.addFirst(head.content);
			return reverseRec(head.next, listaReverse);
		}
			return listaReverse;
	}

	@Override
	public int isSubList(AbstractSingleLinkedListImpl<T> part) {
		 return isSubListRec(header, part, 0);
	}

	private int isSubListRec(Node<T> head, AbstractSingleLinkedListImpl<T> headPart, int pos) {
		if(head == null || headPart == null)
			return -1;
		if(head.content.equals(headPart.header.content)) {
			boolean sol = isSubListRecRec(head, headPart.header);
			if(sol)
				return pos;
			else
				isSubListRec(head.next, headPart, ++pos);
		}
		return -1;
		
	}

	private boolean isSubListRecRec(Node<T> head1, Node<T> headerPart1) {
		if(headerPart1 == null)
			return true;
		else
			if(head1.content.equals(headerPart1.content))
				isSubListRecRec(head1.next, headerPart1.next);
		return false;
	}

	
}
