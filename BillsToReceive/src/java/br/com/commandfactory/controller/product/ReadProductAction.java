/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.commandfactory.controller.product;


import br.com.commandfactory.controller.receivable.ICommand;
import dao.NatureDao;
import dao.ProductDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Nature;
import models.Product;

/**
 *
 * @author Marcos
 */
public class ReadProductAction implements ICommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        try{
             
            ProductDao productDao = new ProductDao();
            int id = Integer.parseInt( request.getParameter("id"));
            
            Product product = productDao.selectProduct(id);
            
            request.setAttribute("productEdit", product); 
           
        }
        catch(Exception e)
        {
            System.out.println("Error "+ e.getMessage());
        }
        
        return "pages/product/toEdit.jsp";
    }
}
