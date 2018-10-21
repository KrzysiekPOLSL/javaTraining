package app.model;

import app.model.utils.NoSentenceException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Shuffler sets words in random positions in sentence or sorts them by first letters
 * 
 * @author Krzysztof Poloczek
 * @version 1.1
 */
public class Shuffler {
    
     /**
      * Safe method that sorts the provided sentence by first letter of each word
      * @param sentence
      * @return 
     * @throws app.model.utils.NoSentenceException 
      */
    public String sortSentence(String[] sentence) throws NoSentenceException {
        if(sentence.length == 0)
            throw new NoSentenceException("Sentence cannot be empty!");
        return sortSentenceUnsafe(sentence);
    }
    
    /**
     * Unsafe version of sortSentence member function, has use only if provided data is not empty
     * @param sentence
     * @return 
     */
    public String sortSentenceUnsafe(String[] sentence){
        for(int i = 0 ; i < sentence.length ; i++)
            sentence[i] = sentence[i].toLowerCase(); //lowercase all sentence
      
        Arrays.sort(sentence); //sorting
        sentence[0] = sentence[0].substring(0, 1).toUpperCase() + sentence[0].substring(1); //adding uppercase to the first letter of the sentence
        return String.join(" ", sentence); //converting array yo string
    }
    
    /**
     * Safe method that randomly shuffles the provided sentence
     * @param sentence
     * @return 
     * @throws app.model.utils.NoSentenceException 
     */
    public String shuffleSentence(String[] sentence) throws NoSentenceException {
        if(sentence.length == 0)
            throw new NoSentenceException("Sentence cannot be empty!");
        return shuffleSentenceUnsafe(sentence);
    }
    
    /**
     * Unsafe version of shuffleSentence member function, has use only if provided data is not empty
     * @param sentence
     * @return 
     */
    public String shuffleSentenceUnsafe(String[] sentence){
        List<String> strList = Arrays.asList(sentence);
        Collections.shuffle(strList); //shuffling sentence
        return String.join(" ", strList.toArray(new String[strList.size()])); //converting list to string
    }
}



