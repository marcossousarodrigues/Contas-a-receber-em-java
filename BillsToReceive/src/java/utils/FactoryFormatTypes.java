/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.SimpleDateFormat;
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
    
    public double formatDouble(String number)
    {
        return Double.parseDouble(number);
    }
    
    public int formatInt(String number)
    {
        return Integer.parseInt(number);
    }
    
}
