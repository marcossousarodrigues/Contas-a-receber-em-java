/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.commandfactory.controller.user;

import br.com.commandfactory.controller.receivable.ICommand;
import dao.ProductDao;
import dao.UserDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import models.Product;
import models.User;
/**
 *
 * @author Marcos
 */
public class FindUserAction implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        try{
            String searchMessage = "";
            
            UserDao userDao = new UserDao();
            
            
            ArrayList<User> list = userDao.selectByField(request.getParameter("field"), 
                    request.getParameter("fieldValue"));
            
            searchMessage += list.size()+" Resultado(s) Correspondentes Para: ";
            searchMessage += " '"+request.getParameter("fieldValue")+"'";
            
            request.setAttribute("users", list); 
            request.setAttribute("searchMessage", searchMessage); 
            
        }
        catch(Exception e)
        {
            System.out.println("Error "+ e.getMessage());
        }
        
        return "pages/user/listUsers.jsp";
    }
}
