/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Marcos
 */
public class Nature {
    private int id;
    private String name;
    private String description;
    private String type;
    private String costCenter;
    private String account;
    private String blocked;

    public Nature(int id, String name, String description, String type, String costCenter, String account, String blocked) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.costCenter = costCenter;
        this.account = account;
        this.blocked = blocked;
    }

  
    public static class NatureBuilder
    {
        private int id;
        private String name;
        private String description;
        private String type;
        private String costCenter;
        private String account;
        private String blocked;
        
        public NatureBuilder id(int id)
        {
            this.id = id;
            return this;
        }
        
        public NatureBuilder name(String name)
        {
            this.name = name;
            return this;
        }
        
        public NatureBuilder description(String description)
        {
            this.description = description;
            return this;
        }
        
        public NatureBuilder type(String type)
        {
            this.type = type;
            return this;
        }
        
        public NatureBuilder costCenter(String costCenter)
        {
            this.costCenter = costCenter;
            return this;
        }
        
        public NatureBuilder account(String account)
        {
            this.account = account;
            return this;
        }
        
        public NatureBuilder blocked(String blocked)
        {
            this.blocked = blocked;
            return this;
        }
        
        public Nature build()
        {
            return new Nature(
                    id, 
                    name, 
                    description, 
                    type, 
                    costCenter, 
                    account, 
                    blocked
            );
            
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getBlocked() {
        return blocked;
    }

    public void setBlocked(String blocked) {
        this.blocked = blocked;
    }

    
    
    
}
