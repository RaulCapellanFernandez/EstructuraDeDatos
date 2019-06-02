package ule.edi.tree;


import java.nio.charset.CoderMalfunctionError;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;





public class BinarySearchTreeADTTests {

    /*
	* ∅
    */
	private BinarySearchTreeADTImpl<Integer> TE = null;
	
	/*
	* 1
	* |  ∅
	* |  2
	* |  |  ∅
	* |  |  3
	* |  |  |  ∅
	* |  |  |  4
	* |  |  |  |  ∅
	* |  |  |  |  ∅
    */	
	private BinarySearchTreeADTImpl<Integer> T1234 = null;
	
	/*
	* 4
	* |  3
	* |  |  2
	* |  |  |  1
	* |  |  |  |  ∅
	* |  |  |  |  ∅
	* |  |  |  ∅
	* |  |  ∅
	* |  ∅
    */	
	private BinarySearchTreeADTImpl<Integer> T4321 = null;

	/*
	* 50
	* |  20
	* |  |  10
	* |  |  |  ∅
	* |  |  |  ∅
	* |  |  30
	* |  |  |  ∅
	* |  |  |  ∅
	* |  80
	* |  |  70
	* |  |  |  ∅
	* |  |  |  ∅
	* |  |  90
	* |  |  |  ∅
	* |  |  |  ∅
    */	
	private BinarySearchTreeADTImpl<Integer> TC3 = null;

	/*
	* 10
	* |  5
	* |  |  ∅
	* |  |  ∅
	* |  20
	* |  |  ∅
	* |  |  30
	* |  |  |  ∅
	* |  |  |  ∅
	*/
	private BinarySearchTreeADTImpl<Integer> TEx = null;

	/*
	 * 10
	 * |  5
	 * |  |  ∅
	 * |  |  7
	 * |  |  |  6
	 * |  |  |  |  ∅
	 * |  |  |  |  ∅
	 * |  |  |  ∅
	 * |  15
	 * |  |  ∅
	 * |  |  ∅
	 * 
	 */
	
	private BinarySearchTreeADTImpl<Integer> TPruebas = null;
	
	private BinarySearchTreeADTImpl<Integer> TV1 = null;

	@Before
	public void setupBSTs() {
		
		TE = new BinarySearchTreeADTImpl<Integer>();
		TPruebas = new BinarySearchTreeADTImpl<Integer>();
		
		T1234 = new BinarySearchTreeADTImpl<Integer>();
		T1234.insert(1,2,3,4);
		Assert.assertEquals(T1234.toString(), "{1, ∅, {2, ∅, {3, ∅, {4, ∅, ∅}}}}");
		
		T4321 = new BinarySearchTreeADTImpl<Integer>();
		T4321.insert(4, 3, 2, 1);
		Assert.assertEquals(T4321.toString(), "{4, {3, {2, {1, ∅, ∅}, ∅}, ∅}, ∅}");
		
		TC3 = new BinarySearchTreeADTImpl<Integer>();
		TC3.insert(50, 20, 80, 10, 30, 70, 90);
		Assert.assertEquals(TC3.toString(), "{50, {20, {10, ∅, ∅}, {30, ∅, ∅}}, {80, {70, ∅, ∅}, {90, ∅, ∅}}}");
		
		TEx = new BinarySearchTreeADTImpl<Integer>();
		TEx.insert(10, 20, 30, 5);
		Assert.assertEquals(TEx.toString(), "{10, {5, ∅, ∅}, {20, ∅, {30, ∅, ∅}}}");
		
		TV1 = new BinarySearchTreeADTImpl<Integer>();
		TV1.insert(10, 5, 7, 6, 15);		
		Assert.assertEquals(TV1.toString(), "{10, {5, ∅, {7, {6, ∅, ∅}, ∅}}, {15, ∅, ∅}}");
		
		
	}
	/*
	@Test
	public void testConstructorInsert() {
		Assert.assertEquals("∅", TPruebas.toString());
		
		TPruebas.insert(10, 5, 4, 13, 3, 1, 17, 11, 10, 15, 20, 7, 19, 21, 14, 12);
		Assert.assertEquals("{10, {5, {4, {3, {1, ∅, ∅}, ∅}, ∅}, {7, ∅, ∅}}, {13, {11, ∅, {12, ∅, ∅}}, {17, {15, {14, ∅, ∅}, ∅}, {20, {19, ∅, ∅}, {21, ∅, ∅}}}}}", TPruebas.toString());
		System.out.println(TPruebas.toString());
		
		TPruebas.withdraw(14);
	}
	
	@Test
	public void testConstructorCollection() {
		List<Integer> miColeccion = new ArrayList<Integer>();
		miColeccion.add(1);
		miColeccion.add(2);
		TPruebas.insert(miColeccion);
		
		Assert.assertEquals("{1, ∅, {2, ∅, ∅}}", TPruebas.toString());
	}
	*/
	@Test
	public void testWithdrawElement() {
		TPruebas.insert(3);
		TPruebas.insert(2);
		TPruebas.insert(4);
		Assert.assertEquals("{3, {2, ∅, ∅}, {4, ∅, ∅}}", TPruebas.toString());
		
		//Para hojas por la derecha
		TPruebas.withdraw(4);
		Assert.assertEquals("{3, {2, ∅, ∅}, ∅}", TPruebas.toString());
		
		//Para hojas por la izquierda
		TPruebas.withdraw(2);
		Assert.assertEquals("{3, ∅, ∅}", TPruebas.toString());
		
		//Para ramas por la derecha
		TPruebas.insert(25);
		TPruebas.insert(24);
		TPruebas.insert(30);
		TPruebas.insert(20);
		TPruebas.insert(19);
		
		TPruebas.withdraw(25);
		Assert.assertEquals("{3, ∅, {24, {20, {19, ∅, ∅}, ∅}, {30, ∅, ∅}}}", TPruebas.toString());
		TPruebas.withdraw(20);
		TPruebas.withdraw(30);
		Assert.assertEquals("{3, ∅, {24, {19, ∅, ∅}, ∅}}", TPruebas.toString());
		TPruebas.withdraw(3);
		Assert.assertEquals("{24, {19, ∅, ∅}, ∅}", TPruebas.toString());
		TPruebas.withdraw(24);
		Assert.assertEquals("{19, ∅, ∅}", TPruebas.toString());
		TPruebas.withdraw(19);
		Assert.assertEquals("∅", TPruebas.toString());
		
		
		//Para ramas por izquierdas
		TPruebas.insert(30);
		TPruebas.insert(2);
		TPruebas.insert(4);
		TPruebas.insert(5);
		TPruebas.insert(6);
		
		Assert.assertEquals("{30, {2, ∅, {4, ∅, {5, ∅, {6, ∅, ∅}}}}, ∅}", TPruebas.toString());
		TPruebas.withdraw(4);
		Assert.assertEquals("{30, {2, ∅, {5, ∅, {6, ∅, ∅}}}, ∅}", TPruebas.toString());
		TPruebas.withdraw(5);
		Assert.assertEquals("{30, {2, ∅, {6, ∅, ∅}}, ∅}", TPruebas.toString());
		TPruebas.insert(31);
		TPruebas.withdraw(30);
		Assert.assertEquals("{2, ∅, {6, ∅, {31, ∅, ∅}}}", TPruebas.toString());
		TPruebas.withdraw(6);
		Assert.assertEquals("{2, ∅, {31, ∅, ∅}}", TPruebas.toString());
		TPruebas.withdraw(31);
		TPruebas.insert(1);
		TPruebas.withdraw(2);
		Assert.assertEquals("{1, ∅, ∅}", TPruebas.toString());
		TPruebas.withdraw(1);
		Assert.assertEquals("∅", TPruebas.toString());
	}
	
	@Test
	public void testWithdrawElementCollection() {
		TPruebas.insert(3);
		TPruebas.insert(2);
		TPruebas.insert(4);
		
		List<Integer> miColeccion = new ArrayList<Integer>();
		miColeccion.add(3);
		miColeccion.add(4);
		
		TPruebas.withdraw(miColeccion);
		
		Assert.assertEquals("∅", TPruebas.toString());
	}
	
	/*
	 * 
	@Test(expected = IllegalArgumentException.class)
	public void testRemoveLastEmptyException() throws IllegalArgumentException {
		
		TPruebas.insert();
	}*/

	/*
		@Test
		public void testTagDescendTC4() {
			List<String> lista= new LinkedList<String>();
			TC3.parentChildPairsTagDescend(lista);
			Assert.assertEquals(lista.toString(), "[(80, 90), (80, 70), (50, 80), (50, 20), (20, 30), (20, 10)]");
			TC3.filterTags("descend");
			Assert.assertEquals("{50 [(descend, 4)], {20 [(descend, 6)], {10 [(descend, 7)], ∅, ∅}, {30 [(descend, 5)], ∅, ∅}}, {80 [(descend, 2)], {70 [(descend, 3)], ∅, ∅}, {90 [(descend, 1)], ∅, ∅}}}", TC3.toString());
			
		}
	*/
	}


