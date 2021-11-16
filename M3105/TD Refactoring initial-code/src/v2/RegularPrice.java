package v2;

public class RegularPrice extends Price {

    @Override
    public PriceCode getPriceCode() {
        return PriceCode.REGULAR;
    }

    @Override
    public double getCharge(int dayRented) {
        double result = 2;
        if (dayRented > 2) {
            result += (dayRented - 2) * 1.5;
        }
        return result;
    }
}
