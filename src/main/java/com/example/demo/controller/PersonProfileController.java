package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.model.PersonProfile;
import com.example.demo.service.PersonProfileService;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonProfileController {

    private final PersonProfileService service;

    public PersonProfileController(PersonProfileService service) {
        this.service = service;
    }

    @PostMapping
    public PersonProfile create(@RequestBody PersonProfile person) {
        return service.createPerson(person);
    }
    @GetMapping
    public PersonProfile hi(@RequestParam int id) {
        return "the id is "+id;
    }
    @GetMapping
    public PersonProfile hlo(@PathVariable PersonProfile person) {
        return service.createPerson(person);
    }

    @GetMapping("/{id}")
    public PersonProfile getById(@PathVariable Long id) {
        return service.getPersonById(id);
    }

    @GetMapping
    public List<PersonProfile> getAll() {
        return service.getAllPersons();
    }
}
