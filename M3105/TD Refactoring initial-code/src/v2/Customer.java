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

	public String getName (){
		return name; 
	}

	public String statement() {

		String result = "Rental Record for " + getName() + "\n";
	
		for (Rental each : rentals) {
			result += "\t"+ each.getMovie().getTitle()+ "\t" + each.getCharge() + "\n";
		}
		//add footer lines 
		result += "Amount owed is " + getTotalCharge() + "\n";
		result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";
		
		return result;
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

