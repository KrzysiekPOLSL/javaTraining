package pl.polsl.lab.servlets;

import app.model.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Date;

/**
 * Main class of the servlet that handles computions and model operations
 * 
 * @author Krzysztof Poloczek
 * @version 1.0
 */
public class HandleSentence extends HttpServlet {

    /** Model of the application, handles computions */
    static Shuffler shuffler = new Shuffler();
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param req servlet request
     * @param resp servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        HttpSession session = req.getSession(true);
        String action = req.getParameter("choice");
        String sentence = req.getParameter("sentence");
        boolean sort = false;
        
        Date firstDate;
        Object obj = session.getAttribute("first date");
        if(obj == null)
               firstDate = new Date();
        else 
            firstDate = (Date) obj;
      
        if (action.equals("sort"))
            sort = true;
       
       PrintWriter out = resp.getWriter();
       resp.setContentType("text/plain; charset=ISO-8859-2");
        try {
            String result;
            if(sort)
                result = shuffler.sortSentence(sentence.split(" "));
            else result = shuffler.shuffleSentence(sentence.split(" "));
            out.println("Sentence: " + result);
            Cookie cookie = new Cookie("Sentence", result);
            resp.addCookie(cookie);
        } catch (NoSentenceException ex) {
            out.println(ex.toString());
        }  
        
        session.setAttribute("first date", firstDate);
        out.println("First date of the operation in this session: " + firstDate.toString());
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param req servlet request
     * @param resp servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req,resp);
    }
}
