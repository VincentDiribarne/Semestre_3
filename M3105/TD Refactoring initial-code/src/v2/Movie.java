package v2;

public class Movie {
    private final String title;
    private Price price;

    public Movie(String title, Price initialPrice) {
        this.title = title;
        setPriceCode(initialPrice);
    }

    public void setPriceCode(Price newPrice) {
        price = newPrice;
    }
    public String getTitle() {
        return title;
    }
    public double getCharge(int dayRented) {
        return price.getCharge(dayRented);
    }
    public int getFrequentRenterPoint(int daysRented) {
        return price.getFrequentRenterPoint(daysRented);
    }
}