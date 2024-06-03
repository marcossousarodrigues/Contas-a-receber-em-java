/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade.controller;

import br.com.commandfactory.controller.receivable.ICommand;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Marcos
 */
public class ControllerFacade {

    public void processController(HttpServletRequest request, HttpServletResponse response, String className) {
        try {
            
            Class classAction = Class.forName(className);

            ICommand commandAction = (ICommand) classAction.newInstance();

            String pageDispatcher = commandAction.execute(request, response);

            request.getRequestDispatcher("/" + pageDispatcher).forward(request, response);

        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }
}
