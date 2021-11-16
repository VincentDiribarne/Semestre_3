package v2;

public class Rental {

    private final Movie movie;
    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    Movie getMovie() {
        return movie;
    }
    double getCharge() {
        return movie.getCharge(daysRented);
    }
    int getFrequentRenterPoint() {
        return movie.getFrequentRenterPoint(daysRented);
    }
}
