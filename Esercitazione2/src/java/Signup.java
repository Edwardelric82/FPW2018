/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fpw.news.UtenteFactory;

/**
 *
 * @author Sary
 */
@WebServlet(urlPatterns = {"/Signup"})
public class Signup extends HttpServlet {

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
        
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("surname");
        String email = request.getParameter("email");
        String urlImgProfile = request.getParameter("urlImgProfile");
        String psw = request.getParameter("psw");
        
        System.out.println(nome);
        System.out.println(cognome);
        System.out.println(email);
        System.out.println(urlImgProfile);
        System.out.println(psw);
        
        if(nome != null &&
           cognome != null &&
           email != null &&
           psw != null &&
           urlImgProfile != null)
        {
            System.out.println("Qui inserisce nuovo utente");
            
            UtenteFactory user_factory = UtenteFactory.getInstance();
            //Chiama il metodo della factory per l'inserimento nel db di un nuovo utente
            user_factory.insertUser(nome, cognome, email, psw, urlImgProfile);
      
            
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
           
        
        request.getRequestDispatcher("signup.jsp").forward(request,response);
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
