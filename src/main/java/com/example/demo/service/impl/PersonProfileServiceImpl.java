package com.example.demo.service.impl;

import java.util.*;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ApiException;
import com.example.demo.model.PersonProfile;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.service.PersonProfileService;

@Service
public class PersonProfileServiceImpl implements PersonProfileService {

    private final PersonProfileRepository repo;

    public PersonProfileServiceImpl(PersonProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public PersonProfile createPerson(PersonProfile person) {

        if (person.getEmail() == null || person.getEmail().isBlank()) {
            throw new ApiException("email is required");
        }

        if (repo.findByEmail(person.getEmail()).isPresent()) {
            throw new ApiException("email already exists");
        }

        if (repo.findByReferenceId(person.getReferenceId()).isPresent()) {
            throw new ApiException("reference already exists");
        }

        return repo.save(person);
    }


    @Override
    public PersonProfile getPersonById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ApiException("person not found"));
    }

    @Override
    public List<PersonProfile> getAllPersons() {
        return repo.findAll(); // tests verify this call
    }

  @Override
    public PersonProfile updateRelationshipDeclared(Long id, boolean declared) {
    PersonProfile p = getPersonById(id);
    p.setRelationshipDeclared(declared);
    return repo.save(p);
}

    @Override
    public Optional<PersonProfile> findByReferenceId(String referenceId) {
        return repo.findByReferenceId(referenceId);
    }
}