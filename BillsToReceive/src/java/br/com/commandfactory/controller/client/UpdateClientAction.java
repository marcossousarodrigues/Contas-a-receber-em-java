/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.commandfactory.controller.client;

import br.com.commandfactory.controller.receivable.ICommand;
import dao.ClientDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Client;

/**
 *
 * @author Marcos
 */
public class UpdateClientAction implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        ClientDao clientDao = new ClientDao();
        
        Client client = new Client.ClientBuilder()
                .id(Integer.parseInt(request.getParameter("id")))
                .name(request.getParameter("name"))
                .person(request.getParameter("person"))
                .cnpjCpf(request.getParameter("cnpj_cpf"))
                .email(request.getParameter("email"))
                .tel(request.getParameter("tel"))
                .cep(request.getParameter("cep"))
                .country(request.getParameter("country"))
                .state(request.getParameter("state"))
                .city(request.getParameter("city"))
                .neighborhood(request.getParameter("neighborhood"))
                .street(request.getParameter("street"))
                .number(request.getParameter("number"))
                .blocked(request.getParameter("blocked"))
                .build();
        
        try
        {
            clientDao.update(client);
        }
        catch(Exception e)
        {
            
        }
        
        return "ClientController?action=ReadAll";
    }
}
