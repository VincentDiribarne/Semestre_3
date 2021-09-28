package Hashage.exceptions;

/**
 *
 * @author rvenant
 */
public class NullKeyException extends RuntimeException {

    /**
     * Creates a new instance of <code>NullKeyException</code> without detail
     * message.
     */
    public NullKeyException() {
    }

    /**
     * Constructs an instance of <code>NullKeyException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NullKeyException(String msg) {
        super(msg);
    }
}
