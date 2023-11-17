package com.example.contactslist;

import com.example.contactslist.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ContactController {

    private final ContactService service;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("contacts", service.findAll());
        return "index";
    }

    @GetMapping("/contacts/create")
    public String showEditForm(Model model){
        Contact contact = new Contact();
        contact.setId(System.currentTimeMillis());
        model.addAttribute("contact", contact);
        return "edit";
    }


    @GetMapping("/contacts/edit/{id}")
    public String edit(@PathVariable long id, Model model){
        for(Contact c : service.findAll()){
             if(c.getId() == id){
                model.addAttribute("contact", c);
                return "edit";
            }
        }
        return "redirect:/";
    }

    @PostMapping("/contacts/save")
    public String saveEdited(@ModelAttribute Contact contact){
        int flag = 0;
        for(Contact c : service.findAll()){
            if(c.getId() == contact.getId()){
                c.setFirstName(contact.getFirstName());
                c.setLastName(contact.getLastName());
                c.setEmail(contact.getEmail());
                c.setPhone(contact.getPhone());
                flag++;
            }
        }
        if(flag == 0) service.add(contact);
        return "redirect:/";
    }

    @GetMapping("/contacts/delete/{id}")
    public String delete(@PathVariable long id){
        Contact contactToDelete = new Contact();
        for(Contact c: service.findAll()){
            if(c.getId() == id){
                contactToDelete = c;
            }
        }
        service.delete(contactToDelete);
        return "redirect:/";
    }
}
