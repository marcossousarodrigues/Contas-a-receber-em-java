/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.commandfactory.controller.user;

import br.com.commandfactory.controller.receivable.ICommand;
import dao.UserDao;
import decorator.auth.user.BaseNotification;
import decorator.auth.user.BlockNotification;
import decorator.auth.user.BlockedPasswordErrorNotification;
import decorator.auth.user.EmailErrorNotification;
import decorator.auth.user.INotification;
import decorator.auth.user.InactivityLockNotification;
import decorator.auth.user.PasswordErrorNotification;
import decorator.auth.user.UnauthenticatedNotification;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;
import models.User;
import utils.FactoryFormatTypes;

/**
 *
 * @author Marcos
 */
public class AuthUserAction implements ICommand {
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        FactoryFormatTypes formatTypes = new FactoryFormatTypes();
        UserDao userDAO = new UserDao();
        
        // notificações de feedback
        String redirect = "pages/user/login.jsp";
        
        INotification notification = new BaseNotification();
            
        User user = new User.UserBuilder()
                .email(request.getParameter("email"))
                .password(request.getParameter("password"))
                .blocked(request.getParameter("blocked"))
                .build();
        try
        {
            User userAuth = userDAO.selectByEmail(user);
           
            if( user.getEmail().equals(userAuth.getEmail()) && 
                user.getPassword().equals(userAuth.getPassword()) && 
                userAuth.getBlocked().equals("2") &&
                userAuth.getDtAccess().after(formatTypes.dateMinus7Days(new Date(), 7))
               )
            {
                HttpSession session = request.getSession();
                session.setAttribute("user", userAuth);
                
                userAuth.setDtAccess(new Date());
                userDAO.update(userAuth);
                
                redirect = "index.jsp";
            }
            else
            { 
                // notificação para usuário não autenticado
                notification = new UnauthenticatedNotification(notification);
                
                if(userAuth.getEmail() == null)
                { 
                    // notificação para usuários que erraram o e-mail
                    notification = new EmailErrorNotification(notification);
                }
                else if(userAuth.getErrors_to_access() >= 3)
                {
                   // notificação para usuários que erraram a senha mais de 3 vezes
                   notification = new BlockedPasswordErrorNotification(notification);
                   userAuth.setBlocked("1");
                   userDAO.update(userAuth);
                }
                else if(!user.getPassword().equals(userAuth.getPassword()))
                {
                    // notificação para usuários que erraram a senha
                    notification = new PasswordErrorNotification(notification);
                    
                  
                    userAuth.setErrors_to_access( userAuth.getErrors_to_access() + 1);
                    userDAO.update(userAuth);
                    
                }
                else if(userAuth.getBlocked().equals("1"))
                {
                    // notificação para usuários que estão bloqueados no sistema
                    notification = new BlockNotification(notification);
                }
                
                else if(!userAuth.getDtAccess().after(formatTypes.dateMinus7Days(new Date(), 7)))
                {
                    // notificação para usuários que estão muito tempo sem acessar o sistema
                    notification = new InactivityLockNotification(notification);
                }
               
                request.setAttribute("messageFeedback", notification.getMessage());
            }
            
        }catch(Exception e ) {
            System.out.println("Erro: " + e.getMessage());
        }
        
       
        return redirect;
           
    }
   
}
