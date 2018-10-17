package app.interfaces;

/**
 * Interface Displayer takes care of communication with user
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
}
