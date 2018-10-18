package app.view.utils;

/**
 *
 * 
 */
public class ShuffleSelector {
    
    /**
     * 
     */
    private Character sortingIndicator, shufflingIndicator;
    
    /**
     *
     * @return
     */
    public Character getSortingIndicator(){
        return sortingIndicator;
    }
    
    /**
     *
     * @return
     */
    public Character getShufflingIndicator(){
        return shufflingIndicator;
    }
    
    /**
     * 
     * @param sortingIndicator
     * @param shufflingIndicator 
     */
    public ShuffleSelector(Character sortingIndicator, Character shufflingIndicator)
    {
      this.shufflingIndicator = shufflingIndicator;
      this.sortingIndicator   = sortingIndicator;
    }
    
    /**
     * 
     * @param ch
     * @return 
     */
    public boolean isCharacterDesired(Character ch){
        return ch.equals(shufflingIndicator) | ch.equals(sortingIndicator);
    }
    
}
