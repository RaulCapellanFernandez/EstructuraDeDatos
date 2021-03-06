package ule.edi.tree;


import java.nio.charset.CoderMalfunctionError;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

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
	private BinarySearchTreeADTImpl<String> TPruebas1 = null;
	
	private BinarySearchTreeADTImpl<Integer> TV1 = null;

	@Before
	public void setupBSTs() {
		
		TE = new BinarySearchTreeADTImpl<Integer>();
		TPruebas = new BinarySearchTreeADTImpl<Integer>();
		TPruebas1 = new BinarySearchTreeADTImpl<String>();
		
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
	
	@Test
	public void testConstructorInsert() {
		Assert.assertEquals("∅", TPruebas.toString());
		
		TPruebas.insert(10, 5, 4, 13, 3, 1, 17, 11, 10, 15, 20, 7, 19, 21, 14, 12);
		Assert.assertEquals("{10, {5, {4, {3, {1, ∅, ∅}, ∅}, ∅}, {7, ∅, ∅}}, {13, {11, ∅, {12, ∅, ∅}}, {17, {15, {14, ∅, ∅}, ∅}, {20, {19, ∅, ∅}, {21, ∅, ∅}}}}}", TPruebas.toString());
		
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
		Collection<Integer> miColeccion = new ArrayList<Integer>();
		miColeccion.add(1);
		miColeccion.add(2);
		TPruebas.insert(miColeccion);
		
		Assert.assertEquals("{1, ∅, {2, ∅, ∅}}", TPruebas.toString());
		
		TPruebas.withdraw(miColeccion);
		
		Assert.assertEquals("∅", TPruebas.toString());
	}
	@Test
	public void testWithdrawElementElements() {
		Collection<Integer> miColeccion = new ArrayList<Integer>();
		miColeccion.add(1);
		miColeccion.add(2);
		TPruebas.insert(miColeccion);
		
		TPruebas.withdraw(1,2);
		Assert.assertEquals("∅", TPruebas.toString());
	}
	
	@Test
	public void tesIsPath() {
		List<Integer> lista = new ArrayList<Integer>();
		lista.add(50);
		lista.add(30);
		lista.add(10);
		TPruebas.insert(50,30,10,40,80,60,90,100,85,84,87);
		
		Assert.assertEquals(true, TPruebas.isPathIn(lista));
		lista.add(80);
		Assert.assertEquals(false, TPruebas.isPathIn(lista));
		
		Assert.assertEquals("{50 [(Path, 1)], {30 [(Path, 2)], {10 [(Path, 3)], ∅, ∅}, {40, ∅, ∅}}, {80, {60, ∅, ∅}, {90, {85, {84, ∅, ∅}, {87, ∅, ∅}}, {100, ∅, ∅}}}}", TPruebas.toString());
		
	}
	@Test
	public void tesIsPath1() {
		 List<Integer> lista = new ArrayList<Integer>();
		
		 TPruebas.insert(50,30,10,40,80,60,90,100,85,84,87);
		 lista.add(50);
		 lista.add(80);
		 lista.add(90);
		 lista.add(85);
		 lista.add(87);
		 
		 Assert.assertEquals(true, TPruebas.isPathIn(lista));
		 lista = new ArrayList<Integer>();
		 lista.add(90);
		 Assert.assertEquals(false, TPruebas.isPathIn(lista));
		 
		 Assert.assertEquals("{50 [(Path, 1)], {30, {10, ∅, ∅}, {40, ∅, ∅}}, {80 [(Path, 2)], {60, ∅, ∅}, {90 [(Path, 3)], {85 [(Path, 4)], {84, ∅, ∅}, {87 [(Path, 5)], ∅, ∅}}, {100, ∅, ∅}}}}", TPruebas.toString());
	}
	@Test
	public void tesIsPath2() {
		List<Integer> lista = new ArrayList<Integer>();
		TPruebas.insert(50,30,10,40,80,60,90,100,85,84,87);
		
		 lista.add(50);
		 Assert.assertEquals(true, TPruebas.isPathIn(lista));
		 Assert.assertEquals("{50 [(Path, 1)], {30, {10, ∅, ∅}, {40, ∅, ∅}}, {80, {60, ∅, ∅}, {90, {85, {84, ∅, ∅}, {87, ∅, ∅}}, {100, ∅, ∅}}}}", TPruebas.toString());
	}
	@Test
	public void tesIsPath3() {
		List<Integer> lista = new ArrayList<Integer>();
		TPruebas.insert(50,30,10,40,80,60,90,100,85,84,87);
		
		 Assert.assertEquals(true, TPruebas.isPathIn(lista));
		 
		 lista = new ArrayList<Integer>();
		 lista.add(50);
		 lista.add(75);
		 Assert.assertEquals(false, TPruebas.isPathIn(lista));
	}
	@Test
	public void testTagWidth() {
		TPruebas.insert(50,30,10,40,80,60);
		TPruebas.tagWidth();
		
		//Lo he hecho como en los apuntes
		Assert.assertEquals("{50 [(width, 1)], {30 [(width, 2)], {10 [(width, 4)], ∅, ∅}, {40 [(width, 5)], ∅, ∅}}, {80 [(width, 3)], {60 [(width, 6)], ∅, ∅}, ∅}}", TPruebas.toString());
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testInsertException() throws IllegalArgumentException {
		List<String> lista = new ArrayList<String>();
		lista.add(null);
		TPruebas1.insert(lista);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testInsert1Exception() throws IllegalArgumentException {
		List<String> lista = new ArrayList<String>();
		lista.add(null);
		TPruebas1.insert("1",null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testInsert2Exception() throws IllegalArgumentException {
		String nom = null;
		TPruebas1.insert(nom);;
	}
	@Test(expected = IllegalArgumentException.class)
	public void testWithdrawException() throws IllegalArgumentException {
		List<String> lista = new ArrayList<String>();
		lista.add(null);
		TPruebas1.withdraw(lista);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testWithdraw1Exception() throws IllegalArgumentException {
		List<String> lista = new ArrayList<String>();
		lista.add(null);
		TPruebas1.withdraw("1", null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testWithdraw2Exception() throws IllegalArgumentException {
		String nom = null;
		TPruebas1.withdraw(nom);
	}

	
		@Test
		public void testTagDescendTC4() {
			List<String> lista= new LinkedList<String>();
			TC3.parentChildPairsTagDescend(lista);
			Assert.assertEquals(lista.toString(), "[(80, 90), (80, 70), (50, 80), (50, 20), (20, 30), (20, 10)]");
			TC3.filterTags("descend");
			Assert.assertEquals("{50 [(descend, 4)], {20 [(descend, 5)], {10 [(descend, 7)], ∅, ∅}, {30 [(descend, 6)], ∅, ∅}}, {80 [(descend, 2)], {70 [(descend, 3)], ∅, ∅}, {90 [(descend, 1)], ∅, ∅}}}", TC3.toString());
			
		}
		@Test
		public void testGetSubtreeWithPath() {
			String path ="01";
			TPruebas.insert(50,30,10,35,80);

			Assert.assertEquals("{50, {30, ∅, {35, ∅, ∅}}, ∅}", TPruebas.getSubtreeWithPath(path).toString());
			path="";
			Assert.assertEquals("{50, ∅, ∅}", TPruebas.getSubtreeWithPath(path).toString());
		}
		@Test(expected = NoSuchElementException.class)
		public void testGetSubtreePathException() throws NoSuchElementException {
			String path ="01011111";
			TPruebas.insert(50,30,10,35,80);
			TPruebas.getSubtreeWithPath(path);
		}
		@Test(expected = NoSuchElementException.class)
		public void testGetSubtreePathException1() throws NoSuchElementException {
			String path ="1111111";
			TPruebas.insert(50,30,10,35,80);
			TPruebas.getSubtreeWithPath(path);
		}
		/*
		@Test
		public void testIteratorInOrder() {
			TPruebas.insert(50,30,10,80);
			Iterator<Integer> iteratorIn = TPruebas.iteratorInorden();
			
			Assert.assertEquals(true, iteratorIn.hasNext());
			Assert.assertEquals(true, iteratorIn.next());
		}*/
	}


