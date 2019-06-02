package ule.edi.tree;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Ã�rbol binario de bÃºsqueda (binary search tree, BST).
 * 
 * El cÃ³digo fuente estÃ¡ en UTF-8, y la constante 
 * EMPTY_TREE_MARK definida en AbstractTreeADT del
 * proyecto API deberÃ­a ser el sÃ­mbolo de conjunto vacÃ­o: âˆ…
 * 
 * Si aparecen caracteres "raros", es porque
 * el proyecto no estÃ¡ bien configurado en Eclipse para
 * usar esa codificaciÃ³n de caracteres.
 *
 * En el toString() que estÃ¡ ya implementado en AbstractTreeADT
 * se usa el formato:
 * 
 * 		Un Ã¡rbol vacÃ­o se representa como "âˆ…". Un Ã¡rbol no vacÃ­o
 * 		como "{(informaciÃ³n raÃ­z), sub-Ã¡rbol 1, sub-Ã¡rbol 2, ...}".
 * 
 * 		Por ejemplo, {A, {B, âˆ…, âˆ…}, âˆ…} es un Ã¡rbol binario con 
 * 		raÃ­z "A" y un Ãºnico sub-Ã¡rbol, a su izquierda, con raÃ­z "B".
 * 
 * El mÃ©todo render() tambiÃ©n representa un Ã¡rbol, pero con otro
 * formato; por ejemplo, un Ã¡rbol {M, {E, âˆ…, âˆ…}, {S, âˆ…, âˆ…}} se
 * muestra como:
 * 
 * M
 * |  E
 * |  |  âˆ…
 * |  |  âˆ…
 * |  S
 * |  |  âˆ…
 * |  |  âˆ…
 * 
 * Cualquier nodo puede llevar asociados pares (clave,valor) para
 * adjuntar informaciÃ³n extra. Si es el caso, tanto toString() como
 * render() mostrarÃ¡n los pares asociados a cada nodo.
 * 
 * Con {@link #setTag(String, Object)} se inserta un par (clave,valor)
 * y con {@link #getTag(String)} se consulta.
 * 
 * 
 * Con <T extends Comparable<? super T>> se pide que exista un orden en
 * los elementos. Se necesita para poder comparar elementos al insertar.
 * 
 * Si se usara <T extends Comparable<T>> serÃ­a muy restrictivo; en
 * su lugar se permiten tipos que sean comparables no sÃ³lo con exactamente
 * T sino tambiÃ©n con tipos por encima de T en la herencia.
 * 
 * @param <T>
 *            tipo de la informaciÃ³n en cada nodo, comparable.
 */
public class BinarySearchTreeADTImpl<T extends Comparable<? super T>> extends
		AbstractBinaryTreeADT<T> {

	/**
	 * Devuelve el Ã¡rbol binario de bÃºsqueda izquierdo.
	 */
	protected BinarySearchTreeADTImpl<T> getLeftBST() {
		//	El atributo leftSubtree es de tipo AbstractBinaryTreeADT<T> pero
		//	aquÃ­ se sabe que es ademÃ¡s de bÃºsqueda binario
		//
		return (BinarySearchTreeADTImpl<T>) leftSubtree;
	}

	private void setLeftBST(BinarySearchTreeADTImpl<T> left) {
		this.leftSubtree = left;
	}
	
	/**
	 * Devuelve el Ã¡rbol binario de bÃºsqueda derecho.
	 */
	protected BinarySearchTreeADTImpl<T> getRightBST() {
		return (BinarySearchTreeADTImpl<T>) rightSubtree;
	}

	private void setRightBST(BinarySearchTreeADTImpl<T> right) {
		this.rightSubtree = right;
	}
	
	/**
	 * Ã�rbol BST vacÃ­o
	 */
	public BinarySearchTreeADTImpl() {
		
		setContent(null);
		
		setLeftBST(null);
		setRightBST(null);
	}

	private BinarySearchTreeADTImpl<T> emptyBST() {
		return new BinarySearchTreeADTImpl<T>();
	}
	
	/**
	 * Inserta todos los elementos de una colecciÃ³n en el Ã¡rbol.
	 * 
	 * No se permiten elementos null.
	 * 
	 * @param elements
	 *            valores a insertar.
	 */
	public void insert(Collection<T> elements) {
		for(T i: elements) {
			if(i == null) 
				throw new IllegalArgumentException("No se aceptan elementos nulos");
		}
		
		for(T j: elements) {
			insert(j);
		}
		
	}

	/**
	 * Inserta todos los elementos de un array en el Ã¡rbol.
	 * 
	 * No se permiten elementos null.
	 * 
	 * @param elements elementos a insertar.
	 */
	public void insert(T ... elements) {
		for(int i = 0; i < elements.length; i++) {
			if(elements[i] == null)
				throw new IllegalArgumentException("No se aceptan elementos nulos");
		}
		
		for(int i = 0; i < elements.length; i++) {
			insert(elements[i]);
		}
		
	}
	
	/**
	 * Inserta de forma recursiva (como hoja) un nuevo elemento en el Ã¡rbol de bÃºsqueda.
	 * 
	 * No se permiten elementos null. Si el elemento ya existe en el Ã¡rbol NO lo inserta.
	 * 
	 * @param element
	 *            valor a insertar.
	 */
	public void insert(T element) {
		if (element == null) {
			throw new IllegalArgumentException("No se aceptan elementos nulos");
		}
		
		if (this.content == null) {
			this.setContent(element);
			this.setLeftBST(emptyBST());
			this.setRightBST(emptyBST());
		} else if (this.content.compareTo(element) > 0) {
			this.getLeftBST().insert(element);
		} else if (this.content.compareTo(element) < 0) {
			this.getRightBST().insert(element);
		}
	}
	
	
	
	/**
	 * Elimina los elementos de la colecciÃ³n del Ã¡rbol.
	 */
	public void withdraw(Collection<T> elements) {
		for(T i: elements) {
			if(i == null) 
				throw new IllegalArgumentException("No se aceptan elementos nulos");
		}
		
		for(T j: elements) {
			withdraw(elements);
		}
	}

	/**
	 * Elimina los valores en un array del Ã¡rbol.
	 */
	public void withdraw(T ... elements) {
		for(int i = 0; i < elements.length; i++) {
			if(elements[i] == null)
				throw new IllegalArgumentException("No se aceptan elementos nulos");
		}
		
		for(int i = 0; i < elements.length; i++) {
			withdraw(elements[i]);
		}
	}
	
	/**
	 * Elimina un elemento del Ã¡rbol.
	 * 
	 * @throws NoSuchElementException si el elemento a eliminar no estÃ¡ en el Ã¡rbol           
	 */
	public void withdraw(T element) {
		if (element == null) {
			throw new IllegalArgumentException("No se aceptan elementos nulos");
		}
		System.out.println();
		System.out.println();
		System.out.println("El element es:"+ content);
		System.out.println("L: "+this.getLeftBST().content);
		System.out.println("R: "+this.getRightBST().content);
		
		//Para borrar el nodo raiz
		
		if(content.equals(element)) {
			System.out.println("He encontrado el elemento que buscaba");
			System.out.println("C->: "+content);
			System.out.println("E: "+element);
			
			if(isLeaf()) {
				setContent(null);
				setRightBST(null);
				setLeftBST(null);
				
				return;
			}else {
				Collection<T> listaIntroducir = new ArrayList<T>();
				T elemenAnt = content;
				listaIntroducir = recorreGuardaPreOrderRaiz(listaIntroducir, elemenAnt,0);
				System.out.println(listaIntroducir.size());
				setContent(null);
				setRightBST(null);
				setLeftBST(null);
				
				insert(listaIntroducir);
			}
			return;
		}
		
		//Para borrar la rama izquierda
		if(this.getLeftBST().content != null && this.getLeftBST().content.equals(element)) {
			System.out.println("He encontrado el elemento que buscaba");
			System.out.println("C->I: "+ getLeftBST().content);
			System.out.println("E: "+element);
			
			if(getLeftBST().isLeaf()) {
				getLeftBST().setContent(null);
				getLeftBST().setRightBST(null);;
				getLeftBST().setLeftBST(null);
			}else {
				//Hacer una lista de todos los elementos e insertarlos
				Collection<T> listaIntroducir = new ArrayList<T>();
				T elemenAnt = content;
				listaIntroducir = recorreGuardaPreOrderIzquierda(listaIntroducir, elemenAnt,0);
				
				getLeftBST().setContent(null);
				getLeftBST().setRightBST(null);;
				getLeftBST().setLeftBST(null);
				
				insert(listaIntroducir);
			}
			
			return;
		}
		
		//Para borrar la rama derecha
		if(this.getRightBST().content != null && this.getRightBST().content.equals(element)) {
			System.out.println("He encontrado el elemento que buscaba");
			System.out.println("C: "+ content);
			System.out.println("C->D: "+ getRightBST().content);
			System.out.println("E: "+element);
			
			if(getRightBST().isLeaf()) {
				getRightBST().setContent(null);
				getRightBST().setRightBST(null);;
				getRightBST().setLeftBST(null);
			}else {
				//Hacer una lista de todos los elementos e insertarlos
				Collection<T> listaIntroducir = new ArrayList<T>();
				T elemenAnt = content;
				listaIntroducir = recorreGuardaPreOrderDerecha(listaIntroducir, elemenAnt,0);
		
				getRightBST().setContent(null);
				getRightBST().setRightBST(null);;
				getRightBST().setLeftBST(null);
				
				insert(listaIntroducir);
			}
			return;
		}
		
		if (this.content.compareTo(element) > 0) {
			System.out.println("Entra aqui");
			System.out.println("Va a a la izquierda");
			System.out.println(getLeftBST().content);
			this.getLeftBST().withdraw(element);
		}
		else if(this.content.compareTo(element) < 0) {
			System.out.println("Va a a la Derecha");
			System.out.println(getRightBST().content);
			this.getRightBST().withdraw(element);
		}
	}
	
	private Collection<T> recorreGuardaPreOrderIzquierda(Collection<T> listaIntroducir, T elemenAnt, int cont) {
		System.out.println(content);
		if(content != null) {
			if(content.compareTo(elemenAnt) < 0) {
				cont++;
				if(cont > 1) 
				listaIntroducir.add(content);
			}
		}
		if(getLeftBST() != null)
			getLeftBST().recorreGuardaPreOrderIzquierda(listaIntroducir, elemenAnt, cont);
		if(getRightBST() != null) {
			getRightBST().recorreGuardaPreOrderIzquierda(listaIntroducir, elemenAnt, cont);
		}
		System.out.print(listaIntroducir.toString());
		
		return listaIntroducir;
	}

	private Collection<T> recorreGuardaPreOrderDerecha(Collection<T> listaIntroducir, T elemenAnt, int cont) {
		if(content != null) {
			if(content.compareTo(elemenAnt) > 0) {
				cont++;
				if(cont > 1) 
				listaIntroducir.add(content);
			}
		}
		if(getLeftBST() != null)
			getLeftBST().recorreGuardaPreOrderDerecha(listaIntroducir, elemenAnt, cont);
		if(getRightBST() != null) {
			getRightBST().recorreGuardaPreOrderDerecha(listaIntroducir, elemenAnt, cont);
		}
		listaIntroducir.remove(elemenAnt);
		System.out.print(listaIntroducir.toString());
		
		return listaIntroducir;
	}
	
	private Collection<T> recorreGuardaPreOrderRaiz(Collection<T> listaIntroducir, T elemenAnt, int cont) {
		System.out.println(content+"  HOLAAAA");
		if(content != null) {
			System.out.println(content+"FKLJdhfdskljf");
			cont++;
			if(cont > 1) 
				listaIntroducir.add(content);
		}
		if(getLeftBST() != null)
			getLeftBST().recorreGuardaPreOrderRaiz(listaIntroducir, elemenAnt, cont);
		if(getRightBST() != null) {
			getRightBST().recorreGuardaPreOrderRaiz(listaIntroducir, elemenAnt, cont);
		}
		System.out.print(listaIntroducir.toString());
		
		return listaIntroducir;
	}

	/**
	 * Devuelve el sub-Ã¡rbol indicado. (para tests)
	 * path serÃ¡ el camino para obtener el sub-arbol. EstÃ¡ formado por 0 y 1.
	 * Si se codifica "bajar por la izquierda" como "0" y
	 * "bajar por la derecha" como "1", el camino desde un 
	 * nodo N hasta un nodo M (en uno de sus sub-Ã¡rboles) serÃ¡ la
	 * cadena de 0s y 1s que indica cÃ³mo llegar desde N hasta M.
     *
     * Se define tambiÃ©n el camino vacÃ­o desde un nodo N hasta
     * Ã©l mismo, como cadena vacÃ­a.
	 * 
	 * Si el subarbol no existe lanzarÃ¡ la excepciÃ³n NoSuchElementException.
	 * 
	 * @param path
	 * @return
	 * @throws NoSuchElementException si el subarbol no existe
	 */
	public BinarySearchTreeADTImpl<T> getSubtreeWithPath(String path) {
		//TODO implementar el mÃ©todo
		
		return null;
		
	}	
	
	/**
	 * Acumula en orden descendente, una lista con los pares 'padre-hijo' en este Ã¡rbol.
	 * 
	 * Por ejemplo, sea un Ã¡rbol "A":
	 * 
	 * {10, {5, {2, âˆ…, âˆ…}, âˆ…}, {20, âˆ…, {30, âˆ…, âˆ…}}}
	 * 
     * 10
     * |  5
     * |  |  2
     * |  |  |  âˆ…
     * |  |  |  âˆ…
     * |  |  âˆ…
     * |  20
     * |  |  âˆ…
     * |  |  30
     * |  |  |  âˆ…
     * |  |  |  âˆ…
     * 
	 * el resultado serÃ­a una lista de cadenas:
	 * 
	 * 	[(20,30), (10,20), (10,5), (5,2)]
	 * 
	 * y ademÃ¡s quedarÃ­a etiquetado como:
	 * 
	 *  {10 [(descend, 3)], 
	 *       {5 [(descend, 4)], {2 [(descend, 5)], âˆ…, âˆ…}, âˆ…}, 
	 *       {20 [(descend, 2)], âˆ…, {30 [(descend, 1)], âˆ…, âˆ…}}}
	 * 
	 * @param buffer lista con el resultado.
	 */
	public void parentChildPairsTagDescend(List<String> buffer) {
	
		// TODO Implementar el mÃ©todo
	}
		
	
	
	/**
	 * Importante: Solamente se debe recorrer el Ã¡rbol una vez
	 * 
	 * Comprueba si los elementos de la lista coinciden con algÃºn camino desde la raiz.
	 * AdemÃ¡s, si existe algÃºn camino que coincida con los elementos de la lista, los etiqueta en el Ã¡rbol,
	 * numerandolos empezando por la raiz como 1.
	 * 
	 * Por ejemplo, el Ã¡rbol
	 * 
	 * {50, {30, {10, âˆ…, âˆ…}, {40, âˆ…, âˆ…}}, {80, {60, âˆ…, âˆ…}, âˆ…}}
	 * 
	 * si path = [50, 30, 10]
	 * 
	 * devolverÃ­a true y el Ã¡rbol quedarÃ­a asÃ­ etiquetado:
	 * 
	 * {50 [(path, 1)], {30 [(path, 2)], {10 [(path, 3)], âˆ…, âˆ…}, {40, âˆ…, âˆ…}}, {80, {60, âˆ…, âˆ…}, âˆ…}}
	 * 
	 * Para el mismo Ã¡rbol, si path es [50, 40]  devolverÃ­a true y el Ã¡rbol quedarÃ­a asÃ­ etiquetado:
	 * {50 [(path, 1)], {30, {10, âˆ…, âˆ…}, {40 [(path, 2)], âˆ…, âˆ…}}, {80, {60, âˆ…, âˆ…}, âˆ…}}
	 * 
	 * Para el mismo Ã¡rbol, si path es [50, 80]  devolverÃ­a false y el Ã¡rbol no se etiqueta:
	 * {50, {30, {10, âˆ…, âˆ…}, {40, âˆ…, âˆ…}}, {80, {60, âˆ…, âˆ…}, âˆ…}}
	 * 
	 * 
	 * @return  true si los elementos de la lista coinciden con algÃºn camino desde la raiz,  falso si no es asÃ­
	 */
	public boolean isPathIn(List<T> path) {
		//	TODO Implementar mÃ©todo
		return false;
	}

	
	/**
	 * 
	 * Etiqueta cada nodo con su posiciÃ³n en el recorrido en anchura, con la etiqueta "width"
	 * 
	 *  Por ejemplo, el Ã¡rbol
	 * 
	 * {50, {30, {10, âˆ…, âˆ…}, {40, âˆ…, âˆ…}}, {80, {60, âˆ…, âˆ…}, âˆ…}}
	 * 
	 *  queda etiquetado como 
	 * 
	 *   {50 [(width, 1)], 
                 {30 [(width, 2)], {10 [(width, 4)], âˆ…, âˆ…},{40 [(width, 5)], âˆ…, âˆ…}},
                 {80 [(width, 3)], {60 [(width, 6)], âˆ…, âˆ…}, âˆ…}}
	 * 

	 */	
	public void tagWidth(){
		//	TODO Implementar mÃ©todo
	}
	
	
	/**	
	 * Devuelve un iterador que recorre los elementos del arbol en inorden (de menor a mayor)
	 * 
	 * Por ejemplo, con el Ã¡rbol
	 * 
	 * 		{50, {30, {10, âˆ…, âˆ…}, {40, âˆ…, âˆ…}}, {80, {60, âˆ…, âˆ…}, âˆ…}}
	 * 
	 * y devolverÃ­a el iterador que recorrerÃ­a los ndos en el orden: 10, 30, 40, 50, 60, 80
	 * 
	 * 		
	 * 
	 * @return iterador para el recorrido inorden o ascendente
	 */
	public Iterator<T> iteratorInorden() {
		//	TODO Implementar mÃ©todo
		return null;
	}	
	
}

