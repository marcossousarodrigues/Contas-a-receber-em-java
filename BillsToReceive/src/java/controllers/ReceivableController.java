/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import br.com.commandfactory.controller.receivable.ICommand;
import dao.NatureDao;
import dao.ClientDao;
import dao.ProductDao;
import dao.ReceivableDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import models.Client;
import models.Nature;
import models.Product;
import models.Receivable;
import models.User;
import utils.FactoryFormatTypes;

/**
 *
 * @author Marcos
 */
@WebServlet(name = "ReceivableController", urlPatterns = {"/ReceivableController"})
public class ReceivableController extends HttpServlet {

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
            FactoryFormatTypes formatTypes = new FactoryFormatTypes();
            try {
                   
                String paramAction = request.getParameter("action");
                             
                String nomeDaClasse = "br.com.commandfactory.controller.receivable." + paramAction + "ReceivableAction";
               
                Class classeAction = Class.forName(nomeDaClasse);

                ICommand commandAction = (ICommand) classeAction.newInstance();

                String pageDispatcher = commandAction.execute(request, response);
                
                request.getRequestDispatcher("/"+pageDispatcher).forward(request, response);
                
              
                
            } catch (Exception ex) {
                System.out.println("Erro: " + ex.getMessage());
                request.setAttribute("erro", ex.getMessage());
               // request.getRequestDispatcher("erro.jsp").forward(request, response);
                response.getWriter().println("Erro "+ ex.getMessage());
            }
        }
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
