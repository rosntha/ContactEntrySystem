package com.contact.system;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.contact.system.model.Address;
import com.contact.system.model.Contacts;
import com.contact.system.model.Name;
import com.contact.system.repository.ContactSystemRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ContactSystemApplication.class)
public class ContactSystemRepositoryTest {

	@Autowired
	private ContactSystemRepository repo;
	
	@Test
	public void checkCURDOperations(){
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
		
		repo.save(c);
		List<Contacts> all= (List<Contacts>) repo.findAll();
		assertTrue(all.size()>0);
	}
}
