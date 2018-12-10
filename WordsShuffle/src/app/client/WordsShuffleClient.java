package app.client;

import java.net.*;
import java.io.*;
import java.util.Properties;

/** 
 * The TCP client class 
 * 
 * @author Krzysztof Poloczek
 * @version 1.2
 */
public class WordsShuffleClient implements Closeable {

    /** communication socket */
    private Socket Socket;
    /** server port number  */
    int PORT;
    /** server address */
    private InetAddress hostAddress;
     /** Properties of the client*/
    private Properties properties = new Properties();
    /** For handling input */
    BufferedReader in;
    /** For handling output */
    PrintWriter  out;
    
    /** 
     * The constructor of the TCP client object
     * @throws java.net.UnknownHostException
     * @throws java.io.FileNotFoundException
     */
    public WordsShuffleClient() throws UnknownHostException, IOException {
        
         /* reading properties from xml file*/
         boolean fileFound = true;
         try(FileInputStream propertiesInput = new FileInputStream("client_properties.xml")) {
             properties.loadFromXML(propertiesInput);
             PORT = Integer.parseInt(properties.getProperty("port"));
             hostAddress = InetAddress.getByName(properties.getProperty("address"));
         }
         catch (FileNotFoundException ex) {
             fileFound = false;
         }
         
        if(!fileFound){
            PORT = 8888;
            hostAddress = InetAddress.getByName("localhost");
        }
        
        Socket = new Socket(hostAddress, PORT);
       
        /* setting up streams */
        in = new BufferedReader(new InputStreamReader(Socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(Socket.getOutputStream())), true);
        
        in.readLine(); //consumes greeting
    }
    
    /**
     * Closes client session
     * @throws IOException 
     */
    @Override
    public void close() throws IOException {
        if (Socket != null) {
            Socket.close();
            /* initialization */
            properties = new Properties();
            properties.setProperty("port", Integer.toString(Socket.getLocalPort()));
            properties.setProperty("address", Socket.getInetAddress().getHostAddress());
            
            /* writing properties into xml file*/
            FileOutputStream propertiesOutput = new FileOutputStream("client_properties.xml"); 
            properties.storeToXML(propertiesOutput, "--Conf--");
        }
    }
    
    public String send(String s) throws IOException {
        out.println(s);
        in.readLine(); //server acknowlegde message only for debugging
        return in.readLine();
    }
    
    public String getAnswer() throws IOException{
        return in.readLine();
    }

    
}
