package ule.edi.doubleList;



import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.*;


public class DoubleLinkedListImplTests {

	private DoubleLinkedListImpl<String> lS;
	private DoubleLinkedListImpl<String> li;
	private DoubleLinkedListImpl<String> li1;
	private DoubleLinkedListImpl<String> lSABC;
	private DoubleLinkedListImpl<String> lSABCDE;


	@Before
	public void setup() {
		this.lS = new DoubleLinkedListImpl<String>();
		this.li = new DoubleLinkedListImpl<String>();
		this.li1 = new DoubleLinkedListImpl<String>();
	    this.lSABC=new DoubleLinkedListImpl<String>("A", "B", "C");
	    this.lSABCDE=new DoubleLinkedListImpl<String>("A", "B", "C", "D", "E");
	}
	
	@Test
	public void testIsEmpty() {
		Assert.assertEquals(true, lS.isEmpty());
		lS.addFirst("1");
		Assert.assertEquals(false, lS.isEmpty());
	}
	@Test
	public void testAddFirst() {
		Assert.assertEquals("[]", lS.toString());
		lS.addFirst("1");
		Assert.assertEquals(false, lS.isEmpty());
		Assert.assertEquals("[1]", lS.toString());
		lS.addFirst("2");
		Assert.assertEquals("[2, 1]", lS.toString());
		lS.addFirst("3");
		Assert.assertEquals("[3, 2, 1]", lS.toString());
		lS.addFirst("4");
		Assert.assertEquals("[4, 3, 2, 1]", lS.toString());
		lS.addFirst("5");
		Assert.assertEquals("[5, 4, 3, 2, 1]", lS.toString());
	}
	@Test
	public void testAddLast() {
		Assert.assertEquals("[]", lS.toString());
		lS.addLast("1");
		Assert.assertEquals(false, lS.isEmpty());
		Assert.assertEquals("[1]", lS.toString());
		lS.addLast("2");
		Assert.assertEquals("[1, 2]", lS.toString());
		lS.addLast("3");
		Assert.assertEquals("[1, 2, 3]", lS.toString());
		lS.addLast("4");
		Assert.assertEquals("[1, 2, 3, 4]", lS.toString());
		lS.addLast("5");
		Assert.assertEquals("[1, 2, 3, 4, 5]", lS.toString());
	}
	@Test
	public void testAddAtPos() {
		Assert.assertEquals("[]", lS.toString());
		lS.addAtPos("1", 5);
		Assert.assertEquals(false, lS.isEmpty());
		Assert.assertEquals("[1]", lS.toString());
		lS.addAtPos("2", 1);
		Assert.assertEquals("[2, 1]", lS.toString());
		lS.addAtPos("3", 2);
		Assert.assertEquals("[2, 3, 1]", lS.toString());
		lS.addAtPos("4", 3);
		Assert.assertEquals("[2, 3, 4, 1]", lS.toString());
		lS.addAtPos("5", 20);
		Assert.assertEquals("[2, 3, 4, 1, 5]", lS.toString());
		lS.addAtPos("6", 6);
		Assert.assertEquals("[2, 3, 4, 1, 5, 6]", lS.toString());
	}
	@Test
	public void testGetElement() {
		lS.addFirst("7");
		lS.addFirst("6");
		lS.addFirst("5");
		lS.addFirst("4");
		lS.addFirst("3");
		lS.addFirst("2");
		lS.addFirst("1");
		Assert.assertEquals("2", lS.getElem(2));
		Assert.assertEquals("5", lS.getElem(5));
		Assert.assertEquals("7", lS.getElem(7));
		Assert.assertEquals("1", lS.getElem(1));
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetElementPinvalid() throws IndexOutOfBoundsException {
		lS.getElem(-1);
		
	}
	
	@Test
	public void testSetElement() {
		lS.addFirst("7");
		lS.addFirst("6");
		lS.addFirst("5");
		lS.addFirst("4");
		lS.addFirst("3");
		lS.addFirst("2");
		lS.addFirst("1");
		
		lS.setElem("1.1", 3);
		lS.setElem("1.2", 5);
		lS.setElem("1.3", 7);
		lS.setElem("1.4", 1);
		
		Assert.assertEquals("[1.4, 2, 1.1, 4, 1.2, 6, 1.3]", lS.toString());
		
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testSetElementPinvalid() throws IndexOutOfBoundsException {
		lS.setElem("2", 8);
		
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testSetElementPinvalid1() throws IndexOutOfBoundsException {
		lS.setElem("2", -1);
		
	}
	
	
	@Test
	public void testAddNTimes() {
		Assert.assertEquals("[]", lS.toString());
		lS.addAtPos("3", 4);
		lS.addNTimes("1", 5);
		Assert.assertEquals("[3, 1, 1, 1, 1, 1]", lS.toString());
	}
	
	@Test
	public void testSize(){
		Assert.assertEquals(0, lS.size());
		lS.addLast("4");
		Assert.assertEquals(1, lS.size());
		lS.addLast("4");
		Assert.assertEquals(2, lS.size());
	}
	@Test
	public void testIdexOf() {
		lS.addFirst("7");
		lS.addFirst("6");
		lS.addFirst("5");
		lS.addFirst("4");
		lS.addFirst("3");
		lS.addFirst("2");
		lS.addFirst("1");
		
		Assert.assertEquals(2, lS.indexOf("2"));
		Assert.assertEquals(1, lS.indexOf("1"));
		Assert.assertEquals(7, lS.indexOf("7"));
	}
	@Test(expected = NoSuchElementException.class)
	public void testIndexOfNO() throws NoSuchElementException {
		lS.addFirst("7");
		lS.addFirst("6");
		lS.addFirst("5");
		lS.addFirst("4");
		
		lS.indexOf("8");		
	}
	@Test
	public void testIdexOfElement() {
		lS.addFirst("7");
		lS.addFirst("6");
		lS.addFirst("5");
		lS.addFirst("4");
		lS.addFirst("3");
		lS.addFirst("2");
		lS.addFirst("1");
		
		Assert.assertEquals(2, lS.indexOf("2",2));
		Assert.assertEquals(1, lS.indexOf("1",1));
		Assert.assertEquals(7, lS.indexOf("7",7));
	}
	@Test(expected = NoSuchElementException.class)
	public void testIndexOfNO1() throws NoSuchElementException {
		lS.addFirst("7");
		lS.addFirst("6");
		lS.addFirst("5");
		lS.addFirst("4");
		
		lS.indexOf("4",2);		
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testIndexOfNO2() throws IndexOutOfBoundsException {
		lS.addFirst("7");
		lS.addFirst("6");
		lS.addFirst("5");
		lS.addFirst("4");
		
		lS.indexOf("12",23);		
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testIdexOfNo3() throws IndexOutOfBoundsException {
		lS.indexOf("2", 8);
		
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testIdexOfNo4() throws IndexOutOfBoundsException {
		lS.indexOf("2", -1);
		
	}
	@Test
	public void testRemoveFirst() throws EmptyCollectionException {
		lS.addFirst("4");
		lS.addFirst("2");
		lS.addFirst("3");
		lS.addFirst("4");
		lS.addFirst("5");
		lS.addFirst("1");
		lS.addFirst("2");
		
		
		lS.removeFirst("1");
		
		//System.out.println(lS.toString());
	}
	@Test(expected = EmptyCollectionException.class)
	public void testRemoveFirstExc() throws EmptyCollectionException {
		lS.removeFirst("1");
		
	}
	@Test(expected = NoSuchElementException.class)
	public void testRemoveFirstExc1() throws NoSuchElementException, EmptyCollectionException {
		lS.addFirst("4");
		lS.addFirst("2");
		lS.addFirst("3");
		lS.addFirst("4");
		lS.addFirst("5");
		lS.addFirst("1");
		lS.addFirst("2");
		
		lS.removeFirst("12");
	}
	
	@Test
	public void testRemoveAll() throws EmptyCollectionException {
		lS.addFirst("1");
		lS.addFirst("3");
		lS.addFirst("1");
		lS.addFirst("3");
		lS.addFirst("1");
		lS.addFirst("5");
		lS.addFirst("1");
		lS.addFirst("1");
		Assert.assertEquals("[1, 1, 5, 1, 3, 1, 3, 1]", lS.toString());
		Assert.assertEquals("1", lS.removeAll("1"));
		Assert.assertEquals("[5, 3, 3]", lS.toString());
	}
	@Test(expected = EmptyCollectionException.class)
	public void testRemoveAllExc() throws EmptyCollectionException {
		lS.removeAll("1");
		
	}
	@Test(expected = NoSuchElementException.class)
	public void testRemoveAllExc1() throws NoSuchElementException, EmptyCollectionException {
		lS.addFirst("4");
		lS.addFirst("2");
		lS.addFirst("3");
		lS.addFirst("4");
		lS.addFirst("5");
		lS.addFirst("1");
		lS.addFirst("2");
		
		lS.removeAll("12");
	}
	
	@Test
	public void testRemoveLast() throws EmptyCollectionException {
		lS.addFirst("4");
		lS.addFirst("2");
		lS.addFirst("3");
		lS.addFirst("4");
		lS.addFirst("5");
		lS.addFirst("1");
		lS.addFirst("2");
		
		Assert.assertEquals("[2, 1, 5, 4, 3, 2, 4]", lS.toString());
		Assert.assertEquals("4", lS.removeLast());
		Assert.assertEquals("[2, 1, 5, 4, 3, 2]", lS.toString());
		lS.removeLast();
		lS.removeLast();
		Assert.assertEquals("4", lS.removeLast());
		Assert.assertEquals("[2, 1, 5]", lS.toString());
		lS.removeLast();
		lS.removeLast();
		Assert.assertEquals("2", lS.removeLast());
	}
	@Test(expected = EmptyCollectionException.class)
	public void testRemoveLastExc() throws EmptyCollectionException {
		lS.removeLast();
		
	}
	@Test
	public void testReverse() {
		lS.addFirst("4");
		lS.addFirst("2");
		lS.addFirst("3");
		lS.addFirst("4");
		lS.addFirst("5");
		lS.addFirst("1");
		lS.addFirst("2");
		Assert.assertEquals("[2, 1, 5, 4, 3, 2, 4]", lS.toString());
		lS.reverse();
		Assert.assertEquals("[4, 2, 3, 4, 5, 1, 2]", lS.toString());
	}
	@Test
	public void testInterlace() {
		lS.interlace(li);
		Assert.assertEquals("[]", lS.toString());
		
		lS.addFirst("1");
		lS.addFirst("1");
		lS.addFirst("1");
		lS.addFirst("1");
		lS.addFirst("1");
		lS.addFirst("1");
		lS.addFirst("1");
		lS.addFirst("1");
		lS.addFirst("1");
		lS.addFirst("1");
		Assert.assertEquals("[1, 1, 1, 1, 1, 1, 1, 1, 1, 1]", lS.toString());
		
		li.addFirst("2");
		li.addFirst("2");
		li.addFirst("2");
		li.addFirst("2");
		li.addFirst("2");
		li.addFirst("2");
		li.addFirst("2");
		Assert.assertEquals("[2, 2, 2, 2, 2, 2, 2]", li.toString());
		
		
		lS.interlace(li);
		Assert.assertEquals("[1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 1, 1]", lS.toString());
		
	}
	@Test
	public void testSubList() {
		
		lS.addFirst("7");
		lS.addFirst("6");
		lS.addFirst("5");
		lS.addFirst("4");
		lS.addFirst("3");
		lS.addFirst("2");
		lS.addFirst("1");
		
		li.addFirst("7");
		li.addFirst("5");
		li.addFirst("4");
		li.addFirst("2");
		
		Assert.assertEquals(-1, lS.isSubList(li));
		
		Assert.assertEquals(1, lS.isSubList(li1));
		
		li1.addFirst("7");
		li1.addFirst("6");
		li1.addFirst("5");
		li1.addFirst("4");
		
		Assert.assertEquals(4, lS.isSubList(li1));
	}
	@Test
	public void testForewardIterator() {
		Iterator<String> iteratorE = lS.iterator();
		Assert.assertEquals(false, iteratorE.hasNext());
		
		lS.addFirst("4");
		lS.addFirst("2");
		lS.addFirst("3");
		Iterator<String> iteratorF = lS.iterator();
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
		
	}
	@Test
	public void testReverseIterator() {
		Iterator<String> iteratorE = lS.reverseIterator();
		Assert.assertEquals(false, iteratorE.hasNext());
		
		lS.addFirst("4");
		lS.addFirst("2");
		lS.addFirst("3");
		Iterator<String> iteratorF = lS.reverseIterator();
		Assert.assertEquals(true, iteratorF.hasNext());
		Assert.assertEquals(true, iteratorF.hasNext());
		Assert.assertEquals(true, iteratorF.hasNext());
		Assert.assertEquals("4", iteratorF.next());
		Assert.assertEquals(true, iteratorF.hasNext());
		Assert.assertEquals("2", iteratorF.next());
		Assert.assertEquals(true, iteratorF.hasNext());
		Assert.assertEquals("3", iteratorF.next());
		Assert.assertEquals(false, iteratorF.hasNext());
		Assert.assertEquals(false, iteratorF.hasNext());
		Assert.assertEquals(false, iteratorF.hasNext());
		
	}
	@Test(expected = NoSuchElementException.class)
	public void testReverseItException() {
		Iterator<String> i = lS.reverseIterator();
		Assert.assertFalse(i.hasNext());
		i.next();
	}
	@Test
	public void testConstructorConElementos() {
		Assert.assertEquals("[A, B, C]", lSABC.toString());
	}
	@Test
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
	}
}
