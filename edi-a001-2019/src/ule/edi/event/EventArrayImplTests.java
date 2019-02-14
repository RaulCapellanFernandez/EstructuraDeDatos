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
	
	@Test
	public void testNumberSoldSeats()throws Exception{
		persona = new Person("Pene", "71471266P", 23);
		persona1 = new Person("Pablo", "71471265P", 23);
		persona2 = new Person("Raon", "71271265P", 23);
		
		e.sellSeat(5, persona, Configuration.Type.GOLD);
		e.sellSeat(7, persona1, Configuration.Type.GOLD);
		e.sellSeat(5, persona, Configuration.Type.SILVER);
		e.sellSeat(8, persona1, Configuration.Type.SILVER);
		
		Assert.assertEquals(2,e.getNumberOfSoldGoldSeats());
		Assert.assertEquals(2,e.getNumberOfSoldSilverSeats());
		Assert.assertEquals(4,e.getNumberOfSoldSeats());
	}
	
	@Test
	public void testNumberAvaiableSeats()throws Exception{
		persona = new Person("Pene", "71471266P", 23);
		persona1 = new Person("Pablo", "71471265P", 23);
		persona2 = new Person("Raon", "71271265P", 23);
		
		e.sellSeat(5, persona, Configuration.Type.GOLD);
		e.sellSeat(7, persona1, Configuration.Type.GOLD);
		e.sellSeat(5, persona, Configuration.Type.SILVER);
		e.sellSeat(8, persona1, Configuration.Type.SILVER);
		
		Assert.assertEquals(106,e.getNumberOfAvailableSeats());
	}
	
	@Test 
	public void testGetSeat()throws Exception{
		persona = new Person("Pene","71471266P",23);
		e.sellSeat(5, persona, Configuration.Type.GOLD);
		
		Assert.assertEquals(persona, e.refundSeat(5, Configuration.Type.GOLD));
		Assert.assertEquals(null, e.refundSeat(8, Configuration.Type.GOLD));
	}
	
	@Test 
	public void testIsGold()throws Exception{
		persona = new Person("Pene","71471266P",23);
		persona1 = new Person("Pablo", "71471265P", 23);
		
		e.sellSeat(5, persona, Configuration.Type.GOLD);
		
		Assert.assertEquals(true, e.isGold(persona));
		Assert.assertEquals(false, e.isGold(persona1));
	}
	
	@Test 
	public void testIsSilver()throws Exception{
		persona = new Person("Pene","71471266P",23);
		persona1 = new Person("Pablo", "71471265P", 23);
		
		e.sellSeat(5, persona, Configuration.Type.SILVER);
		
		Assert.assertEquals(true, e.isSilver(persona));
		Assert.assertEquals(false, e.isSilver(persona1));
	}
	
	@Test 
	public void testGetPosPersonGold()throws Exception{
		persona = new Person("Pene","71471266P",23);
		persona1 = new Person("Pablo", "71471265P", 23);
		
		e.sellSeat(5, persona, Configuration.Type.GOLD);
		
		Assert.assertEquals(5, e.getPosPersonGold(persona));
		Assert.assertEquals(-1, e.getPosPersonGold(persona1));
	}
	
	@Test 
	public void testGetPosPersonSilver()throws Exception{
		persona = new Person("Pene","71471266P",23);
		persona1 = new Person("Pablo", "71471265P", 23);
		
		e.sellSeat(5, persona, Configuration.Type.SILVER);
		
		Assert.assertEquals(5, e.getPosPersonSilver(persona));
		Assert.assertEquals(-1, e.getPosPersonSilver(persona1));
	}
	
	@Test 
	public void testGetPrice()throws Exception{
		persona = new Person("Pene","71471266P",23);
		persona1 = new Person("Pablo", "71471265P", 23);
		
		e.sellSeat(5, persona, Configuration.Type.GOLD);
		e.sellSeat(8, persona1, Configuration.Type.SILVER);
		
		Seat seat = new Seat(null, 5, Configuration.Type.GOLD, persona);
		Seat seat1 = new Seat(null, 8, Configuration.Type.SILVER, persona1);
		
		Assert.assertEquals(Configuration.DEFAULT_PRICE_GOLD, e.getPrice(seat));
		Assert.assertEquals(Configuration.DEFAULT_PRICE_SILVER, e.getPrice(seat1));
	}
	
	@Test 
	public void testGetCollectionEvent()throws Exception{
		persona = new Person("Pene", "71471266P", 23);
		persona1 = new Person("Pablo", "71471265P", 23);
		persona2 = new Person("Raon", "71271265P", 23);
		
		e.sellSeat(5, persona, Configuration.Type.GOLD);
		e.sellSeat(7, persona1, Configuration.Type.GOLD);
		e.sellSeat(5, persona, Configuration.Type.SILVER);
		e.sellSeat(8, persona1, Configuration.Type.SILVER);
		
		Double price  = 300.00;
		
		Assert.assertEquals(price, e.getCollectionEvent());
	}
}
