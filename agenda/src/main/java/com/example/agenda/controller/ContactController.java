package com.example.agenda.controller;

import com.example.agenda.data.Contact;
import com.example.agenda.repository.ContactRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Slf4j
public class ContactController {

    private final ContactRepository contactRepository;

    @PostMapping(value = "/contacts", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        log.info("New contact {}", contact);
        contactRepository.save(contact);
        return new ResponseEntity<Contact>(contact, HttpStatus.CREATED);
    }

    @GetMapping(value = "/contacts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Contact> getContactById(@PathVariable Long id) {
        log.info("Get contact by ID '{}'", id);
        Optional<Contact> contact = contactRepository.findById(id);
        if (contact.isPresent()) {
            return new ResponseEntity<Contact>(contact.get(), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/contacts", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Contact>> getContactsByName(@RequestParam(required = false) String name, @RequestParam(required = false) String number) {
        List<Contact> contacts = new ArrayList<>();
        if (name == null && number == null) {
            log.info("Get contacts");
            contacts = contactRepository.findAll();
            if (!contacts.isEmpty()) {
                return new ResponseEntity<List<Contact>>(contacts, HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        if (name != null && number != null) {
            log.info("Get contact by name '{}' and number '{}'", name, number) ;
            contacts = contactRepository.findByNameAndNumber(name, number);
            if (!contacts.isEmpty()) {
                return new ResponseEntity<List<Contact>>(contacts, HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        if (name != null) {
            log.info("Get contact by name '{}'", name);
            contacts = contactRepository.findByName(name);
            if (!contacts.isEmpty()) {
                return new ResponseEntity<List<Contact>>(contacts, HttpStatus.OK);
            }
        }

        if (number != null) {
            log.info("Get contact by number '{}'", number);
            contacts = contactRepository.findByNumber(number);
            if (!contacts.isEmpty()) {
                return new ResponseEntity<List<Contact>>(contacts, HttpStatus.OK);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/contacts/{id}")
    ResponseEntity<String> deleteContactById(@PathVariable Long id) {
        log.info("Delete contact by ID '{}'", id);
        Optional<Contact> contact = contactRepository.findById(id);
        if (contact.isPresent()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "/contacts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact newContact) {
        Optional<Contact> contact = contactRepository.findById(id);
        if (contact.isPresent()) {
            log.info("Update contact with id '{}'", id);
            Contact currentContact = contact.get();
            currentContact.setName(newContact.getName());
            currentContact.setNumber(newContact.getNumber());
            contactRepository.save(currentContact);
            return new ResponseEntity<Contact>(currentContact, HttpStatus.OK);
        } else {
            newContact.setId(id);
            log.info("Create new contact '{}'", newContact);
            contactRepository.save(newContact);
            return new ResponseEntity<Contact>(newContact, HttpStatus.CREATED);
        }
    }
}
