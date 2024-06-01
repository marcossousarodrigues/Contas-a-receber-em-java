/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.commandfactory.controller.client;

import dao.ClientDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import models.Client;

/**
 *
 * @author Marcos
 */
public class ReadAllClientAction implements ICommand {
    
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        
        try{
            
            ClientDao clientDao = new ClientDao();
            
            ArrayList<Client> list = clientDao.selectAll();
            
            request.setAttribute("clients", list); 
           
        }
        catch(Exception e)
        {
            System.out.println("Error "+ e.getMessage());
        }
        
        return "pages/client/listClients.jsp";
        
    }
    
}
