package app.model;

import app.model.utils.NoSentenceException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * Shuffler sets words in random positions in sentence or sorts them by first letters
 */
public class Shuffler {
    
     /**
      * 
      * @param sentence
      * @return 
      */
    public String sortSentence(String[] sentence) throws NoSentenceException {
        if(sentence.length == 0)
            throw new NoSentenceException("Sentence cannot be empty!");
        Arrays.sort(sentence);
        return String.join(" ", sentence);
    }
    
    /**
     * 
     * @param sentence
     * @return 
     */
    public String shuffleSentence(String[] sentence) throws NoSentenceException {
        if(sentence.length == 0)
            throw new NoSentenceException("Sentence cannot be empty!");
        Random random = new Random();
        for(int i =0; i < sentence.length ; i++){
            int index = random.nextInt(i + 1);
            String s = sentence[index];
            sentence[index] = sentence[i];
            sentence[i] = s;
        }
        return String.join(" ", sentence);
    }
}



