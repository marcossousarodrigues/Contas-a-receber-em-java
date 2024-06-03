/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.commandfactory.controller.user;

import br.com.commandfactory.controller.receivable.ICommand;
import dao.UserDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;

/**
 *
 * @author Marcos
 */
public class UpdateUserAction implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        
        try
        {
        UserDao userDao = new UserDao();
        User user = new User.UserBuilder()
                .id(Integer.parseInt(request.getParameter("id")))
                .name(request.getParameter("name"))
                .surname(request.getParameter("surname"))
                .email(request.getParameter("email"))
                .password(request.getParameter("password"))
                .permission(request.getParameter("permission"))
                .blocked(request.getParameter("blocked"))
                .build();
        
            userDao.update(user);
        }
        catch(Exception e)
        {
            
        }
        
        return "UserController?action=ReadAll";
    }
}
