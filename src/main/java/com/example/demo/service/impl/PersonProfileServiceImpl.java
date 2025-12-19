package com.example.demo.service.impl;

import com.example.demo.service.PersonProfileService;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.model.PersonProfile;
import com.example.demo.exception.ApiException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service   
public class PersonProfileServiceImpl implements PersonProfileService {

    private final PersonProfileRepository repo;

    public PersonProfileServiceImpl(PersonProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public PersonProfile createPerson(PersonProfile person) {
        repo.findByEmail(person.getEmail())
            .ifPresent(p -> {
                throw new ApiException("Duplicate email");
            });
        return repo.save(person);
    }

    @Override
    public PersonProfile getPersonById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ApiException("Missing person"));
    }

    @Override
    public List<PersonProfile> getAllPersons() {
        return repo.findAll();
    }
}
