package com.ktv.mengxiacheng;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ktv.mengxiacheng.domain.Contact;
import com.ktv.mengxiacheng.domain.ContactsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MengxiachengApplicationTests {
	@Autowired
    ContactsRepository contactsRepository;
	@Test
	public void contextLoads() {
	}
	
	
	@Test
	public void findContactByName() {
        Contact contact = this.contactsRepository.findByName("zs");
        if(contact==null)
    	{
        	System.out.println("null");
    	}else{
    		System.out.println("======"+contact.getName());
    	}
        
    }

}
