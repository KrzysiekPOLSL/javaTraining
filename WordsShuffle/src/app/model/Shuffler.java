package app.model;

import app.model.utils.NoSentenceException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        for(int i = 0 ; i < sentence.length ; i++)
            sentence[i] = sentence[i].toLowerCase();
      
        Arrays.sort(sentence);
        sentence[0] = sentence[0].substring(0, 1).toUpperCase() + sentence[0].substring(1);
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
        List<String> strList = Arrays.asList(sentence);
        Collections.shuffle(strList);
        return String.join(" ", strList.toArray(new String[strList.size()]));
    }
}



