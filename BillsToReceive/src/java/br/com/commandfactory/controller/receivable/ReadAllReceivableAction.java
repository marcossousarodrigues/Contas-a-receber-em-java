/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.commandfactory.controller.receivable;

import dao.ReceivableDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import models.Receivable;

/**
 *
 * @author Marcos
 */
public class ReadAllReceivableAction extends Controller implements ICommand {
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        Boolean auth = verifyAuthentication(request, response);
        
        try
        {   
            ReceivableDao receivableDao = new ReceivableDao();
  
            ArrayList<Receivable> list = receivableDao.selectAll();
           
            request.setAttribute("receivable", list);
        }
        catch(Exception e)
        {
            System.out.println("Error: "+e.getMessage());
        }
        
        return "pages/aReceive/listReceived.jsp";
    }
}
