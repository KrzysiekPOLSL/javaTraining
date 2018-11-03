/**
 * All program interfaces
 */
package app.interfaces;

/**
 * Interface Displayer takes care of communication with user
 * 
 * @author Krzysztof Poloczek
 * @version 1.2
 */
public interface Displayer {
    /**
     * Asking user if he wants to shuffle words or get them sorted
     * @return The intention of user wether to sort of shuffle
     */
    public Character shuffleOrSort();
    /**
     * Prints Out result of shuffling or sorting
     * @param sentence Parameter that needs to be printed
     */
    public void displayResult(String sentence);
    /**
     * Prints out exception message
     * @param message Message that will be printed
     */
    public void displayExceptionMessage(String message);
    /**
     * Loop that waits for user to input any data
     * @return Data given by user
     */
    public String[] askForData();
}
