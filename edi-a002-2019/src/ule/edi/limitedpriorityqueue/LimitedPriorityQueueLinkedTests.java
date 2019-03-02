package ule.edi.limitedpriorityqueue;

import org.junit.*;




public class LimitedPriorityQueueLinkedTests {

	
	private LimitedPriorityQueueLinkedImpl<String> pq3;
	private LimitedPriorityQueueLinkedImpl<String> pq5;
	
	public LimitedPriorityQueueLinkedTests() {
		

	}
	
	@Before
	public void testBefore() throws Exception{
	    pq3 = new LimitedPriorityQueueLinkedImpl<String>(10); // limitado a 3 elementos
	    pq5 = new LimitedPriorityQueueLinkedImpl<String>(5); // limitado a 5 elementos

	}	
	
	@Test
	public void testGetCapacity() throws Exception {
		Assert.assertEquals(10, pq3.getCapacity());
	}
	
	@Test
	public void testGetSize() throws Exception {
		Assert.assertEquals(0, pq3.getSize());
		pq3.enqueue(4, "1");
		Assert.assertEquals(1, pq3.getSize());
	}
	
	@Test
	public void testIsFull() throws Exception {
		Assert.assertEquals(false, pq3.isFull());
		pq3.enqueue(4, "1");
		pq3.enqueue(4, "2");
		pq3.enqueue(4, "3");
		pq3.enqueue(4, "4");
		pq3.enqueue(4, "5");
		pq3.enqueue(4, "6");
		pq3.enqueue(4, "7");
		pq3.enqueue(4, "8");
		pq3.enqueue(4, "9");
		pq3.enqueue(4, "10");
		Assert.assertEquals(true, pq3.isFull());
	}
	@Test(expected = EmptyCollectionException.class)
	public void testDesqueueEmpty() throws EmptyCollectionException {
		pq3.dequeue();
		
	}
	@Test(expected = EmptyCollectionException.class)
	public void testFirstEmpty() throws EmptyCollectionException {
		pq3.first();
	}
	
	@Test
	public void testDesqueue() throws EmptyCollectionException {
		pq3.enqueue(4, "1");
		
		Assert.assertEquals("1", pq3.dequeue());
		
		pq3.enqueue(4, "1");
		pq3.enqueue(3, "2");
		pq3.enqueue(2, "3");
		pq3.enqueue(5, "4");
		pq3.enqueue(2, "5");

		Assert.assertEquals("3", pq3.dequeue());
	}
	
	@Test
	public void testIsEmpty() throws Exception {
		Assert.assertEquals(true, pq3.isEmpty());
		pq3.enqueue(5, "4");
		Assert.assertEquals(false, pq3.isEmpty());
	}
	
	
	@Test
	public void testEnqueue() throws Exception {
		Assert.assertEquals(null,pq3.enqueue(4, "1"));
		Assert.assertEquals(null,pq3.enqueue(3, "2"));
		Assert.assertEquals(null,pq3.enqueue(2, "3"));
		Assert.assertEquals(null,pq3.enqueue(1, "4"));
		Assert.assertEquals(null,pq3.enqueue(2, "5"));
		Assert.assertEquals(null,pq3.enqueue(1, "6"));
		Assert.assertEquals(null,pq3.enqueue(5, "7"));
		Assert.assertEquals(null,pq3.enqueue(2, "8"));
		Assert.assertEquals(null,pq3.enqueue(2, "9"));
		Assert.assertEquals(null,pq3.enqueue(2,"10"));
		
		Assert.assertEquals("4",pq3.enqueue(2, "11"));
		
		Assert.assertEquals("6",pq3.enqueue(2,"10"));
		
	}
	@Test
	public void testIsFirst() throws EmptyCollectionException {
		pq3.enqueue(1, "Prior1_1");
		Assert.assertEquals("Prior1_1" , pq3.first());
	}
	
	@Test
	public void testSomething() throws Exception {
		
	    Assert.assertEquals(pq3.isEmpty(), true);
	    Assert.assertEquals(pq3.isFull(), false);
	    Assert.assertEquals(pq3.getSize(), 0);
	    Assert.assertEquals(pq3.toString(), "[]");
	}
	
	@Test
	public void testInsertarHastaLLenar() throws Exception{
	    Assert.assertEquals(pq3.enqueue(1, "Prior1_1"), null);
	    Assert.assertEquals(pq3.isEmpty(), false);
	    Assert.assertEquals(pq3.getSize(), 1);
	    Assert.assertEquals(pq3.enqueue(2, "Prior2_1"), null);
	    Assert.assertEquals(pq3.isEmpty(), false);
	    Assert.assertEquals(pq3.getSize(), 2);	
	    Assert.assertEquals(pq3.enqueue(2, "Prior2_2"), null);
	    Assert.assertEquals(pq3.isEmpty(), false);
	    Assert.assertEquals(pq3.getSize(), 3);	
	    Assert.assertEquals(pq3.isFull(), false);
	    Assert.assertEquals(pq3.toString(), "[( Priority:1 (Prior1_1)), ( Priority:2 (Prior2_1, Prior2_2))]");
	  
	}
	
	@Test
	public void testInsertarMenorPrioEnLLena() throws Exception{
	    Assert.assertEquals(pq3.enqueue(1, "Prior1_1"), null);
	    Assert.assertEquals(pq3.isEmpty(), false);
	    Assert.assertEquals(pq3.getSize(), 1);
	    Assert.assertEquals(pq3.enqueue(2, "Prior2_1"), null);
	    Assert.assertEquals(pq3.isEmpty(), false);
	    Assert.assertEquals(pq3.getSize(), 2);	
	    Assert.assertEquals(pq3.enqueue(2, "Prior2_2"), null);
	    Assert.assertEquals(pq3.isEmpty(), false);
	    Assert.assertEquals(pq3.getSize(), 3);	
	    Assert.assertEquals(pq3.isFull(), false);
	    Assert.assertEquals(pq3.toString(), "[( Priority:1 (Prior1_1)), ( Priority:2 (Prior2_1, Prior2_2))]");
	    Assert.assertEquals(pq3.enqueue(2, "Prior2_3"), "Prior2_3");
	    Assert.assertEquals(pq3.toString(), "[( Priority:1 (Prior1_1)), ( Priority:2 (Prior2_1, Prior2_2))]");
	  
	}
}
