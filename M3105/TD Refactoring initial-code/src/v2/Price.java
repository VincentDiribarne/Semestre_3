package v2;

public abstract class Price {
    public abstract double getCharge(int dayRented);
    public int getFrequentRenterPoint(int daysRented) {
        return 1;
    }
}
