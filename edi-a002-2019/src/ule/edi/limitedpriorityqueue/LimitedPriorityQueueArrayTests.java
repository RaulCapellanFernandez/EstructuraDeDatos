package ule.edi.limitedpriorityqueue;

import org.junit.*;




public class LimitedPriorityQueueArrayTests {

	
	private LimitedPriorityQueueArrayImpl<String> pq10;
	private LimitedPriorityQueueArrayImpl<String> pq5;
	
	
	public LimitedPriorityQueueArrayTests() {
		

	}
	
	@Before
	public void testBefore() throws Exception{
	    pq10 = new LimitedPriorityQueueArrayImpl<String>(3,2); // limitado a 3 elementos, las posibles prioridades son [1,2]
	    pq5 = new LimitedPriorityQueueArrayImpl<String>(5,3); // limitado a 5 elementos, las posibles prioridades son [1,2,3]

	}
	@Test
	public void testMisCosas() throws Exception {
		Assert.assertEquals(false, pq10.isFull());
		Assert.assertEquals(true, pq10.isEmpty());
		Assert.assertEquals(3, pq10.getCapacity());
		Assert.assertEquals(null, pq10.enqueue(1, "1_1"));
		Assert.assertEquals(null, pq10.enqueue(1, "2_1"));
		Assert.assertEquals(null, pq10.enqueue(1, "3_1"));
		System.out.println(pq10.toString());
		Assert.assertEquals("4_1", pq10.enqueue(1, "4_1"));
		System.out.println(pq10.toString());
		Assert.assertEquals("1_2", pq10.enqueue(2, "1_2"));
		Assert.assertEquals(null, pq10.enqueue(2, "2_2"));
		Assert.assertEquals(null, pq10.enqueue(2, "3_2"));
		Assert.assertEquals("4_2", pq10.enqueue(2, "4_2"));
		Assert.assertEquals("4_1", pq10.enqueue(1, "4_1"));
		Assert.assertEquals("4_2", pq10.enqueue(2, "4_2"));
		Assert.assertEquals(true, pq10.isFull());
		Assert.assertEquals(false, pq10.isEmpty());
		System.out.println(pq10.toString());
	}
	/*
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
	    Assert.assertEquals(3, pq10.getCapacity());
	    Assert.assertEquals(pq10.isFull(), false);
	    Assert.assertEquals(pq10.toString(), "[( Priority:1 (Prior1_1)), ( Priority:2 (Prior2_1, Prior2_2))]");
	  
	}
	
	@Test
	public void testInsertarMenorPrioEnLLena() throws Exception{
	    Assert.assertEquals(pq10.enqueue(1, "Prior1_1"), null);
	    Assert.assertEquals(pq10.enqueue(2, "Prior2_1"), null);
	    Assert.assertEquals(pq10.enqueue(2, "Prior2_2"), null);
	    Assert.assertEquals(pq10.toString(), "[( Priority:1 (Prior1_1)), ( Priority:2 (Prior2_1, Prior2_2))]");
	    Assert.assertEquals(pq10.enqueue(2, "Prior2_3"), "Prior2_3");    // El elemento insertado tiene menor prioridad que los que estaban, por tanto es el que sale
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
	  
	}*/
}
