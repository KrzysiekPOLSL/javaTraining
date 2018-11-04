package app.tests;

import app.model.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
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
        assertEquals("Variable values ​​are not the same!","",shuffler.shuffleSentenceUnsafe(new String[0]));
    }
    
    @Test
    public void testEmptyUnsafeSort() {
        assertEquals("Variable values ​​are not the same!","",shuffler.sortSentenceUnsafe(new String[0]));
    }
    
    @Test
    public void testNotSameAfterShuffle() throws NoSentenceException {
        String[] sentence = {"A", "b", "c"};
        assertNotEquals("Variable values ​​are the same!","A b c",shuffler.shuffleSentenceUnsafe(sentence));
        sentence = new String[]{"A", "b", "c"};
        assertNotEquals("Variable values ​​are the same!","A b c",shuffler.shuffleSentence(sentence));
    }
    
    @Test
    public void testSameAfterSort() throws NoSentenceException {
        String[] sentence = {"C", "b", "a"};
        assertEquals("Variable values ​​are not the same!","A b c",shuffler.sortSentenceUnsafe(sentence));
        sentence = new String[]{"A", "b", "c"};
        assertEquals("Variable values ​​are not the same!","A b c",shuffler.sortSentence(sentence));
    }
    
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
 
}