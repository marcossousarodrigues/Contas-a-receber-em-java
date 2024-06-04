/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author Marcos
 */
public class User {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String permission;
    private Date dtAccess;
    private int errors_to_access;
    private String blocked;

    public User(int id, String name, String surname, String email, String password, String permission, Date dtAccess, int errors_to_access, String blocked) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.permission = permission;
        this.dtAccess = dtAccess;
        this.errors_to_access = errors_to_access;
        this.blocked = blocked;
    }

    
    
    public static class UserBuilder
    {
        private int id;
        private String name;
        private String surname;
        private String email;
        private String password;
        private String permission;
        private Date dtAccess;
        private int errors_to_access;
        private String blocked;
        
        public UserBuilder id(int id)
        {
            this.id = id;
            return this;
        }
        
        public UserBuilder name(String name)
        {
            this.name = name;
            return this;
        }
        
        public UserBuilder surname(String surname)
        {
            this.surname = surname;
            return this;
        }
        
        public UserBuilder email(String email)
        {
            this.email = email;
            return this;
                               
        }
        
        public UserBuilder password(String password)
        {
            this.password = password;
            return this;
        }
        
        public UserBuilder permission(String permission)
        {
            this.permission = permission;
            return this;
        }
        
        public UserBuilder dtAccess(Date dtAccess)
        {
            this.dtAccess = dtAccess;
            return this;
        }
        
        public UserBuilder errors_to_access(int errors_to_access)
        {
            this.errors_to_access = errors_to_access;
            return this;
        }
        
        public UserBuilder blocked(String blocked)
        {
            this.blocked = blocked;
            return this;
        }
        
        public User build()
        {
            return new User(
                    id, 
                    name, 
                    surname, 
                    email, 
                    password, 
                    permission, 
                    dtAccess, 
                    errors_to_access, 
                    blocked);
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Date getDtAccess() {
        return dtAccess;
    }

    public void setDtAccess(Date dtAccess) {
        this.dtAccess = dtAccess;
    }

    public int getErrors_to_access() {
        return errors_to_access;
    }

    public void setErrors_to_access(int errors_to_access) {
        this.errors_to_access = errors_to_access;
    }

    public String getBlocked() {
        return blocked;
    }

    public void setBlocked(String blocked) {
        this.blocked = blocked;
    }

    
    
    
    
    
}
