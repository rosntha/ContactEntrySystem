package com.contact.system.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.system.model.Contacts;
import com.contact.system.model.Phone;
import com.contact.system.repository.ContactSystemRepository;
import com.contact.system.service.ContactSystemService;

@Service 
public class ContactSystemServiceImpl implements ContactSystemService {
	@Autowired
	private ContactSystemRepository repository;

	@Override
	public String createContact(Contacts contacts) {
		contacts = map(contacts);
		repository.save(contacts);
		return "Saved";
	}

	private Contacts map(Contacts contacts) {
		for(Phone p : contacts.getPhone()){
			p.setContact(contacts);
			contacts.getPhone().add(p);
		}
		return contacts;
	}

	@Override
	public Iterable<Contacts> getAllContacts() {
		return repository.findAll();
	}

	@Override
	public String updateContact(Long id,Contacts contact) {
		contact.setId(id);
		repository.save(contact);
		return "Updated";
	}

	@Override
	public Contacts getContact(Long id) {
		Optional<Contacts> contact =  repository.findById(id);
		return contact.isPresent() ? contact.get() : new Contacts();
	}

	@Override
	public String deleteContact(Long id) {
		Contacts contacts = getContact(id);
		if(contacts.getEmail()==null)return "given id is not exist. please try with different id";
		repository.deleteById(id);
		return "Deleted";
	}

}
