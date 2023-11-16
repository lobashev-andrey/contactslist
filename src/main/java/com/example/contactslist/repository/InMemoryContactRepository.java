package com.example.contactslist.repository;

import com.example.contactslist.Contact;
//import com.example.contactslist.listener.DatabaseContactsListener;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
@ConditionalOnProperty(value = "app.database.source", havingValue = "inMemory")
public class InMemoryContactRepository implements ContactRepository{

    private final List<Contact> contacts = new ArrayList<>();

    @Override
    public List<Contact> findAll() {
        return contacts;
    }

    @Override
    public Contact findById(long id) {
        return null;
    }

    @Override
    public void saveContact(Contact contact) {}

    @Override
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    @Override
    public void deleteContact(Contact contact) {
        contacts.remove(contact);
    }

    @Override
    public void batchUpdate(List<Contact> contacts) {
        for (Contact c : contacts){
            addContact(c);
        }
    }
}
