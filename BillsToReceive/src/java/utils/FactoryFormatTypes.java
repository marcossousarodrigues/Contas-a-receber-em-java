/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Marcos
 */
public class FactoryFormatTypes {
    
    public Date formatDate(String date)
    {
        Date newDate = null;
        try
        {
            if(date.equals(""))
            {
                newDate = null;
            }
            else 
            {            
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                newDate = dateFormat.parse(date);
            }
        }
        catch(Exception e)
        {
            System.out.println("Error: "+e.getMessage());
        }
        
        return newDate;
    }
    
    public java.sql.Date formatSqlDate(Date paramDate)
    {
        java.sql.Date newDate = null;
        try
        {
            java.util.Date date = paramDate;
            newDate = new java.sql.Date(date.getTime());
        }
        
        catch(Exception e)
        {
            System.out.println("Error: "+e.getMessage());
        }
        
        return newDate;
    }
    
    public static String convertDateToString(Date date) {
        // Define o formato da data que você deseja
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        // Converte a data para a string no formato especificado
        return dateFormat.format(date);
    }
    
    
    public double formatDouble(String number)
    {
        return Double.parseDouble(number);
    }
    
    public int formatInt(String number)
    {
        return Integer.parseInt(number);
    }
    
    public String formatDateD_M_Y(Date date)
    {
       
        // Define o formato da data que você deseja
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        // Converte a data para a string no formato especificado
        return dateFormat.format(date);

    }
    
    public Date dateMinus7Days(Date today, int day)
   {
       
        // Usar Calendar para subtrair 7 dias
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DAY_OF_MONTH, -day);
        
        // Obter a nova data
        Date newDate = calendar.getTime();
        
        return newDate;
   }
    
}
