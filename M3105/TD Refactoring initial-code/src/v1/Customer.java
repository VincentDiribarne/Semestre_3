package v1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer {

    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental aRental) {
        rentals.add(aRental);
    }

    public String getName() {
        return name;
    }

    public String statement() {

        double totalAmount = 0;
        int frequentRenterPoints = 0;

        Iterator<Rental> theRentals = rentals.iterator();

        String result = "Rental Record for " + getName() + "\n";

        while (theRentals.hasNext()) {
            Rental each = theRentals.next();

            //determine amounts for each line
            double thisAmount = each.getCharge(each);
            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
                frequentRenterPoints++;

            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }
        //add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";

        return result;
    }
}

