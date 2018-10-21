package app.interfaces;

/**
 * Interface Displayer takes care of communication with user
 * 
 * @author Krzysztof Poloczek
 * @version 1.1
 */
public interface Displayer {
    /**
     * Asking user if he wants to shuffle words or get them sorted
     * @return 
     */
    public Character shuffleOrSort();
    /**
     * Prints out result of shuffling or sorting
     * @param sentence
     */
    public void displayResult(String sentence);
    /**
     * Prints out exception message
     * @param message
     */
    public void displayExceptionMessage(String message);
    /**
     * Loop that waits for user to input any data
     * @return 
     */
    public String[] askForData();
}
