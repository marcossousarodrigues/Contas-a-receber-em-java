/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.commandfactory.controller.receivable;

import dao.ReceivableDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Marcos
 */
public class DeleteReceivableAction implements ICommand{
      
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {   
       
        try
        {
            ReceivableDao.delete(Integer.parseInt(request.getParameter("id")));
            
        }
        catch(Exception e)
        {
            System.out.println("Error: "+e.getMessage());
        }
        
        return "ReceivableController?action=ReadAll";
     }
}
