package com.example.contactslist.service;

import com.example.contactslist.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> findAll();
    Contact findById(long id);
    void save(Contact contact);
    void add(Contact contact);
    void delete(Contact contact);
    void batchInsert(List<Contact> contacts);
}
