package com.alxayeed.keycloak.springbootkeycloak.repository;

import com.alxayeed.keycloak.springbootkeycloak.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
