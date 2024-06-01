/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.commandfactory.controller.receivable;

import dao.ProductDao;
import dao.ReceivableDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import models.Product;
import models.Receivable;

/**
 *
 * @author Marcos
 */
public class FindReceivableAction implements ICommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        try{
            String searchMessage = "";
            
            ReceivableDao receivableDao = new ReceivableDao();
            
            
            ArrayList<Receivable> list = receivableDao
                    .selectByField(request.getParameter("field"), 
                    request.getParameter("fieldValue"));
            
            searchMessage += list.size()+" Resultado(s) Correspondentes Para: ";
            searchMessage += " '"+request.getParameter("fieldValue")+"'";
            
            request.setAttribute("receivable", list); 
            request.setAttribute("searchMessage", searchMessage); 
            
        }
        catch(Exception e)
        {
            System.out.println("Error "+ e.getMessage());
        }
        
        return "pages/aReceive/listReceived.jsp";
    }
    
    
}
