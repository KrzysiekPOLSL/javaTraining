/**
 * Main program
 */
package app.wordsshuffle.main;

import app.controller.Manager;

/**
 * Main class of the program
 * 
 *  @author Krzysztof Poloczek
 *  @version 1.1
 */
public class WordsShuffle {

    /**
     * Main method of program
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        Manager manager = new Manager(args, 's', 'f'); //initializing and running application's manager
        manager.run();
    }
    
}
