package app.view.utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Objects;

/**
 * Simple class that realizes taking characters from keyboard
 */
public class KeyChecker implements KeyListener {
    
    /**
     * Constructor takes the list of characters that should be noticed
     * @param desiredCharacters 
     */
    public KeyChecker(List<Character> desiredCharacters)
    {
        this.desiredCharacters = desiredCharacters;
    }
    
    /**
     * Holds the value of the noticed key
     */
    private Character keypressed;
    /**
     * Notifies if was the proper key pressed
     */
    private boolean wasRightKeyPressed;
    /**
     * List of characters desired by programmer
     */
    private List<Character> desiredCharacters;
    
    /**
     * getter to the wasRightKeyPressed variable
     * @return 
     */
    private boolean getWasRightKeyPressed(){
        return wasRightKeyPressed;
    }
    
    /**
     * getter to the keypressed variable
     * @return 
     */
    public Character getKeyPressed(){
        return keypressed;
    }
   
    /**
     * Loop that waits for one of the desired keys to pe pressed
     */
    public void waitForRightKey(){
        while(!getWasRightKeyPressed()) {}
    }
    
    /**
     * Unsuppoerted part of KeyListener interface, don't needed so far
     * @param ke 
     */
    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("'keyTyped not supported yet."); 
    }

    /**
     * Noticing when one of the desired keys was hit on the keyboard
     * @param ke 
     */
    @Override
    public void keyPressed(KeyEvent ke) {
         keypressed = ke.getKeyChar();
         for(int i = 0; i < desiredCharacters.size(); i++){
             if(Objects.equals(keypressed, desiredCharacters.get(i))){
                  wasRightKeyPressed = true;
             }
         }
    }

    /**
     * Noticing when one of the desired keys was released
     * @param ke 
     */
    @Override
    public void keyReleased(KeyEvent ke) {
        keypressed = Character.MIN_VALUE;
        wasRightKeyPressed = false;
    }
}

