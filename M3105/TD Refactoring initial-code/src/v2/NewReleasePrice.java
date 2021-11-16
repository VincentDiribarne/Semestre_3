package v2;

public class NewReleasePrice extends Price{

    @Override
    public double getCharge(int dayRented) {
        return dayRented * 3;
    }

    @Override
    public int getFrequentRenterPoint(int daysRented) {
        if (daysRented > 1) {
            return 2;
        }
        return super.getFrequentRenterPoint(daysRented);
    }
}
