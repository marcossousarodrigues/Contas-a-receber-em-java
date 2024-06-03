/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste;

import dao.ClientDao;
import dao.NatureDao;
import dao.ProductDao;
import dao.ReceivableDao;
import dao.UserDao;
import decorator.auth.user.BaseNotification;
import decorator.auth.user.InactivityLockNotification;
import decorator.auth.user.PasswordErrorNotification;
import decorator.auth.user.UnauthenticatedNotification;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import models.Client;
import models.Debtors;
import models.Nature;
import models.Product;
import models.Receivable;
import models.User;
import utils.FactoryFormatTypes;
import decorator.auth.user.INotification;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Marcos
 */
public class teste {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        FactoryFormatTypes formatTypes = new FactoryFormatTypes();
        
        ReceivableDao receivableDao = new ReceivableDao();
        
        ArrayList<Receivable> receivable = receivableDao.selectByDtExpiration();
        
        
        for (int i = 0; i < receivable.size(); i++) {
            System.out.println("teste");
        }
        
    }
    
}
