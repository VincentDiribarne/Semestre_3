package Test;

import v2.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestNoRegression {

    @Test
    public void test() {
        Customer paul = new Customer("Paul");

        paul.addRental(new Rental(new Movie("Monty Python et le sacre graal", new RegularPrice()), 3));
        paul.addRental(new Rental(new Movie("La cite de la peur", new RegularPrice()), 2));
        paul.addRental(new Rental(new Movie("Han Solo ", new NewReleasePrice()), 2));
        paul.addRental(new Rental(new Movie("Moi, moche et mechant", new ChildrensPrice()), 4));
        paul.addRental(new Rental(new Movie("Wallace and Gromit", new ChildrensPrice()), 6));

        assertEquals(20.5, paul.getTotalCharge(), 0.);
        assertEquals(6, paul.getTotalFrequentRenterPoints());
    }
}
