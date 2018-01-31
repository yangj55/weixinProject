package com.ktv.mengxiacheng.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String name;
    
    private String phone;
    
    private String mail;
    
    public Contact() {
        super();
    }
    
    public Contact(String name, String phone, String mail) {
        super();
        
        this.name = name;
        this.phone = phone;
        this.mail = mail;
    }
    
    public long getId() {
        return this.id;
    }
    
    public void setId(long value) {
        this.id = value;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String value) {
        this.name = value;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String value) {
        this.phone = value;
    }
    
    public String getMail() {
        return this.mail;
    }
    
    public void setMail(String value) {
        this.mail = value;
    }
}