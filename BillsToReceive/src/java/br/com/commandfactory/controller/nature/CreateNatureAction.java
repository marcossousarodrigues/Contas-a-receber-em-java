/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.commandfactory.controller.nature;

import dao.NatureDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import models.Nature;

/**
 *
 * @author Marcos
 */
public class CreateNatureAction implements ICommand {
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        
        try{
            NatureDao natureDao = new NatureDao();
            Nature nature = new Nature.NatureBuilder()
                    .name(request.getParameter("name"))
                    .description(request.getParameter("description"))
                    .type(request.getParameter("type"))
                    .costCenter(request.getParameter("costCenter"))
                    .account(request.getParameter("account"))
                    .blocked(request.getParameter("blocked"))
                    .build();
            natureDao.create(nature);
            
        }
        catch(Exception e)
        {
            
        }
       
        return "NatureController?action=ReadAll";
           
    }
    
}
