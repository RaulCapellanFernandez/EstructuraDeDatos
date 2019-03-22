package ule.edi.doubleList;



import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.*;


public class DoubleLinkedListImplTests {

	private DoubleLinkedListImpl<String> ls;
	private DoubleLinkedListImpl<String> li;
	private DoubleLinkedListImpl<String> li1;
	private DoubleLinkedListImpl<String> lSABC;
	private DoubleLinkedListImpl<String> lSABCDE;


	@Before
	public void setup() {
		this.ls = new DoubleLinkedListImpl<String>();
		this.li = new DoubleLinkedListImpl<String>();
		this.li1 = new DoubleLinkedListImpl<String>();
	    //this.lSABC=new DoubleLinkedListImpl<String>("A", "B", "C");
	    //this.lSABCDE=new DoubleLinkedListImpl<String>("A", "B", "C", "D", "E");
	}
	
	@Test
	public void testIsEmpty() {
		Assert.assertEquals(true, ls.isEmpty());
		ls.addFirst("1");
		Assert.assertEquals(false, ls.isEmpty());
	}
	@Test
	public void testAddFirst() {
		Assert.assertEquals("[]", ls.toString());
		ls.addFirst("1");
		Assert.assertEquals(false, ls.isEmpty());
		Assert.assertEquals("[1]", ls.toString());
		ls.addFirst("2");
		Assert.assertEquals("[2, 1]", ls.toString());
		ls.addFirst("3");
		Assert.assertEquals("[3, 2, 1]", ls.toString());
		ls.addFirst("4");
		Assert.assertEquals("[4, 3, 2, 1]", ls.toString());
		ls.addFirst("5");
		Assert.assertEquals("[5, 4, 3, 2, 1]", ls.toString());
	}
	@Test
	public void testAddLast() {
		Assert.assertEquals("[]", ls.toString());
		ls.addLast("1");
		Assert.assertEquals(false, ls.isEmpty());
		Assert.assertEquals("[1]", ls.toString());
		ls.addLast("2");
		Assert.assertEquals("[1, 2]", ls.toString());
		ls.addLast("3");
		Assert.assertEquals("[1, 2, 3]", ls.toString());
		ls.addLast("4");
		Assert.assertEquals("[1, 2, 3, 4]", ls.toString());
		ls.addLast("5");
		Assert.assertEquals("[1, 2, 3, 4, 5]", ls.toString());
	}
	@Test
	public void testAddAtPos() {
		Assert.assertEquals("[]", ls.toString());
		ls.addAtPos("1", 5);
		Assert.assertEquals(false, ls.isEmpty());
		Assert.assertEquals("[1]", ls.toString());
		ls.addAtPos("2", 1);
		Assert.assertEquals("[2, 1]", ls.toString());
		ls.addAtPos("3", 2);
		Assert.assertEquals("[2, 3, 1]", ls.toString());
		ls.addAtPos("4", 3);
		Assert.assertEquals("[2, 3, 4, 1]", ls.toString());
		ls.addAtPos("5", 20);
		Assert.assertEquals("[2, 3, 4, 1, 5]", ls.toString());
		ls.addAtPos("6", 6);
		Assert.assertEquals("[2, 3, 4, 1, 5, 6]", ls.toString());
	}
	@Test
	public void testGetElement() {
		ls.addFirst("7");
		ls.addFirst("6");
		ls.addFirst("5");
		ls.addFirst("4");
		ls.addFirst("3");
		ls.addFirst("2");
		ls.addFirst("1");
		Assert.assertEquals("2", ls.getElem(2));
		Assert.assertEquals("5", ls.getElem(5));
		Assert.assertEquals("7", ls.getElem(7));
		Assert.assertEquals("1", ls.getElem(1));
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetElementPinvalid() throws IndexOutOfBoundsException {
		ls.getElem(-1);
		
	}
	
	@Test
	public void testSetElement() {
		ls.addFirst("7");
		ls.addFirst("6");
		ls.addFirst("5");
		ls.addFirst("4");
		ls.addFirst("3");
		ls.addFirst("2");
		ls.addFirst("1");
		
		ls.setElem("1.1", 3);
		ls.setElem("1.2", 5);
		ls.setElem("1.3", 7);
		ls.setElem("1.4", 1);
		
		Assert.assertEquals("[1.4, 2, 1.1, 4, 1.2, 6, 1.3]", ls.toString());
		
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testSetElementPinvalid() throws IndexOutOfBoundsException {
		ls.setElem("2", 8);
		
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testSetElementPinvalid1() throws IndexOutOfBoundsException {
		ls.setElem("2", -1);
		
	}
	
	
	@Test
	public void testAddNTimes() {
		Assert.assertEquals("[]", ls.toString());
		ls.addAtPos("3", 4);
		ls.addNTimes("1", 5);
		Assert.assertEquals("[3, 1, 1, 1, 1, 1]", ls.toString());
	}
	
	@Test
	public void testSize(){
		Assert.assertEquals(0, ls.size());
		ls.addLast("4");
		Assert.assertEquals(1, ls.size());
		ls.addLast("4");
		Assert.assertEquals(2, ls.size());
	}
	@Test
	public void testIdexOf() {
		ls.addFirst("7");
		ls.addFirst("6");
		ls.addFirst("5");
		ls.addFirst("4");
		ls.addFirst("3");
		ls.addFirst("2");
		ls.addFirst("1");
		
		Assert.assertEquals(2, ls.indexOf("2"));
		Assert.assertEquals(1, ls.indexOf("1"));
		Assert.assertEquals(7, ls.indexOf("7"));
	}
	@Test(expected = NoSuchElementException.class)
	public void testIndexOfNO() throws NoSuchElementException {
		ls.addFirst("7");
		ls.addFirst("6");
		ls.addFirst("5");
		ls.addFirst("4");
		
		ls.indexOf("8");		
	}
	@Test
	public void testIdexOfElement() {
		ls.addFirst("7");
		ls.addFirst("6");
		ls.addFirst("5");
		ls.addFirst("4");
		ls.addFirst("3");
		ls.addFirst("2");
		ls.addFirst("1");
		
		Assert.assertEquals(2, ls.indexOf("2",2));
		Assert.assertEquals(1, ls.indexOf("1",1));
		Assert.assertEquals(7, ls.indexOf("7",7));
	}
	@Test(expected = NoSuchElementException.class)
	public void testIndexOfNO1() throws NoSuchElementException {
		ls.addFirst("7");
		ls.addFirst("6");
		ls.addFirst("5");
		ls.addFirst("4");
		
		ls.indexOf("4",2);		
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testIndexOfNO2() throws IndexOutOfBoundsException {
		ls.addFirst("7");
		ls.addFirst("6");
		ls.addFirst("5");
		ls.addFirst("4");
		
		ls.indexOf("12",23);		
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testIdexOfNo3() throws IndexOutOfBoundsException {
		ls.indexOf("2", 8);
		
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testIdexOfNo4() throws IndexOutOfBoundsException {
		ls.indexOf("2", -1);
		
	}
	@Test
	public void testRemoveFirst() throws EmptyCollectionException {
		ls.addFirst("4");
		ls.addFirst("2");
		ls.addFirst("3");
		ls.addFirst("4");
		ls.addFirst("5");
		ls.addFirst("1");
		ls.addFirst("2");
		
		
		ls.removeFirst("1");
		
		//System.out.println(ls.toString());
	}
	@Test(expected = EmptyCollectionException.class)
	public void testRemoveFirstExc() throws EmptyCollectionException {
		ls.removeFirst("1");
		
	}
	@Test(expected = NoSuchElementException.class)
	public void testRemoveFirstExc1() throws NoSuchElementException, EmptyCollectionException {
		ls.addFirst("4");
		ls.addFirst("2");
		ls.addFirst("3");
		ls.addFirst("4");
		ls.addFirst("5");
		ls.addFirst("1");
		ls.addFirst("2");
		
		ls.removeFirst("12");
	}
	
	@Test
	public void testRemoveAll() throws EmptyCollectionException {
		ls.addFirst("1");
		ls.addFirst("3");
		ls.addFirst("1");
		ls.addFirst("3");
		ls.addFirst("1");
		ls.addFirst("5");
		ls.addFirst("1");
		ls.addFirst("1");
		Assert.assertEquals("[1, 1, 5, 1, 3, 1, 3, 1]", ls.toString());
		Assert.assertEquals("1", ls.removeAll("1"));
		Assert.assertEquals("[5, 3, 3]", ls.toString());
	}
	@Test(expected = EmptyCollectionException.class)
	public void testRemoveAllExc() throws EmptyCollectionException {
		ls.removeAll("1");
		
	}
	@Test(expected = NoSuchElementException.class)
	public void testRemoveAllExc1() throws NoSuchElementException, EmptyCollectionException {
		ls.addFirst("4");
		ls.addFirst("2");
		ls.addFirst("3");
		ls.addFirst("4");
		ls.addFirst("5");
		ls.addFirst("1");
		ls.addFirst("2");
		
		ls.removeAll("12");
	}
	
	@Test
	public void testRemoveLast() throws EmptyCollectionException {
		ls.addFirst("4");
		ls.addFirst("2");
		ls.addFirst("3");
		ls.addFirst("4");
		ls.addFirst("5");
		ls.addFirst("1");
		ls.addFirst("2");
		
		Assert.assertEquals("[2, 1, 5, 4, 3, 2, 4]", ls.toString());
		Assert.assertEquals("4", ls.removeLast());
		Assert.assertEquals("[2, 1, 5, 4, 3, 2]", ls.toString());
		ls.removeLast();
		ls.removeLast();
		Assert.assertEquals("4", ls.removeLast());
		Assert.assertEquals("[2, 1, 5]", ls.toString());
		ls.removeLast();
		ls.removeLast();
		Assert.assertEquals("2", ls.removeLast());
	}
	@Test(expected = EmptyCollectionException.class)
	public void testRemoveLastExc() throws EmptyCollectionException {
		ls.removeLast();
		
	}
	@Test
	public void testReverse() {
		ls.addFirst("4");
		ls.addFirst("2");
		ls.addFirst("3");
		ls.addFirst("4");
		ls.addFirst("5");
		ls.addFirst("1");
		ls.addFirst("2");
		Assert.assertEquals("[2, 1, 5, 4, 3, 2, 4]", ls.toString());
		ls.reverse();
		Assert.assertEquals("[4, 2, 3, 4, 5, 1, 2]", ls.toString());
	}
	@Test
	public void testForeward() {
		Iterator<String> iteratorE = ls.iterator();
		Assert.assertEquals(false, iteratorE.hasNext());
		
		ls.addFirst("4");
		ls.addFirst("2");
		ls.addFirst("3");
		Iterator<String> iteratorF = ls.iterator();
		Assert.assertEquals(true, iteratorF.hasNext());
		Assert.assertEquals(true, iteratorF.hasNext());
		Assert.assertEquals(true, iteratorF.hasNext());
		Assert.assertEquals("3", iteratorF.next());
		Assert.assertEquals(true, iteratorF.hasNext());
		Assert.assertEquals("2", iteratorF.next());
		Assert.assertEquals(true, iteratorF.hasNext());
		Assert.assertEquals("4", iteratorF.next());
		Assert.assertEquals(false, iteratorF.hasNext());
		Assert.assertEquals(false, iteratorF.hasNext());
		Assert.assertEquals(false, iteratorF.hasNext());
		Assert.assertEquals("4", iteratorF.next());
		
	}
	@Test
	public void testInterlace() {
		ls.interlace(li);
		Assert.assertEquals("[]", ls.toString());
		
		ls.addFirst("1");
		ls.addFirst("1");
		ls.addFirst("1");
		ls.addFirst("1");
		ls.addFirst("1");
		ls.addFirst("1");
		ls.addFirst("1");
		ls.addFirst("1");
		ls.addFirst("1");
		ls.addFirst("1");
		Assert.assertEquals("[1, 1, 1, 1, 1, 1, 1, 1, 1, 1]", ls.toString());
		
		li.addFirst("2");
		li.addFirst("2");
		li.addFirst("2");
		li.addFirst("2");
		li.addFirst("2");
		li.addFirst("2");
		li.addFirst("2");
		Assert.assertEquals("[2, 2, 2, 2, 2, 2, 2]", li.toString());
		
		
		ls.interlace(li);
		Assert.assertEquals("[1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 1, 1]", ls.toString());
		
	}
	@Test
	public void testSubList() {
		
		ls.addFirst("7");
		ls.addFirst("6");
		ls.addFirst("5");
		ls.addFirst("4");
		ls.addFirst("3");
		ls.addFirst("2");
		ls.addFirst("1");
		
		li.addFirst("7");
		li.addFirst("5");
		li.addFirst("4");
		li.addFirst("2");
		
		Assert.assertEquals(-1, ls.isSubList(li));
		
		Assert.assertEquals(1, ls.isSubList(li1));
		
		li1.addFirst("7");
		li1.addFirst("6");
		li1.addFirst("5");
		li1.addFirst("4");
		
		Assert.assertEquals(4, ls.isSubList(li1));
	}
	/*@Test
	public void testToStringVacio(){
		Assert.assertEquals(lS.toString(),"[]");		
	}
	
	@Test
	public void testToStringNoVacio(){
		Assert.assertEquals(lSABC.toString(),"[A, B, C]");		
	}
	
	@Test
	public void testConstructorConLista(){
		DoubleLinkedListImpl<String> nueva= new DoubleLinkedListImpl<String>(lSABCDE);
		Assert.assertEquals("[A, B, C, D, E]", nueva.toString());
	}
	
	@Test
	public void testForwardIt() {
		lS = new DoubleLinkedListImpl<String>("A", "B", "C", "D");
		Iterator<String> i = lS.iterator();
		Assert.assertTrue(i.hasNext());
		Assert.assertEquals("A", i.next());
		Assert.assertTrue(i.hasNext());
		Assert.assertEquals("B", i.next());
		Assert.assertTrue(i.hasNext());
		Assert.assertEquals("C", i.next());
		Assert.assertTrue(i.hasNext());
		Assert.assertEquals("D", i.next());
		Assert.assertFalse(i.hasNext());
	    Assert.assertEquals("[A, B, C, D]", lS.toString());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testForwardItException() {
		Iterator<String> i = lS.iterator();
		Assert.assertFalse(i.hasNext());
		i.next();
	}
	
	@Test
	public void testOddAndEvenIt() {
		lS = new DoubleLinkedListImpl<>("A", "B", "C", "D", "E");
		Iterator<String> i = lS.oddAndEvenIterator();
		Assert.assertTrue(i.hasNext());
		Assert.assertEquals("B", i.next());
		Assert.assertTrue(i.hasNext());
		Assert.assertEquals("D", i.next());
		Assert.assertTrue(i.hasNext());
		Assert.assertEquals("A", i.next());
		Assert.assertTrue(i.hasNext());
		Assert.assertEquals("C", i.next());
		Assert.assertTrue(i.hasNext());
		Assert.assertEquals("E", i.next());
		Assert.assertFalse(i.hasNext());
	    Assert.assertEquals("[A, B, C, D, E]", lS.toString());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testOddAndEvenException() {
		Iterator<String> i = lS.oddAndEvenIterator();
		Assert.assertFalse(i.hasNext());
		i.next();
	}*/
}
