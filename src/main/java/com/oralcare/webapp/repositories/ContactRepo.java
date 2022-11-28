package com.oralcare.webapp.repositories;

import com.oralcare.webapp.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<Contact, Integer> {
}
