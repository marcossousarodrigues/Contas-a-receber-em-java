/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.commandfactory.controller.user;

import dao.UserDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.User;

/**
 *
 * @author Marcos
 */
public class LogoutUserAction implements ICommand {
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {

        try
        {
            HttpSession session = request.getSession(false);
            
            if (session != null) {
                session.invalidate();
            }
            
         
        }catch(Exception e ) {
            System.out.println("Erro: " + e.getMessage());
        }
       
        return "UserController?action=ReadAll";
           
    }
}
