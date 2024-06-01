/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

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
    private String blocked;

    public User() {
    }

    public User(int id, String name, String surname, String email, String password, String permission, String blocked) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.permission = permission;
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
        
        public UserBuilder blocked(String blocked)
        {
            this.blocked = blocked;
            return this;
        }
        
        public User build()
        {
            return new User(id, name, surname, email, password, permission, blocked);
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

    public String getBlocked() {
        return blocked;
    }

    public void setBlocked(String blocked) {
        this.blocked = blocked;
    }

    
    
    
    
}
