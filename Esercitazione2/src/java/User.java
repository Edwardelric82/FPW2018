 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import fpw.news.UtenteFactory;
import fpw.news.Utente;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sary
 */
public class User extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
        
        request.setAttribute("isLogged", false);

        if (session == null) 
        {
            //Se non c'è la sessione
            request.setAttribute("isLogged", false);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        else if (session.getAttribute("loggedIn") != null &&
                 !session.getAttribute("loggedIn").equals(true))
        {
            //loggedIn non vale true
            request.setAttribute("isLogged", false);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        else if (session.getAttribute("loggedIn") == null)
        {
            //non c'è loggedIn
            request.setAttribute("isLogged", false);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }


        UtenteFactory user_factory = UtenteFactory.getInstance();

        int idUtente = (int)session.getAttribute("userId");
        Utente user = user_factory.getUtenteById(idUtente);

        String name = user.getNome();
        String surname = user.getCognome();
        String email = user.getEmail();

        request.setAttribute("name", name);
        request.setAttribute("surname", surname);
        request.setAttribute("email", email);
        request.setAttribute("isLogged", true);

            
        request.getRequestDispatcher("utente.jsp").forward(request,response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}