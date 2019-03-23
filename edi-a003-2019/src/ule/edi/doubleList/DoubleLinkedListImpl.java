package ule.edi.doubleList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.imageio.IIOException;
import javax.sound.midi.Soundbank;

public class DoubleLinkedListImpl<T> implements DoubleLinkedList<T> {
	/**
	 * Nodo doblemente enlazado.
	 * 
	 * Como es estÃ¡tica, no tiene en Ã¡mbito el parÃ¡metro 'T' de la
	 * clase que la contiene. El parÃ¡metro 'D' serÃ¡ sustituÃ­do por
	 * un tipo particular cuando se use el nodo, por ejemplo:
	 * 
	 * 		DoubleNode<T> cab;
	 * 
	 * en la lista.
	 *
	 * @param <D>
	 */
	static class DoubleNode<D> {

		DoubleNode(D element) {
			this.content = element;
			this.previous = null;
			this.next = null;
		}
		
		//	dato a almacenar en el nodo
		D content;
		
		DoubleNode<D> previous;
		
		DoubleNode<D> next;
	}

	/**
	 * Apunta al nodo cabecera; siempre habrÃ¡ un nodo vacÃ­o (sin elemento) que actua de cabecera
	 *  OJO!!! ESTE NODO CABECERA DEBERÃ� CREARSE EN CADA CONSTRUCTOR DE LA LISTA
	 */
	private DoubleNode<T> cab;
	
	
	
	//////////////////////
	/////  CONSTRUCTORES
	//////////////////////
	
	
	/**
	 * Construye una lista vacÃ­a.
	 */
	public DoubleLinkedListImpl() {
		cab = new DoubleNode<T>(null);	
		cab.next = cab;
		cab.previous = cab;
	}
	
	/**
	 * Construye una lista con los elementos dados.
	 * 
	 * Java crearÃ¡ un array 'elements' con los dados en la
	 * llamada al constructor; por ejemplo:
	 * 
	 * 	x = new DoubleLinkedList<String>("A", "B", "C");
	 * 
	 * ejecuta este mÃ©todo con un array [A, B, C] en 
	 * 'elements'.
	 * 
	 * @param elements
	 */
	public DoubleLinkedListImpl(T ... elements) {
		ArrayList<T> elementosLista = new ArrayList<T>();
		
		cab = new DoubleNode<T>(null);	
		cab.next = cab;
		cab.previous = cab;
		
		for(int i = 0; i < elements.length; i++) {
			addLast(elements[i]);
		}
	}
	
	/**
	 * Construye una lista a partir de otra.
	 * 
	 * Las listas tienen nodos independientes, con los mismos
	 * contenidos.
	 */
	public DoubleLinkedListImpl(DoubleLinkedList<T> other) {
		Iterator<T> iterador = other.iterator();
		
		cab = new DoubleNode<T>(null);	
		cab.next = cab;
		cab.previous = cab;
		
		while(iterador.hasNext()) 
			addLast( iterador.next());
	}
	

	
	//////////////////////
	/////  ITERADORES
	//////////////////////
	
	private class ForwardIterator implements Iterator<T> {

		private DoubleNode<T> at = cab ;
		
		@Override
		public boolean hasNext() {
			
			if(at.next == cab)
				return false;
			
			return true;
		}

		@Override
		public T next() {
			
			if(hasNext())
				at = at.next;
			else
				throw new NoSuchElementException();
			return at.content;

		}
		
		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
	};
	
	
	private class ReverseIterator implements Iterator<T> {

		private DoubleNode<T> at = cab;
		
		@Override
		public boolean hasNext() {
			if(at.previous == cab)
				return false;
			
			return true;
			
		}

		@Override
		public T next() {
			if(hasNext())
				at = at.previous;
			else
				throw new NoSuchElementException();
			
			return at.content;
			
		}
		
		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
	};

		private class OddAndEvenIterator implements Iterator<T> {

		// Definir los atributos necesarios para implementar el iterador
		
		public OddAndEvenIterator(){
			
		}
		
		@Override
		public boolean hasNext() {
			return false;
			// TODO Auto-generated method stub
			
		}

		@Override
		public T next() {
			return null;
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
	};

		
	
	
	////// FIN DE ITERADORES ///////
	////////////////////////////////
	
	@Override
	public boolean isEmpty() {
		if(cab.next == cab)
			return true;
		else
			return false;
		
	}

	@Override
	public int size() {
		DoubleNode<T> cabAux = cab;
		int tam = 0;
		while(cabAux.next != cab) {
			tam++;
			cabAux = cabAux.next;
		}
		return tam;
	}
	
	@Override
	public void addFirst(T element) {
		DoubleNode<T> introducir = new DoubleNode<T>(element);
		//Cuando la lista esta vacia
		if(isEmpty()) {
			cab.next = introducir;
			cab.previous = introducir;
			introducir.previous = cab;
			introducir.next = cab;
		}
		//Insertar en segunda posicion
		else if(cab.next.next == cab) {
			cab.next = introducir;
			cab.previous.previous = introducir;
			introducir.next = cab.previous;
			introducir.previous = cab;
		//Para el resto de posiciones
		}else {
			cab.next.previous = introducir;
			introducir.previous = cab;
			introducir.next = cab.next;
			cab.next = introducir;
		}
	}

	@Override
	public void addLast(T element) {
		DoubleNode<T> introducir = new DoubleNode<T>(element);
		//Cuando la lista esta vacia
		if(isEmpty()) {
			cab.next = introducir;
			cab.previous = introducir;
			introducir.previous = cab;
			introducir.next = cab;
		}
		//Insertar en segunda posicion por detras
		else if(cab.next.next == cab) {
			cab.previous = introducir;
			introducir.next = cab;
			introducir.previous = cab.next;
			cab.next.next = introducir;
			
		//Para el resto de posiciones
		}else {
			cab.previous.next = introducir;
			introducir.previous = cab.previous;
			introducir.next = cab;
			cab.previous = introducir;
		}
	}

	@Override
	public void addAtPos(T element, int p) {//hacerlo con size
		DoubleNode<T> aux = cab;
		DoubleNode<T> introducir = new DoubleNode<T>(element);
		
		//introduces en la ultima posicion
		if(size() < p)
			addLast(element);
		//Introduces en la primera posicion
		else if(p == 1)
			addFirst(element);
		else {
			//Introduces en una posicion intermedia
			for(int i = 0; i <= p; i++) {
				if(i == p) {
					aux.previous.next = introducir;
					introducir.previous =aux.previous;
					aux.previous = introducir;
					introducir.next = aux;
				}else
					aux = aux.next;
			}
		}
		
	}

	@Override
	public void addNTimes(T element, int n) {
		for(int i = 0; i < n; i++) {
			addLast(element);
		}
		
	}

	@Override
	public T getElem(int p) {//hacerlo con size
		DoubleNode<T> aux = cab;
		
		for(int i = 0; i <= size(); i++) {
			if(i == p)
				return aux.content;
			aux = aux.next;
		}
		
		throw new IndexOutOfBoundsException();
	}

	@Override
	public void setElem(T elem, int p) {//hacerlo con size
		DoubleNode<T> aux = cab;
		
		if(p <= 0 || p > size())
			throw new IndexOutOfBoundsException();
		
		for(int i = 0; i <= p; i++) {
			if(i == p)
				aux.content = elem;
			aux = aux.next;
		}
		
	}

	@Override
	public int indexOf(T elem) {
		DoubleNode<T> aux = cab;
		
		for(int i = 0; i <= size(); i++) {
			if(aux.content == elem)
				return i;
			aux = aux.next;
		}
		throw new NoSuchElementException();
	}

	@Override
	public int indexOf(T elem, int p) {
		DoubleNode<T> aux = cab;
		
		if(p <= 0 || p > size())
			throw new IndexOutOfBoundsException();
		
		for(int i = 0; i <= size(); i++) {
			if(aux.content == elem && i == p)
				return i;
			aux = aux.next;
		}
		throw new NoSuchElementException();
	}

	@Override
	public T removeFirst(T elem) throws EmptyCollectionException {
		DoubleNode<T> aux = cab;
		
		if(size() == 0)
			throw new EmptyCollectionException("");
		
		for(int i = 0; i <= size(); i++) {
			if(aux.content == elem) {
				aux.previous.next = aux.next;
				aux.next.previous = aux.previous;
				return elem;
			}
			aux = aux.next;
		}
		throw new NoSuchElementException();
	}

	@Override
	public T removeAll(T elem) throws EmptyCollectionException {
		DoubleNode<T> aux = cab;
		boolean borrado = false;
		
		if(size() == 0)
			throw new EmptyCollectionException("");
		
		for(int i = 0; i <= size(); i++) {
			if(aux.content == elem) {
				aux.previous.next = aux.next;
				aux.next.previous = aux.previous;
				borrado = true;
				i--;
			}
			aux = aux.next;
		}
		if(borrado)
			return elem;
		throw new NoSuchElementException();
	}
	@Override
	public T removeLast() throws EmptyCollectionException {
		if(size() == 0)
			throw new EmptyCollectionException("");
		
		T borrado = cab.previous.content;
		cab.previous.previous.next = cab;
		cab.previous = cab.previous.previous;
		return borrado;
	}
	
	
	

	@Override
	public void reverse() {
		ArrayList<T> elementosLista = new ArrayList<T>();
		DoubleNode<T> aux = cab;
		aux = aux.next;
		int j = 0;
		while(cab != aux) {
			elementosLista.add(aux.content);
			aux = aux.next;
		}
		cab.next = cab;
		cab.previous = cab;
		
		for(int i= 0; i < elementosLista.size(); i++){
			addFirst(elementosLista.get(i));
		}
	}

	@Override
	public int isSubList(DoubleLinkedList<T> part) {
		DoubleNode<T> aux = cab.next;
		Iterator<T> iterador = part.iterator();
		ArrayList<T> elementosLista = new ArrayList<T>();
		int inicio = 1, p = 0;
		boolean introducir = false;

		if(!iterador.hasNext())
			return 1;
			
		while(!introducir) {
			if(cab != aux){
				elementosLista.add(aux.content);
				aux = aux.next;
			}
			if(cab == aux)
				introducir = true;
		}
		
		while(introducir) {
			
			if(!iterador.hasNext())
				return inicio;
			if(elementosLista.get(p) != iterador.next()) {
				p = 0;
				inicio++;
				if(elementosLista.size() == 1)
					introducir = false;
				else
					elementosLista.remove(p);
				
				iterador = part.iterator();
			}else {
				p++;
			} 
		}
		
		return -1;
	}

	@Override
	public void interlace(DoubleLinkedList<T> other) {
		DoubleNode<T> aux = cab.next;
		Iterator<T> iterador = other.iterator();
		ArrayList<T> elementosLista = new ArrayList<T>();
		boolean introducir = false;
		
		while(!introducir) {
			if(cab != aux){
				elementosLista.add(aux.content);
				aux = aux.next;
			}
			if(iterador.hasNext()) {
				elementosLista.add(iterador.next());
			}
			if(cab == aux && !iterador.hasNext())
				introducir = true;
		}
		cab.next = cab;
		cab.previous = cab;
		
		for(int i = elementosLista.size()-1; i >= 0; i--) {
			addFirst(elementosLista.get(i));
		}
		
	}	
	
	@Override
	public String toString() {
		
		if (cab != cab.next) {
			StringBuffer rx = new StringBuffer();
			rx.append("[");
			DoubleNode<T> i = cab.next;
			while (i != cab) {
				//System.out.println("yee"+i.content);
				rx.append(i.content);
				rx.append(", ");
				i = i.next;
			}
			//System.out.println(rx);
			rx.delete(rx.length() - 2, rx.length());
			//System.out.print(rx);
			rx.append("]");
			
			return rx.toString();
		} else {
			return "[]";
		}
	}

	

	///////////////////////////////////////////
	  // mÃ©todos que devuelve iteradores
	 ///////////////////////////////////////
	@Override
	public Iterator<T> oddAndEvenIterator() {
		return null;
		// TODO Auto-generated method stub
		
		
	}

	 @Override
		public Iterator<T> iterator() {
	    	return new ForwardIterator();
			
		}

		@Override
		public Iterator<T> reverseIterator() {
			// TODO Auto-generated method stub
			return new ReverseIterator();
		}

		
	
}
