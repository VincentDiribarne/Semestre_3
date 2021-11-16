package v2;

public abstract class Statement {
    public final String value(Customer aCustomer) {
        StringBuilder result = new StringBuilder(headerString(aCustomer));

        for (Rental each : aCustomer.getRentals()) {
            result.append(eachRentalString(each));
        }

        result.append(footerString(aCustomer));
        return result.toString();
    }

    public abstract String headerString(Customer customer);
    public abstract String eachRentalString(Rental rental);
    public abstract String footerString(Customer customer);
}
