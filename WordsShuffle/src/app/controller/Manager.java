/**
 * Controlling the data flow in the program
 */
package app.controller;

import app.client.WordsShuffleClient;
import app.view.console.ConsolePrinter;
import java.io.IOException;
import java.net.UnknownHostException;

/**
 * Manager is the controller class from MVC, it stands for managing the two others
 * which are Model (handling data) and View (displaying data)
 * 
 * @author Krzysztof Poloczek
 * @version 2.1
 */
public class Manager {
    /** Data that is provided to program */
    private String[] context;
    /** User desicion - sort or shuffle */
    private Character userDecision;
    /** Object that handles computions */
    private WordsShuffleClient connector;
    /** Object that is to communicate with user */
    private ConsolePrinter printer;
    /** Sentence is the result of computing */
    private String sentence;
    /** True if caught an exception */
    private boolean wereErrors;
    
    /**
     * Constructor takes input data and initializes objects
     * @param args Sentence to be processed 
     * @param sortingIndicator Character that indicates sorting operation
     * @param shufflingIndicator Character that indicates shuffling operation
     */
    public Manager(String[] args, Character sortingIndicator, Character shufflingIndicator)
    {
        this.context = args;
        printer = new ConsolePrinter(sortingIndicator, shufflingIndicator);
        try {
            connector = new WordsShuffleClient();
        } catch (UnknownHostException ex) {
            printer.displayExceptionMessage(ex.getMessage());
        } catch (IOException ex) {
             printer.displayExceptionMessage(ex.getMessage());
        }
    }
    
    /**
     * Core of the manager, handles information exchange between model and view
     */
    public void run(){
        try {
            connector.send("Hi");
        } catch (IOException ex) {
            printer.displayExceptionMessage(ex.getMessage());
        }
        userDecision = Character.toLowerCase(printer.shuffleOrSort()); //scan users decision
        try{
           connector.send(userDecision.toString());
        }
        catch (IOException ex)
        {
            printer.displayExceptionMessage(ex.getMessage()); //provided data was empty
        } 
        
        if(this.context == null || this.context.length == 0)
            this.context = printer.askForData();
        
        try {
            printer.displayResult(connector.send(String.join((" "),this.context)));
        } catch (IOException ex) {
            printer.displayExceptionMessage(ex.getMessage());
        }
        
        try {
            connector.send("quit");
        } catch (IOException ex) {
           printer.displayExceptionMessage(ex.getMessage());
        }
            
    }
}
