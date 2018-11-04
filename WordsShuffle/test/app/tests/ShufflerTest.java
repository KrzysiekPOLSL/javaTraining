package app.tests;

import app.model.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.either;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Test case of shuffler methods
 * 
 * @author Krzysztof Poloczek
 * @version 2.1
 */
public class ShufflerTest {
    
    
    Shuffler shuffler = new Shuffler();
   
    
    /**
     * Makes sentence from given set of strings
     * 
     * @param words set of strings
     * @return sentence made from strings
     */
    String[] makeSentence(String... words) {
        return words;
    }

    /**
     * Testing empty sentence case
     */
    @Test
    public void testEmptySafeSort() {
         try{
             shuffler.sortSentence(new String[0]);
             fail("An exception should be thrown when the sentence is empty");
         }
         catch(NoSentenceException e)
         {
             System.out.println(e.toString());
         }
    }
    
    /**
     * Testing empty sentence case
     */
    @Test
    public void testEmptySafeShuffle() {
         try{
             shuffler.shuffleSentence(new String[0]);
             fail("An exception should be thrown when the sentence is empty");
         }
         catch(NoSentenceException e)
         {
             System.out.println(e.toString());
         }
    }
    
    /**
     * Testing empty sentence case
     */
    @Test
    public void testEmptyUnsafeShuffle() {
        assertEquals("Variable values ​​are not the same!","",shuffler.shuffleSentenceUnsafe(new String[0]));
    }
    
    /**
     * Testing empty sentence case
     */
    @Test
    public void testEmptyUnsafeSort() {
        assertEquals("Variable values ​​are not the same!","",shuffler.sortSentenceUnsafe(new String[0]));
    }
    
    /**
     * Testing all cases pf shuffling sentence
     */
    @Test
    public void testAfterShuffleResult() throws NoSentenceException {
        String[] sentence = makeSentence("A", "b", "c");
        String result = shuffler.shuffleSentenceUnsafe(sentence);
        assertEquals("Variable values ​​are not the same!", 5, result.length());
        assertThat(result,
               either(containsString("A b c")).
               or(containsString("A c b")).
               or(containsString("B a c")).
               or(containsString("B c a")).
               or(containsString("C a b")).
               or(containsString("C b a"))
        ); 
        
        sentence = makeSentence("A", "b", "c");
        result = shuffler.shuffleSentence(sentence);
        assertEquals("Variable values ​​are not the same!", 5, result.length());
        assertThat(result,
               either(containsString("A b c")).
               or(containsString("A c b")).
               or(containsString("B a c")).
               or(containsString("B c a")).
               or(containsString("C a b")).
               or(containsString("C b a"))
        );
    }
    
    /**
     * Testing if sorting is working
     */
    @Test
    public void testSameAfterSort() throws NoSentenceException {
        String[] sentence = makeSentence("C", "b", "a");
        assertEquals("Variable values ​​are not the same!","A b c",shuffler.sortSentenceUnsafe(sentence));
        sentence = makeSentence("C", "b", "a");
        assertEquals("Variable values ​​are not the same!","A b c",shuffler.sortSentence(sentence));
    }
    
    /**
     * Testing if sorting is working
     */
     @Test
    public void testNotSameAfterSort() throws NoSentenceException {
        String[] sentence = makeSentence("C", "b", "a");
        assertNotEquals("Variable values ​​arecthe same!","C b a",shuffler.sortSentenceUnsafe(sentence));
        sentence = makeSentence("C", "b", "a");
        assertNotEquals("Variable values ​​are the same!","C b a",shuffler.sortSentence(sentence));
    }
    
    /**
     * Testing handling situation when there is only space
     */
    @Test
    public void testSpaceOnly() throws NoSentenceException {
        String[] sentence = {" "};
        assertEquals("Variable values ​​are not the same!"," ",shuffler.sortSentenceUnsafe(sentence));
        sentence = new String[]{" "};
        assertEquals("Variable values ​​are not the same!"," ",shuffler.sortSentence(sentence));
        sentence = new String[]{" "};
        assertEquals("Variable values ​​are not the same!"," ",shuffler.shuffleSentenceUnsafe(sentence));
        sentence = new String[]{" "};
        assertEquals("Variable values ​​are not the same!"," ",shuffler.shuffleSentence(sentence));
    }
    
    /**
     * Testing handling one character
     */
     @Test
    public void testOneCharacter() throws NoSentenceException {
        String[][] sentences;
        sentences = new String[3][1];
        sentences[0] = new String[]{"a"};
        sentences[1] = new String[]{"b"};
        sentences[2] = new String[]{"c"};
        
        for(String[] sentence: sentences){
            String s = String.join("", sentence).toUpperCase();
            assertEquals("Variable values ​​are not the same!", s, shuffler.sortSentenceUnsafe(sentence));
            assertEquals("Variable values ​​are not the same!", s, shuffler.sortSentence(sentence));
            assertEquals("Variable values ​​are not the same!", s, shuffler.shuffleSentenceUnsafe(sentence));
            assertEquals("Variable values ​​are not the same!", s, shuffler.shuffleSentenceUnsafe(sentence));
        }
        
        sentences[0] = new String[]{"A"};
        sentences[1] = new String[]{"B"};
        sentences[2] = new String[]{"C"};
        
        for(String[] sentence: sentences){
            String s = String.join("", sentence);
            assertEquals("Variable values ​​are not the same!", s, shuffler.sortSentenceUnsafe(sentence));
            assertEquals("Variable values ​​are not the same!", s, shuffler.sortSentence(sentence));
            assertEquals("Variable values ​​are not the same!", s, shuffler.shuffleSentenceUnsafe(sentence));
            assertEquals("Variable values ​​are not the same!", s, shuffler.shuffleSentenceUnsafe(sentence));
        }
    }
}