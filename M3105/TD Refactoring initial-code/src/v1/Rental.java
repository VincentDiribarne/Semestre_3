package v1;

public class Rental {
	
	private final Movie movie;
	private final int daysRented;
	
	public Rental(Movie movie, int daysRented) { 
		this.movie = movie;
		this.daysRented = daysRented;
	}
	
	public int getDaysRented() {
		return daysRented; 
	}
	
	public Movie getMovie() { 
		return movie;
	}

	double getCharge(Rental each) {
		double thisAmount = 0;
		switch (each.getMovie().getPriceCode()) {
			case Movie.REGULAR -> {
				thisAmount += 2;
				if (each.getDaysRented() > 2) {
					thisAmount += (each.getDaysRented() - 2) * 1.5;
				}
			}
			case Movie.NEW_RELEASE -> thisAmount += each.getDaysRented() * 3;
			case Movie.CHILDRENS -> {
				thisAmount += 1.5;
				if (each.getDaysRented() > 3) {
					thisAmount += (each.getDaysRented() - 3) * 1.5;
				}
			}
		}
		return thisAmount;
	}
}
