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
    /**
     * asking user if he wants to shuffle words or get them sorted by the console
     */
     @Override
     public char shuffleOrSort(){
         System.out.print("Press S for sorting or F for shuffling the sentence");
         return 'c';
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
    
    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
         char ch = ke.getKeyChar();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
