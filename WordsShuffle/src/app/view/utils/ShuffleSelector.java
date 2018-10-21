package app.view.utils;

/**
 * Utility that handles managing characters that indicates choice
 * 
 * @author Krzysztof Poloczek
 * @version 1.1
 */
public class ShuffleSelector {
    
    /**
     * Choice indicators
     */
    private Character sortingIndicator, shufflingIndicator;
    
    /**
     * Getter for sortingIndicator
     * @return
     */
    public Character getSortingIndicator(){
        return sortingIndicator;
    }
    
    /**
     * Getter for shufflingIndicator
     * @return
     */
    public Character getShufflingIndicator(){
        return shufflingIndicator;
    }
    
    /**
     * Constructor that initializes indicators
     * @param sortingIndicator
     * @param shufflingIndicator 
     */
    public ShuffleSelector(Character sortingIndicator, Character shufflingIndicator)
    {
      this.shufflingIndicator = shufflingIndicator;
      this.sortingIndicator   = sortingIndicator;
    }
    
    /**
     * Checks if given parameter matches one of the indicators
     * @param ch
     * @return 
     */
    public boolean isCharacterDesired(Character ch){
        return ch.equals(shufflingIndicator) | ch.equals(sortingIndicator);
    }
    
}
