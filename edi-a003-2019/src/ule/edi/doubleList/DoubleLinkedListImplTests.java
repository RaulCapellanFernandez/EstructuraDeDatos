package ule.edi.doubleList;



import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.*;


public class DoubleLinkedListImplTests {

	private DoubleLinkedListImpl<String> ls;
	private DoubleLinkedListImpl<String> lSABC;
	private DoubleLinkedListImpl<String> lSABCDE;


	@Before
	public void setup() {
		this.ls = new DoubleLinkedListImpl<String>();
	    //this.lSABC=new DoubleLinkedListImpl<String>("A", "B", "C");
	    //this.lSABCDE=new DoubleLinkedListImpl<String>("A", "B", "C", "D", "E");
	}
	
	/*@Test
	public void testIsEmpty() {
		Assert.assertEquals(true, ls.isEmpty());
		ls.addFirst("1");
		Assert.assertEquals(false, ls.isEmpty());
	}*/
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
	public void testSize(){
		Assert.assertEquals(0, ls.size());
		ls.addLast("4");
		Assert.assertEquals(1, ls.size());
		ls.addLast("4");
		Assert.assertEquals(2, ls.size());
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
