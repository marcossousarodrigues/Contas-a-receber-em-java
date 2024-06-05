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
public class Receivable {
    private int id;
    private String title;
    private String installments;
    private String title_type;
    private double title_value;
    private int title_amount;
    private double title_total;
    private Date dt_payment;
    private Date dt_expiration;
    private String form_of_payment;
    private String pay;
    private Date dt_emission;
    private String blocked;
    
    private Product product;
    private Client client;
    private Nature nature;
    private User user;
    

    public Receivable(int id, String title, String installments, String title_type, double title_value, int title_amount, double title_total, Date dt_payment, Date dt_expiration, String form_of_payment, String pay, Date dt_emission, String blocked, Product product, Client client, Nature nature, User user) {
        this.id = id;
        this.title = title;
        this.installments = installments;
        this.title_type = title_type;
        this.title_value = title_value;
        this.title_amount = title_amount;
        this.title_total = title_total;
        this.dt_payment = dt_payment;
        this.dt_expiration = dt_expiration;
        this.form_of_payment = form_of_payment;
        this.pay = pay;
        this.dt_emission = dt_emission;
        this.blocked = blocked;
        this.product = product;
        this.client = client;
        this.nature = nature;
        this.user = user;
    }

    
    
    
    public static class ReceivableBuilder
    {
        private int id;
        private String title;
        private String installments;
        private String title_type;
        private double title_value;
        private int title_amount;
        private double title_total;
        private Date dt_payment;
        private Date dt_expiration;
        private String form_of_payment;
        private String pay;
        private Date dt_emission;
        private String blocked;
        
        private Product product;
        private Client client;
        private Nature nature;
        private User user;
        
        public ReceivableBuilder id(int id)
        {   
            this.id = id;
          
            return this;
        }
        
        public ReceivableBuilder title(String title)
        {
            this.title = title;
            return this;
        }
          
          
        public ReceivableBuilder installments(String installments)
        {
            this.installments = installments;
            return this;
        }
        
        public ReceivableBuilder titleType(String title_type)
        {
            this.title_type = title_type;
            return this;
        }
        public ReceivableBuilder title_value(double title_value)
        {
            this.title_value = title_value;
            return this;
        }
        
        public ReceivableBuilder title_amount(int title_amount)
        {
            this.title_amount = title_amount;
            return this;
            
        }
        
        public ReceivableBuilder title_total(double title_total)
        {
            this.title_total = title_total;
            return this;
        }
        
        public ReceivableBuilder dt_payment(Date dt_payment)
        {
            this.dt_payment = dt_payment;
            return this;
        }
        
        public ReceivableBuilder dt_expiration(Date dt_expiration)
        {
            this.dt_expiration = dt_expiration;
            return this;
        }
        
        public ReceivableBuilder form_of_payment(String form_of_payment)
        {
            this.form_of_payment = form_of_payment;
            return this;
        }
        
        public ReceivableBuilder pay(String pay)
        {
            this.pay = pay;
            return this;
        }
        
        public ReceivableBuilder dt_emission(Date dt_emission)
        {
            this.dt_emission = dt_emission;
            return this;
        }
        
        public ReceivableBuilder blocked(String blocked)
        {
            this.blocked = blocked;
            return this;
        }
        
        public ReceivableBuilder product(Product product)
        {
            this.product = product;
            return this;
        }
        
        public ReceivableBuilder client(Client client)
        {
            this.client = client;
            return this;
        }
        
        public ReceivableBuilder nature(Nature nature)
        {
            this.nature = nature;
            return this;
        }
        
        public ReceivableBuilder user(User user)
        {
            this.user = user;
            return this;
        }
        
        public Receivable build()
        {
            return new Receivable(
                    id, 
                    title, 
                    installments, 
                    title_type, 
                    title_value, 
                    title_amount, 
                    title_total, 
                    dt_payment, 
                    dt_expiration, 
                    form_of_payment, 
                    pay, 
                    dt_emission, 
                    blocked, 
                    product, 
                    client, 
                    nature, 
                    user
            );
        }
      
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstallments() {
        return installments;
    }

    public void setInstallments(String installments) {
        this.installments = installments;
    }

    public String getTitle_type() {
        return title_type;
    }

    public void setTitle_type(String title_type) {
        this.title_type = title_type;
    }

    public double getTitle_value() {
        return title_value;
    }

    public void setTitle_value(double title_value) {
        this.title_value = title_value;
    }

    public int getTitle_amount() {
        return title_amount;
    }

    public void setTitle_amount(int title_amount) {
        this.title_amount = title_amount;
    }

    public double getTitle_total() {
        return title_total;
    }

    public void setTitle_total(double title_total) {
        this.title_total = title_total;
    }

    public Date getDt_payment() {
        return dt_payment;
    }

    public void setDt_payment(Date dt_payment) {
        this.dt_payment = dt_payment;
    }

    public Date getDt_expiration() {
        return dt_expiration;
    }

    public void setDt_expiration(Date dt_expiration) {
        this.dt_expiration = dt_expiration;
    }

    public String getForm_of_payment() {
        return form_of_payment;
    }

    public void setForm_of_payment(String form_of_payment) {
        this.form_of_payment = form_of_payment;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public Date getDt_emission() {
        return dt_emission;
    }

    public void setDt_emission(Date dt_emission) {
        this.dt_emission = dt_emission;
    }

    public String getBlocked() {
        return blocked;
    }

    public void setBlocked(String blocked) {
        this.blocked = blocked;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Nature getNature() {
        return nature;
    }

    public void setNature(Nature nature) {
        this.nature = nature;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
 
}
