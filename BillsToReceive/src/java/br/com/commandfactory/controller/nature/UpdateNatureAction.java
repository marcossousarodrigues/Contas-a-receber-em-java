/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.commandfactory.controller.nature;

import br.com.commandfactory.controller.receivable.ICommand;
import dao.NatureDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Nature;

/**
 *
 * @author Marcos
 */
public class UpdateNatureAction implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        NatureDao natureDao = new NatureDao();
        Nature nature = new Nature.NatureBuilder()
                .id(Integer.parseInt(request.getParameter("id")))
                .name(request.getParameter("name"))
                .description(request.getParameter("description"))
                .type(request.getParameter("type"))
                .costCenter(request.getParameter("costCenter"))
                .account(request.getParameter("account"))
                .blocked(request.getParameter("blocked"))
                .build();
        
        try
        {
            natureDao.update(nature);
        }
        catch(Exception e)
        {
            
        }
        
        return "NatureController?action=ReadAll";
    }
}
