package Hashage.exceptions;

/**
 * RuntimeExeption raised when a map if full a entriy is tried for insertion.
 * @author rvenant
 */
public class CompleteTableException extends RuntimeException {

    /**
     * Creates a new instance of <code>CompleteTableException</code> without
     * detail message.
     */
    public CompleteTableException() {
    }

    /**
     * Constructs an instance of <code>CompleteTableException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CompleteTableException(String msg) {
        super(msg);
    }
}
