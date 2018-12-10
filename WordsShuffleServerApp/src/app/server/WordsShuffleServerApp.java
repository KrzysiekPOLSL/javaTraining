package app.server;

import app.model.NoSentenceException;
import app.model.Shuffler;
import java.net.*;
import java.io.*;
import java.util.Properties;

/**
 * The main class of the server
 *
 * @author Krzysztof Poloczek
 * @version 1.0
 */
public class WordsShuffleServerApp implements Closeable {

    /**
     * port number
     */
    private Integer PORT = 8888;
    
    /**
     * Properties of the server
     */
    private Properties properties = new Properties();

    /**
     * field represents the socket waiting for client connections
     */
    private ServerSocket serverSocket;

    /**
     * Creates the server socket
     *
     * @throws IOException when prot is already bind
     */
    WordsShuffleServerApp() throws IOException {
        /* reading properties from xml file*/
        try (FileInputStream in = new FileInputStream("server_properties.xml")) {
            properties.loadFromXML(in);
            PORT = Integer.parseInt(properties.getProperty("port"));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        serverSocket = new ServerSocket(PORT);
    }

    /**
     * The main application method
     *
     * @param args all parametres are ignored
     */
    public static void main(String args[]) {

        try (WordsShuffleServerApp tcpServer = new WordsShuffleServerApp()) {
            System.out.println("Server started");
            while (true) {
                Socket socket = tcpServer.serverSocket.accept();
                try (SingleService singleService = new SingleService(socket)) {
                    singleService.realize();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Closes server session
     * @throws IOException when input/output fails
     */
    @Override
    public void close() throws IOException {
        if (serverSocket != null) {
            serverSocket.close();
            /* initialization */
            properties = new Properties();
            properties.setProperty("port", Integer.toString(serverSocket.getLocalPort()));
            
            /* writing properties into xml file*/
            try (FileOutputStream out = new FileOutputStream("server_properties.xml")) {
                properties.storeToXML(out, "--Conf--");
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}

/**
 * The server class servicing a single connection
 */
class SingleService implements Closeable {
    
    /**
     * Enumeration that defines states of connection with client
     */
    enum CONNECTION_STATE{CONNECTED, INITIALIZED, CHOSEN_OPERATION, HELP}
    
    /**
     * Enumeration that defines of what is clinet's desired action
     */
    enum DESIRED_ACTION{NONE, SHUFFLE, SORT}
    
    /**
     * Variable that stores connection state
     */
    private CONNECTION_STATE connectionState;
    
    /**
     * Variable that stores desired action
     */
    private DESIRED_ACTION desiredAction;

    /**
     * socket representing connection to the client
     */
    private Socket socket;
    /**
     * buffered input character stream
     */
    private BufferedReader input;
    /**
     * Formatted output character stream
     */
    private PrintWriter output;
    /**
     * Application model
     */
    static private Shuffler shuffler = new Shuffler();

    /**
     * The constructor of instance of the SingleService class. Use the socket as
     * a parameter.
     *
     * @param socket socket representing connection to the client
     */
    public SingleService(Socket socket) throws IOException {
        this.socket = socket;
        output = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(
                                socket.getOutputStream())), true);
        input = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream()));
        connectionState = CONNECTION_STATE.CONNECTED;
        desiredAction = DESIRED_ACTION.NONE;
    }

    /**
     * Realizes the service
     */
    public void realize() {
        try {
            output.println("Welcome to Shuffle Sever, say anything to initialize app or type 'quit' to exit");

            while (true) {
                String str = input.readLine();
                output.println("Server answers to: " + str);
                if (str == null || str.toLowerCase().equals("quit")) {
                    break;
                }
                System.out.println("Client sent: " + str);
                if(str.toLowerCase().equals("-h")){
                    output.println(" Usage of program: "
                            + "Follow the steps that server gives you. "
                            + "First chooose if you want to shuffle or sort. "
                            + "After that type a sentence, and that's all ;)");
                }
                else{
                    switch(connectionState)
                    {
                        case CONNECTED:
                            connectionState = CONNECTION_STATE.INITIALIZED;
                            output.println("Please type 's' for sorting or 'f' for shuffling...");
                            break;
                            
                        case INITIALIZED:
                            if(str.length() > 1)
                            {
                                output.println("Wrong, you should type only one letter!");
                                break;
                            }   
                            else if(!str.toLowerCase().equals("f") && !str.toLowerCase().equals("s"))
                            {
                                 output.println("Wrong, 's' or 'f' only!");
                                 break;
                            }
                            else if("f".equals(str.toLowerCase()))
                                desiredAction = DESIRED_ACTION.SHUFFLE;
                            else desiredAction = DESIRED_ACTION.SORT;
                            
                            connectionState = CONNECTION_STATE.CHOSEN_OPERATION;
                            output.println("Thank you! Now type a sentence...");
                            break;
                            
                        case CHOSEN_OPERATION:
                            if(desiredAction == DESIRED_ACTION.SORT && str.length() > 0)
                                try {
                                    output.println(shuffler.sortSentence(str.split(" ")));
                            } catch (NoSentenceException ex) {
                                output.println(ex.getMessage());
                            }
                            else if (desiredAction == DESIRED_ACTION.SHUFFLE && str.length() > 0)
                                try {
                                    output.println(shuffler.shuffleSentence(str.split(" ")));
                            } catch (NoSentenceException ex) {
                                output.println(ex.getMessage());
                            }
                            else output.println("Type in a valid sentence!");

                            output.println("Press any key to refresh...");
                            connectionState = CONNECTION_STATE.CONNECTED;
                            desiredAction = DESIRED_ACTION.NONE;
                            break;
                    }
                }
            }
            System.out.println("closing...");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * Closes service session
     * @throws IOException when input/output fails
     */
    @Override
    public void close() throws IOException {
        if (socket != null) {
            socket.close();
        }
    }
}
