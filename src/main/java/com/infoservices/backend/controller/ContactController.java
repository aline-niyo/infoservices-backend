
package com.infoservices.backend.controller;

import com.infoservices.backend.model.Contact;
import com.infoservices.backend.repository.ContactRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "http://localhost:5174")
public class ContactController {

    private final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @PostMapping
    public ResponseEntity<Contact> envoyerMessage(
            @RequestBody Contact contact) {

        Contact nouveauContact =
                contactRepository.save(contact);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nouveauContact);
    }
}
