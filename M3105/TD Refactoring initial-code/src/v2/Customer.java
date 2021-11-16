package v2;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private final String name;
	private final List<Rental> rentals = new ArrayList<Rental>();

	public Customer (String name){ 
		this.name = name;
	}
	public void addRental(Rental aRental) { 
		rentals.add(aRental);
	}
	public List<Rental> getRentals() {
		return rentals;
	}
	public String getName(){
		return name; 
	}

	public String statement() {
		return new TextStatement().value(this);
	}

	public String htmlStatement() {
		return new HTMLStatement().value(this);
	}

	public int getTotalFrequentRenterPoints() {
		int result =0;

		for (Rental each : rentals) {
			result += each.getFrequentRenterPoint();
		}
		return result;
	}

	public double getTotalCharge() {
		double result = 0;
		
		for (Rental each : rentals) {
			result += each.getCharge();
		}
		return result;
	}
}

