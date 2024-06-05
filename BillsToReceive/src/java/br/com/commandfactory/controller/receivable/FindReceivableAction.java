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
import utils.FactoryFormatTypes;

/**
 *
 * @author Marcos
 */
public class FindReceivableAction implements ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        FactoryFormatTypes formatTypes = new FactoryFormatTypes();
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
            
            searchMessage += list.size() + " Resultado(s) Correspondentes Para: ";
            searchMessage += " '" + request.getParameter("fieldValue") + "'";
            
            
            if((field != null && fieldValue != null) && (field.equals("dt_emission") || field.equals("dt_payment") || field.equals("dt_expiration")))
            {
                searchMessage = list.size() + " Resultado(s) Correspondentes Para: ";
                searchMessage += " '" + fieldValue != null ? formatTypes.formatDateD_M_Y( formatTypes.formatDate(fieldValue)) : ""  + "'";
            }
             /// recebimentos confirmados
            
            if(request.getParameter("confirmedReceipts") != null && request.getParameter("confirmedReceipts").equals("true"))
            {   
                field = "pay";
                fieldValue = "1";
                list = receivableDao.selectByField(field, fieldValue);
                searchMessage = list.size() + " Resultado(s) Correspondentes Para: 'Recebimentos confirmados'";
            }
            
              
            if (request.getParameter("pendingReceipts") != null && request.getParameter("pendingReceipts").equals("true")) {
                
                field = "pay";
                fieldValue = "2";
                list = receivableDao.selectByField(field, fieldValue);
                searchMessage = list.size() + " Resultado(s) Correspondentes Para: 'Em Processo de Recebimento'";
            }
            
            
            if (request.getParameter("delayedReceipt") != null && request.getParameter("delayedReceipt").equals("true")) {
                list = receivableDao.selectByDtExpiration();
                
                searchMessage = list.size() + " Resultado(s) Correspondentes Para: 'Recebimentos em atraso'";
            }
        
            

            request.setAttribute("receivable", list);
            request.setAttribute("searchMessage", searchMessage);

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return "pages/aReceive/listReceived.jsp";
    }

}
