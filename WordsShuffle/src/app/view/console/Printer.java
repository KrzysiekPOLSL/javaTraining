package app.view.console;

import app.interfaces.Displayer;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

/**
 *
 * Printer is ment to communicate with the user
 */
public class Printer implements Displayer {
    public KeyChecker keychecker;
    /**
     * asking user if he wants to shuffle words or get them sorted by the console
     */
     @Override
     public char shuffleOrSort(){
         System.out.print("Press S for sorting or F for shuffling the sentence");
         keychecker.waitForRightKey();
         return keychecker.getKeypressed();
     }
    /**
     * prints out result of shuffling or sorting to console 
     */
     @Override
    public void displayResult(List<String> words){
        String joined = String.join(" ", words);
        System.out.print("Changed sentence: " + joined);    
    }
}

class KeyChecker implements KeyListener {
    
    private char keypressed;
    private boolean wasKeyPressed;
    
    public char getKeypressed(){
        return keypressed;
    }
    
    public boolean getWasKeyPressed(){
        return wasKeyPressed;
    }
    
    public void waitForRightKey(){
        while(!getWasKeyPressed()) {}
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("'keyTyped not supported yet."); 
    }

    @Override
    public void keyPressed(KeyEvent ke) {
         keypressed = ke.getKeyChar();
         wasKeyPressed = true;
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("keyReleased not supported yet."); 
    }
}
