package com.example.demo.service;

import com.example.demo.model.PersonProfile;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PersonProfileService {

    PersonProfile createPerson(PersonProfile person);
    PersonProfile getPersonById(Long id);
    List<PersonProfile> getAllPersons();
}
