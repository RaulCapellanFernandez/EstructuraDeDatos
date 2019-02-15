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
	   this.gold = new Seat[nGold];
	   this.silver = new Seat[nSilver];
	   this.priceGold = priceGold;
	   this.priceSilver = priceSilver;
	   
	   
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
		int child = 0;
		for(int i = 0; i < nGold; i++) {
			if(gold[i] != null) {
				if(gold[i].getHolder().getAge() < Configuration.CHILDREN_EXMAX_AGE)
					child++;
			}
		}
		for(int i = 0; i < nSilver; i++) {
			if(silver[i] != null) {
				if(silver[i].getHolder().getAge() < Configuration.CHILDREN_EXMAX_AGE)
					child++;
			}
		}
		return child;
	}

	@Override
	public int getNumberOfAttendingAdults() {
		int adult = 0;
		for(int i = 0; i < nGold; i++) {
			if(gold[i] != null) {
				if(gold[i].getHolder().getAge() >= Configuration.CHILDREN_EXMAX_AGE && gold[i].getHolder().getAge() < Configuration.ELDERLY_PERSON_INMIN_AGE)
					adult++;
			}
		}
		for(int i = 0; i < nSilver; i++) {
			if(silver[i] != null) {
				if(silver[i].getHolder().getAge() >= Configuration.CHILDREN_EXMAX_AGE && silver[i].getHolder().getAge() < Configuration.ELDERLY_PERSON_INMIN_AGE)
					adult++;
			}
		}
		return adult;
	}

	@Override
	public int getNumberOfAttendingElderlyPeople() {
		int elder = 0;
		for(int i = 0; i < nGold; i++) {
			if(gold[i] != null) {
				if(gold[i].getHolder().getAge() >= Configuration.ELDERLY_PERSON_INMIN_AGE)
					elder++;
			}
		}
		for(int i = 0; i < nSilver; i++) {
			if(silver[i] != null) {
				if(silver[i].getHolder().getAge() >= Configuration.ELDERLY_PERSON_INMIN_AGE)
					elder++;
			}
		}
		return elder;
	}

	@Override
	public int getNumberOfSoldSeats() {
		int soldSeats = getNumberOfSoldGoldSeats() + getNumberOfSoldSilverSeats();
		return soldSeats;
	}

	@Override
	public int getNumberOfSoldGoldSeats() {
		int nGoldSeats = 0;
		for(int i = 0; i < nGold; i++) {
			if(gold[i] != null)
				nGoldSeats++;
		}
		return nGoldSeats;
	}

	@Override
	public int getNumberOfSoldSilverSeats() {
		int nSilverSeats = 0;
		for(int i = 0; i < nSilver; i++) {
			if(silver[i] != null)
				nSilverSeats++;
		}
		return nSilverSeats;
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
		int avaiableSeats = getAvailableGoldSeatsList().size() + getAvailableSilverSeatsList().size();
		return avaiableSeats;
	}


	@Override
	public Seat getSeat(int pos, Type type) {
		pos = pos-1;
		if(Configuration.Type.GOLD == type) {
			if(gold[pos] != null)
				return gold[pos];
		}
		
		if(Configuration.Type.SILVER == type) {
			if(silver[pos] != null)
				return silver[pos];
		}
		return null;
	}


	@Override
	public Person refundSeat(int pos, Type type) {
		Person persona = new Person(null, null, 0);
		pos = pos-1;
		if(Configuration.Type.GOLD == type) {
			if(pos >= 0 && pos < nGold) {
				if(gold[pos] != null) {
					persona = gold[pos].getHolder();
					gold[pos]= null;
					return persona;
				}
			}
		}
		if(Configuration.Type.SILVER == type) {
			if(pos >= 0 && pos < nSilver) {
				if(silver[pos] != null) {
					persona = silver[pos].getHolder();
					silver[pos]= null;
					return persona;
				}
			}
		}
		return null;
	}


	@Override
	public boolean sellSeat(int pos, Person p, Type type) {
		int pos1 = pos -1;
		if(type == Configuration.Type.GOLD) {//Comprueba el tipo
			if(pos1 <= nGold && pos1 >= 0) {//Comprueba que no se sale
				if(gold[pos1] == null) {//Que este vacio
					gold[pos1] = new Seat(null,pos,Configuration.Type.GOLD,p);
					return true;
				}
			}
		}
		if(type == Configuration.Type.SILVER) {//Comprueba el tipo
			if(pos1 <= nSilver && pos1 >= 0) {//Comprueba que no se sale
				if(silver[pos1] == null) {//Que este vacio
					silver[pos1] = new Seat(null,pos,Configuration.Type.SILVER,p);
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
		Double precio = 0.00;
		if(seat.getType() == Configuration.Type.GOLD)
			precio = priceGold;
		
		if(seat.getType() == Configuration.Type.SILVER)
			precio = priceSilver;
		
		return precio;
	}


	@Override
	public Double getCollectionEvent() {
		int soldSilver = getNumberOfSoldSilverSeats();
		int soldGold = getNumberOfSoldGoldSeats();
		
		double totalMoney = soldSilver * Configuration.DEFAULT_PRICE_SILVER + soldGold * Configuration.DEFAULT_PRICE_GOLD;
		return totalMoney;
	}


	@Override
	public int getPosPersonGold(Person p) {
		for(int i = 0; i < nGold; i++) {
			if(gold[i] != null) {
				if(gold[i].getHolder().equals(p)) {
					return (i+1);
				}
			}
		}
		return -1;
	}


	@Override
	public int getPosPersonSilver(Person p) {
		for(int i = 0; i < nSilver; i++) {
			if(silver[i] != null) {
				if(silver[i].getHolder().equals(p)) {
					return (i+1);
				}
			}
		}
		return -1;
	}


	@Override
	public boolean isGold(Person p) {
		for(int i = 0; i < nGold; i++) {
			if(gold[i] != null) {
				if(gold[i].getHolder().equals(p)) {
					return true;
				}
			}
		}
		return false;
	}


	@Override
	public boolean isSilver(Person p) {
		for(int i = 0; i < nSilver; i++) {
			if(silver[i] != null) {
				if(silver[i].getHolder().equals(p)) {
					return true;
				}
			}
		}
		return false;
	}

	

	
}
