/**
 * Tools for view elements
 */
package app.view.utils;

/**
 * Utility that handles managing characters that indicates choice
 * 
 * @author Krzysztof Poloczek
 * @version 1.2
 */
public class ShuffleSelector {
    
    /*Character that indicates sorting operation*/
    private Character sortingIndicator;
    /*Character that indicates shuffling operation*/
    private Character shufflingIndicator;
    
    /**
     * Getter for sortingIndicator
     * @return Value of sortingIndicator
     */
    public Character getSortingIndicator(){
        return sortingIndicator;
    }
    
    /**
     * Getter for shufflingIndicator
     * @return Value of shufflingIndicator
     */
    public Character getShufflingIndicator(){
        return shufflingIndicator;
    }
    
    /**
     * Constructor that initializes indicators
     * @param sortingIndicator Character that indicates sorting operation
     * @param shufflingIndicator Character that indicates shuffling operation
     */
    public ShuffleSelector(Character sortingIndicator, Character shufflingIndicator)
    {
      this.shufflingIndicator = shufflingIndicator;
      this.sortingIndicator   = sortingIndicator;
    }
    
    /**
     * Checks if given parameter matches one of the indicators
     * @param ch The character given by user
     * @return Boolean value if the character is essential
     */
    public boolean isCharacterDesired(Character ch){
        return ch.equals(shufflingIndicator) | ch.equals(sortingIndicator);
    }
    
}
