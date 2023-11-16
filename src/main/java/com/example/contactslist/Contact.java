package com.example.contactslist;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@FieldNameConstants
public class Contact {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
