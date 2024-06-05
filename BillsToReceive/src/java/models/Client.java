/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Marcos
 */
public class Client {
    private int id;
    private String name;
    private String person;
    private String cnpj_cpf;
    private String email;
    private String tel;
    private String cep;
    private String country;
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private String number;
    private String blocked;

    public Client(int id, String name, String person, String cnpj_cpf, String email, String tel, String cep, String country, String state, String city, String neighborhood, String street, String number, String blocked) {
        this.id = id;
        this.name = name;
        this.person = person;
        this.cnpj_cpf = cnpj_cpf;
        this.email = email;
        this.tel = tel;
        this.cep = cep;
        this.country = country;
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
        this.street = street;
        this.number = number;
        this.blocked = blocked;
    }
    
    
    public static class ClientBuilder
    {
        private int id;
        private String name;
        private String person;
        private String cnpj_cpf;
        private String email;
        private String tel;
        private String cep;
        private String country;
        private String state;
        private String city;
        private String neighborhood;
        private String street;
        private String number;
        private String blocked;
        
        public ClientBuilder id(int id)
        {
            this.id = id;
            return this;
        }
        
        public ClientBuilder name(String name)
        {
            this.name = name;
            return this;
        }
        public ClientBuilder person(String person)
        {
            this.person = person;
            return this;
        }
        public ClientBuilder cnpjCpf(String cnpj_cpf)
        {
            this.cnpj_cpf = cnpj_cpf;
            return this;
        }
        public ClientBuilder email(String email)
        {
            this.email = email;
            return this;
        }
        
        public ClientBuilder tel(String tel)
        {
            this.tel = tel;
            return this;
        }
        
        public ClientBuilder cep(String cep)
        {
            this.cep = cep;
            return this;
        }
        
        public ClientBuilder country(String country)
        {
            this.country = country;
            return this;
        }
        
        public ClientBuilder state(String state)
        {
            this.state = state;
            return this;
        }
        
        public ClientBuilder city(String city)
        {
            this.city = city;
            return this;
        }
        
        public ClientBuilder neighborhood(String neighborhood)
        {
            this.neighborhood = neighborhood;
            return this;
        }
        public ClientBuilder street(String street)
        {
            this.street = street;
            return this;
        }
        public ClientBuilder number(String number)
        {
            this.number = number;
            return this;
        }
        public ClientBuilder blocked(String blocked)
        {
            this.blocked = blocked;
            return this;
        }
        
        public Client build()
        {
            return new Client(
                    id, 
                    name, 
                    person,
                    cnpj_cpf, 
                    email,
                    tel, 
                    cep, 
                    country, 
                    state, 
                    city, 
                    neighborhood, 
                    street, 
                    number, 
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

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getCnpj_cpf() {
        return cnpj_cpf;
    }

    public void setCnpj_cpf(String cnpj_cpf) {
        this.cnpj_cpf = cnpj_cpf;
    }
   
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBlocked() {
        return blocked;
    }

    public void setBlocked(String blocked) {
        this.blocked = blocked;
    }
    
    
    
}
