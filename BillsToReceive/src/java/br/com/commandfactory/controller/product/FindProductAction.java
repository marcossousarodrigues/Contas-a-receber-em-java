/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.commandfactory.controller.product;

import br.com.commandfactory.controller.receivable.ICommand;
import dao.ProductDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import models.Product;

/**
 *
 * @author Marcos
 */
public class FindProductAction implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        try{
            String searchMessage = "";
            
            ProductDao productDao = new ProductDao();
            
            
            ArrayList<Product> list = productDao
                    .selectByField(request.getParameter("field"), 
                    request.getParameter("fieldValue"));
            
            searchMessage += list.size()+" Resultado(s) Correspondentes Para: ";
            searchMessage += " '"+request.getParameter("fieldValue")+"'";
            
            request.setAttribute("products", list); 
            request.setAttribute("searchMessage", searchMessage); 
            
        }
        catch(Exception e)
        {
            System.out.println("Error "+ e.getMessage());
        }
        
        return "pages/product/listProduct.jsp";
    }
}
