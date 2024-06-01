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
public class CreateUserAction implements ICommand {
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        UserDao userDAO = new UserDao();
            
        User user = new User.UserBuilder()
                .name(request.getParameter("name"))
                .surname(request.getParameter("surname"))
                .email(request.getParameter("email"))
                .password(request.getParameter("password"))
                .permission(request.getParameter("permission"))
                .blocked(request.getParameter("blocked"))
                .build();
        try
        {
            userDAO.create(user);
            
        }catch(Exception e ) {
            System.out.println("Erro: " + e.getMessage());
        }
       
        return "UserController?action=ReadAll";
           
    }
}
