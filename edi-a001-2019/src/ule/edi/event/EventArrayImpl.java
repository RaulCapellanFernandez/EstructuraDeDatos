package ule.edi.event;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ule.edi.model.Configuration.Type;
import ule.edi.model.*;

public class EventArrayImpl implements Event {
	
	
	private String name;
	private Date date;
	
	private Double priceGold;    // precio de entradas tipo GOLD
	private Double priceSilver;  // precio de entradas tipo SILVER
	
	private int nGold;    // Nº de butacas de tipo GOLD
	private int nSilver;  // Nº de butacas de tipo SILVER
	
	private Seat[] gold;
	private Seat[] silver;	
	
   public Double getPriceGold() {
		return priceGold;
	}

   public void setGoldSeats(int nGold) {
		this.nGold = nGold;
		gold = new Seat[nGold];
		  

	}
   public void setSilvereats(int nSilver) {
		this.nSilver = nSilver;
		silver = new Seat[nSilver];
	}

	public void setPriceGold(Double priceGold) {
		this.priceGold = priceGold;
	}


	public Double getPriceSilver() {
		return priceSilver;
	}


	public void setPriceSilver(Double priceSilver) {
		this.priceSilver = priceSilver;
	}

public EventArrayImpl(String name, Date date, int nGold, int nSilver, Seat[]gold, Seat[]silver){
	 this.name = name;
	 this.date = date;
	 this.nSilver = nSilver;
	 this.nGold =nGold;
	 this.gold = new Seat[nGold];
	 this.silver = new Seat[nSilver];
	
	//TODO 
	   // utiliza los precios por defecto: DEFAULT_PRICE_GOLD y DEFAULT_PRICE_SILVER definidos en Configuration.java
	   
	   // Debe crear los arrays de butacas gold y silver
	   
   }
   
   
   public EventArrayImpl(String name, Date date, int nGold, int nSilver, Double priceGold, Double priceSilver, Seat[]gold, Seat[]silver){
	   this.name = name;
	   this.date = date;
	   this.nSilver = nSilver;
	   this.nGold = nGold;
	   this.gold = gold;
	   
	   
	   //TODO 
	   // Debe crear los arrays de butacas gold y silver
	   
	   
   }
   

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Date getDate() {
		// TODO Auto-generated method stub
		return date;
	}

	
	@Override
	public int getNumberOfAttendingChildren() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfAttendingAdults() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfAttendingElderlyPeople() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfSoldSeats() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfSoldGoldSeats() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfSoldSilverSeats() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfSeats() {
		// TODO Auto-generated method stub
		return (nGold+nSilver);
	}

	@Override
	public int getNumberOfGoldSeats() {
		// TODO Auto-generated method stub
		return nGold;
	}

	@Override
	public int getNumberOfSilverSeats() {
		// TODO Auto-generated method stub
		return nSilver;
	}


	@Override
	public int getNumberOfAvailableSeats() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Seat getSeat(int pos, Type type) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Person refundSeat(int pos, Type type) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean sellSeat(int pos, Person p, Type type) {
		int pos1 = pos -1;
		if(type == Configuration.Type.GOLD) {//Comprueba el tipo
			if(pos1 <= nGold && pos1 >= 0) {//Comprueba que no se sale
				if(gold[pos1] == null) {//Que este vacio
					gold[pos1] = new Seat(null,pos1,Configuration.Type.GOLD,p);
					return true;
				}
			}
		}
		if(type == Configuration.Type.SILVER) {//Comprueba el tipo
			if(pos1 <= nSilver && pos1 >= 0) {//Comprueba que no se sale
				if(silver[pos1] == null) {//Que este vacio
					silver[pos1] = new Seat(null,pos1,Configuration.Type.SILVER,p);
					return true;
				}
			}
		}
		return false;	
	}


	@Override
	public List<Integer> getAvailableGoldSeatsList() {
		List<Integer>listaDisponibles =new ArrayList<Integer>();
		
		for(int i = 0; i < nGold; i++) {
			if(gold[i] == null)
				listaDisponibles.add(i+1);
		}
		
		return listaDisponibles;
	}


	@Override
	public List<Integer> getAvailableSilverSeatsList() {
		List<Integer>listaDisponibles =new ArrayList<Integer>();
		
		for(int i = 0; i < nSilver; i++) {
			if(silver[i] == null)
				listaDisponibles.add(i+1);
		}
		
		return listaDisponibles;
	}


	@Override
	public Double getPrice(Seat seat) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Double getCollectionEvent() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getPosPersonGold(Person p) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getPosPersonSilver(Person p) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean isGold(Person p) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isSilver(Person p) {
		// TODO Auto-generated method stub
		return false;
	}

	

	
}
