/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.commandfactory.controller.receivable;

import dao.NatureDao;
import dao.ClientDao;
import dao.ProductDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import models.Client;
import models.Nature;
import models.Product;

/**
 *
 * @author Marcos
 */
public class AddReceivableAction implements ICommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {

            // resgatando o relacionamento entre tabelas
            ProductDao productDao = new ProductDao();
            NatureDao natureDao = new NatureDao();
            ClientDao clientDao = new ClientDao();

 
            ArrayList<Product> product = productDao.selectAll();
            ArrayList<Nature> nature = natureDao.selectAll();  
            ArrayList<Client> client = clientDao.selectAll();
            
            request.setAttribute("productAdd", product);
            request.setAttribute("natureAdd", nature);
            request.setAttribute("clientAdd", client);
           
        }
        catch(Exception e)
        {
            System.out.println("Error: "+ e.getMessage());
        }
        
        return "pages/aReceive/toAdd.jsp";
    }
    
}
