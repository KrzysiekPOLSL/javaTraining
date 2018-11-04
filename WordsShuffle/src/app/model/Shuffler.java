/**
 * Computing data
 */
package app.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Shuffler sets words in random positions in sentence or sorts them by first letters
 * 
 * @author Krzysztof Poloczek
 * @version 1.2
 */
public class Shuffler {
    
     /**
      * Safe method that sorts the provided sentence by first letter of each word
      * @param sentence Data that will be sorted
      * @return Sorted data
     * @throws app.model.NoSentenceException Exception that occurs when there is no data
      */
    public String sortSentence(String[] sentence) throws NoSentenceException {
        if(sentence.length == 0)
            throw new NoSentenceException("Sentence cannot be empty!");
        return sortSentenceUnsafe(sentence);
    }
    
    /**
     * Unsafe version of sortSentence member function, has use only if provided data is not empty
     * @param sentence Data that will by sorted
     * @return Sorted data
     */
    public String sortSentenceUnsafe(String[] sentence){
        for(int i = 0 ; i < sentence.length ; i++)
            sentence[i] = sentence[i].toLowerCase(); //lowercase all sentence
        
        List<String> strList = Arrays.asList(sentence);
        Collections.sort(strList); //sorting
        if(sentence[0].length() > 0)
            sentence[0] = sentence[0].substring(0, 1).toUpperCase() + sentence[0].substring(1); //adding uppercase to the first letter of the sentence
        return String.join(" ", strList.toArray(new String[strList.size()])); //converting list to string
    }
    
    /**
     * Safe method that randomly shuffles the provided sentence
     * @param sentence Data that will be shufled
     * @return Shuffled data
     * @throws app.model.NoSentenceException Exception that occurs when there is no data
     */
    public String shuffleSentence(String[] sentence) throws NoSentenceException {
        if(sentence.length == 0)
            throw new NoSentenceException("Sentence cannot be empty!");
        return shuffleSentenceUnsafe(sentence);
    }
    
    /**
     * Unsafe version of shuffleSentence member function, has use only if provided data is not empty
     * @param sentence Data that will be shufled
     * @return Shuffled data
     */
    public String shuffleSentenceUnsafe(String[] sentence){
        for(int i = 0 ; i < sentence.length ; i++)
            sentence[i] = sentence[i].toLowerCase(); //lowercase all sentence
        
        List<String> strList = Arrays.asList(sentence);
        Collections.shuffle(strList); //shuffling sentence
        if(sentence[0].length() > 0)
            sentence[0] = sentence[0].substring(0, 1).toUpperCase() + sentence[0].substring(1); //adding uppercase to the first letter of the sentence
        return String.join(" ", strList.toArray(new String[strList.size()])); //converting list to string
    }
}



