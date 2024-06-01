/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Marcos
 */
public class Debtors {
    private int id;
    private String name;
    private String surname;
    private String email;

    public Debtors() {
        
    }

    public Debtors(int id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
    
    
    public static class DebtorsBuilder{
        private int id;
        private String name;
        private String surname;
        private String email;
        
        public DebtorsBuilder id(int id)
        {
            this.id = id;
            return this;
        }
        
        public DebtorsBuilder name(String name)
        {
            this.name = name;
            return this;
        }
        
        public DebtorsBuilder surname(String surname)
        {
            this.surname = surname;
            return this;
        }
        public DebtorsBuilder email(String email)
        {
            this.email = email;
            return this;
        }
        public Debtors build()
        {
            return new Debtors(id, name, surname, email);
        }
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
