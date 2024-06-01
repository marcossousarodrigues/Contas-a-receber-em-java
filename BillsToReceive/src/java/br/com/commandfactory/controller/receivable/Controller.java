/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.commandfactory.controller.receivable;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;

/**
 *
 * @author Marcos
 */
public class Controller {
    
    public Boolean verifyAuthentication(HttpServletRequest request, HttpServletResponse response){
       
       User user = (User) request.getSession().getAttribute("user");
       
       Boolean auth = false;
       
       try
       {
            if(user.getEmail() != null)
            {
              auth = true;
            }
            
       }
       catch(Exception e)
       {
           System.out.println("error: " + e.getMessage());
       }
       
       return auth;
    }
    
}
