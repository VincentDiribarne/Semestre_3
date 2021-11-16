package v2;

public class NewReleasePrice extends Price{

    @Override
    public PriceCode getPriceCode() {
        return PriceCode.NEW_RELEASE;
    }

    @Override
    public double getCharge(int dayRented) {
        return dayRented * 3;
    }
}
