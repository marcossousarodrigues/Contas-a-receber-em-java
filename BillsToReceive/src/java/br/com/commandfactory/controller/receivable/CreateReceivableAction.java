/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.commandfactory.controller.receivable;

import dao.ClientDao;
import dao.NatureDao;
import dao.ProductDao;
import dao.ReceivableDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import models.Client;
import models.Debtors;
import models.Nature;
import models.Product;
import models.Receivable;
import models.User;
import utils.FactoryFormatTypes;

/**
 *
* @author Marcos
 */
public class CreateReceivableAction implements ICommand{
      
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
       
        User user = (User) request.getSession().getAttribute("user");
        
        FactoryFormatTypes formatTypes = new FactoryFormatTypes();
        
         try
        {
            ReceivableDao receivableDao = new ReceivableDao();
            
            Product product = ProductDao.selectProduct(formatTypes.formatInt(request.getParameter("product_id")));
            
            Nature nature = NatureDao.selectNature(formatTypes.formatInt(request.getParameter("nature_id")));
            
            Client client = ClientDao.selectClient(formatTypes.formatInt(request.getParameter("client_id")));
            
            Receivable receivable = new Receivable.ReceivableBuilder()
                    .title(request.getParameter("title"))
                    .installments(request.getParameter("installments"))
                    .titleType(request.getParameter("title_type"))
                    .title_value(formatTypes.formatDouble(request.getParameter("title_value")))
                    .dt_payment(formatTypes.formatDate(request.getParameter("dt_payment")))
                    .dt_expiration(formatTypes.formatDate(request.getParameter("dt_expiration")))
                    .form_of_payment(request.getParameter("form_of_payment"))
                    .pay(request.getParameter("pay"))
                    .dt_emission(formatTypes.formatDate(request.getParameter("dt_emission")))
                    .blocked(request.getParameter("blocked"))
                    .product(product)
                    .client(client)
                    .nature(nature)
                    .user(user)
                    .build();
     
            receivableDao.create(receivable); 
            
        }
        catch(Exception e){
             System.out.println("Error" + e.getMessage());
        }
        
        return "ReceivableController?action=ReadAll";
    }
    
    
}
