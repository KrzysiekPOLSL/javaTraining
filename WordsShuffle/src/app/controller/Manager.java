/**
 * Controlling the data flow in the program
 */
package app.controller;

import app.model.Shuffler;
import app.model.utils.NoSentenceException;
import app.view.console.ConsolePrinter;
import java.util.Objects;

/**
 * Manager is the controller class from MVC, it stands for managing the two others
 * which are Model (handling data) and View (displaying data)
 * 
 * @author Krzysztof Poloczek
 * @version 1.1
 */
public class Manager {
    /** Data that is provided to program */
    private String[] context;
    /** user desicion - sort or shuffle */
    private Character userDecision;
    /** object that handles computions */
    private Shuffler shuffler;
    /** object that is to communicate with user */
    private ConsolePrinter printer;
    /** sentence is the result of computing */
    private String sentence;
    /** true if caught an exception */
    private boolean wereErrors;
    
    /**
     * Constructor takes input data and initializes objects
     * @param args
     * @param sortingIndicator
     * @param shufflingIndicator 
     */
    public Manager(String[] args, Character sortingIndicator, Character shufflingIndicator)
    {
        this.context = args;
        printer = new ConsolePrinter(sortingIndicator, shufflingIndicator);
        shuffler = new Shuffler();
    }
    
    /**
     * core of the manager, handles information exchange between model and view
     */
    public void run(){
        userDecision = Character.toLowerCase(printer.shuffleOrSort()); //scan users decision
        try{
            if(Objects.equals(userDecision, printer.getShufflingIndicator())){
                this.sentence = shuffler.shuffleSentence(context);
             }
            else if(Objects.equals(userDecision, printer.getSortingIndicator())){
                this.sentence = shuffler.sortSentence(context);
            }
        }
        catch (NoSentenceException ex)
        {
            printer.displayExceptionMessage(ex.getMessage()); //provided data was empty
            wereErrors = true;
        } 
       
        if(!wereErrors) //normal workflow
            printer.displayResult(sentence);
        else {
            String[] newContext = printer.askForData(); //loop until user inserts any data
            if(Objects.equals(userDecision, printer.getShufflingIndicator())){
                this.sentence = shuffler.shuffleSentenceUnsafe(newContext);
            }
            else if(Objects.equals(userDecision, printer.getSortingIndicator())){
                this.sentence = shuffler.sortSentenceUnsafe(newContext);
                
                printer.displayResult(sentence);
            }
        }
            
    }
}
