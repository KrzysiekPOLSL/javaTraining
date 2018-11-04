/**
 * Utils for model elements
 */
package app.model;

/**
 * Exception occurs when provided data is empty
 * 
 * @author Krzysztof Poloczek
 * @version 2.1
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
     * @param message Message that will be displayed
     */
    public NoSentenceException(String message) {
        super(message);
    }
}