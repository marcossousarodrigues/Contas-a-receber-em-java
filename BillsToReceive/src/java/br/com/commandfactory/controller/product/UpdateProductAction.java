/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.commandfactory.controller.product;

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
public class UpdateProductAction implements ICommand {
     @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        ProductDao productDao = new ProductDao();
        Product product = new Product.ProductBuilder()
                .id(Integer.parseInt(request.getParameter("id")))
                .name(request.getParameter("name"))
                .description(request.getParameter("description"))
                .price(Double.parseDouble(request.getParameter("price")))
                .blocked(request.getParameter("blocked"))
                .build();
        
        try
        {
            productDao.update(product);
        }
        catch(Exception e)
        {
            
        }
        
        return "ProductController?action=ReadAll";
    }
}
