package com.contact.system;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.contact.system.model.Address;
import com.contact.system.model.Contacts;
import com.contact.system.model.Name;
import com.contact.system.service.ContactSystemService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ContactSystemApplication.class)
public class ContactSystemServiceTest {

	@Autowired
	private ContactSystemService service;
	
	@Before
	public void before(){
		Contacts c = new Contacts();
		Name n = new Name();
		n.setFirst("f");
		n.setMiddle("m");
		n.setLast("l");
		
		c.setName(n);
		
		Address a = new Address();
		a.setState("s");
		a.setStreet("st");
		a.setCity("c");
		c.setAddress(a);
		
		c.setEmail("email");
		
		service.createContact(c);
	}
	@Test
	public void getAllContacts(){
		List<Contacts> all= (List<Contacts>) service.getAllContacts();
		assertTrue(all.size()>0);
	}
	
	@Test
	public void getContactBasedOnId(){
		Contacts c= service.getContact(1l);
		assertTrue(c.getId()!=null);
	}
}
