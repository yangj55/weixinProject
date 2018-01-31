package com.ktv.mengxiacheng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ktv.mengxiacheng.dao.ContactsRepository;
import com.ktv.mengxiacheng.domain.Contact;

@RestController
@RequestMapping("/contacts")
public class ContactsController {
    
    @Autowired
    ContactsRepository contactsRepository;
       
    //����
    @RequestMapping(value="/save/new", method=RequestMethod.POST)
    public Contact saveNewContact(@RequestBody Contact contact) {return this.contactsRepository.save(contact);
    }
    
    //����
    @RequestMapping(value="/save/updated", method=RequestMethod.PUT)
    public Contact saveUpdatedContact(@RequestBody Contact contact) {
        Contact contactExisted = this.contactsRepository.findByName(contact.getName());
        contactExisted.setPhone(contact.getPhone());
        contactExisted.setMail(contact.getMail());
        return this.contactsRepository.save(contactExisted);
    }
    
    //ɾ��
    @RequestMapping(value="/remove", method=RequestMethod.DELETE)
    public void removeContact(long id) {
        this.contactsRepository.delete(id);
    }
    
    //��ѯ��ͨ��name��ѯһ��
    @RequestMapping(value="/query/byname", method=RequestMethod.GET)
    public Contact findContactByName(String name) {
        Contact contact = this.contactsRepository.findByName(name);
        return contact;
    }
    
    //��ѯ��ͨ��like name��ѯ����
    @RequestMapping(value="/query/likename", method=RequestMethod.GET)
    public List<Contact> findContactLikeName(String name) {
        String nameWhere = org.apache.commons.lang.StringUtils.join(new String[]{"%", name, "%"}, "");
        List<Contact> contacts = this.contactsRepository.findByNameLike(nameWhere);
        return contacts;
    }
}