package v2;

public abstract class Price {
    public abstract PriceCode getPriceCode();
    public abstract double getCharge(int dayRented);
}
