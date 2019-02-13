package ule.edi.event;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.*;

import ule.edi.model.*;
import ule.edi.model.Configuration.Type;

public class EventArrayImplTests {

	private DateFormat dformat = null;
	private EventArrayImpl e;
	private Person persona;
	private Person persona1;
	private Person persona2;
	private Seat[]goldArray;
	private Seat[]silverAray;
	
	private Date parseLocalDate(String spec) throws ParseException {
        return dformat.parse(spec);
	}

	public EventArrayImplTests() {
		
		dformat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	@Before
	public void testBefore() throws Exception{
	    e = new EventArrayImpl("Jose", parseLocalDate("24/02/2018 17:00:00"), 10, 100, goldArray, silverAray);
	}
	
	@Test
	public void testSomething() throws Exception {
		
	    Assert.assertTrue(e.getNumberOfAvailableSeats()==110);
	    Assert.assertEquals(e.getNumberOfSilverSeats(), 110);
	    Assert.assertEquals(e.getNumberOfAttendingAdults(), 0);
	}
	
	@Test
	public void testSellSeat1Adult() throws Exception{
		
			
	    Assert.assertEquals(e.getNumberOfAttendingAdults(), 0);
		e.sellSeat(1, new Person("10203040A","Alice", 34),Type.GOLD);
	    Assert.assertEquals(e.getNumberOfAttendingAdults(), 1);
	  
	}
	/*
	@Test
	public void testgetAvailableSilverSeatsListBasic() throws Exception{
		 Event  ep = new EventArrayImpl("The Fabulous Five", parseLocalDate("24/02/2018 17:00:00"), 2, 2);
		Assert.assertEquals(ep.sellSeat(1, new Person("1010", "AA", 10), Configuration.Type.SILVER),true);
		Assert.assertEquals(ep.getAvailableSilverSeatsList().toString(), "[2]");					
	}*/
	
	@Test
	public void testMetodoEquals() throws Exception{
		persona = new Person("Pene", "71471266P", 23);
		persona1 = new Person("Pene", "71471266P", 23);
		persona2 = new Person("Ramon", "71471265P", 23);
		
		Assert.assertEquals(persona.equals(persona1), true);
		Assert.assertEquals(persona.equals(persona2), false);
		
	}

	@Test
	public void testGetName()throws Exception{
		Assert.assertTrue("Jose".equals(e.getName()));
		Assert.assertFalse("Raul".equals(e.getName()));
	}
	
	@Test
	public void testGetDate()throws Exception{
		Assert.assertEquals(parseLocalDate("24/02/2018 17:00:00"), e.getDate());
		Assert.assertEquals("Raul".equals(e.getName()), false);
	}
	
	@Test
	public void testNumberSeats()throws Exception{
		int nGold = 10;
		int nSilver = 100;
		
		Assert.assertEquals(nGold , e.getNumberOfGoldSeats());
		Assert.assertEquals(nSilver, e.getNumberOfSilverSeats());
		Assert.assertEquals((nGold+nSilver) , e.getNumberOfSeats()) ;
	}
	
	@Test
	public void testSellSeat()throws Exception{
		persona = new Person("Pene", "71471266P", 23);
		persona1 = new Person("Pene", "71471266P", 23);
		persona2 = new Person("Ramon", "71471265P", 23);
		Assert.assertTrue(e.sellSeat(5, persona, Configuration.Type.GOLD));
		Assert.assertTrue(e.sellSeat(5, persona1, Configuration.Type.SILVER));
		Assert.assertFalse(e.sellSeat(5, persona2, Configuration.Type.GOLD));
		
	}
	@Test
	public void testAvaibleGoldSeat()throws Exception{
		List<Integer>listaDisponibles = new ArrayList<Integer>();
		
		for(int i =0 ; i< e.getNumberOfGoldSeats(); i++) {
			listaDisponibles.add(i+1);
		}
		listaDisponibles.remove(4);
		
		e.sellSeat(5, persona, Configuration.Type.GOLD);
		
		Assert.assertEquals(listaDisponibles, e.getAvailableGoldSeatsList());
	}
	
	@Test
	public void testAvaibleSilverSeat()throws Exception{
		List<Integer>listaDisponibles = new ArrayList<Integer>();
		
		for(int i =0 ; i< e.getNumberOfSilverSeats(); i++) {
			listaDisponibles.add(i+1);
		}
		listaDisponibles.remove(4);
		
		e.sellSeat(5, persona, Configuration.Type.SILVER);
		
		Assert.assertEquals(listaDisponibles, e.getAvailableSilverSeatsList());
	}
}
