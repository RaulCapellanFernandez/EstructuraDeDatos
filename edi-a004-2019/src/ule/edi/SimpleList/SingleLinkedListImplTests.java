package ule.edi.SimpleList;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SingleLinkedListImplTests {

	

	private SingleLinkedListImpl<String> lS;
	private SingleLinkedListImpl<String> lSABC;
	

	@Before
	public void setUp() {
		this.lS = new SingleLinkedListImpl<String>();
		this.lSABC = new SingleLinkedListImpl<String>("A", "B", "C");
	}

   @Test
   public void constructorElemens(){
	   lS=new SingleLinkedListImpl<String>("A", "B", "C", "D");
	   Assert.assertEquals("[A, B, C, D]", lS.toString());
	   Assert.assertEquals("[A, B, C]", lSABC.toString());
   }
   @Test
   public void isEmptyTest(){
	   Assert.assertEquals(true, lS.isEmpty());
	   Assert.assertEquals(false, lSABC.isEmpty());
   }
   @Test
   public void sizeTest(){
	   Assert.assertEquals(0, lS.size());
	   Assert.assertEquals(3, lSABC.size());
   }
   @Test
   public void addFirstTest(){
	   lS.addFirst("1");
	   Assert.assertEquals("[1]", lS.toString());
	   lS.addFirst("2");
	   lS.addFirst("3");
	   Assert.assertEquals("[3, 2, 1]", lS.toString());
   }
   @Test
   public void addLastTest(){
	   lS.addLast("1");
	   Assert.assertEquals("[1]", lS.toString());
	   lS.addLast("2");
	   lS.addLast("3");
	   Assert.assertEquals("[1, 2, 3]", lS.toString());
   }
   @Test
   public void addPosTest(){
	   lS.addAtPos("1", 2);
	   Assert.assertEquals("[1]", lS.toString());
	   lS.addAtPos("2", 1);
	   Assert.assertEquals("[2, 1]", lS.toString());
	   lS.addAtPos("3", 24);
	   Assert.assertEquals("[2, 1, 3]", lS.toString());
	   lS.addAtPos("4", 3);
	   Assert.assertEquals("[2, 1, 4, 3]", lS.toString());
	   lS.addAtPos("5", 2);
	   Assert.assertEquals("[2, 5, 1, 4, 3]", lS.toString());
   }
   @Test
   public void addNTimesTest(){
	   lS.addNTimes("5", 5);
	   Assert.assertEquals("[5, 5, 5, 5, 5]", lS.toString());
	   lSABC.addNTimes("5", 3);
	   Assert.assertEquals("[A, B, C, 5, 5, 5]", lSABC.toString());
	   
   }
   @Test
   public void indexOfTest(){
	   Assert.assertEquals(1, lSABC.indexOf("A"));
	   Assert.assertEquals(2, lSABC.indexOf("B"));
	   Assert.assertEquals(3, lSABC.indexOf("C"));
   }
   @Test
   public void removeLastTest() throws EmptyCollectionException{
	   Assert.assertEquals("C", lSABC.removeLast());
	   Assert.assertEquals("[A, B]", lSABC.toString());
	   Assert.assertEquals("B", lSABC.removeLast());
	   Assert.assertEquals("[A]", lSABC.toString());
	   Assert.assertEquals("A", lSABC.removeLast());
	   Assert.assertEquals("[]", lSABC.toString());
	   
   }/*
   @Test
   public void removeLastElemTest() throws EmptyCollectionException {
	   lSABC.addLast("B");
	   lSABC.addLast("B");
	   lSABC.removeLast("A");
	  Assert.assertEquals("[B, C, B, B]", lSABC.toString());
   }*/
   @Test
   public void reverse() throws EmptyCollectionException {
	   Assert.assertEquals("[C, B, A]", lSABC.reverse().toString());
	   Assert.assertEquals("[]", lS.reverse().toString());
   }
   
/*
   @Test
   public void addAtPos(){
	   
	   lS.addAtPos("A", 1);
	   Assert.assertEquals("[A]", lS.toString());
	   lS.addAtPos("C", 1);
	   Assert.assertEquals("[C, A]", lS.toString());
	   lS.addAtPos("B", 2);
	   Assert.assertEquals("[C, B, A]", lS.toString());
	   lS.addAtPos("D", 5);
	   Assert.assertEquals("[C, B, A, D]", lS.toString());
   }
   
   @Test
   public void addNTimes(){
	   
	   lS.addNTimes("A", 3);
	   Assert.assertEquals("[A, A, A]", lS.toString());
	   lS.addNTimes("B", 2);
	   Assert.assertEquals("[A, A, A, B, B]", lS.toString());
	   
   }
// TEST DE SUBLIST
	@Test
	public void tesSubListEnListaVacia() {
	
		Assert.assertEquals(-1, lS.isSubList(lSABC));		
	}

		@Test
		public void tesSubListConSubListaVacia() {
			Assert.assertEquals(1, lSABC.isSubList(lS));		
		}
		
		
		@Test
		public void subListVarios() {
			lS = new SingleLinkedListImpl<String>("A", "B", "C", "D", "E");
			Assert.assertEquals(1, lS.isSubList(lSABC));	
			lS = new SingleLinkedListImpl<String>("Z", "X", "A", "B", "C", "D", "E");
			Assert.assertEquals(3, lS.isSubList(lSABC));	
			lS = new SingleLinkedListImpl<String>("Z", "X", "A", "B", "C");
			Assert.assertEquals(3, lS.isSubList(lSABC));	
			lS = new SingleLinkedListImpl<String>("A", "B", "C");
			Assert.assertEquals(1, lS.isSubList(lSABC));	
		}
*/
}
