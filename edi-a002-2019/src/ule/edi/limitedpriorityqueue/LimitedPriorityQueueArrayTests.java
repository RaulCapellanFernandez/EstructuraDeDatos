package ule.edi.limitedpriorityqueue;

import org.junit.*;




public class LimitedPriorityQueueArrayTests {

	
	private LimitedPriorityQueueArrayImpl<String> pq10;
	private LimitedPriorityQueueArrayImpl<String> pq5;
	private LinkedQueue<String> pq1 = new LinkedQueue<>();
	
	
	public LimitedPriorityQueueArrayTests() {
		

	}
	
	@Before
	public void testBefore() throws Exception{
	    pq10 = new LimitedPriorityQueueArrayImpl<String>(3,2); // limitado a 3 elementos, las posibles prioridades son [1,2]
	    pq5 = new LimitedPriorityQueueArrayImpl<String>(5,3); // limitado a 5 elementos, las posibles prioridades son [1,2,3]

	}
	
	@Test
	public void testPrueba() throws Exception {
		Assert.assertEquals(true, pq1.isEmpty());
		Assert.assertEquals(0, pq1.size());
		Assert.assertEquals("", pq1.toString());
		
		pq1.enqueue("1");
		pq1.enqueue("2");
		pq1.enqueue("3");
		pq1.enqueue("111");
		
		Assert.assertEquals(4, pq1.size());
		Assert.assertEquals("1, 2, 3, 111", pq1.toString());
		Assert.assertEquals("1", pq1.first());
		Assert.assertEquals("1", pq1.dequeue());
		Assert.assertEquals("111", pq1.dequeueLast());
	}
	
	@Test(expected = EmptyCollectionException.class)
	public void testDequeueLinkedQueue() throws EmptyCollectionException {
		pq1.dequeue();
	}
	@Test(expected = EmptyCollectionException.class)
	public void testDequeueLastLinkedQueue() throws EmptyCollectionException {
		pq1.dequeueLast();
	}
	@Test(expected = EmptyCollectionException.class)
	public void testFirstEmptyLinkedQueue() throws EmptyCollectionException {
		pq1.first();
		
	}
	
	
	@Test
	public void testMisCosas() throws Exception {
		Assert.assertEquals(false, pq10.isFull());
		Assert.assertEquals(true, pq10.isEmpty());
		Assert.assertEquals(3, pq10.getCapacity());
		System.out.println(pq10.toString());
		Assert.assertEquals(null, pq10.enqueue(1, "1_1"));
		System.out.println(pq10.toString());
		Assert.assertEquals(null, pq10.enqueue(2, "2_1"));
		System.out.println(pq10.toString());
		Assert.assertEquals(null, pq10.enqueue(1, "3_1"));
		System.out.println(pq10.toString());
		Assert.assertEquals("2_1", pq10.enqueue(1, "5_1"));
		System.out.println(pq10.toString());
		Assert.assertEquals("6_1", pq10.enqueue(2, "6_1"));
		System.out.println(pq10.toString());
		
		Assert.assertEquals(true, pq10.isFull());
		Assert.assertEquals("1_1", pq10.first());
		Assert.assertEquals("1_1", pq10.dequeue());
		Assert.assertEquals(false, pq10.isFull());
		Assert.assertEquals(false, pq10.isEmpty());
	}
	
	@Test(expected = EmptyCollectionException.class)
	public void testDequeue() throws EmptyCollectionException {
		pq10.dequeue();
	}
	@Test(expected = EmptyCollectionException.class)
	public void testFirst() throws EmptyCollectionException {
		pq10.first();
	}
	
	@Test
	public void testEnVacia() throws Exception {
		
	    Assert.assertEquals(pq10.isEmpty(), true);
	    Assert.assertEquals(pq10.isFull(), false);
	    Assert.assertEquals(pq10.getSize(), 0);
	    Assert.assertEquals(pq10.toString(), "[]");
	}
	
	@Test
	public void testInsertarHastaLLenar() throws Exception{
	    Assert.assertEquals(pq10.enqueue(1, "Prior1_1"), null);
	    Assert.assertEquals(pq10.isEmpty(), false);
	    Assert.assertEquals(pq10.getSize(), 1);
	    Assert.assertEquals(pq10.enqueue(2, "Prior2_1"), null);
	    Assert.assertEquals(pq10.isEmpty(), false);
	    Assert.assertEquals(pq10.getSize(), 2);	
	    Assert.assertEquals(pq10.enqueue(2, "Prior2_2"), null);
	    Assert.assertEquals(pq10.isEmpty(), false);
	    Assert.assertEquals(pq10.getSize(), 3);	
	    Assert.assertEquals(pq10.isFull(), true);
	    Assert.assertEquals(pq10.toString(), "[( Priority:1 (Prior1_1)), ( Priority:2 (Prior2_1, Prior2_2))]");
	  
	}
	
	@Test
	public void testInsertarMenorPrioEnLLena() throws Exception{
		System.out.println(pq10.toString());
	    Assert.assertEquals(pq10.enqueue(1, "Prior1_1"), null);
	    System.out.println(pq10.toString());
	    Assert.assertEquals(pq10.enqueue(2, "Prior2_1"), null);
	    System.out.println(pq10.toString());
	    Assert.assertEquals(pq10.enqueue(2, "Prior2_2"), null);
	    System.out.println(pq10.toString());
	    Assert.assertEquals(pq10.toString(), "[( Priority:1 (Prior1_1)), ( Priority:2 (Prior2_1, Prior2_2))]");
	    Assert.assertEquals(pq10.enqueue(2, "Prior2_3"), "Prior2_3");    // El elemento insertado tiene menor prioridad que los que estaban, por tanto es el que sale
	    System.out.println(pq10.toString());
	    Assert.assertEquals(pq10.toString(), "[( Priority:1 (Prior1_1)), ( Priority:2 (Prior2_1, Prior2_2))]");
	  
	}
	
	@Test
	public void testInsertarMayorPrioEnLLena() throws Exception{
	    Assert.assertEquals(pq10.enqueue(1, "Prior1_1"), null);
	    Assert.assertEquals(pq10.enqueue(2, "Prior2_1"), null);
	    Assert.assertEquals(pq10.enqueue(2, "Prior2_2"), null);
	    Assert.assertEquals(pq10.toString(), "[( Priority:1 (Prior1_1)), ( Priority:2 (Prior2_1, Prior2_2))]");
	    Assert.assertEquals(pq10.enqueue(1, "Prior1_2"), "Prior2_2");
	    Assert.assertEquals(pq10.toString(), "[( Priority:1 (Prior1_1, Prior1_2)), ( Priority:2 (Prior2_1))]");
	  
	}
}
