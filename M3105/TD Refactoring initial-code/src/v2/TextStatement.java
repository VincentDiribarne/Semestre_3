package v2;

public class TextStatement extends Statement {

    @Override
    public String eachRentalString(Rental aRental) {
        return "\t" + aRental.getMovie().getTitle() + "\t" + aRental.getCharge() + "\n";
    }

    @Override
    public String headerString(Customer aCustomer) {
        return "Rental Record for " + aCustomer.getName() + "\n";
    }

    @Override
    public String footerString(Customer aCustomer) {
        return "Amount owed is " + aCustomer.getTotalCharge() + "\n" + "You earned " + aCustomer.getTotalFrequentRenterPoints() + " frequent renter points";
    }
}
