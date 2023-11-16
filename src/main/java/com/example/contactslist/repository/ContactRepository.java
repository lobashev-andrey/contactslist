package com.example.contactslist.repository;

import com.example.contactslist.Contact;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface ContactRepository {

    public List<Contact> findAll();

    public Contact findById(long id);
    public void saveContact(Contact contact);
    public void addContact(Contact contact);
    public void deleteContact(Contact contact);
    public void batchUpdate(List<Contact> contacts);
}
