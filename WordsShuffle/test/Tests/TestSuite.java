package Tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test suite indicting the test engine and classes containg unit tests.
 * 
 * @author Krzysztof Poloczek
 * @version 2.1
 */
@RunWith(Suite.class)
@SuiteClasses({
    ShufflerTest.class})
public class TestSuite {
}
