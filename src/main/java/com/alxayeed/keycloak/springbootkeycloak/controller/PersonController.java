package com.alxayeed.keycloak.springbootkeycloak.controller;

import com.alxayeed.keycloak.springbootkeycloak.model.Person;
import com.alxayeed.keycloak.springbootkeycloak.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @PostMapping("/employees")
    public ResponseEntity<Person> addPerson(@RequestBody Person person){
        return ResponseEntity.ok().body(personRepository.save(person));

    }

    @GetMapping("/employees")
    public ResponseEntity<List<Person>> getAllPerson(){
        return ResponseEntity.ok().body(personRepository.findAll());
    }
}
