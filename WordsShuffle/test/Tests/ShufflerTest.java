/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import app.model.*;
import org.junit.*;
import static org.junit.Assert.fail;

/**
 *
 * @author Krzysief
 */
public class ShufflerTest {

    Shuffler shuffler;

    @Before
    public void setup() {
        shuffler = new Shuffler();
    }

    @Test
    public void testEmpty() {
         try{
             shuffler.sortSentence(new String[0]);
             fail("An exception should be thrown when the sentence is empty");
         }
         catch(NoSentenceException e)
         {
             System.out.println(e.toString());
         }
    }

   
}