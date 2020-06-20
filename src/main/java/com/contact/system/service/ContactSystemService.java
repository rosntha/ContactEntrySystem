package com.contact.system.service;

import com.contact.system.model.Contacts;

public interface ContactSystemService {

	String createContact(Contacts contacts);

	Iterable<Contacts> getAllContacts();

	String updateContact(Long id, Contacts contact);

	Contacts getContact(Long id);

	String deleteContact(Long id);
	
}
