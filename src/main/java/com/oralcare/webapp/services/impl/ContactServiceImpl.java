package com.oralcare.webapp.services.impl;

import com.oralcare.webapp.model.Contact;
import com.oralcare.webapp.repositories.ContactRepo;
import com.oralcare.webapp.services.ContactSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ContactServiceImpl implements ContactSerivce {
    @Autowired
    private ContactRepo contactRepo;

    @Override
    public boolean receiveContact(Contact contact) {
        try {
            contact.setCreateDate(new Timestamp(new java.util.Date().getTime()));
            contactRepo.save(contact);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
