/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.commandfactory.controller.user;

import dao.NatureDao;
import dao.UserDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Nature;
import models.User;

/**
 *
 * @author Marcos
 */
public class DeleteUserAction implements ICommand {
     @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        try{
            UserDao userDao = new UserDao();
            User user = new User.UserBuilder()
                    .id( Integer.parseInt(request.getParameter("id")))
                    .build();
            
            userDao.delete(user);
            
        }
        catch(Exception e)
        {
            
        }
        
        return "UserController?action=ReadAll";
        
    }
}
