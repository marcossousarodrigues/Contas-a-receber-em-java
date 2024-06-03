/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.commandfactory.controller.client;
import br.com.commandfactory.controller.receivable.ICommand;
import dao.ClientDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Client;

/**
 *
 * @author Marcos
 */
public class ReadClientAction implements ICommand {
     @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        try{
             
            ClientDao clientDao = new ClientDao();
            int id = Integer.parseInt( request.getParameter("id"));
            
            Client client = clientDao.selectClient(id);
            
            request.setAttribute("clientEdit", client); 
           
        }
        catch(Exception e)
        {
            System.out.println("Error "+ e.getMessage());
        }
        
        return "pages/client/toEdit.jsp";
    }
}
