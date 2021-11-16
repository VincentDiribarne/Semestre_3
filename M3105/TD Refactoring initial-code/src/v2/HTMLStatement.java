package v2;

public class HTMLStatement extends Statement {

    @Override
    public String eachRentalString(Rental aRental) {
        return aRental.getMovie().getTitle() + " : " + aRental.getCharge() + "\n";
    }

    @Override
    public String headerString(Customer aCustomer) {
        return "Rentals for " + aCustomer.getName() + "\n";
    }

    @Override
    public String footerString(Customer aCustomer) {
        return "You owe " + aCustomer.getTotalCharge() + "\n" + "On this rental you earned " + aCustomer.getTotalFrequentRenterPoints() + " frequent renter points";
    }
}
