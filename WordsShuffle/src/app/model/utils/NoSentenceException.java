package app.model.utils;

/**
 * Exception occurs when provided data is empty
 * 
 * @author Krzysztof Poloczek
 * @version 1.1
 */
public class NoSentenceException extends Exception {

    /**
     * Non-parameter constructor 
     */
    public NoSentenceException() {
    }

    /**
     * Constructor
     *
     * @param message display message
     */
    public NoSentenceException(String message) {
        super(message);
    }
}