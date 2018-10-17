package app.interfaces;

import java.util.List;

/**
 *
 * interface Displayer takes care of communication with user
 */
public interface Displayer {
    /**
     * asking user if he wants to shuffle words or get them sorted
     * @return 
     */
    public Character shuffleOrSort();
    /**
     * prints out result of shuffling or sorting
     * @param words
     */
    public void displayResult(String sentence);
}
