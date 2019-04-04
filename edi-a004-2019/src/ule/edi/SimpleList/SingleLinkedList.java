package ule.edi.SimpleList;

import java.util.Iterator;

import javax.lang.model.element.Element;

public interface SingleLinkedList<T> extends Iterable<T> {

	/**
	 * Implementar de forma RECURSIVA
	 */
	public void addLast(T element);

}
