/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.commandfactory.controller.user;

import dao.NatureDao;
import dao.UserDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import models.Nature;
import models.User;

/**
 *
 * @author Marcos
 */
public class ReadAllUserAction implements ICommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        try{
            
            UserDao userDao = new UserDao();
            
            ArrayList<User> list = userDao.selectAll();
            
            request.setAttribute("users", list); 
           
        }
        catch(Exception e)
        {
            System.out.println("Error "+ e.getMessage());
        }
        
        return "pages/user/listUsers.jsp";
    }
}
