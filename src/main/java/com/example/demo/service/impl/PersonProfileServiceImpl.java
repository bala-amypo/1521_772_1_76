package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.PersonProfile;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.service.PersonProfileService;

import java.util.*;

public class PersonProfileServiceImpl implements PersonProfileService {

    private final PersonProfileRepository repo;

    public PersonProfileServiceImpl(PersonProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public PersonProfile createPerson(PersonProfile p) {
        if (p.getEmail() == null)
            throw new ApiException("Email required");

        if (repo.findByEmail(p.getEmail()).isPresent())
            throw new ApiException("Duplicate email");

        if (repo.findByReferenceId(p.getReferenceId()).isPresent())
            throw new ApiException("Duplicate reference");

        return repo.save(p);
    }

    @Override
    public PersonProfile getPersonById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ApiException("Person not found"));
    }

    @Override
    public PersonProfile updateRelationshipDeclared(Long id, boolean flag) {
        PersonProfile p = getPersonById(id);
        p.setRelationshipDeclared(flag);
        return repo.save(p);
    }

    @Override
    public List<PersonProfile> getAllPersons() {
        return repo.findAll();
    }

    @Override
    public Optional<PersonProfile> findByReferenceId(String ref) {
        return repo.findByReferenceId(ref);
    }
}
