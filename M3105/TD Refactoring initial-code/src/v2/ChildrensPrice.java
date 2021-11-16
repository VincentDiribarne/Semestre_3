package v2;

public class ChildrensPrice extends Price{

    @Override
    public PriceCode getPriceCode() {
        return PriceCode.CHILDRENS;
    }

    @Override
    public double getCharge(int dayRented) {
        double result = 1.5;
        if (dayRented > 3) {
            result += (dayRented - 3) * 1.5;
        }
        return result;
    }
}
