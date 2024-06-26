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
import java.util.Date;
import models.Client;
import models.Nature;
import models.Product;
import models.Receivable;
import utils.FactoryFormatTypes;

/**
 *
 * @author Marcos
 */
public class UpdatePaymentReceivableAction implements ICommand{
      @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        FactoryFormatTypes formatTypes = new FactoryFormatTypes();
        try
        {
            ReceivableDao receivableDao = new ReceivableDao();
            
            Receivable receivable = ReceivableDao.selectReceivable(Integer.parseInt(request.getParameter("id")));
            
            receivable.setPay("1"); 
            receivable.setDt_payment(new Date()); 
            
            receivableDao.update(receivable); 
            
        }
        catch(Exception e){
             System.out.println("Error" + e.getMessage());
        }
        
        return "ReceivableController?action=ReadAll";
 
    }
    
    
    
}
