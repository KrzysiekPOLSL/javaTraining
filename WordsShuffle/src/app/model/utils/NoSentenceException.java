package app.model.utils;

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