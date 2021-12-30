package com.alxayeed.keycloak.springbootkeycloak.controller;

import com.alxayeed.keycloak.springbootkeycloak.model.Person;
import com.alxayeed.keycloak.springbootkeycloak.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @RolesAllowed({"USER", "ADMIN"})
    @PostMapping("/persons")
    public ResponseEntity<Person> addPerson(@RequestBody Person person){
        return ResponseEntity.ok().body(personRepository.save(person));

    }

    @RolesAllowed("ADMIN")
    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPerson(){
        return ResponseEntity.ok().body(personRepository.findAll());
    }

    @RolesAllowed({"USER"})
    @GetMapping("/home")
    public String home(){
        return "Hello from Spring Keycloak";
    }
}
