/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Marcos
 */
public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private String blocked;

    public Product() {
        super();
    }

    public Product(int id, String name, String description, double price, String blocked) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.blocked = blocked;
    }
    
    public static class ProductBuilder
    {
        private int id;
        private String name;
        private String description;
        private double price;
        private String blocked;
        
        public ProductBuilder id(int id)
        {
            this.id = id;
            return this;
        }
        
        public ProductBuilder name(String name)
        {
            this.name = name;
            return this;
        }
        
        public ProductBuilder description(String description)
        {
            this.description = description;
            return this;
        }
        
        public ProductBuilder price(double price)
        {
            this.price = price;
            return this;
        }
        
        public ProductBuilder blocked(String blocked)
        {
            this.blocked = blocked;
            return this;
        }
        
        public Product build()
        {
            return new Product(
                    id, 
                    name, 
                    description, 
                    price, 
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBlocked() {
        return blocked;
    }

    public void setBlocked(String blocked) {
        this.blocked = blocked;
    }
    
    
    
}
