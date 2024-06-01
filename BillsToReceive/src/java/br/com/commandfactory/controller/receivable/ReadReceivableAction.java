/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.commandfactory.controller.receivable;

import dao.NatureDao;
import dao.ClientDao;
import dao.ProductDao;
import dao.ReceivableDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import models.Client;
import models.Debtors;
import models.Nature;
import models.Product;
import models.Receivable;

/**
 *
 * @author Marcos
 */
public class ReadReceivableAction implements ICommand {
    
     @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
         // resgatando o relacionamento entre tabelas
            int id = Integer.parseInt( request.getParameter("id"));
            ProductDao productDao = new ProductDao();
            NatureDao natureDao = new NatureDao();
            ClientDao clientDao = new ClientDao();
            
            ReceivableDao recevableDao = new ReceivableDao();
            
            Receivable recev = recevableDao.selectReceivable(id);
            
             
            ArrayList<Product> productEdit = productDao.selectAll();
            ArrayList<Nature> natureEdit = natureDao.selectAll();  
            ArrayList<Client> clientEdit = clientDao.selectAll();
            
            request.setAttribute("receivableEdit", recev);
            request.setAttribute("productEdit", productEdit);
            request.setAttribute("natureEdit", natureEdit);
            request.setAttribute("clientEdit", clientEdit);
            
        } 
        catch(Exception e)
        {
                
        }
        
        return "pages/aReceive/toEdit.jsp";
    }
    
}
