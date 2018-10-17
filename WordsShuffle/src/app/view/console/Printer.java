package app.view.console;

import app.interfaces.Displayer;
import app.view.utils.KeyChecker;


/**
 * Printer is ment to communicate with the user
 */
public class Printer implements Displayer {
    private KeyChecker keychecker;
    /**
     * Asking user if he wants to shuffle words or get them sorted by the console
     */
     @Override
     public Character shuffleOrSort(){
         System.out.print("Press S for sorting or F for shuffling the sentence");
         keychecker.waitForRightKey();
         return keychecker.getKeyPressed();
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