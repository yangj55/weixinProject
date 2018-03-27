package com.ktv.mengxiacheng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ktv.mengxiacheng.dao.ContactsRepository;
import com.ktv.mengxiacheng.domain.Contact;

@RestController
//@Controller
@RequestMapping("/contacts")
public class ContactsController {
    
    @Autowired
    ContactsRepository contactsRepository;
       
    //新增
    @RequestMapping(value="/save/new", method=RequestMethod.POST)
    public Contact saveNewContact(@RequestBody Contact contact) {return this.contactsRepository.save(contact);
    }
    
    //更新
    @RequestMapping(value="/save/updated", method=RequestMethod.PUT)
    public Contact saveUpdatedContact(@RequestBody Contact contact) {
        Contact contactExisted = this.contactsRepository.findByName(contact.getName());
        contactExisted.setPhone(contact.getPhone());
        contactExisted.setMail(contact.getMail());
        return this.contactsRepository.save(contactExisted);
    }
    
    //删除
    @RequestMapping(value="/remove", method=RequestMethod.DELETE)
    public void removeContact(long id) {
        this.contactsRepository.delete(id);
    }
    
    //查询，通过name查询一条
    @RequestMapping(value="/query/byname", method=RequestMethod.GET)
   public Contact findContactByName(@RequestParam("name")String name) {
//   public Contact findContactByName() {
        Contact contact = this.contactsRepository.findByName(name);
        return contact;
    }
    
    //查询，通过like name查询多条
    @RequestMapping(value="/query/likename", method=RequestMethod.GET)
    public List<Contact> findContactLikeName(String name) {
        String nameWhere = org.apache.commons.lang3.StringUtils.join(new String[]{"%", name, "%"}, "");
        List<Contact> contacts = this.contactsRepository.findByNameLike(nameWhere);
        return contacts;
    }
}