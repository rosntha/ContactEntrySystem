package com.contact.system.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.contact.system.model.Contacts;

@Repository
public interface ContactSystemRepository extends CrudRepository<Contacts, Long>{
	
}
