/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.commandfactory.controller.nature;

import dao.NatureDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import models.Nature;

/**
 *
 * @author Marcos
 */
public class ReadNatureAction implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        try{
             
            NatureDao natureDao = new NatureDao();
            int id = Integer.parseInt( request.getParameter("id"));
            
            Nature nature = natureDao.selectNature(id);
            
            request.setAttribute("natureEdit", nature); 
           
        }
        catch(Exception e)
        {
            System.out.println("Error "+ e.getMessage());
        }
        
        return "pages/nature/toEdit.jsp";
    }
}
