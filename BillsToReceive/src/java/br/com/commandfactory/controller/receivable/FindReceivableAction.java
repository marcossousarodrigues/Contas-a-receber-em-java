/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.commandfactory.controller.receivable;

import dao.ProductDao;
import dao.ReceivableDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import models.Product;
import models.Receivable;

/**
 *
 * @author Marcos
 */
public class FindReceivableAction implements ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            String searchMessage = "";
            String field = request.getParameter("field");
            String fieldValue = request.getParameter("fieldValue");

            if (field != null && fieldValue != null) {

                if ((field.equals("pay") || field.equals("blocked")) && fieldValue.equals("Sim")) {
                    fieldValue = "1";
                }
                else if ((field.equals("Npay") || field.equals("Nblocked")) && fieldValue.equals("Não")) {
                    fieldValue = "2";
                    if(field.equals("Npay"))
                    {
                        field = "pay";
                    }
                    else
                    {
                        field = "blocked";
                    }
                }
            }

            ReceivableDao receivableDao = new ReceivableDao();

            ArrayList<Receivable> list = receivableDao
                    .selectByField(field, fieldValue);

            if (request.getParameter("delayedReceipt") != null && request.getParameter("delayedReceipt").equals("true")) {
                list = receivableDao.selectByDtExpiration();
            }

            searchMessage += list.size() + " Resultado(s) Correspondentes Para: ";
            searchMessage += " '" + request.getParameter("fieldValue") + "'";

            request.setAttribute("receivable", list);
            request.setAttribute("searchMessage", searchMessage);

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return "pages/aReceive/listReceived.jsp";
    }

}
