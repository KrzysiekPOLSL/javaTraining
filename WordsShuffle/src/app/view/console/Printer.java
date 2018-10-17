package app.view.console;

import app.interfaces.Displayer;
import app.view.utils.KeyChecker;


/**
 *
 * Printer is ment to communicate with the user
 */
public class Printer implements Displayer {
    private KeyChecker keychecker;
    /**
     * asking user if he wants to shuffle words or get them sorted by the console
     */
     @Override
     public Character shuffleOrSort(){
         System.out.print("Press S for sorting or F for shuffling the sentence");
         keychecker.waitForRightKey();
         return keychecker.getKeyPressed();
     }
    /**
     * prints out result of shuffling or sorting to console 
     */
     @Override
    public void displayResult(String sentence){
        System.out.print("Changed sentence: " + sentence);    
    }
}