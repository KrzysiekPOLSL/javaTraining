package Tests;

import app.model.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.fail;

/**
 * Test case of shuffler methods
 * 
 * @author Krzysztof Poloczek
 * @version 2.1
 */
public class ShufflerTest {

    Shuffler shuffler = new Shuffler();
    
   
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
    
    @Test
    public void testEmptyUnsafeShuffle() {
        assertEquals("",shuffler.shuffleSentenceUnsafe(new String[0]));
    }
    
    @Test
    public void testEmptyUnsafeSort() {
        assertEquals("",shuffler.sortSentenceUnsafe(new String[0]));
    }
    
    @Test
    public void testNotSameAfterShuffle() throws NoSentenceException {
        String[] sentence = {"A", "b", "c"};
        assertNotSame("A b c d",shuffler.shuffleSentenceUnsafe(sentence));
        assertNotSame("A b c d",shuffler.shuffleSentence(sentence));
    }
    
    @Test
    public void testNotSameAfterSort() throws NoSentenceException {
        String[] sentence = {"A", "b", "c"};
        assertNotSame("A b c",shuffler.sortSentenceUnsafe(sentence));
        assertNotSame("A b c",shuffler.sortSentence(sentence));
    }
    
    @Test
    public void testSameAfterSort() throws NoSentenceException {
        String[] sentence = {"C", "b", "a"};
        assertEquals("A b c",shuffler.sortSentenceUnsafe(sentence));
        assertEquals("A b c",shuffler.sortSentence(sentence));
    }
 
}