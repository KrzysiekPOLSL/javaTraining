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
 * @version 1.1
 */
public class ConsolePrinter extends ShuffleSelector implements Displayer {
    
    /**
     * Constructs printer and initializes ShuffleSelector base class with given indicators
     * @param sortingIndicator
     * @param shufflingIndicator
     */
    public ConsolePrinter(Character sortingIndicator, Character shufflingIndicator)
    {
      super(sortingIndicator, shufflingIndicator);
    }
    
    /**
     * Asks user if user wants to shuffle words or get them sorted by the console
     */
     @Override
     public Character shuffleOrSort(){
         System.out.println("Press " + getSortingIndicator() + " for sorting or " + getShufflingIndicator() + " for shuffling the sentence");
         Character result = Character.MAX_VALUE;
         while(!isCharacterDesired(result)){
             try {
                 result = (char) System.in.read(); //getting character from console and cleaning the stream
                 Character enterConsumer = (char) System.in.read();
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
        System.out.println("Changed sentence: " + sentence);    
    }
    
    /**
     * Notifies user about exception
     * @param message 
     */
    @Override
    public void displayExceptionMessage(String message) {
        System.out.println("An exception occoured, message: " + message);
    }
    
    /**
     * Loop that waits untill user provides not empty data
     * @return 
     */
    @Override
    public String[] askForData() {
        String[] data = new String[0];
        String temp = new String(); //temporary string for user input
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