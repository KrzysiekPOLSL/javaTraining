package app.view.console;

import app.interfaces.Displayer;
import app.view.utils.ShuffleSelector;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
         Character result = Character.MAX_VALUE;
         while(!isCharacterDesired(result)){
             try {
                 result = (char) System.in.read();
             } catch (IOException ex) {
                 Logger.getLogger(ConsolePrinter.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         return result;
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