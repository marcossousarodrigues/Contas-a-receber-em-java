/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.commandfactory.controller.nature;

import dao.NatureDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Nature;

/**
 *
 * @author Marcos
 */
public class DeleteNatureAction implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        try{
            NatureDao natureDao = new NatureDao();
            Nature nature = new Nature.NatureBuilder()
                    .id( Integer.parseInt(request.getParameter("id")))
                    .build();
            NatureDao.delete(nature);
            
        }
        catch(Exception e)
        {
            
        }
        
        return "NatureController?action=ReadAll";
        
    }
    
}
