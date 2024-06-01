/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import br.com.commandfactory.controller.user.ICommand;
import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import models.User;

/**
 *
 * @author Marcos
 */
@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            try {
              
                String paramAction = request.getParameter("action");
             
                String className = "br.com.commandfactory.controller.user." + paramAction + "UserAction";
                

                Class classAction = Class.forName(className);

                ICommand commandAction = (ICommand) classAction.newInstance();

                String pageDispatcher = commandAction.execute(request, response);
                
                request.getRequestDispatcher("/" + pageDispatcher).forward(request, response);
               
               
                
            } catch (Exception ex) {
                System.out.println("Erro: " + ex.getMessage());
                request.setAttribute("erro", ex.getMessage());
                response.getWriter().println("Error "+ ex.getMessage());
               // request.getRequestDispatcher("erro.jsp").forward(request, response);
            }
        
        }
        

    }

    protected User loginUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String comfirPassword = request.getParameter("comfirPassword");
        
        User user = new User.UserBuilder().email(email).password(password).build();
        UserDao userDao = new UserDao();

        User usr = userDao.selectByEmail(user);
        
        User userRet = null;
        
        if(usr.getEmail() != null)
        {
            if(usr.getPassword().equals(user.getPassword()))
            {
               userRet = usr;
            }
        }
        
       
        return userRet;
    }

    protected void authUser(HttpServletRequest request, HttpServletResponse response, User user)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(); // Obtém a sessão do request
        
        User usr = new User.UserBuilder().name(user.getName()).email(user.getEmail()).build();
        
        session.setAttribute("user", usr);
        
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
