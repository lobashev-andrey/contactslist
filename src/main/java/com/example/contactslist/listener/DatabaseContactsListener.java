package com.example.contactslist.listener;

import com.example.contactslist.Contact;
import com.example.contactslist.service.ContactService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
@ConditionalOnExpression("${app.database.init}")
public class DatabaseContactsListener {

    private final ContactService service;

    @EventListener(ApplicationReadyEvent.class)
    public void batchInit(){
        log.debug("DatabaseContactsListener -> batchInit");
        service.batchInsert(getInitContactsList());
    }

    public static List<Contact> getInitContactsList() {
        List<Contact> list = new ArrayList<>();
        for(long i = 0; i < 10; i++){
            Contact c = new Contact();
            c.setId(System.currentTimeMillis());
            c.setFirstName("Name_" + i);
            c.setLastName("LastName_" + i);
            c.setEmail("e_" + i + "_mail@example.com");
            c.setPhone("+987654321" + i);
            list.add(c);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
