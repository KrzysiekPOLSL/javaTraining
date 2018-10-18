package app.controller;

import app.model.Shuffler;
import app.model.utils.NoSentenceException;
import app.view.console.ConsolePrinter;
import java.util.Objects;

/**
 *
 * Manager is the controller class from MVC, it stands for managing the two others
 * which are Model (handling data) and View (displaying data)
 */
public class Manager {
    private String[] context;
    private Character userDecision;
    private Shuffler shuffler;
    private ConsolePrinter printer;
    private String sentence;
    private boolean wereErrors;
    
    public Manager(String[] args, Character sortingIndicator, Character shufflingIndicator)
    {
        this.context = args;
        printer = new ConsolePrinter(sortingIndicator, shufflingIndicator);
        shuffler = new Shuffler();
    }
    
    public void run(){
        userDecision = Character.toLowerCase(printer.shuffleOrSort());
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
            printer.displayExceptionMessage(ex.getMessage());
            wereErrors = true;
        }
       
        if(!wereErrors)
            printer.displayResult(sentence);
    }
}
