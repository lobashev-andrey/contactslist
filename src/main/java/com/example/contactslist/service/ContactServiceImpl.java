package com.example.contactslist.service;

import com.example.contactslist.Contact;
import com.example.contactslist.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService{

    private final ContactRepository repository;

    @Override
    public List<Contact> findAll() {
        return repository.findAll();
    }

    @Override
    public Contact findById(long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Contact contact) {
        repository.saveContact(contact);
    }

    @Override
    public void add(Contact contact) {
        repository.addContact(contact);
    }

    @Override
    public void delete(Contact contact) {
        repository.deleteContact(contact);
    }

    @Override
    public void batchInsert(List<Contact> contacts) {
        repository.batchUpdate(contacts);
    }
}
