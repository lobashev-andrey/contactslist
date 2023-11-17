package com.example.contactslist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan(value = "com.example")
public class ContactslistApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactslistApplication.class, args);
	}

}
