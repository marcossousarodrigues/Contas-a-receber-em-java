/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.commandfactory.controller.client;

import br.com.commandfactory.controller.receivable.ICommand;
import dao.ClientDao;
import dao.ProductDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import models.Client;
import models.Product;

/**
 *
 * @author Marcos
 */
public class FindClientAction implements ICommand {
     @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        try{
            String searchMessage = "";
            
            ClientDao clintDao = new ClientDao();
            
            
            ArrayList<Client> list = clintDao
                    .selectByField(request.getParameter("field"), 
                    request.getParameter("fieldValue"));
            
            searchMessage += list.size()+" Resultado(s) Correspondentes Para: ";
            searchMessage += " '"+request.getParameter("fieldValue")+"'";
            
            request.setAttribute("clients", list); 
            request.setAttribute("searchMessage", searchMessage); 
            
        }
        catch(Exception e)
        {
            System.out.println("Error "+ e.getMessage());
        }
        
        return "pages/client/listClients.jsp";
    }
}
