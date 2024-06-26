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
public class DeleteClientAction implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        try{
            ClientDao clientDao = new ClientDao();
            Client client = new Client.ClientBuilder()
                    .id( Integer.parseInt(request.getParameter("id")))
                    .build();
            ClientDao.delete(client);
            
        }
        catch(Exception e)
        {
            
        }
        
        return "ClientController?action=ReadAll";
        
    }
    
    
}
