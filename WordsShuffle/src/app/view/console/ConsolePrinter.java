/**
 * Console type of interface
 */
package app.view.console;

import app.interfaces.Displayer;
import app.view.utils.ShuffleSelector;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Printer is ment to communicate with the user
 * 
 * @author Krzysztof Poloczek
 * @version 2.1
 */
public class ConsolePrinter extends ShuffleSelector implements Displayer {
    
    /**
     * Constructs printer and initializes ShuffleSelector base class with given indicators
     * @param sortingIndicator Character that indicates sorting operation
     * @param shufflingIndicator Character that indicates shuffling operation
     */
    public ConsolePrinter(Character sortingIndicator, Character shufflingIndicator)
    {
      super(sortingIndicator, shufflingIndicator);
    }
    
    /**
     * Asks if user wants to shuffle words or get them sorted by the console
     * @return The intention of user wether to sort of shuffle
     */
     @Override
     public Character shuffleOrSort(){
         System.out.println("Press " + getSortingIndicator() + " for sorting or " + getShufflingIndicator() + " for shuffling the sentence");
         Character result = Character.MAX_VALUE;
         while(!isCharacterDesired(result)){
             try {
                 result = (char) System.in.read(); //getting character from console and cleaning the stream
                 System.in.read(); //consuming endline character
             } catch (IOException ex) {
                 Logger.getLogger(ConsolePrinter.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         return result;
     }
    /**
     * Prints out result of shuffling or sorting to console 
     * @param sentence Parameter that needs to be printed
     */
     @Override
    public void displayResult(String sentence){
        System.out.println("Changed sentence: " + sentence);    
    }
    
    /**
     * Notifies user about exception
     * @param message Message that will be printed
     */
    @Override
    public void displayExceptionMessage(String message) {
        System.err.println("An exception occoured, message: " + message);
    }
    
    /**
     * Loop that waits untill user provides not empty data
     * @return Data given by user
     */
    @Override
    public String[] askForData() {
        String[] data = new String[0];
        String temp; //temporary string for user input
        while(data.length == 0){
            System.out.println("Please write down a sentence and press ENTER");
            Scanner scanner = new Scanner(System. in);
            temp = scanner. nextLine();
            if(!temp.isEmpty())
                data = temp.split(" ");
        }
        return data;
    }
}