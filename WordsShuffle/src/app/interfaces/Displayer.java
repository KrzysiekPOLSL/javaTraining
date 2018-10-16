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
    public char shuffleOrSort();
    /**
     * prints out result of shuffling or sorting
     * @param words
     */
    public void displayResult(List<String> words);
}
