package com.ktv.mengxiacheng.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ktv.mengxiacheng.domain.Contact;


public interface ContactsRepository extends JpaRepository<Contact, Long> {
    Contact findByName(String name);
    
    List<Contact> findByNameLike(String name);
}