package app.view.console;

import app.interfaces.Displayer;
import app.view.utils.ShuffleSelector;


/**
 * Printer is ment to communicate with the user
 */
public class ConsolePrinter extends ShuffleSelector implements Displayer {
    
    /**
     *
     * @param sortingIndicator
     * @param shufflingIndicator
     */
    public ConsolePrinter(Character sortingIndicator, Character shufflingIndicator)
    {
       super(sortingIndicator, shufflingIndicator);
    }
    
    /**
     * Asking user if he wants to shuffle words or get them sorted by the console
     */
     @Override
     public Character shuffleOrSort(){
         System.out.print("Press " + getSortingIndicator() + " for sorting or " + getShufflingIndicator() + " for shuffling the sentence");
         return waitForRightKeyLoop();
     }
    /**
     * Prints out result of shuffling or sorting to console 
     * @param sentence
     */
     @Override
    public void displayResult(String sentence){
        System.out.print("Changed sentence: " + sentence);    
    }
    
    /**
     * Notifies user about exception
     * @param message 
     */
    @Override
    public void displayExceptionMessage(String message) {
        System.out.print("An exception occoured, message: " + message);
    }
}