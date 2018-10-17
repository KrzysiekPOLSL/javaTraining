package app.view.utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 
 */
public class ShuffleSelector {
    
    private Character sortingIndicator;
    
    private Character shufflingIndicator;
    
    private KeyChecker keychecker;
    
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
    
    public ShuffleSelector(Character sortingIndicator, Character shufflingIndicator){
        List<Character> desiredCharacters = new ArrayList<>();
        desiredCharacters.add(sortingIndicator);
        desiredCharacters.add(shufflingIndicator);
        keychecker = new KeyChecker(desiredCharacters);
        
        this.shufflingIndicator = shufflingIndicator;
        this.sortingIndicator   = sortingIndicator;
    }
    
    public Character waitForRightKeyLoop(){
         keychecker.waitForRightKey();
         return keychecker.getKeyPressed();
    }
    
}
